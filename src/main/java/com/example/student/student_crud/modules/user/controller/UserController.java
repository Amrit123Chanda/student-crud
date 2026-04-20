package com.example.student.student_crud.modules.user.controller;

import com.example.student.student_crud.modules.user.dto.RoleDto;
import com.example.student.student_crud.modules.user.dto.UserDto;
import com.example.student.student_crud.modules.user.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;

    // Admin creates roles STUDENT and INSTRUCTOR
    @PostMapping("/create-role")
    public ResponseEntity<RoleDto> createRole(@RequestBody RoleDto roleDto) {
        RoleDto createdRole = userService.createRole(roleDto);
        return new ResponseEntity<>(createdRole, HttpStatus.CREATED);
    }

    // STUDENT or INSTRUCTOR registers their username and password
    @PostMapping("/register")
    public ResponseEntity<UserDto> registerUser(@RequestBody UserDto userDto) {
        UserDto registeredUser = userService.registerUser(userDto);
        return new ResponseEntity<>(registeredUser, HttpStatus.CREATED);
    }
}
