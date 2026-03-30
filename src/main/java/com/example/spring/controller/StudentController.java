package com.example.spring.controller;

import com.example.spring.model.Student;
import org.springframework.web.bind.annotation.*;

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

    public String getStudents(@RequestHeader(value = "Accept", defaultValue = "text/plain") String acceptHeader) {

        if ("text/plain".equals(acceptHeader) || "*/*".equals(acceptHeader)) {
            if (studentList.isEmpty()) {
                return "Aucun étudiant enregistré.";
            }
            return studentList.stream()
                    .map(s -> s.getFirstName() + " " + s.getLastName())
                    .collect(Collectors.joining(", "));
        } else {
            return "Format non supporté";
        }
    }

}
