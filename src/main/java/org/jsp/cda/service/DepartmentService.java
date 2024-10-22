package org.jsp.cda.service;

import org.jsp.cda.entity.Department;
import org.springframework.http.ResponseEntity;

public interface DepartmentService 
{

	ResponseEntity<?> saveDept(Department department);

	ResponseEntity<?> updateDept(int id, Department department);

	ResponseEntity<?> findAllDept();

	ResponseEntity<?> deleteDeptById(int id);
	
}
