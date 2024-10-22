package org.jsp.cda.dao;

import java.util.List;
import java.util.Optional;

import org.jsp.cda.entity.StudentProfile;

public interface StudentDao 
{
	StudentProfile saveStudent(StudentProfile student);

	StudentProfile updateStudent(StudentProfile student);

	List<StudentProfile> findAllStudent();

	Optional<StudentProfile> findStudentById(int id);
}
