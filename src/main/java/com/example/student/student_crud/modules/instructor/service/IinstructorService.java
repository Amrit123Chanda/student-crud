package com.example.student.student_crud.modules.instructor.service;

import com.example.student.student_crud.modules.instructor.dto.InstructorDto;

public interface IinstructorService {

    InstructorDto getInstructorById(Long id) ;

    InstructorDto createInstructor(InstructorDto instructorDto);

    InstructorDto updateInstructor(Long id, InstructorDto instructorDto) ;
}

