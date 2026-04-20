package com.example.student.student_crud.modules.user.dao;

import com.example.student.student_crud.modules.user.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.Optional;

public interface RoleRepo extends JpaRepository<Role, Long> {
    @Query("SELECT r FROM Role r WHERE r.roleName = :roleName")
    Optional<Role> findByRoleName(String roleName);
}
