package com.vcube.college.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vcube.college.model.CollegeInfo;

public interface CollegeRepository  extends JpaRepository<CollegeInfo,Long>{
	boolean existsByPhonenumber(String phonenumber);
	List<CollegeInfo> findByName(String name);
	Optional<CollegeInfo>findByPhonenumber(String phonenumber);
	
}
