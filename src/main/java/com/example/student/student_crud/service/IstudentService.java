package com.example.student.student_crud.service;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;

import com.example.student.student_crud.dto.StudentDto;

public interface IstudentService {
	
	public StudentDto getStudentById(@PathVariable Long id);
	public StudentDto createStudent(StudentDto stdDto);
	public List<StudentDto> getStudentByAge(Integer age);


}
