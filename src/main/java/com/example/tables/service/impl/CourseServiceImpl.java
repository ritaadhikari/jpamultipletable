package com.example.tables.service.impl;

import com.example.tables.dto.CourseDto;
import com.example.tables.entitiy.Course;
import com.example.tables.mapper.CourseMapper;
import com.example.tables.repository.CourseRepository;
import com.example.tables.service.CourseService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService
{
    private final CourseRepository courseRepository;

    public CourseServiceImpl(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public CourseDto createCourse(CourseDto courseDto) {
        Course course = CourseMapper.mapToCourse(courseDto);
        Course savedCourse = courseRepository.save(course);
        return CourseMapper.maptoCourseDto(savedCourse);
    }

    @Override
    public List<Course> findByFeeLessThan(double fee) {
        return List.of();
    }
}
