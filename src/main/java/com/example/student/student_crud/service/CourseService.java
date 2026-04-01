package com.example.student.student_crud.service;

import com.example.student.student_crud.mapper.Mapper;
import org.springframework.stereotype.Service;

import com.example.student.student_crud.dao.CourseRepo;
import com.example.student.student_crud.dto.CourseDto;
import com.example.student.student_crud.entity.CourseEntity;
import com.example.student.student_crud.exception.ResourceNotFoundException;

@Service
public class CourseService implements IcourseService {

	private final CourseRepo courseRepo;

	public CourseService(CourseRepo courseRepo) {
		this.courseRepo = courseRepo;
	}

	@Override
	public CourseDto saveCourse(CourseDto courseDto) {
		CourseEntity courseEntity = Mapper.toCourseEntity(courseDto);
		CourseEntity savedCourse = courseRepo.save(courseEntity);
		return Mapper.toCourseDto(savedCourse);
	}

	@Override
	public CourseDto getCourseByID(Long id) {
		CourseEntity courseEntity = courseRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Course not found with id: " + id));
		return Mapper.toCourseDto(courseEntity);
	}

}
