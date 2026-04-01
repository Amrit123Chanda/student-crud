package com.example.student.student_crud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.student.student_crud.dto.CourseDto;
import com.example.student.student_crud.service.IcourseService;

@RestController
@RequestMapping("/course")
public class CourseController {

	private IcourseService courseService;

	@Autowired
	public CourseController(IcourseService courseService) {
		this.courseService = courseService;
	}

	@PostMapping("/save")
	public CourseDto saveCourse(@RequestBody CourseDto courseDto) {
		return courseService.saveCourse(courseDto);
	}

	@GetMapping("/getbyid/{id}")
	public CourseDto getCourseByID(@PathVariable Long id) {
		return courseService.getCourseByID(id);
	}


}
