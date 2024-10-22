package org.jsp.cda.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.jsp.cda.dao.CourseDao;
import org.jsp.cda.dao.EnrollmentDao;
import org.jsp.cda.dao.StudentDao;
import org.jsp.cda.entity.Course;
import org.jsp.cda.entity.Enrollment;
import org.jsp.cda.entity.StudentProfile;
import org.jsp.cda.responseStructure.ResponseStructure;
import org.jsp.cda.service.EnrollmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class EnrollmentServiceImpl implements EnrollmentService {
	@Autowired
	private EnrollmentDao enrollmentDao;

	@Autowired
	private StudentDao studentDao;

	@Autowired
	private CourseDao courseDao;

	@Override
	public ResponseEntity<?> saveEnrollment(int id, int cid) {
		Optional<StudentProfile> optional1 = studentDao.findStudentById(id);
		Optional<Course> optional2 = courseDao.findCourseById(cid);
		if (optional1.isEmpty())
			throw new RuntimeException("Invalid student id...");

		if (optional2.isEmpty())
			throw new RuntimeException("Invalid course id");

		StudentProfile student = optional1.get();
		Course course = optional2.get();

		Enrollment enrollment = Enrollment.builder().course(course).student(student).build();
		enrollment = enrollmentDao.saveEnrollment(enrollment);

		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value())
				.message("Enrolled Student Successfully...").body(enrollment).build());
	}

	@Override
	public ResponseEntity<?> findErollmentById(int id) {
		Optional<Enrollment> optional = enrollmentDao.findErollmentById(id);
		if (optional.isEmpty())
			throw new RuntimeException("Invalid id...unable to find");

		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value())
				.message("Found Enrolled Student Successfully...").body(optional.get()).build());
	}

	@Override
	public ResponseEntity<?> findAllEnrollment() {
		List<Enrollment> enrollments = enrollmentDao.findAllEnrollment();
		if(enrollments.isEmpty())
			throw new RuntimeException("No enrollments found");
		
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value())
				.message("Found All Enrolled Students Successfully...").body(enrollments).build());
	}
	
	
	

}
