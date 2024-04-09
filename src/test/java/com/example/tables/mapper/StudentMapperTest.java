package com.example.tables.mapper;

import com.example.tables.dto.StudentDto;
import com.example.tables.entitiy.Course;
import com.example.tables.entitiy.Student;
//import com.example.tables.mapper.StudentMapper;
//import com.example.tables.mapper.StudentMapper;
import org.checkerframework.checker.units.qual.C;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class StudentMapperTest {

    public List<Course> courseCreator() {
        List<Course> courseList = new ArrayList<>();
        // Create Course objects and add them to the list without adding students
        Course course1 = new Course(9L, "hello", "ahhaha", 9, 2D, new ArrayList<>());
        courseList.add(course1);


        return courseList;
    }
    public List<Student> studentCreator() {
        List<Student> studentList = new ArrayList<>();
        // Create Student objects and add them to the list without setting courses
        Student student1 = new Student(9L, "hello", 7, "scul", new ArrayList<>());
        studentList.add(student1);
        System.out.println(studentList);
        return studentList;
    }

    @Test
    public void testMapToStudentDto() {
        List<Course> courseList = this.courseCreator();

        // Setup a student with simplified course details
        Student student = new Student();
        student.setId(1L);
        student.setName("parbati");
        student.setAge(60);
        student.setDept("something");
        student.setCourses(courseList);

        // Act
        StudentDto studentDto = StudentMapper.mapToStudentDto(student);

        // Assert basic information
       assertEquals(student.getId(), studentDto.getId());
        assertEquals(student.getName(), studentDto.getName());
        assertEquals(student.getAge(), studentDto.getAge());
        assertEquals(student.getDept(), studentDto.getDept());
        System.out.println(courseList);

        // Assert courses information
        assertEquals(student.getCourses(), studentDto.getCourses());
    }

    @Test
    public void  should_throw_null_pointer_exception_studentDto_to_student_when_studentDto_is_null(){
      var exp = assertThrows(NullPointerException.class,() ->StudentMapper.mapToStudent(null));
      assertEquals("The student Dto is null",exp.getMessage());

    }

    @Test
    public void testMapToStudent() {
        // Setup a StudentDto with simplified course details
        List<Course> courseList = this.courseCreator();

//        Given
//        StudentDto studentDto = new StudentDto();
//        studentDto.setId(1L);
//        studentDto.setName("parbati");
//        studentDto.setAge(60);
//        studentDto.setDept("something");
//        studentDto.setCourses(courseCreator());

                StudentDto studentDto = new StudentDto(
                        1L,
                        "Rita",
                        45,
                        "something",
                        courseList
                );


        // Act
//        When
        Student student = StudentMapper.mapToStudent(studentDto);

//        Then
        // Assert basic information
        assertEquals(studentDto.getId(), student.getId());
        assertEquals(studentDto.getName(), student.getName());
        assertEquals(studentDto.getAge(), student.getAge());
        assertEquals(studentDto.getDept(), student.getDept());

        // Assert courses information
        assertEquals(studentDto.getCourses(), student.getCourses());
    }


}
