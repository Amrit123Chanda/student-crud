package com.example.student.student_crud.modules.course.controller;

import com.example.student.student_crud.modules.course.dto.CourseDto;
import com.example.student.student_crud.modules.course.service.IcourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/courses")
public class CourseController {

	private IcourseService courseService;

	@Autowired
	public CourseController(IcourseService courseService) {
		this.courseService = courseService;
	}

	@PostMapping
	public ResponseEntity<CourseDto> saveCourse(@RequestBody CourseDto courseDto) {
		CourseDto savedCourse = courseService.saveCourse(courseDto);
		return new ResponseEntity<>(savedCourse, HttpStatus.CREATED);
	}

	@GetMapping("/{id}")
	public ResponseEntity<CourseDto> getCourseByID(@PathVariable Long id) {
		CourseDto courseDto = courseService.getCourseByID(id);
		return ResponseEntity.ok(courseDto);
	}

	@PatchMapping("/{id}")
	public ResponseEntity<CourseDto> updateCourse(@PathVariable Long id, @RequestBody CourseDto courseDto) {
		CourseDto updatedCourse = courseService.updateCourse(id, courseDto);
		return ResponseEntity.ok(updatedCourse);
	}

	@GetMapping("/instructor/{instructorId}")
	public ResponseEntity<CourseDto> getCourseByInstructor(@PathVariable Long instructorId) {
		CourseDto courseDto = courseService.getCourseByInstructor(instructorId);
		return ResponseEntity.ok(courseDto);
	}


}
