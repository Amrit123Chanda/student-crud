package com.example.student.student_crud.mapper;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.example.student.student_crud.dto.AddressDto;
import com.example.student.student_crud.dto.CourseDto;
import com.example.student.student_crud.dto.StudentDto;
import com.example.student.student_crud.entity.AddressEntity;
import com.example.student.student_crud.entity.CourseEntity;
import com.example.student.student_crud.entity.StudentEntity;

public class StudentMapper {

	public static StudentDto toStdDto(StudentEntity stdEnt)
	{
		StudentDto stdDto = new StudentDto();
		
		stdDto.setId(stdEnt.getId());
		stdDto.setName(stdEnt.getName());
		stdDto.setAge(stdEnt.getAge());
		
		List<AddressEntity> listAddEnt=stdEnt.getListAdd();
		List<AddressDto> listAddDto=new ArrayList<>();
		for(AddressEntity addEnt:listAddEnt)
		{
			AddressDto addDto=toAddDto(addEnt);
			listAddDto.add(addDto);
		}
		stdDto.setAddresses(listAddDto);
		
		Set<CourseEntity> setCourseEnt=stdEnt.getStudentCourseSet();
		Set<CourseDto> setCourseDto=new HashSet<>();
		for(CourseEntity courseEntity:setCourseEnt)
		{
			CourseDto courseDto=toCourseDto(courseEntity);
			setCourseDto.add(courseDto);
		}
		stdDto.setCourses(setCourseDto);
		
		return stdDto;
	}
	
	public static StudentEntity toStdEntity(StudentDto stdDto)
	{
		StudentEntity stdEnt = new StudentEntity();
		
		stdEnt.setId(stdDto.getId());
		stdEnt.setName(stdDto.getName());
		stdEnt.setAge(stdDto.getAge());
		List<AddressDto> listAddDto=stdDto.getAddresses();
		List<AddressEntity> listAddEntity=new ArrayList<>();
		for(AddressDto addDto:listAddDto)
		{
			AddressEntity addEnt=toAddEntity(addDto);
			listAddEntity.add(addEnt);
		}
		stdEnt.setListAdd(listAddEntity);
		
		Set<CourseDto> setCourseDto=stdDto.getCourses();
		Set<CourseEntity> setCourseEntity = new HashSet<>();
		for(CourseDto courseDto:setCourseDto)
		{
			CourseEntity courseEntity=toCourseEntity(courseDto);
			setCourseEntity.add(courseEntity);
		}
		stdEnt.setStudentCourseSet(setCourseEntity);
		
		return stdEnt;
		
	}
	
	public static AddressEntity toAddEntity(AddressDto addDto)
	{
		AddressEntity addEnt = new AddressEntity();
		addEnt.setId(addDto.getId());
		addEnt.setCity(addDto.getCity());
		addEnt.setState(addDto.getState());
		
		return addEnt;
	}
	
	public static CourseEntity toCourseEntity(CourseDto courseDto)
	{
		CourseEntity courseEntity = new CourseEntity();
		
		courseEntity.setId(courseDto.getId());
		courseEntity.setCourseName(courseDto.getCourseName());
		
		return courseEntity;
	}
	
	public static AddressDto toAddDto(AddressEntity addEnt)
	{
		AddressDto addDto=new AddressDto();
		
		addDto.setId(addEnt.getId());
		addDto.setCity(addEnt.getCity());
		addDto.setState(addEnt.getState());
		
		return addDto;
	}
	
	public static CourseDto toCourseDto(CourseEntity courseEnt)
	{
		CourseDto courseDto= new CourseDto();
		courseDto.setId(courseEnt.getId());
		courseDto.setCourseName(courseEnt.getCourseName());
		
		return courseDto;
	}

}
