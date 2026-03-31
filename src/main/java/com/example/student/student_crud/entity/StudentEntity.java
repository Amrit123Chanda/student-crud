package com.example.student.student_crud.entity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.annotations.Columns;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;

@Entity
public class StudentEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	String name;
	Integer age;
	
	@OneToMany(mappedBy = "studentEntity")
	List<AddressEntity> listAdd = new ArrayList<>();
	
	@ManyToMany
	@JoinTable(name="student_course",
	joinColumns=@JoinColumn(name="student_id"),
	inverseJoinColumns = @JoinColumn(name="course_id")
	)
	Set<CourseEntity> studentCourseSet = new HashSet<>();
	
	

	public List<AddressEntity> getListAdd() {
		return listAdd;
	}
	public void setListAdd(List<AddressEntity> listAdd) {
		this.listAdd = listAdd;
	}
	public Set<CourseEntity> getStudentCourseSet() {
		return studentCourseSet;
	}
	public void setStudentCourseSet(Set<CourseEntity> studentCourseSet) {
		this.studentCourseSet = studentCourseSet;
	}
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
	
	
	
}
