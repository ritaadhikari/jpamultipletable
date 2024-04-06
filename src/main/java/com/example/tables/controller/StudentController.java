package com.example.tables.controller;

import com.example.tables.dto.StudentDto;
import com.example.tables.entitiy.Student;
import com.example.tables.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")

public class StudentController {

    public final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public ResponseEntity<StudentDto> addStudent(@RequestBody StudentDto studentDto){
        return new ResponseEntity<>(studentService.createStudent(studentDto), HttpStatus.CREATED);

    }

    @GetMapping
    public ResponseEntity<List<StudentDto>> getAllStudents(){

        List<StudentDto> students = studentService.getAllStudents();
        return ResponseEntity.ok(students);
    }
}

