package com.example.student.student_crud.modules.enrollment.controller;

import com.example.student.student_crud.modules.enrollment.dto.EnrollmentDto;
import com.example.student.student_crud.modules.enrollment.service.IenrollmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/enrollments")
public class EnrollmentController {

    private final IenrollmentService enrollmentService;

    @Autowired
    public EnrollmentController(IenrollmentService enrollmentService) {
        this.enrollmentService = enrollmentService;
    }

    @PostMapping
    public ResponseEntity<EnrollmentDto> enroll(@RequestBody EnrollmentDto enrollmentDto) {
        EnrollmentDto enrolled = enrollmentService.enroll(enrollmentDto);
        return new ResponseEntity<>(enrolled, HttpStatus.CREATED);
    }

    @DeleteMapping("/students/{studentId}/courses/{courseId}")
    public ResponseEntity<Void> unenroll(@PathVariable Long studentId, @PathVariable Long courseId) {
        enrollmentService.unenroll(studentId, courseId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/students/{studentId}/courses")
    public ResponseEntity<List<Long>> getCourseIdsByStudent(@PathVariable Long studentId) {
        List<Long> courseIds = enrollmentService.getCourseIdsByStudentId(studentId);
        return ResponseEntity.ok(courseIds);
    }

    @GetMapping("/courses/{courseId}/students")
    public ResponseEntity<List<Long>> getStudentIdsByCourse(@PathVariable Long courseId) {
        List<Long> studentIds = enrollmentService.getStudentIdsByCourseId(courseId);
        return ResponseEntity.ok(studentIds);
    }
}
