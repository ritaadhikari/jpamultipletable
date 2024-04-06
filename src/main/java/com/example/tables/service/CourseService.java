package com.example.tables.service;

import com.example.tables.dto.CourseDto;
import com.example.tables.dto.StudentDto;
import com.example.tables.entitiy.Course;

import java.util.List;

public interface CourseService {
   CourseDto createCourse(CourseDto courseDto);

   List<Course> findByFeeLessThan(double fee);

}
