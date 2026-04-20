package com.example.student.student_crud.modules.enrollment.dao;

import com.example.student.student_crud.modules.enrollment.entity.EnrollmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EnrollmentRepo extends JpaRepository<EnrollmentEntity, Long> {

    @Query("SELECT e.courseId FROM EnrollmentEntity e WHERE e.studentId = :studentId")
    List<Long> findCourseIdsByStudentId(@Param("studentId") Long studentId);

    @Query("SELECT e.studentId FROM EnrollmentEntity e WHERE e.courseId = :courseId")
    List<Long> findStudentIdsByCourseId(@Param("courseId") Long courseId);

    Optional<EnrollmentEntity> findByStudentId(Long studentId);

    Optional<EnrollmentEntity> findByStudentIdAndCourseId(Long studentId, Long courseId);
}
