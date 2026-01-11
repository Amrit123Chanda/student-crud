package com.example.student.student_crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.example.student.student_crud.dto.StudentDto;
import com.example.student.student_crud.service.StudentService;

@RestController("/student")
public class StudentController {

	@Autowired
	private StudentService studentservice;
	
	public StudentDto getStudentById(Long id)
	{
		return null;
	}
	
	public StudentDto createStudent(StudentDto stdDto)
	{
		return null;
	}
	
	public List<StudentDto> getStudentByAge(Integer age)
	{
		return null;
	}
	
	public List<StudentDto> searchStudentbyName(String name)
	{
		return null;
	}
	
}
