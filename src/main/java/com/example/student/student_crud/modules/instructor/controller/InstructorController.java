package com.example.student.student_crud.modules.instructor.controller;

import com.example.student.student_crud.modules.instructor.dto.InstructorDto;
import com.example.student.student_crud.modules.instructor.service.IinstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/instructors")
public class InstructorController {

    private final IinstructorService instructorService;

    @Autowired
    public InstructorController(IinstructorService instructorService) {
        this.instructorService = instructorService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<InstructorDto> getInstructorById(@PathVariable Long id)  {
        InstructorDto instructorDto = instructorService.getInstructorById(id);
        return ResponseEntity.ok(instructorDto);
    }

    @PostMapping
    public ResponseEntity<InstructorDto> createInstructor(@RequestBody InstructorDto dto) {
        InstructorDto createdInstructor = instructorService.createInstructor(dto);
        return new ResponseEntity<>(createdInstructor, HttpStatus.CREATED);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<InstructorDto> updateInstructor(@PathVariable Long id, @RequestBody InstructorDto dto) {
        InstructorDto updatedInstructor = instructorService.updateInstructor(id, dto);
        return ResponseEntity.ok(updatedInstructor);
    }

}
