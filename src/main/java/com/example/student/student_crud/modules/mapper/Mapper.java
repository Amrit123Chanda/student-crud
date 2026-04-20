package com.example.student.student_crud.modules.mapper;

import com.example.student.student_crud.modules.course.dto.CourseDto;
import com.example.student.student_crud.modules.course.entity.CourseEntity;
import com.example.student.student_crud.modules.instructor.dto.InstructorDto;
import com.example.student.student_crud.modules.instructor.entity.InstructorEntity;
import com.example.student.student_crud.modules.student.dto.StudentDto;
import com.example.student.student_crud.modules.student.entity.StudentEntity;
import com.example.student.student_crud.modules.user.dto.RoleDto;
import com.example.student.student_crud.modules.user.dto.UserDto;
import com.example.student.student_crud.modules.user.entity.Role;
import com.example.student.student_crud.modules.user.entity.User;

public class Mapper {

	public static StudentDto toStdDto(StudentEntity stdEnt)
	{
		StudentDto stdDto = new StudentDto();
		
		stdDto.setId(stdEnt.getId());
		stdDto.setName(stdEnt.getName());
		stdDto.setAge(stdEnt.getAge());
		stdDto.setCity(stdEnt.getCity());
		stdDto.setState(stdEnt.getState());
		
		return stdDto;
	}
	
	public static StudentEntity toStdEntity(StudentDto stdDto)
	{
		StudentEntity stdEnt = new StudentEntity();
		
		stdEnt.setId(stdDto.getId());
		stdEnt.setName(stdDto.getName());
		stdEnt.setAge(stdDto.getAge());
		stdEnt.setCity(stdDto.getCity());
		stdEnt.setState(stdDto.getState());
		
		return stdEnt;
	}
	
	public static CourseEntity toCourseEntity(CourseDto courseDto)
	{
		CourseEntity courseEntity = new CourseEntity();
		
		courseEntity.setId(courseDto.getId());
		courseEntity.setCourseName(courseDto.getCourseName());
		courseEntity.setInstructorId(courseDto.getInstructorId());

		return courseEntity;
	}
	
	public static CourseDto toCourseDto(CourseEntity courseEnt)
	{
		CourseDto courseDto= new CourseDto();
		courseDto.setId(courseEnt.getId());
		courseDto.setCourseName(courseEnt.getCourseName());
		courseDto.setInstructorId(courseEnt.getInstructorId());

		return courseDto;
	}

	public static InstructorEntity toinstructorEntity(InstructorDto instructorDto)
	{
		InstructorEntity instructorEntity = new InstructorEntity();
		instructorEntity.setId(instructorDto.getId());
		instructorEntity.setName(instructorDto.getName());

		return instructorEntity;
	}
	public static InstructorDto toinstructorDto(InstructorEntity instructorEntity)
	{
		InstructorDto instructorDto = new InstructorDto();
		instructorDto.setId(instructorEntity.getId());
		instructorDto.setName(instructorEntity.getName());

		return instructorDto;
	}

	public static RoleDto toRoleDto(Role role) {
		RoleDto roleDto = new RoleDto();
		roleDto.setId(role.getId());
		roleDto.setRoleName(role.getRoleName());
		return roleDto;
	}

	public static UserDto toUserDto(User user) {
		UserDto userDto = new UserDto();
		userDto.setId(user.getId());
		userDto.setUsername(user.getUsername());
		userDto.setRoleName(user.getRole().getRoleName());

		return userDto;
	}

	public static Role toRoleEntity(RoleDto roleDto) {
		Role role = new Role();
		String roleName= role.getRoleName().toUpperCase();
		if(roleName.startsWith("ROLE_"))
			role.setRoleName(roleName);
		else
			role.setRoleName("ROLE_"+roleName);
		return role;
	}

    public static User toUserEntity(UserDto userDto, Role role) {
        User user = new User();
        user.setUsername(userDto.getUsername());
        user.setPassword(userDto.getPassword());
		user.setRole(role);
        return user;
    }
}
