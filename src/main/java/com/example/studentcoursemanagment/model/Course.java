package com.example.studentcoursemanagment.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long courseId; // Renamed from 'id' to 'courseId'

    private String courseName;
    private String courseDuration;
    private String courseDescription;

    private LocalDate courseStartDate;
    private LocalDate courseEndDate;

    private String instructorName;
    private Double courseFee;
    private Integer maxStudents;
    private String courseCategory;

    @ManyToMany
    @JoinTable(
        name = "course_student",
        joinColumns = @JoinColumn(name = "course_id"),
        inverseJoinColumns = @JoinColumn(name = "student_id")
    )
    private Set<Student> students = new HashSet<>();

    public Course() {
        // Default constructor required by JPA
    }

    public Course(String courseName, String courseDuration, String courseDescription,
                  LocalDate courseStartDate, LocalDate courseEndDate, String instructorName,
                  Double courseFee, Integer maxStudents, String courseCategory) {
        this.courseName = courseName;
        this.courseDuration = courseDuration;
        this.courseDescription = courseDescription;
        this.courseStartDate = courseStartDate;
        this.courseEndDate = courseEndDate;
        this.instructorName = instructorName;
        this.courseFee = courseFee;
        this.maxStudents = maxStudents;
        this.courseCategory = courseCategory;
    }

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
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

    public String getCourseDescription() {
        return courseDescription;
    }

    public void setCourseDescription(String courseDescription) {
        this.courseDescription = courseDescription;
    }

    public LocalDate getCourseStartDate() {
        return courseStartDate;
    }

    public void setCourseStartDate(LocalDate courseStartDate) {
        this.courseStartDate = courseStartDate;
    }

    public LocalDate getCourseEndDate() {
        return courseEndDate;
    }

    public void setCourseEndDate(LocalDate courseEndDate) {
        this.courseEndDate = courseEndDate;
    }

    public String getInstructorName() {
        return instructorName;
    }

    public void setInstructorName(String instructorName) {
        this.instructorName = instructorName;
    }

    public Double getCourseFee() {
        return courseFee;
    }

    public void setCourseFee(Double courseFee) {
        this.courseFee = courseFee;
    }

    public Integer getMaxStudents() {
        return maxStudents;
    }

    public void setMaxStudents(Integer maxStudents) {
        this.maxStudents = maxStudents;
    }

    public String getCourseCategory() {
        return courseCategory;
    }

    public void setCourseCategory(String courseCategory) {
        this.courseCategory = courseCategory;
    }

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }

    public String getCourseDetails() {
        return "Course Name: " + courseName +
                ", Duration: " + courseDuration +
                ", Description: " + courseDescription +
                ", Start Date: " + courseStartDate +
                ", End Date: " + courseEndDate +
                ", Instructor: " + instructorName +
                ", Fee: " + courseFee +
                ", Max Students: " + maxStudents +
                ", Category: " + courseCategory;
    }

    public void updateCourseDetails(String courseName, String courseDuration, String courseDescription,
                                    LocalDate courseStartDate, LocalDate courseEndDate, String instructorName,
                                    Double courseFee, Integer maxStudents, String courseCategory) {
        setCourseName(courseName);
        setCourseDuration(courseDuration);
        setCourseDescription(courseDescription);
        setCourseStartDate(courseStartDate);
        setCourseEndDate(courseEndDate);
        setInstructorName(instructorName);
        setCourseFee(courseFee);
        setMaxStudents(maxStudents);
        setCourseCategory(courseCategory);
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseId=" + courseId +
                ", courseName='" + courseName + '\'' +
                ", courseDuration='" + courseDuration + '\'' +
                ", courseDescription='" + courseDescription + '\'' +
                ", courseStartDate=" + courseStartDate +
                ", courseEndDate=" + courseEndDate +
                ", instructorName='" + instructorName + '\'' +
                ", courseFee=" + courseFee +
                ", maxStudents=" + maxStudents +
                ", courseCategory='" + courseCategory + '\'' +
                '}';
    }
}
