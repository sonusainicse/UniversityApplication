package com.milestone3.universityapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.milestone3.universityapplication.model.University;

public interface UniversityRepository extends JpaRepository<University, Long>{

}
