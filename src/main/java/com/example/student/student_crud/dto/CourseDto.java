package com.example.student.student_crud.dto;

import java.util.HashSet;
import java.util.Set;

public class CourseDto {

	Long id;
	String courseName;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	
	
}
