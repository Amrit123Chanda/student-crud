package com.example.student.student_crud.dto;

import com.example.student.student_crud.entity.StudentEntity;

public class AddressDto {

	Long id;	
	String city;
	String state;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	
}
