package com.example.student.student_crud.modules.student.dao;

import com.example.student.student_crud.modules.student.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepo extends JpaRepository<StudentEntity, Long> {
	
	@Query("select s from StudentEntity s where s.age>=:x ")
	List<StudentEntity> findByAge(@Param("x") int age);

	@Query("Select s from StudentEntity s where s.name like %:name%")
	List<StudentEntity> findByName(String name);
}
