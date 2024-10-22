package org.jsp.cda.daoImpl;

import java.util.List;
import java.util.Optional;

import org.jsp.cda.dao.EnrollmentDao;
import org.jsp.cda.entity.Enrollment;
import org.jsp.cda.repository.EnrollmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class EnrollmentDaoImpl implements EnrollmentDao
{
	@Autowired
	private EnrollmentRepository enrollmentRepository;

	@Override
	public Enrollment saveEnrollment(Enrollment enrollment) {
		return enrollmentRepository.save(enrollment);
	}

	@Override
	public Optional<Enrollment> findErollmentById(int id) {
		return enrollmentRepository.findById(id);
	}

	@Override
	public List<Enrollment> findAllEnrollment() {
		return enrollmentRepository.findAll();
	}
	
}
