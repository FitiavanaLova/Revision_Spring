package com.example.spring.model;

public class Student {
   private String reference;
   private String lastName;
   private String firstName;
   private Integer age;

    public Student(String reference, String lastName, String firstName, Integer age) {
        this.reference = reference;
        this.lastName = lastName;
        this.firstName = firstName;
        this.age = age;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
