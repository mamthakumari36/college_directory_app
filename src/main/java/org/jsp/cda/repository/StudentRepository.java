package org.jsp.cda.repository;

import org.jsp.cda.entity.StudentProfile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<StudentProfile, Integer>{

}
