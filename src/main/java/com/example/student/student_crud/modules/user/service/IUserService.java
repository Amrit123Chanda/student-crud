package com.example.student.student_crud.modules.user.service;

import com.example.student.student_crud.modules.user.dto.RoleDto;
import com.example.student.student_crud.modules.user.dto.UserDto;

public interface IUserService {
    RoleDto createRole(RoleDto roleDto);
    UserDto registerUser(UserDto userDto);
}
