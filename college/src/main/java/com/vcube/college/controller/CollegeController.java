package com.vcube.college.controller;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vcube.college.model.CollegeInfo;
import com.vcube.college.service.CollegeService;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/college")
public class CollegeController {
	
	private CollegeService service;
	public CollegeController(CollegeService service)
	{
		this.service=service;
	}
	//save one record
	@Operation(summary="TRY IT ! TO SAVE ONE RECORD ")
	@PostMapping("/onerow")
	
	//http://localhost:1010/college/onerow
	
	public CollegeInfo saveStudentInfo( @Valid @RequestBody CollegeInfo college)
	{
		return service.createStudent(college);
	}
	@Operation(summary="TRY IT ! TO SAVE MULTIPLE RECORDS")
	@PostMapping("/all")
	public List<CollegeInfo> saveAllStudent(@Valid  @RequestBody List<CollegeInfo> college)
	{
		return service.saveAllStudent(college);
	}
	@Operation(summary="TRY IT !! TO GET RECORD USING ID")
	@GetMapping("/getby/{id}")
	public CollegeInfo getRecordByid( @PathVariable Long id)
	{
		return service.getById(id);
	}
	@Operation(summary="TRY IT ! TO FETACH ALL RECORDS")
	@GetMapping("/all")
	public List<CollegeInfo> getAll()
	{
		return service.getAll();
	}
	@Operation(summary="TRY IT ! UPDATE THE RECORD BASED ON ID ")
	@PutMapping("/update/{id}")
	public CollegeInfo updateRecord(@PathVariable Long id ,@RequestBody CollegeInfo college) {
		return service.updateCollege(id,college);
	}
	@DeleteMapping("/delete/{id}")
	@Operation(summary="TRY IT ! TI DELETE A RECORD")
  public String deleteRecord(@PathVariable Long id)
  {
	  service.deleteById(id);
	  return "Succesfully deleted";
  }
	@Operation(summary="TRY IT  DELETE ALL DATA")
	@DeleteMapping("/deleteAll")
	public String AllRecordDelete()
	{
		 return service.DeleteAllRecords();
		
	}
	@Operation(summary="TRY IT ! TO FECTCH DATA USING NAME !!")
	@GetMapping("/getname/{name}")
	public List<CollegeInfo> getByName(@RequestParam String name)
	{
		return service.getByName(name);
	}
	@Operation(summary="TRY IS ! TO FETCH RECORD USING MOBILE NUMBER")
	@GetMapping("/{mobile}")
	public CollegeInfo getByMobile(@RequestParam String phonenumber)
	{
		return service.getRecordByNumber(phonenumber);
	}
	@GetMapping("/cpllege")
	@Operation(summary="TRY IT !PAGE AND  SORTING OPERATION")
	public Page<CollegeInfo> pageandSorting(@RequestParam int page,@RequestParam int size,@RequestParam(defaultValue="id")String sortby)
	{
		return service.pageandSort(page,size,sortby);
	}
}
