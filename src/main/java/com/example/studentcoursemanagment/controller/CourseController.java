package com.example.studentcoursemanagment.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.studentcoursemanagment.model.Course;
import com.example.studentcoursemanagment.repository.CourseRepository;

@RestController
@RequestMapping("/api/course")
public class CourseController {

    private static final Logger logger = LoggerFactory.getLogger(CourseController.class);

    @Autowired
    private CourseRepository courseRepository;

    @GetMapping
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Course> getCourseById(@PathVariable Long id) {
        return courseRepository.findById(id)
            .map(course -> ResponseEntity.ok().body(course))
            .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/count")
    public long getCourseCount() {
        return courseRepository.count();
    }

    @PostMapping
    public ResponseEntity<Course> createCourse(@RequestBody Course course) {
        try {
            logger.info("Creating course: {}", course);
           return ResponseEntity.ok(courseRepository.save(course));
            
        } catch (Exception e) {
            logger.error("Error creating course", e);
            throw e;
        }
    }

    @PutMapping("/{courseId}")
    public ResponseEntity<Course> updateCourse(@PathVariable Long courseId, @RequestBody Course courseDetails) {
        return courseRepository.findById(courseId).map(course -> {
            if (courseDetails.getCourseName() != null) {
                course.setCourseName(courseDetails.getCourseName());
            }
            if (courseDetails.getCourseDuration() != null) {
                course.setCourseDuration(courseDetails.getCourseDuration());
            }
            if (courseDetails.getCourseDescription() != null) {
                course.setCourseDescription(courseDetails.getCourseDescription());
            }
            if (courseDetails.getCourseStartDate() != null) {
                course.setCourseStartDate(courseDetails.getCourseStartDate());
            }
            if (courseDetails.getCourseEndDate() != null) {
                course.setCourseEndDate(courseDetails.getCourseEndDate());
            }
            if (courseDetails.getInstructorName() != null) {
                course.setInstructorName(courseDetails.getInstructorName());
            }
            if (courseDetails.getCourseFee() != null) {
                course.setCourseFee(courseDetails.getCourseFee());
            }
            if (courseDetails.getMaxStudents() != null) {
                course.setMaxStudents(courseDetails.getMaxStudents());
            }
            if (courseDetails.getCourseCategory() != null) {
                course.setCourseCategory(courseDetails.getCourseCategory());
            }
            // Optionally update students if needed
            if (courseDetails.getStudents() != null && !courseDetails.getStudents().isEmpty()) {
                course.setStudents(courseDetails.getStudents());
            }
            Course updatedCourse = courseRepository.save(course);
            return ResponseEntity.ok(updatedCourse);
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{courseId}")
    public ResponseEntity<Object> deleteCourse(@PathVariable Long courseId) {
        return courseRepository.findById(courseId).map(course -> {
            courseRepository.delete(course);
            return ResponseEntity.ok().build();
        }).orElse(ResponseEntity.notFound().build());
    }
}
