package com.example.student.student_crud.modules.instructor.service;

import com.example.student.student_crud.exception.ResourceNotFoundException;
import com.example.student.student_crud.modules.instructor.dao.InstructorRepo;
import com.example.student.student_crud.modules.instructor.dto.InstructorDto;
import com.example.student.student_crud.modules.instructor.entity.InstructorEntity;
import com.example.student.student_crud.modules.mapper.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InstructorService implements IinstructorService, IInstructorLookupService {

    private final InstructorRepo instructorRepo;

    @Autowired
    public InstructorService(InstructorRepo instructorRepo) {
        this.instructorRepo = instructorRepo;
    }

    @Override
    public InstructorDto getInstructorById(Long id)  {
        InstructorEntity entity = instructorRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Instructor not found with id: " + id));
        return Mapper.toinstructorDto(entity);
    }

    @Override
    public InstructorDto createInstructor(InstructorDto instructorDto) {
        InstructorEntity entity = Mapper.toinstructorEntity(instructorDto);
        InstructorEntity saved = instructorRepo.save(entity);
        return Mapper.toinstructorDto(saved);
    }

    @Override
    public InstructorDto updateInstructor(Long id, InstructorDto instructorDto) {
        InstructorEntity entity = instructorRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Instructor not found with id: " + id));

        if (instructorDto.getName() != null) {
            entity.setName(instructorDto.getName());
        }

        InstructorEntity updated = instructorRepo.save(entity);
        return Mapper.toinstructorDto(updated);
    }

    @Override
    public void validateInstructorExists(Long instructorId) {
        Long foundInstructorId = instructorRepo.checkInstructorById(instructorId);
        if (foundInstructorId == null) {
            throw new ResourceNotFoundException("Instructor not found with id: " + instructorId);
        }
    }
}


