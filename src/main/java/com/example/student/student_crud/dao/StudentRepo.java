package com.example.student.student_crud.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.student.student_crud.entity.StudentEntity;

@Repository
public interface StudentRepo extends JpaRepository<StudentEntity, Long> {
	
	@Query("select s from StudentEntity s where s.age>=:x ")
	List<StudentEntity> findByAge(@Param("x") int age);
	
}
