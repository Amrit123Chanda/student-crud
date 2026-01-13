package com.example.student.student_crud.service;

import org.springframework.web.bind.annotation.PathVariable;

import com.example.student.student_crud.dto.StudentDto;

public interface IstudentService {
	
	public StudentDto getStudentById(@PathVariable Long id);
	public StudentDto createStudent(StudentDto stdDto);


}
