package com.example.spring.service;

import com.example.spring.model.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {
    // La responsabilité du stockage est ici
    private final List<Student> studentList = new ArrayList<>();

    public void saveStudents(List<Student> students) {
        studentList.addAll(students);
    }

    public List<Student> getAllStudents() {
        return studentList;
    }
}