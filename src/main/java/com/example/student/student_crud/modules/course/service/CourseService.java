package com.example.student.student_crud.modules.course.service;

import com.example.student.student_crud.exception.ResourceNotFoundException;
import com.example.student.student_crud.modules.course.dao.CourseRepo;
import com.example.student.student_crud.modules.course.dto.CourseDto;
import com.example.student.student_crud.modules.course.entity.CourseEntity;
import com.example.student.student_crud.modules.instructor.service.IInstructorLookupService;
import com.example.student.student_crud.modules.mapper.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService implements IcourseService, CourseLookup {

	private final CourseRepo courseRepo;
	private final IInstructorLookupService instructorLookupService;

	@Autowired
	public CourseService(CourseRepo courseRepo, IInstructorLookupService instructorLookupService) {
		this.courseRepo = courseRepo;
        this.instructorLookupService = instructorLookupService;
    }

	@Override
	public CourseDto saveCourse(CourseDto courseDto) {
		if (courseDto.getInstructorId() != null) {
			instructorLookupService.validateInstructorExists(courseDto.getInstructorId());
		}
		CourseEntity courseEntity = Mapper.toCourseEntity(courseDto);
		CourseEntity savedCourse = courseRepo.save(courseEntity);
		return Mapper.toCourseDto(savedCourse);
	}

	@Override
	public CourseDto getCourseByID(Long id) {
		CourseEntity courseEntity = courseRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("course not found with id: " + id));
		return Mapper.toCourseDto(courseEntity);
	}

	@Override
	public CourseDto updateCourse(Long id, CourseDto courseDto) {
		CourseEntity courseEntity = courseRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("course not found with id: " + id));
		if (courseDto.getCourseName() != null) {
			courseEntity.setCourseName(courseDto.getCourseName());
		}
		if (courseDto.getInstructorId() != null) {
			instructorLookupService.validateInstructorExists(courseDto.getInstructorId());
			courseEntity.setInstructorId(courseDto.getInstructorId());
		}

		CourseEntity updatedCourse = courseRepo.save(courseEntity);
		CourseDto updatedCourseDto = Mapper.toCourseDto(updatedCourse);
		return updatedCourseDto;
	}

	@Override
	public CourseDto getCourseByInstructor(Long instructorId) {
		instructorLookupService.validateInstructorExists(instructorId);
		CourseEntity courseEntity = courseRepo.findByInstructorId(instructorId)
				.orElseThrow(() -> new ResourceNotFoundException("No course found for instructor with id: " + instructorId));
		return Mapper.toCourseDto(courseEntity);
	}

	@Override
	public void validateCourseExists(Long courseId) {
		if (courseId == null || !courseRepo.existsById(courseId)) {
			throw new ResourceNotFoundException("Course not found with id: " + courseId);
		}
	}

}
