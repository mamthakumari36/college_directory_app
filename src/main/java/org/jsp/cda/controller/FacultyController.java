package org.jsp.cda.controller;

import java.time.LocalTime;

import org.jsp.cda.entity.Faculty;
import org.jsp.cda.service.FacultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/faculties")
public class FacultyController 
{
	@Autowired
	private FacultyService facultyService;
	
	@PostMapping(value = "/{uid}")
	public ResponseEntity<?> saveFaculty(@RequestBody Faculty faculty,@PathVariable int uid)
	{
		return facultyService.saveFaculty(faculty,uid);
	}
	
	@PatchMapping(value = "/{fid}/{did}")
	public ResponseEntity<?> setDeptToFaculty(@PathVariable int fid,@PathVariable int did)
	{
		return facultyService.setDeptToFaculty(fid,did);
	}
	
	@GetMapping(value = "/{fid}")
	public ResponseEntity<?> findFacultyById(@PathVariable int fid)
	{
		return facultyService.findFacultyById(fid);
	}
	
	@GetMapping
	public ResponseEntity<?> findAllFaculty()
	{
		return facultyService.findAllFaculty();
	}
	
	@PatchMapping(value = "/officehours/{fid}")
	public ResponseEntity<?> updateOfficeHour(@PathVariable int fid,@RequestParam LocalTime officeHours)
	{
		return facultyService.updateOfficeHour(fid,officeHours);
	}

}
