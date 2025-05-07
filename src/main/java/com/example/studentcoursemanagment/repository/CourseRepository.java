package com.example.studentcoursemanagment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.studentcoursemanagment.model.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
}