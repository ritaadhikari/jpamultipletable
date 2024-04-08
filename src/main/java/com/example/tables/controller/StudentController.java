package com.example.tables.controller;

import com.example.tables.dto.StudentDto;
import com.example.tables.entitiy.Student;
import com.example.tables.service.StudentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Book;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;


import java.util.List;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("/student")

public class StudentController {

    public final StudentService studentService;
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    private static final String name = "Rita Adhikari";
    String j;

    String[] cars = {"Volvo", "BMW", "Ford", "Mazda"};


    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public ResponseEntity<StudentDto> addStudent(@RequestBody StudentDto studentDto) {
        return new ResponseEntity<>(studentService.createStudent(studentDto), HttpStatus.CREATED);

    }

    @Operation(summary = "Get a book by its id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the book",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Book.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid id supplied",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Book not found",
                    content = @Content) })
    @GetMapping
    public ResponseEntity<List<StudentDto>> getAllStudents() {

        List<StudentDto> students = studentService.getAllStudents();
        return ok(students);
    }

    @GetMapping("/greeting")
    public StudentService.Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new StudentService.Greeting(counter.incrementAndGet(), String.format(template, name));
    }

    @GetMapping("/name")
        public String cars() {
        String j="";
        for (int i = 0; i < cars.length; i++) {
           j = cars[i];
            System.out.println(cars[i]);

        }
        return cars[3];
    }

    @GetMapping("/find/{dept}")
    public ResponseEntity<List<StudentDto>> findAllByDept(@PathVariable("dept") String dept){
        List<StudentDto> students = studentService.findAllByDept(dept);
        return ok(students);

    }
    @GetMapping("/find/student/{dept}")
    public ResponseEntity<List<StudentDto>> findAllStudentByDept(@PathVariable("dept") String dept){
        List<StudentDto> students = studentService.findAllByDept(dept);
        return ok(students);

    }
    @PutMapping("/{id}/change")
    public ResponseEntity<StudentDto> change(@PathVariable Long id ,@RequestBody Map<String,String> request){
        String name = request.get("name");
        StudentDto studentDto = studentService.change(id,name);

        return ResponseEntity.ok(studentDto);
    }
//    @DeleteMapping("{dept}")
//    public ResponseEntity<String> deleteStudent(@PathVariable String dept){
//        studentService.deleteStudent(dept);
//        return ResponseEntity.ok("Student is deleted sucessfully");
//    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable Long id){
        studentService.deleteStudentById(id);
        return ResponseEntity.ok("Student is deleted sucessfully");
    }
}