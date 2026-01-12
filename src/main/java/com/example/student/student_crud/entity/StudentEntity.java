package com.example.student.student_crud.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class StudentEntity {

	@Id
	Long id;
	String name;
	String address;
	Integer age;
	
}
