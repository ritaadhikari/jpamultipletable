package com.example.tables.repository;

import com.example.tables.entitiy.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Long> {
}
