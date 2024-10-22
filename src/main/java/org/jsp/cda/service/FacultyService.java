package org.jsp.cda.service;

import java.time.LocalTime;

import org.jsp.cda.entity.Faculty;
import org.springframework.http.ResponseEntity;

public interface FacultyService  
{

	ResponseEntity<?> saveFaculty(Faculty faculty, int id);

	ResponseEntity<?> setDeptToFaculty(int fid, int did);

	ResponseEntity<?> findFacultyById(int fid);

	ResponseEntity<?> findAllFaculty();

	ResponseEntity<?> updateOfficeHour(int fid, LocalTime officeHours);

}
