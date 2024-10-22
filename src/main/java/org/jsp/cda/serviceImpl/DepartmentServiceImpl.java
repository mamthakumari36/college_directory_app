package org.jsp.cda.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.jsp.cda.daoImpl.DepartmentDaoImpl;
import org.jsp.cda.entity.Department;
import org.jsp.cda.exceptionclasses.InvalidIdException;
import org.jsp.cda.exceptionclasses.NoDepartmentFoundException;
import org.jsp.cda.responseStructure.ResponseStructure;
import org.jsp.cda.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class DepartmentServiceImpl implements DepartmentService
{
	@Autowired
	private DepartmentDaoImpl departmentDao;

	public ResponseEntity<?> saveDept(Department department) {
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value())
				.body(departmentDao.saveDept(department)).message("Department Saved Successfully").build());
	}

	public ResponseEntity<?> updateDept(int id, Department department) {

		Optional<Department> dept = departmentDao.findDeptById(id);
		if(dept.isEmpty())
			throw NoDepartmentFoundException.builder().message("No Department Found in the DB").build();
		
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value())
				.body(departmentDao.updateDept(department)).message("Department Updated Successfully").build());
	}

	public ResponseEntity<?> findAllDept() 
	{
		List<Department> depts = departmentDao.findAllDept();
		if(depts.isEmpty())
			throw NoDepartmentFoundException.builder().message("No Departments Found in the DB").build();
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value())
				.body(depts).message("All Departments Fetched Successfully").build());
	}

	@Override
	public ResponseEntity<?> deleteDeptById(int id) {
		Optional<Department> dept = departmentDao.findDeptById(id);
		if(dept.isEmpty())
			throw InvalidIdException.builder().message("No Department Found, Invalid Id...").build();
		
		departmentDao.deleteDeptById(id);
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value())
				.body("Deleted Department...").message("Department deleted Successfully").build());
	}

}
