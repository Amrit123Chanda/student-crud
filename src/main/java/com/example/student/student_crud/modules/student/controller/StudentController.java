package com.example.student.student_crud.modules.student.controller;

import com.example.student.student_crud.modules.student.dto.StudentDto;
import com.example.student.student_crud.modules.student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

	@Autowired
	private StudentService studentservice;
	
	@GetMapping("/{id}")
	public ResponseEntity<StudentDto> getStudentById(@PathVariable Long id)
	{
		StudentDto studentDto = studentservice.getStudentById(id);
		return ResponseEntity.ok(studentDto);
	}
	
	@PostMapping
	public ResponseEntity<StudentDto> createStudent(@RequestBody StudentDto stdDto)
	{
		StudentDto createdStudent = studentservice.createStudent(stdDto);
		return new ResponseEntity<>(createdStudent, HttpStatus.CREATED);
	}

	@GetMapping("/search")
	public ResponseEntity<List<StudentDto>> searchStudentbyName(@RequestParam String name)
	{
		List<StudentDto> students = studentservice.searchStudentbyName(name);
		return ResponseEntity.ok(students);
	}
	
	@PatchMapping("/{id}")
	public ResponseEntity<StudentDto> updateStudent(@PathVariable Long id, @RequestBody StudentDto stdDto) {
	    StudentDto updatedStudent = studentservice.updateStudent(id, stdDto);
		return ResponseEntity.ok(updatedStudent);
	}
}
