package com.example.tables.controller;

import com.example.tables.dto.CourseDto;
import com.example.tables.dto.StudentDto;
import com.example.tables.entitiy.Student;
import com.example.tables.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/course")

public class CourseController {



    public final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }
    @PostMapping
    public ResponseEntity<CourseDto> addCourse(@RequestBody CourseDto courseDto){
        return new ResponseEntity<>(courseService.createCourse(courseDto), HttpStatus.CREATED);

    }



}
