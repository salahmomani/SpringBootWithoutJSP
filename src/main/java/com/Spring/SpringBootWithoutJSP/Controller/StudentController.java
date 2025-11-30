package com.Spring.SpringBootWithoutJSP.Controller;


import com.Spring.SpringBootWithoutJSP.Model.Student;
import com.Spring.SpringBootWithoutJSP.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")

public class StudentController {
    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/getAll")
    public List<Student> findAll() {
        return studentService.findAll();

    }

    @PostMapping("/add")
    public void add(@RequestBody Student student) {
        studentService.add(student);
    }

    @GetMapping("/getByID/{id}")
    public Student findByID(@PathVariable Long id) {
        return studentService.findByID(id);

    }

    @PutMapping("/update")
    public void update(@RequestBody Student student) {
        studentService.update(student);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id) {
        studentService.delete(id);
    }
}
