package com.example.studentcoursemanagment.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.studentcoursemanagment.model.Course;
import com.example.studentcoursemanagment.repository.CourseRepository;

@Service
public class CourseService {
    @Autowired
    private CourseRepository courseRepository;

    public List<Course> findAll() {
        return courseRepository.findAll();
    }
    public Optional<Course> findById(Long id) {
        return courseRepository.findById(id);
    }
    public Course save(Course course) {
        return courseRepository.save(course);
    }
    public void deleteById(Long id) {
        courseRepository.deleteById(id);
    }
}
