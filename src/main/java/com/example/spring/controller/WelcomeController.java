package com.example.spring.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {
    @GetMapping("/welcome")
    public ResponseEntity<String> welcome(@RequestParam(required = false)String name){
        if (name==null){
            return ResponseEntity
                    .badRequest().build();
        }
        String message = "Welcome " + name;
        return ResponseEntity.ok(message);
    }



}
