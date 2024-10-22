package org.jsp.cda.daoImpl;

import java.util.List;
import java.util.Optional;

import org.jsp.cda.dao.DepartmentDao;
import org.jsp.cda.entity.Department;
import org.jsp.cda.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DepartmentDaoImpl implements DepartmentDao
{
	@Autowired
	private DepartmentRepository departmentRepository;
	
	public Department saveDept(Department dept)
	{
		return departmentRepository.save(dept);
	}
	
	public Department updateDept(Department dept)
	{
		return departmentRepository.save(dept);
	} 
	
	public List<Department> findAllDept()
	{
		return departmentRepository.findAll();
	}
	
	public Optional<Department> findDeptById(int id)
	{
		return departmentRepository.findById(id);
	}

	@Override
	public void deleteDeptById(int id) {
		departmentRepository.deleteById(id);
	}
	

}
