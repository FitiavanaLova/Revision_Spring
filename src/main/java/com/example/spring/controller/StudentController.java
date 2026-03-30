package com.example.spring.controller;

import com.example.spring.model.Student;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("students")
public class StudentController {
    private static List<Student> studentList = new ArrayList<>();
    @PostMapping
    public String addStudents(@RequestBody List<Student> newStudents) {
        studentList.addAll(newStudents);
        return studentList.stream()
                .map(s -> s.getFirstName() + " " + s.getLastName())
                .collect(Collectors.joining(", "));
    }

}
