package com.example.student.student_crud.entity;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class CourseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	String courseName;
	
	@ManyToMany(mappedBy = "studentCourseSet" )
	Set<StudentEntity> courseStudentSet = new HashSet<>();

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

	public Set<StudentEntity> getCourseStudentSet() {
		return courseStudentSet;
	}

	public void setCourseStudentSet(Set<StudentEntity> courseStudentSet) {
		this.courseStudentSet = courseStudentSet;
	}
	
	
	
}
