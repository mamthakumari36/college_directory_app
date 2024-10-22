package org.jsp.cda.service;

import org.jsp.cda.entity.StudentProfile;
import org.springframework.http.ResponseEntity;

public interface StudentService {

	ResponseEntity<?> saveStudent(StudentProfile student, int uid);

	ResponseEntity<?> setDeptToStudent(int id, int did);

	ResponseEntity<?> findStudentById(int id);

	ResponseEntity<?> findAllStudent();

}
