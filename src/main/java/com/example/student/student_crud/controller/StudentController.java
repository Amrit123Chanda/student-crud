package com.example.student.student_crud.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.example.student.student_crud.dto.StudentDto;
import com.example.student.student_crud.service.StudentService;

@RestController("/student")
public class StudentController {

	@Autowired
	private StudentService studentservice;
	
	@GetMapping("/{id}")
	public StudentDto getStudentById(@PathVariable Long id)
	{
		return studentservice.getStudentById(id);
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
