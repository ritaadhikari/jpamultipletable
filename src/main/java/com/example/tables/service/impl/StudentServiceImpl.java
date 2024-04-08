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
    public List<StudentDto> findAllByDept(String dept) {
        List<Student> students =studentRepository.findAllByDept(dept);
        return students.stream().map((student) -> StudentMapper.mapToStudentDto(student)).collect(Collectors.toList());
    }

    @Override
    public List<StudentDto> findAllStudentByDept(String dept) {
        List<Student> students =studentRepository.findAllStudentByDept(dept);
        return students.stream().map((student) -> StudentMapper.mapToStudentDto(student)).collect(Collectors.toList());

    }

    @Override
    public List<StudentDto> getAllStudents() {
        List<Student> students = studentRepository.findAll();
        return students.stream().map((student) -> StudentMapper.mapToStudentDto(student)).collect(Collectors.toList());
    }

    @Override
    public StudentDto change(Long id, String name) {
        Student student = studentRepository.findById(id).orElseThrow(()->new RuntimeException("Student does not exist"));
//        String updateName = student.getName() + name;
        student.setName(name);
        Student savedName = studentRepository.save(student);
        return StudentMapper.mapToStudentDto(savedName);
    }

    @Override
    public void deleteStudentById(Long id) {
        Student student = studentRepository.findById(id).orElseThrow(()->new RuntimeException("Student does not exist"));
        studentRepository.deleteById(id);
    }
//    .orElseThrow(() -> new BookNotFoundException());

    @Override
    public void deleteStudent(Long id) {
        Student student = studentRepository.findById(id).orElseThrow(()->new RuntimeException("Student does not exist"));
        studentRepository.deleteById(id);

    }



}
