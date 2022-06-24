package com.milestone3.universityapplication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.milestone3.universityapplication.model.University;
import com.milestone3.universityapplication.service.UniversityService;


@RestController
public class UniversityController {
	
	@Autowired
	private UniversityService universityservice;

	public UniversityController(UniversityService studentservice) {
		super();
		this.universityservice = studentservice;
	}
	
	
	@GetMapping("/universities")
	public List<University> getAllUniversity(){
		return this.universityservice.getAllUniversity();
	}
	
	@GetMapping("/universities/{id}")
	public University getemStudentById(@PathVariable("id") String id) {
		return this.universityservice.getUniversityById(Long.parseLong(id));
		
	}
	
	@GetMapping("/universitiesbyascendingorderbyname")
	public List<University> getStudentsByAscendingOrderbyname(){
		return universityservice.getAllUniversityAscendingOrderbyname();
	}

	@GetMapping("/universitiesbyascendingorderbytotalcolleges")
	public List<University> getStudentsByAscendingOrderbymarks(){
		return universityservice.getAllUniversityAscendingOrderbytotalColleges();
	}
	
	
	@PostMapping("/universities")
	public ResponseEntity<University> saveStudent(@RequestBody University university){
		return new ResponseEntity<University>(universityservice.saveUniversity(university),HttpStatus.CREATED);
	}
	
	
	@PutMapping("/universities")
	public University updateStudent(@RequestBody University university) {
		return universityservice.updateUniversity(university);
	}

		
		@DeleteMapping("/universities/{id}")
		public ResponseEntity<HttpStatus> deleteEmployeeById(@PathVariable String id) {
			try {
				this.universityservice.deleteUniversityById(Long.parseLong(id));
				return new ResponseEntity<>(HttpStatus.OK);
			}
			catch(Exception e) {
				return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		
	}

}
