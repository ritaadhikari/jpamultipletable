package com.example.tables.dto;

import com.example.tables.entitiy.Student;
import lombok.Data;

import java.util.List;
import java.util.Set;

@Data
public class CourseDto {
    private Long id;
    private String title;
    private String abbreviation;
    private int modules;
    private double fee;
    private List<Student> students;

    public CourseDto(Long id, String title, String abbreviation, int modules, double fee, List<Student> students) {
        this.id = id;
        this.title = title;
        this.abbreviation = abbreviation;
        this.modules = modules;
        this.fee = fee;
        this.students = students;
    }
}
