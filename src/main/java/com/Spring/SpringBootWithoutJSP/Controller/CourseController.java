package com.Spring.SpringBootWithoutJSP.Controller;

import com.Spring.SpringBootWithoutJSP.Model.Course;
import com.Spring.SpringBootWithoutJSP.Service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CourseController {
    private final CourseService courseService;

    @Autowired
    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @PostMapping("/addCourse")
    public void add(@RequestBody Course course) {
        courseService.add(course);
    }

    @GetMapping("/courses")
    public List<Course> findAll() {
        return courseService.findAll();
    }

    @DeleteMapping("/deleteCourse/{id}")
    public void delete(@PathVariable Long id) {
        courseService.delete(id);
    }
}
