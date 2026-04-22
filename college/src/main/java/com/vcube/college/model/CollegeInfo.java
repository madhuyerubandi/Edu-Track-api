package com.vcube.college.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
public class CollegeInfo {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@NotBlank(message="Name field Requried")
	@Column(name="Student_Name",nullable=false)
	@Pattern(regexp = "^[a-zA-Z ]+$")
	@Size(min=3,max=50)
	private String name;
	
	@NotBlank(message="Name field Requried")
	@Column(name="Student_Branch" ,nullable =false)
	@Pattern(regexp="^[a-zA-Z]+$")
	@Size(min=3,max=50)
	private String branch;

	
	@Column(name="Phonenumber")
	@Pattern(regexp="^[0-9]{10}$")
	private String phonenumber;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
	

}
