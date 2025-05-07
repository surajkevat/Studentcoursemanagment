package com.example.studentcoursemanagment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.studentcoursemanagment.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
}