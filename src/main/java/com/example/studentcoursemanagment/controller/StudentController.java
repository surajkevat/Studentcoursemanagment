package com.example.studentcoursemanagment.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.http.ResponseEntity;

import com.example.studentcoursemanagment.model.Student;
import com.example.studentcoursemanagment.repository.StudentRepository;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
@RequestMapping("/api/students")
public class StudentController {

    private static final Logger logger = LoggerFactory.getLogger(StudentController.class);

    @Autowired
    private StudentRepository studentRepository;

    @GetMapping
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable Long id) {
        return studentRepository.findById(id)
            .map(student -> ResponseEntity.ok().body(student))
            .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/count")
    public long getStudentCount() {
        return studentRepository.count();
    }

    @PostMapping
    public Student createStudent(@RequestBody Student student) {
        try {
            logger.info("Creating student: {}", student);
            return studentRepository.save(student);
        } catch (Exception e) {
            logger.error("Error creating student", e);
            throw e;
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable Long id, @RequestBody Student studentDetails) {
        return studentRepository.findById(id).map(student -> {
            if (studentDetails.getName() != null) {
                student.setName(studentDetails.getName());
            }
            if (studentDetails.getEmail() != null) {
                student.setEmail(studentDetails.getEmail());
            }
            if (studentDetails.getAge() != null) {
                student.setAge(studentDetails.getAge());
            }
            if (studentDetails.getPhoneNumber() != null) {
                student.setPhoneNumber(studentDetails.getPhoneNumber());
            }
            if (studentDetails.getAddress() != null) {
                student.setAddress(studentDetails.getAddress());
            }
            // Remove courseName and courseDuration fields, as Course is now a separate entity
            Student updatedStudent = studentRepository.save(student);
            return ResponseEntity.ok(updatedStudent);
        }).orElse(ResponseEntity.notFound().build());
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteStudent(@PathVariable Long id){
        return studentRepository.findById(id).map(student -> {
            studentRepository.delete(student);
            return ResponseEntity.ok().build();
        }).orElse(ResponseEntity.notFound().build());
    }
}
