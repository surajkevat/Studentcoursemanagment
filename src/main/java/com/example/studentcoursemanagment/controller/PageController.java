package com.example.studentcoursemanagment.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

    @GetMapping("/")
    public String getHomepage() {
        return "students"; // Return the name of the HTML file without the .html extension
    }
    
    @GetMapping("/course")
    public String getCoursePage() {
        return "course"; // Return the name of the HTML file without the .html extension
    }
}