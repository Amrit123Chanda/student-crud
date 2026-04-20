package com.example.student.student_crud.modules.student.service;

import com.example.student.student_crud.exception.ResourceNotFoundException;
import com.example.student.student_crud.modules.student.dto.StudentDto;

import java.util.List;

public interface IstudentService {
	
	public StudentDto getStudentById(Long id) throws ResourceNotFoundException;
	public StudentDto createStudent(StudentDto stdDto);
	//public List<StudentDto> getStudentByAge(Integer age);
	public List<StudentDto> searchStudentbyName(String name);
	public StudentDto updateStudent(Long id, StudentDto stdDto);
}


