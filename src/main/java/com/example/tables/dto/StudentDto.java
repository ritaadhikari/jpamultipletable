package com.example.tables.dto;

import com.example.tables.entitiy.Course;
import jakarta.persistence.Column;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
public class StudentDto {
    @Column(nullable = false)
    private Long id;
    @Column(nullable = false,length = 60,unique = true)
    private String name;
    @Column(nullable = false,length = 20)
    private int age;
    private String dept;
    private List<Course> courses;

    public StudentDto(Long id, String name, int age, String dept, List<Course> courses) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.dept = dept;
        this.courses = courses;
    }
}
