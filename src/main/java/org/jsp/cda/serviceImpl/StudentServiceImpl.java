package org.jsp.cda.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.jsp.cda.dao.DepartmentDao;
import org.jsp.cda.dao.StudentDao;
import org.jsp.cda.dao.UserDao;
import org.jsp.cda.entity.Department;
import org.jsp.cda.entity.StudentProfile;
import org.jsp.cda.entity.User;
import org.jsp.cda.exceptionclasses.NoStudentFoundException;
import org.jsp.cda.responseStructure.ResponseStructure;
import org.jsp.cda.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {
	@Autowired
	private StudentDao studentDao;

	@Autowired
	private UserDao userDao;
	
	@Autowired
	private DepartmentDao departmentDao;

	@Override
	public ResponseEntity<?> saveStudent(StudentProfile student, int uid) {
		Optional<User> optional = userDao.findUserById(uid);
		if (optional.isEmpty())
			throw new RuntimeException("Invalid user id...unable to save student");
		User user = optional.get();
		student.setUser(user);
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value())
				.body(studentDao.saveStudent(student)).message("Student Saved Successfully").build());
	}

	@Override
	public ResponseEntity<?> setDeptToStudent(int id, int did) {
		Optional<StudentProfile> optional1 = studentDao.findStudentById(id);
		Optional<Department> optional2 = departmentDao.findDeptById(did);
		
		StudentProfile student = optional1.get();
		Department dept = optional2.get();
		student.setDepartment(dept);
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value())
				.body(studentDao.saveStudent(student)).message("Department added to Student").build());
	}

	@Override
	public ResponseEntity<?> findStudentById(int id) {
		Optional<StudentProfile> optional = studentDao.findStudentById(id);
		if(optional.isEmpty())
			throw NoStudentFoundException.builder().message("Invalid Id ,Unable to Find Student").build();
		
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value())
				.body(studentDao.saveStudent(optional.get())).message("Found Student By Id").build());
	}

	@Override
	public ResponseEntity<?> findAllStudent() {
		List<StudentProfile> students = studentDao.findAllStudent();
		if(students.isEmpty())
			throw NoStudentFoundException.builder().message("No Students Found").build();
		
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value())
				.body(students).message("Found All Students...S").build());
	}

}
