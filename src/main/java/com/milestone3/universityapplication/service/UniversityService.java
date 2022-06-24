package com.milestone3.universityapplication.service;

import java.util.List;

import com.milestone3.universityapplication.model.University;



public interface UniversityService {
	
public University saveUniversity(University university);
	
	public List<University> getAllUniversity();
	
	public List<University> getAllUniversityAscendingOrderbyname();
	
	public List<University> getAllUniversityAscendingOrderbytotalColleges();
	
	public University getUniversityById(long id);
	
	public University updateUniversity(University university);
	
	public void deleteUniversityById(long id);


}
