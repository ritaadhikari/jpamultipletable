package com.example.tables.service.impl;

import com.example.tables.dto.StudentDto;
import com.example.tables.entitiy.Student;
import com.example.tables.mapper.StudentMapper;
import com.example.tables.repository.StudentRepository;
import com.example.tables.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {

     private  final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public StudentDto createStudent(StudentDto studentDto) {
        Student student = StudentMapper.mapToStudent(studentDto);
        Student savedStudent = studentRepository.save(student);
        return StudentMapper.mapToStudentDto(savedStudent);

    }

    @Override
    public List<Student> findByNameContaining(String name) {
        return List.of();
    }

    @Override
    public List<StudentDto> getAllStudents() {
        List<Student> students = studentRepository.findAll();
        return students.stream().map((student) -> StudentMapper.mapToStudentDto(student)).collect(Collectors.toList());
    }

}
