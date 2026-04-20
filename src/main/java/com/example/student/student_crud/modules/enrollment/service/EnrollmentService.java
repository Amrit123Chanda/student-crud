package com.example.student.student_crud.modules.enrollment.service;

import com.example.student.student_crud.exception.ResourceNotFoundException;
import com.example.student.student_crud.modules.course.service.CourseLookup;
import com.example.student.student_crud.modules.enrollment.dao.EnrollmentRepo;
import com.example.student.student_crud.modules.enrollment.dto.EnrollmentDto;
import com.example.student.student_crud.modules.enrollment.entity.EnrollmentEntity;
import com.example.student.student_crud.modules.student.service.StudentLookup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EnrollmentService implements IenrollmentService {

    private final EnrollmentRepo enrollmentRepo;
    private final StudentLookup studentLookup;
    private final CourseLookup courseLookup;

    @Autowired
    public EnrollmentService(EnrollmentRepo enrollmentRepo, StudentLookup studentLookup, CourseLookup courseLookup) {
        this.enrollmentRepo = enrollmentRepo;
        this.studentLookup = studentLookup;
        this.courseLookup = courseLookup;
    }

    @Override
    public EnrollmentDto enroll(EnrollmentDto enrollmentDto) {
        validateStudentExists(enrollmentDto.getStudentId());
        validateCourseExists(enrollmentDto.getCourseId());

        Optional<EnrollmentEntity> existing = enrollmentRepo.findByStudentIdAndCourseId(enrollmentDto.getStudentId(), enrollmentDto.getCourseId());
        EnrollmentEntity enrollmentEntity;
        if (existing.isPresent()) {
            enrollmentEntity = existing.get();
        } else {
            enrollmentEntity = enrollmentRepo.save(new EnrollmentEntity(enrollmentDto.getStudentId(), enrollmentDto.getCourseId()));
        }

        EnrollmentDto saved = new EnrollmentDto();
        saved.setStudentId(enrollmentEntity.getStudentId());
        saved.setCourseId(enrollmentEntity.getCourseId());
        return saved;
    }

    @Override
    public void unenroll(Long studentId, Long courseId) {
        EnrollmentEntity enrollmentEntity = enrollmentRepo.findByStudentIdAndCourseId(studentId, courseId)
                .orElseThrow(() -> new ResourceNotFoundException("Enrollment not found for studentId: " + studentId + " and courseId: " + courseId));
        enrollmentRepo.delete(enrollmentEntity);
    }

    @Override
    public List<Long> getCourseIdsByStudentId(Long studentId) {
        validateStudentExists(studentId);
        return enrollmentRepo.findCourseIdsByStudentId(studentId);
    }

    @Override
    public List<Long> getStudentIdsByCourseId(Long courseId) {
        validateCourseExists(courseId);
        return enrollmentRepo.findStudentIdsByCourseId(courseId);
    }

    private void validateStudentExists(Long studentId) {
        studentLookup.validateStudentExists(studentId);
    }

    private void validateCourseExists(Long courseId) {
        courseLookup.validateCourseExists(courseId);
    }
}
