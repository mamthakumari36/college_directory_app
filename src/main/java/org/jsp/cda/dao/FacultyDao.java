package org.jsp.cda.dao;

import java.util.List;
import java.util.Optional;

import org.jsp.cda.entity.Faculty;

public interface FacultyDao 
{
	Faculty saveFaculty(Faculty faculty);
	
	Optional<Faculty> findFacultyById(int id);
	
	List<Faculty> findAllFaculty();
	
}
