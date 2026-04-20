# Student-Course Management System

A robust, modular Spring Boot RESTful API designed for managing academic records, including students, instructors, courses, and enrollments. Built with a focus on clean architecture, custom error handling, and cross-module data integrity.

## 🌟 Key Features

- **Modular Architecture**: Decoupled modules for Users, Students, Instructors, Courses, and Enrollments.
- **Data Integrity**: Service-layer validation (Lookup Interfaces) ensures that relationships (like Student-Course or Course-Instructor) remain consistent.
- **Smart Updates**: Support for partial updates (PATCH) that preserve existing data when null values are provided.
- **Centralized Mapping**: Manual `Mapper` class ensures total control over Entity-to-DTO conversions.
- **Unified Error Handling**: A global exception handler returns structured JSON responses for predictable API behavior.
- **Flexible Searching**: Search students by name patterns or filter by age ranges.

## 🏗️ Project Architecture

The project follows the **Controller-Service-Repository** pattern with a clear separation of concerns:

```text
com.example.student.student_crud/
├── modules/
│   ├── user/         # Role-based user registration
│   ├── student/      # Student profiles and searching
│   ├── instructor/   # Faculty management
│   ├── course/       # Curriculum and instructor assignment
│   ├── enrollment/   # Many-to-Many enrollment logic
│   └── mapper/       # Centralized Entity/DTO conversion
├── exception/        # Custom exceptions & REST Advice
└── StudentCrudApplication.java
```

## 🚀 API Documentation

### User & Role Management
- `POST /user/create-role`: Define new system roles (e.g., ADMIN, STUDENT).
- `POST /user/register`: Register new users with specific roles.

### Student Management
- `POST /students`: Create a new student record.
- `GET /students/{id}`: Fetch detailed student profile.
- `GET /students/search?name={query}`: Search students by name (supports partial matching).
- `GET /students/age?age={minAge}`: Filter students by minimum age.
- `PATCH /students/{id}`: Update specific student details.

### Academic Management
- `POST /instructor/create`: Onboard new instructors.
- `POST /course/save`: Create courses and link them to existing instructors.
- `GET /course/getbyinstructor/{id}`: Retrieve curriculum managed by a specific instructor.

### Enrollment System
- `POST /enrollment/enroll`: Securely link a student to a course.
- `DELETE /enrollment/unenroll`: Remove a student from a course.
- `GET /enrollment/student/{id}/courses`: View all course registrations for a student.

## 🛠️ Tech Stack

- **Backend**: Java 17, Spring Boot 3.x
- **Persistence**: Spring Data JPA, Hibernate
- **Database**: MySQL
- **Build Tool**: Maven

## 🚦 Getting Started

1. **Database Setup**:
   Create a schema named `student_crud` in MySQL.

2. **Configuration**:
   Update `src/main/resources/application.properties` with your database credentials.

3. **Build and Run**:
   ```bash
   mvn clean install
   mvn spring-boot:run
   ```

## 🛡️ Error Handling Map

| Exception | HTTP Status | Use Case |
| :--- | :--- | :--- |
| `ResourceNotFoundException` | 404 Not Found | Missing ID (Student, Course, etc.) |
| `UserAlreadyExistsException`| 409 Conflict | Duplicate Username or Role |
| `UnauthorizedException`     | 403 Forbidden | Accessing restricted operations |
| `IllegalStateException`     | 409 Conflict | Business logic state conflicts |
