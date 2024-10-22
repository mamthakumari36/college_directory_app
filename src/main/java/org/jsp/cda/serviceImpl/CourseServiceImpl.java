package org.jsp.cda.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.jsp.cda.dao.CourseDao;
import org.jsp.cda.dao.DepartmentDao;
import org.jsp.cda.dao.FacultyDao;
import org.jsp.cda.entity.Course;
import org.jsp.cda.entity.Department;
import org.jsp.cda.entity.Faculty;
import org.jsp.cda.exceptionclasses.NoCoursesFoundException;
import org.jsp.cda.responseStructure.ResponseStructure;
import org.jsp.cda.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CourseServiceImpl implements CourseService {
	@Autowired
	private CourseDao courseDao;

	@Autowired
	FacultyDao facultyDao;

	@Autowired
	private DepartmentDao departmentDao;

	@Override
	public ResponseEntity<?> saveCourse(Course course) {
		course = courseDao.saveCourse(course);
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value())
				.message("Course Saved Successfully...").body(course).build());
	}

	@Override
	public ResponseEntity<?> findAllCourse() {
		List<Course> courses = courseDao.findAllCourse();
		if (courses.isEmpty())
			throw NoCoursesFoundException.builder().message("No Courses found in the db").build();
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value())
				.message("Found All Courses").body(courses).build());
	}

	@Override
	public ResponseEntity<?> findCourseById(int id) {
		Optional<Course> optional = courseDao.findCourseById(id);
		if (optional.isEmpty())
			throw NoCoursesFoundException.builder().message("Invalid Id").build();
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value())
				.message("Found Course").body(optional.get()).build());
	}

	@Override
	public ResponseEntity<?> deleteCourseById(int id) {
		Optional<Course> optional = courseDao.findCourseById(id);
		if (optional.isEmpty())
			throw NoCoursesFoundException.builder().message("Given Id Is Invalid...").build();

		courseDao.deleteCourseById(id);
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value())
				.message("Deleted Course Successfully").body("Course Deleted...").build());
	}

	@Override
	public ResponseEntity<?> setFacultyToCourse(int cid, int fid) {
		Optional<Faculty> optional1 = facultyDao.findFacultyById(fid);

		Optional<Course> optional2 = courseDao.findCourseById(cid);

		Faculty faculty = optional1.get();
		Course course = optional2.get();

		course.setFaculty(faculty);
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value())
				.message("Faculty added to Course").body(courseDao.saveCourse(course)).build());
	}

	@Override
	public ResponseEntity<?> setDeptToCourse(int cid, int did) {
		Optional<Department> optional1 = departmentDao.findDeptById(did);
		Optional<Course> optional2 = courseDao.findCourseById(cid);

		Department dept = optional1.get();
		Course course = optional2.get();

		course.setDepartment(dept);

		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value())
				.message("Department added to Course").body(courseDao.saveCourse(course)).build());
	}

}
