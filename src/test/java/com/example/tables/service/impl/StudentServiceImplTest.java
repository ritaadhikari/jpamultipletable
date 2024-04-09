package com.example.tables.service.impl;

import com.example.tables.mapper.StudentMapper;
import com.example.tables.repository.StudentRepository;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

class StudentServiceImplTest {

//Which service you want to test
    private StudentServiceImpl studentServiceImpl;

//declare the dependencies
    private StudentRepository studentRepository;
    private StudentMapper studentMapper;
    @BeforeEach
    void setUp() {
    }
}