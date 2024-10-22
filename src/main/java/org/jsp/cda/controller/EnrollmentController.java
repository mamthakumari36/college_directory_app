package org.jsp.cda.controller;

import org.jsp.cda.service.EnrollmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/enrollments")
public class EnrollmentController 
{
	@Autowired
	private EnrollmentService enrollmentService;
	
	@PostMapping(value = "/{id}/{cid}")
	public ResponseEntity<?> saveEnrollment(@PathVariable int id,@PathVariable int cid)
	{
		return enrollmentService.saveEnrollment(id,cid);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<?> findErollmentById(@PathVariable int id)
	{
		return enrollmentService.findErollmentById(id);
	}
	
	@GetMapping
	public ResponseEntity<?> findAllEnrollment()
	{
		return enrollmentService.findAllEnrollment();
	}
	
	
}
