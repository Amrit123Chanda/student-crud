package com.example.student.student_crud.dto;

import java.util.List;
import java.util.Set;

public class StudentDto {
	
	Long id;
	String name;
	Integer age;
	private List<AddressDto> addresses;
    private Set<CourseDto> courses;
    
    
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
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public List<AddressDto> getAddresses() {
		return addresses;
	}
	public void setAddresses(List<AddressDto> addresses) {
		this.addresses = addresses;
	}
	public Set<CourseDto> getCourses() {
		return courses;
	}
	public void setCourses(Set<CourseDto> courses) {
		this.courses = courses;
	}
	
    
	
	
}
