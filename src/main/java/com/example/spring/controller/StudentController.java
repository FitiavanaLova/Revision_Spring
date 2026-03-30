package com.example.spring.controller;

import com.example.spring.model.Student;
import com.example.spring.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping
    public ResponseEntity<List<Student>> addStudents(@RequestBody List<Student> newStudents) {
        try {
            studentService.saveStudents(newStudents);
            return ResponseEntity.status(HttpStatus.CREATED).body(studentService.getAllStudents());
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }

    @GetMapping
    public ResponseEntity<?> getStudents(@RequestHeader(value = "Accept", required = false) String accept) {
        try {
            if (accept == null) return ResponseEntity.badRequest().build();
            if (!accept.contains("text/plain") && !accept.contains("application/json")) {
                return ResponseEntity.status(501).build();
            }
            return ResponseEntity.ok(studentService.getAllStudents());
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }
}