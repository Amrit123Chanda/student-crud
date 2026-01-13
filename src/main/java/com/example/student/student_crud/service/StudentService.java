package com.example.student.student_crud.service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.student.student_crud.dao.StudentRepo;
import com.example.student.student_crud.dto.StudentDto;
import com.example.student.student_crud.entity.StudentEntity;
import com.example.student.student_crud.mapper.StudentMapper;

@Service
public class StudentService implements IstudentService{

	@Autowired
	StudentRepo studentrepo;

	@Override
	public StudentDto getStudentById(Long id) {
		StudentEntity stdEntity=null ;
		Optional<StudentEntity> stdEntOpt = studentrepo.findById(id);
		if(stdEntOpt.isPresent())
			stdEntity=stdEntOpt.get();
//		else
//			stdEntity=null;
		
		StudentDto stdDto=StudentMapper.toDto(stdEntity);
		
		return stdDto;
	}

	@Override
	public StudentDto createStudent(StudentDto stdDto) {
		// TODO Auto-generated method stub
		StudentEntity stdEntity= StudentMapper.toEntity(stdDto);
		StudentEntity savedEntity=studentrepo.save(stdEntity);
		StudentDto resultStudentDto=StudentMapper.toDto(savedEntity);
		return stdDto;
	}
	
	
	
}
