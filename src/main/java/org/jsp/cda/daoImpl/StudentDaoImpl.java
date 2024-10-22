package org.jsp.cda.daoImpl;

import java.util.List;
import java.util.Optional;

import org.jsp.cda.dao.StudentDao;
import org.jsp.cda.entity.StudentProfile;
import org.jsp.cda.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class StudentDaoImpl implements StudentDao
{
	@Autowired
	private StudentRepository studentRepository;
	
	public StudentProfile saveStudent(StudentProfile student)
	{
		return studentRepository.save(student);
	}
	
	public StudentProfile updateStudent(StudentProfile student)
	{
		return studentRepository.save(student);
	}
	
	public List<StudentProfile> findAllStudent()
	{
		return studentRepository.findAll();
	}

	@Override
	public Optional<StudentProfile> findStudentById(int id) {
		return studentRepository.findById(id);
	}
	
	
	
}
