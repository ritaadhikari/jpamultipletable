package com.example.tables.repository;

import com.example.tables.entitiy.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course,Long> {

}
