package com.example.student.student_crud.modules.student.service;


import com.example.student.student_crud.exception.ResourceNotFoundException;
import com.example.student.student_crud.modules.mapper.Mapper;
import com.example.student.student_crud.modules.student.dao.StudentRepo;
import com.example.student.student_crud.modules.student.dto.StudentDto;
import com.example.student.student_crud.modules.student.entity.StudentEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService implements IstudentService, StudentLookup{

	@Autowired
	StudentRepo studentrepo;

	@Override
	public StudentDto getStudentById(Long id)  {
		StudentEntity stdEntity=null ;
		Optional<StudentEntity> stdEntOpt = studentrepo.findById(id);
		if(stdEntOpt.isPresent()) {
			stdEntity = stdEntOpt.get();
			StudentDto stdDto = Mapper.toStdDto(stdEntity);
			return stdDto;
		}
		else
			throw new ResourceNotFoundException("No record found");
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
		List<StudentEntity> stdEntityList = studentrepo.findByAge(age);
		List<StudentDto> stdDtoList = new ArrayList<>();

		for(StudentEntity singleStdEntity:stdEntityList)
		{
			 StudentDto stdDto= Mapper.toStdDto(singleStdEntity);
			 stdDtoList.add(stdDto);
		}

		return stdDtoList;
	}

	@Override
	public List<StudentDto> searchStudentbyName(String name) {
		List<StudentEntity> studentsEntityByName= studentrepo.findByName(name);
		List<StudentDto> StudentDtoByName = new ArrayList<>();
		for(StudentEntity stdEnt:studentsEntityByName)
		{
			StudentDto stdDto= Mapper.toStdDto(stdEnt);
			StudentDtoByName.add(stdDto);
		}

		return StudentDtoByName;

	}

	@Override
	public StudentDto updateStudent(Long id, StudentDto stdDto)  {
		StudentEntity stdEntity = studentrepo.findById(id)
			.orElseThrow(() -> new ResourceNotFoundException("Student not found with id: " + id));

		// Update basic fields only if provided (preserve existing values when null)
		if (stdDto.getName() != null) {
			stdEntity.setName(stdDto.getName());
		}
		if (stdDto.getAge() != null) {
			stdEntity.setAge(stdDto.getAge());
		}
		if (stdDto.getCity() != null) {
			stdEntity.setCity(stdDto.getCity());
		}
		if (stdDto.getState() != null) {
			stdEntity.setState(stdDto.getState());
		}

		// Save and return
		StudentEntity updatedEntity = studentrepo.save(stdEntity);
		return Mapper.toStdDto(updatedEntity);
	}

	@Override
	public void validateStudentExists(Long studentId) {
		if (studentId == null || !studentrepo.existsById(studentId)) {
			throw new ResourceNotFoundException("Student not found with id: " + studentId);
		}
	}
}
