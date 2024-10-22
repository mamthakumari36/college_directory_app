package org.jsp.cda.controller;

import org.jsp.cda.entity.Department;
import org.jsp.cda.service.DepartmentService;
import org.jsp.cda.serviceImpl.DepartmentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping(value = "/department")
@CrossOrigin(value = "*")
public class DepartmentController 
{
	@Autowired
	private DepartmentService departmentService;
	
	@PostMapping
	public ResponseEntity<?> saveDept(@RequestBody Department department)
	{
		return departmentService.saveDept(department);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> updateDept(@PathVariable int id, @RequestBody Department department) 
	{
		return departmentService.updateDept(id,department);
	}
	
	@GetMapping
	public ResponseEntity<?> findAllDept()
	{
		return departmentService.findAllDept();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteDeptById(@PathVariable int id)
	{
		return departmentService.deleteDeptById(id);
	}

}
