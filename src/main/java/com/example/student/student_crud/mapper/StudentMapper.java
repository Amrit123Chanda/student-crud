package com.example.student.student_crud.mapper;

import com.example.student.student_crud.dto.StudentDto;
import com.example.student.student_crud.entity.StudentEntity;

public class StudentMapper {

	public static StudentDto toDto(StudentEntity stdEnt)
	{
		StudentDto stdDto = new StudentDto();
		
		stdDto.setId(stdEnt.getId());
		stdDto.setName(stdEnt.getName());
		stdDto.setAge(stdEnt.getAge());
		stdDto.setAddress(stdEnt.getAddress());
		
		return stdDto;
	}
	
	public static StudentEntity toEntity(StudentDto stdDto)
	{
		StudentEntity stdEnt = new StudentEntity();
		
		stdEnt.setId(stdDto.getId());
		stdEnt.setName(stdDto.getName());
		stdEnt.setAddress(stdDto.getAddress());
		stdEnt.setAge(stdDto.getAge());
		
		return stdEnt;
		
	}
}
