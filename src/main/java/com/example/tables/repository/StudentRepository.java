package com.example.tables.repository;

import com.example.tables.dto.StudentDto;
import com.example.tables.entitiy.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student,Long> {

    List<Student> findAllByDept(String dept);

    List<Student> findAllStudentByDept(String dept);

    void deleteBydept(String dept);

    Optional<Student> findByDept(String dept);
}
