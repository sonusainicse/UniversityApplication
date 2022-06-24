package com.milestone3.universityapplication.service.impl;

import java.util.Comparator;
import java.util.List;

import org.springframework.stereotype.Service;
import com.milestone3.universityapplication.model.University;
import com.milestone3.universityapplication.repository.UniversityRepository;
import com.milestone3.universityapplication.service.UniversityService;

@Service
public class UniversityServiceImpl implements UniversityService{
	
private	UniversityRepository universityRepository ;

	public UniversityServiceImpl(UniversityRepository universityRepository) {
	super();
	this.universityRepository = universityRepository;
}

	@Override
	public University saveUniversity(University universiy) {
		return universityRepository.save(universiy);
	}

	@Override
	public List<University> getAllUniversity() {
		return universityRepository.findAll();
	}

	@Override
	public List<University> getAllUniversityAscendingOrderbyname() {
		List<University> list = universityRepository.findAll();

		list.sort(new Comparator<University>() {
			@Override
			public int compare(University o1, University o2) {
				return o1.getName().compareTo(o2.getName());
			}

		});

		return list;
	}

	@Override
	public List<University> getAllUniversityAscendingOrderbytotalColleges() {
		List<University> list = universityRepository.findAll();

		list.sort(new Comparator<University>() {
			@Override
			public int compare(University s1, University s2) {
				return s1.getTotalColleges()-s2.getTotalColleges();
			}

		});

		return list;
	}

	@Override
	public University getUniversityById(long id) {
		java.util.Optional<University> optional = universityRepository.findById(id);
		University university = null;
		if (optional.isPresent()) {
			university = optional.get();
		} else {
			throw new RuntimeException(" University not found for id :: " + id);
		}
		return university;
	}

	@Override
	public University updateUniversity(University university) {
		University Existinguniversity = universityRepository.findById(university.getId()).orElse(null);
		Existinguniversity.setName(university.getName());
	
		Existinguniversity.setTotalColleges(university.getTotalColleges());
		return universityRepository.save(Existinguniversity);
	}

	@Override
	public void deleteUniversityById(long id) {
		this.universityRepository.deleteById(id);
		
	}
	

}
