package com.example.student.student_crud.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.student.student_crud.entity.CourseEntity;

@Repository
public interface CourseRepo extends JpaRepository<CourseEntity, Long> {

}
