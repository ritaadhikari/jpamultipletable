package com.example.tables.service;

import com.example.tables.dto.StudentDto;
import com.example.tables.entitiy.Student;

import java.util.List;

public interface StudentService {
    StudentDto createStudent(StudentDto studentDto);
    List<Student> findByNameContaining(String name);


    List<StudentDto> getAllStudents();
}
