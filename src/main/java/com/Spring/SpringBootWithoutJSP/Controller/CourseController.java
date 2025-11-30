package com.Spring.SpringBootWithoutJSP.Controller;

import com.Spring.SpringBootWithoutJSP.Model.Course;
import com.Spring.SpringBootWithoutJSP.Service.CourseService;
import com.Spring.SpringBootWithoutJSP.Service.ExamService;
import com.Spring.SpringBootWithoutJSP.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/course")

public class CourseController {
    private final CourseService courseService;
    private final StudentService studentService;
    private final ExamService examService;


    @Autowired
    public CourseController(CourseService courseService, StudentService studentService, ExamService examService) {
        this.courseService = courseService;
        this.studentService = studentService;
        this.examService = examService;
    }


    @PostMapping("/add")
    public void add(@RequestBody Course course) {

        courseService.add(course);
    }

    @GetMapping("/getAll")
    public List<Course> findAll() {
        return courseService.findAll();
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id) {
        courseService.delete(id);
    }
    @GetMapping("/student/{studentId}/courses")
    public List<Course> getCoursesForStudent(@PathVariable Long studentId) {
        return courseService.getCoursesForStudent(studentId);
    }

}
