package org.jsp.cda.dao;

import java.util.List;
import java.util.Optional;

import org.jsp.cda.entity.Department;

public interface DepartmentDao 
{
	Department saveDept(Department dept);

	Department updateDept(Department dept);

	List<Department> findAllDept();

	Optional<Department> findDeptById(int id);
	
	void deleteDeptById(int id);

}
