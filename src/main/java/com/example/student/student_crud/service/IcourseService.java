package com.example.student.student_crud.service;

import com.example.student.student_crud.dto.CourseDto;

public interface IcourseService {

	public CourseDto saveCourse(CourseDto courseDto);

	public CourseDto getCourseByID(Long id);

}
