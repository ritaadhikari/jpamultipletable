package com.example.tables.service;

import com.example.tables.dto.StudentDto;
import com.example.tables.entitiy.Student;
import org.springframework.data.domain.Page;

import java.util.List;

public interface StudentService {
    StudentDto createStudent(StudentDto studentDto);

    List<StudentDto> findAllByDept(String dept);
    List<StudentDto> findAllStudentByDept(String dept);


    List<StudentDto> getAllStudents();
//    Page<StudentDto> getAllStudents();


    StudentDto change(Long id, String name);
    void deleteStudent(Long id);

    void deleteStudentById(Long id);

    public record Greeting(long id, String content) { }


}
