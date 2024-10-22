package org.jsp.cda.service;

import org.springframework.http.ResponseEntity;

public interface EnrollmentService {

	ResponseEntity<?> saveEnrollment(int id, int cid);

	ResponseEntity<?> findErollmentById(int id);

	ResponseEntity<?> findAllEnrollment();

}
