package com.example.student.student_crud.modules.course.service;


import com.example.student.student_crud.modules.course.dto.CourseDto;

public interface IcourseService {

	public CourseDto saveCourse(CourseDto courseDto);

	public CourseDto getCourseByID(Long id);

	public CourseDto updateCourse(Long id, CourseDto courseDto);

	public CourseDto getCourseByInstructor(Long instructorId);
}
