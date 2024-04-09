package com.example.tables.service.impl;

import com.example.tables.dto.StudentDto;
import com.example.tables.entitiy.Course;
import com.example.tables.entitiy.Student;
import com.example.tables.mapper.StudentMapper;
import com.example.tables.repository.StudentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class StudentServiceImplTest {
    public List<Course> courseCreator() {
        List<Course> courseList = new ArrayList<>();
        // Create Course objects and add them to the list without adding students
        Course course1 = new Course(9L, "hello", "ahhaha", 9, 2D, new ArrayList<>());
        courseList.add(course1);


        return courseList;
    }

//Which service you want to test
    @InjectMocks
    private StudentServiceImpl studentServiceImpl;

//declare the dependencies
//    To run the above test in the isolated way we have to mock this repositories
    @Mock
    private StudentRepository studentRepository;
    @Mock
    private StudentMapper studentMapper;
    @BeforeEach

    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void shouldSucessfullySaveTheStudent(){

        List<Course> courseList = this.courseCreator();
//Arrange
        StudentDto student1 = new StudentDto(
                1L,
                "Rita",
                45,
                "something",
                courseList
        );
        Student studentEntity = studentMapper.mapToStudent(student1);



//Act
        studentRepository.save(studentEntity);


        //Assert
        assertEquals(45, studentEntity.getAge());

    }
}