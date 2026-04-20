package com.example.student.student_crud.modules.course.dao;

import com.example.student.student_crud.modules.course.entity.CourseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface CourseRepo extends JpaRepository<CourseEntity, Long> {

    @Query("SELECT c FROM CourseEntity c WHERE c.instructorId = :instructorId")
    Optional<CourseEntity> findByInstructorId(@Param("instructorId") Long instructorId);
}
