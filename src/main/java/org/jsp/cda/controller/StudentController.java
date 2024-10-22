package org.jsp.cda.controller;

import org.jsp.cda.entity.StudentProfile;
import org.jsp.cda.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/students")
@CrossOrigin(value = "*")
public class StudentController 
{
	@Autowired
	private StudentService studentService;
	
	@PostMapping("/{uid}")
	public ResponseEntity<?> saveStudent(@RequestBody StudentProfile student,@PathVariable int uid)
	{
		return studentService.saveStudent(student,uid);
	}
	
	@PatchMapping("/{id}/{did}")
	public ResponseEntity<?> setDeptToStudent(@PathVariable int id,@PathVariable int did)
	{
		return studentService.setDeptToStudent(id,did);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<?> findStudentById(@PathVariable int id)
	{
		return studentService.findStudentById(id);
	}
	
	@GetMapping
	public ResponseEntity<?> findAllStudent()
	{
		return studentService.findAllStudent();
	}
	
}
