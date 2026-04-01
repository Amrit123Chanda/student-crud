package com.example.student.student_crud.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.student.student_crud.dao.StudentRepo;
import com.example.student.student_crud.dto.StudentDto;
import com.example.student.student_crud.entity.StudentEntity;
import com.example.student.student_crud.mapper.Mapper;

@Service
public class StudentService implements IstudentService{

	@Autowired
	StudentRepo studentrepo;// int x ;

	@Override
	public StudentDto getStudentById(Long id) {
		StudentEntity stdEntity=null ;
		Optional<StudentEntity> stdEntOpt = studentrepo.findById(id);
		if(stdEntOpt.isPresent())
			stdEntity=stdEntOpt.get();
//		else
//			stdEntity=null;
		
		StudentDto stdDto= Mapper.toStdDto(stdEntity);
		
		return stdDto;
	}

	@Override
	public StudentDto createStudent(StudentDto stdDto) {
		// TODO Auto-generated method stub
		StudentEntity stdEntity= Mapper.toStdEntity(stdDto);
		StudentEntity savedEntity=studentrepo.save(stdEntity);
		StudentDto resultStudentDto= Mapper.toStdDto(savedEntity);
		return resultStudentDto;
	}
	
	public List<StudentDto> getStudentByAge(Integer age){
		
		List<StudentEntity> stdEntityList =studentrepo.findByAge(age);
		
		List<StudentDto> stdDtoList = new ArrayList<>();
		
		for(StudentEntity singleStdEntity:stdEntityList)
		{
			 StudentDto stdDto= Mapper.toStdDto(singleStdEntity);
			 stdDtoList.add(stdDto);
		}
		
		return stdDtoList;
	}
	
	
}
