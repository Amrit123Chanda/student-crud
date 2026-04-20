package com.example.student.student_crud.modules.enrollment.service;

import com.example.student.student_crud.modules.enrollment.dto.EnrollmentDto;

import java.util.List;

public interface IenrollmentService {
    EnrollmentDto enroll(EnrollmentDto enrollmentDto);

    void unenroll(Long studentId, Long courseId);

    List<Long> getCourseIdsByStudentId(Long studentId);

    List<Long> getStudentIdsByCourseId(Long courseId);
}
