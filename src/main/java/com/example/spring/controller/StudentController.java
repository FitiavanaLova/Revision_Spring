package com.example.spring.controller;

import com.example.spring.model.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("students")
public class StudentController {
    private static List<Student> studentList = new ArrayList<>();
    @PostMapping
    public ResponseEntity<List<Student>>addStudents(@RequestBody List<Student> newStudents){
        try {
            studentList.addAll(newStudents);
            return ResponseEntity.status(HttpStatus.CREATED).body(studentList);
        }catch (Exception e){
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping
    public ResponseEntity<?> getStudents(
            @RequestHeader(value = "Accept", required = false) String acceptHeader) {

        try {
            if (acceptHeader == null) {
                return ResponseEntity.badRequest().build();
            }

            if (!acceptHeader.contains("text/plain") && !acceptHeader.contains("application/json")) {
                return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).build(); // 501
            }
            return ResponseEntity.ok(studentList);

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

}
