package com.example.student.student_crud.modules.user.service;

import com.example.student.student_crud.exception.ResourceNotFoundException;
import com.example.student.student_crud.exception.UserAlreadyExistsException;
import com.example.student.student_crud.modules.mapper.Mapper;
import com.example.student.student_crud.modules.user.dao.RoleRepo;
import com.example.student.student_crud.modules.user.dao.UserRepo;
import com.example.student.student_crud.modules.user.dto.RoleDto;
import com.example.student.student_crud.modules.user.dto.UserDto;
import com.example.student.student_crud.modules.user.entity.Role;
import com.example.student.student_crud.modules.user.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private RoleRepo roleRepo;

    @Override
    public RoleDto createRole(RoleDto roleDto) {
        String roleName = roleDto.getRoleName();
        if (roleRepo.findByRoleName(roleName.toUpperCase()).isPresent()) {
            throw new UserAlreadyExistsException("Role " + roleName + " already exists");
        }

        Role role = Mapper.toRoleEntity(roleDto);
        Role savedRole = roleRepo.save(role);
        return Mapper.toRoleDto(savedRole);
    }

    @Override
    public UserDto registerUser(UserDto userDto) {
        Role role = roleRepo.findByRoleName(userDto.getRoleName().toUpperCase())
                .orElseThrow(() -> new ResourceNotFoundException("Role not found. Registration failed."));

        if (userRepo.findByUsername(userDto.getUsername()).isPresent()) {
            throw new UserAlreadyExistsException("Username already taken");
        }

        User newUser = Mapper.toUserEntity(userDto, role);
        User savedUser = userRepo.save(newUser);
        return Mapper.toUserDto(savedUser);
    }
}
