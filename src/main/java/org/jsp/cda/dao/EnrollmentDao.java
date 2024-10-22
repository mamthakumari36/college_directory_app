package org.jsp.cda.dao;

import java.util.List;
import java.util.Optional;

import org.jsp.cda.entity.Enrollment;

public interface EnrollmentDao 
{
	Enrollment saveEnrollment(Enrollment enrollment);
	
	Optional<Enrollment> findErollmentById(int id);
	
	List<Enrollment> findAllEnrollment();

}
