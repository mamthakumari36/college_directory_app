package org.jsp.cda.service;

import org.jsp.cda.entity.Course;
import org.springframework.http.ResponseEntity;

public interface CourseService {

	ResponseEntity<?> saveCourse(Course course);

	ResponseEntity<?> findAllCourse();

	ResponseEntity<?> findCourseById(int id);

	ResponseEntity<?> deleteCourseById(int id);

	ResponseEntity<?> setFacultyToCourse(int cid, int fid);

	ResponseEntity<?> setDeptToCourse(int cid, int did);

}
