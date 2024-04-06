package com.example.tables.mapper;

import com.example.tables.dto.CourseDto;
import com.example.tables.entitiy.Course;

public class CourseMapper {
    public static Course mapToCourse(CourseDto courseDto) {
        Course course = new Course(
                courseDto.getId(),
                courseDto.getTitle(),
                courseDto.getAbbreviation(),
                courseDto.getModules(),
                courseDto.getFee(),
                courseDto.getStudents()

        );
                return course;
    }
    public static CourseDto maptoCourseDto(Course course){
        CourseDto courseDto =new CourseDto(
                course.getId(),
                course.getTitle(),
                course.getAbbreviation(),
                course.getModules(),
                course.getFee(),
                course.getStudents()
        );
        return courseDto;
    }
}
