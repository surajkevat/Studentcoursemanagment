package com.example.studentcoursemanagment.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private String phoneNumber;
    private String address;
    private String courseName;
    private String courseDuration;
    private String status; // e.g., "ACTIVE", "INACTIVE"
    private Integer age; // Added age field

    public Student() {
        // Default constructor required by JPA
    }

    public Student(String name, String email, String phoneNumber, String address, String courseName, String courseDuration, String status, Integer age) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.courseName = courseName;
        this.courseDuration = courseDuration;
        this.status = status;
        this.age = age;
    }

    // Getters and setters for all fields, including id, status, and age

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseDuration() {
        return courseDuration;
    }

    public void setCourseDuration(String courseDuration) {
        this.courseDuration = courseDuration;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    // Add, update, delete, view, and search/filter logic can be implemented in the service/repository layer

    public String getStudentDetails() {
        return "Name: " + name + ", Email: " + email + ", Phone: " + phoneNumber + ", Address: " + address + ", Course: " + courseName + ", Duration: " + courseDuration + ", Status: " + status + ", Age: " + age;
    }

    public void updateStudentDetails(String name, String email, String phoneNumber, String address, String courseName, String courseDuration, String status, Integer age) {
        setName(name);
        setEmail(email);
        setPhoneNumber(phoneNumber);
        setAddress(address);
        setCourseName(courseName);
        setCourseDuration(courseDuration);
        setStatus(status);
        setAge(age);
    }

    // Example filter method
    public boolean matchesFilter(String name, String course, String status) {
        boolean matches = true;
        if (name != null && !this.name.toLowerCase().contains(name.toLowerCase())) {
            matches = false;
        }
        if (course != null && !this.courseName.toLowerCase().contains(course.toLowerCase())) {
            matches = false;
        }
        if (status != null && !this.status.equalsIgnoreCase(status)) {
            matches = false;
        }
        return matches;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", address='" + address + '\'' +
                ", courseName='" + courseName + '\'' +
                ", courseDuration='" + courseDuration + '\'' +
                ", status='" + status + '\'' +
                ", age=" + age +
                '}';
    }
}
