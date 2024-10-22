package org.jsp.cda.serviceImpl;

import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

import org.jsp.cda.dao.DepartmentDao;
import org.jsp.cda.dao.FacultyDao;
import org.jsp.cda.dao.UserDao;
import org.jsp.cda.entity.Department;
import org.jsp.cda.entity.Faculty;
import org.jsp.cda.entity.User;
import org.jsp.cda.exceptionclasses.InvalidIdException;
import org.jsp.cda.exceptionclasses.NoFacultyFoundException;
import org.jsp.cda.responseStructure.ResponseStructure;
import org.jsp.cda.service.FacultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class FacultyServiceImpl implements FacultyService {
	@Autowired
	private FacultyDao facultyDao;

	@Autowired
	private UserDao userDao;
	
	@Autowired
	DepartmentDao departmentDao;

	@Override
	public ResponseEntity<?> saveFaculty(Faculty faculty, int uid) {
		Optional<User> optional = userDao.findUserById(uid);
		if (optional.isEmpty())
			throw new RuntimeException("Invalid User id...unable to save faculty");
		
		User user = optional.get();
		faculty.setUser(user);
		faculty = facultyDao.saveFaculty(faculty);
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value())
				.message("Faculty Saved Successfully...").body(faculty).build());
	}

	@Override
	public ResponseEntity<?> setDeptToFaculty(int fid, int did) {
		Optional<Faculty> optional1 = facultyDao.findFacultyById(fid);
		
		Optional<Department> optional2 = departmentDao.findDeptById(did);
		
		Faculty faculty = optional1.get();
		Department dept = optional2.get();
		
		faculty.setDepartment(dept);
		
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value())
				.message("Saved Faculty success").body(facultyDao.saveFaculty(faculty)).build());
	}

	@Override
	public ResponseEntity<?> findFacultyById(int fid) {
		Optional<Faculty> optional = facultyDao.findFacultyById(fid);
		if(optional.isEmpty())
			throw InvalidIdException.builder().message("Invalid id...unable to find faculty").build();
		
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value())
				.message("Found Faculty").body(optional.get()).build());
	}

	@Override
	public ResponseEntity<?> findAllFaculty() {
		List<Faculty> faculties = facultyDao.findAllFaculty();
		if(faculties.isEmpty())
			throw NoFacultyFoundException.builder().message("No Faculties found in Db").build();
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value())
				.message("Found All The Faculties").body(faculties).build());
	}

	@Override
	public ResponseEntity<?> updateOfficeHour(int fid, LocalTime officeHours) {
		Optional<Faculty> optional = facultyDao.findFacultyById(fid);
		if(optional.isEmpty())
			throw InvalidIdException.builder().message("Invalid id...unable to find faculty").build();
		
		Faculty faculty = optional.get();
		faculty.setOfficeHours(officeHours);
		faculty = facultyDao.saveFaculty(faculty);
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value())
				.message("Successfully Updated Faculty OfficeHours...").body(faculty).build());
	}

}
