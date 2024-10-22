package org.jsp.cda.controller;

import org.jsp.cda.entity.Course;
import org.jsp.cda.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/course")
@CrossOrigin(value = "*")
public class CourseController 
{
	@Autowired
	private CourseService courseService;
	
	@PostMapping
	public ResponseEntity<?> saveCourse(@RequestBody Course course)
	{
		return courseService.saveCourse(course);
	}
	
	@PatchMapping("/faculty/{cid}/{fid}")
	public ResponseEntity<?> setFacultyToCourse(@PathVariable int cid,@PathVariable int fid)
	{
		return courseService.setFacultyToCourse(cid,fid);
	}
	
	@PatchMapping("/department/{cid}/{did}")
	public ResponseEntity<?> setDeptToCourse(@PathVariable int cid,@PathVariable int did)
	{
		return courseService.setDeptToCourse(cid,did);
	}
	
	@GetMapping
	public ResponseEntity<?> findAllCourse()
	{
		return courseService.findAllCourse();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> findCourseById(@PathVariable int id)
	{
		return courseService.findCourseById(id);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteCourseById(@PathVariable int id)
	{
		return courseService.deleteCourseById(id);
	}
	
}
