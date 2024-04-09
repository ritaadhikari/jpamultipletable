package com.example.tables.mapper;

import com.example.tables.dto.StudentDto;
import com.example.tables.entitiy.Student;

public class StudentMapper {

    public static Student mapToStudent(StudentDto studentDto) {

        if(studentDto == null){
            throw new NullPointerException("The student Dto is null");
        }

        Student student = new Student(
                studentDto.getId(),
                studentDto.getName(),
                studentDto.getAge(),
                studentDto.getDept(),
                studentDto.getCourses()
        );
                return student;
    }

    public static StudentDto mapToStudentDto(Student student) {
        StudentDto studentDto =new StudentDto(
                student.getId(),
                student.getName() ,
                student.getAge(),
                student.getDept(),
                student.getCourses()
        );
        return  studentDto;
    }
}
