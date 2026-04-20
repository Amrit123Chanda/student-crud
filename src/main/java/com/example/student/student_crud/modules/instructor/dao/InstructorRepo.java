package com.example.student.student_crud.modules.instructor.dao;

import com.example.student.student_crud.modules.instructor.entity.InstructorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface InstructorRepo extends JpaRepository<InstructorEntity, Long> {
    @Query("SELECT i.id FROM InstructorEntity i WHERE i.id = :instructorId")
    Long checkInstructorById(@Param("instructorId") Long instructorId);
}
