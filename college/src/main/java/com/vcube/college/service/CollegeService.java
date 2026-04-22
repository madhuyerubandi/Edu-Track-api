package com.vcube.college.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.vcube.college.model.CollegeInfo;
import com.vcube.college.repository.CollegeRepository;

@Service
public class CollegeService {
	
	
	private CollegeRepository collegerepo;
	public CollegeService(CollegeRepository collegerepo)
	{
		this.collegerepo=collegerepo;
	}
	
	
	
	public CollegeInfo createStudent(CollegeInfo college)
	{
		if(collegerepo.existsByPhonenumber(college.getPhonenumber()))
		{
			throw new RuntimeException("User Already exists with phonenumber !");
		}
		return collegerepo.save(college);
	}
	public List<CollegeInfo> saveAllStudent(List<CollegeInfo> college)
	{
		return collegerepo.saveAll(college);
	}
	public CollegeInfo getById(Long id)
	{
		return collegerepo.findById(id).orElseThrow(()-> new RuntimeException(" No User Found With thi id:"+id));
	}
	public  List<CollegeInfo> getAll()
	{
		return collegerepo.findAll();
	}
	public CollegeInfo updateCollege(Long id,CollegeInfo updated)
	{
		CollegeInfo existing=collegerepo.findById(id).orElseThrow(()->new RuntimeException("Record not found wtih id :"+id));
		existing.setName(updated.getName());
		existing.setBranch(updated.getBranch());
		existing.setPhonenumber(updated.getPhonenumber());
		return collegerepo.save(updated);
		
	}
	public void deleteById(Long id)
	{
		if(collegerepo.existsById(id))
		{
			throw new RuntimeException("no record found");
		}
		 collegerepo.deleteById(id);
		 
	}
	public String DeleteAllRecords()
	{
		
	    long count= collegerepo.count();
	    if(count==0)
	    {
	    	return "NO RECORDS TO COUNT";
	    }
	    collegerepo.deleteAll();
	    return "RECORDS DELETED SUCCESSFULLY";
		
	}
	public List<CollegeInfo> getByName(String name)
	{
		 List<CollegeInfo> college=collegerepo.findByName(name);
		 if(college.isEmpty())
		 {
			 throw new RuntimeException("NO RECORD FOUND WITH THIS NAME !");
		 }
		 return college;
	}
	public CollegeInfo getRecordByNumber(String phonenumber)
	{
		return collegerepo.findByPhonenumber(phonenumber).orElseThrow(()->new RuntimeException("NO PHONE NUMBER EXIST"));
	}
	public Page<CollegeInfo> pageandSort(int page,int size,String sortby)
	{
		Pageable pageable=  PageRequest.of(page,size,Sort.by(sortby).ascending());
		return collegerepo.findAll(pageable);
	}
	}


