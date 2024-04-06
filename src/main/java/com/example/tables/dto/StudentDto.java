package com.example.tables.dto;

import com.example.tables.entitiy.Course;
import lombok.Data;

import java.util.Set;

@Data
public class StudentDto {
    private Long id;
    private String name;
    private int age;
    private String dept;
    private Set<Course> courses;

    public StudentDto(Long id, String name, int age, String dept, Set<Course> courses) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.dept = dept;
        this.courses = courses;
    }
}
