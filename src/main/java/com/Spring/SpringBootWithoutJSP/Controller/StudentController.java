package com.Spring.SpringBootWithoutJSP.Controller;


import com.Spring.SpringBootWithoutJSP.Model.Student;
import com.Spring.SpringBootWithoutJSP.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {
    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/getAllStudents")
    public List<Student> findAll() {
        return studentService.findAll();

    }

    @PostMapping("/addStudent")
    public void add(@RequestBody Student student) {
        studentService.add(student);
    }

    @GetMapping("/getByIDStudent/{id}")
    public Student findByID(@PathVariable Long id) {
        return studentService.findByID(id);

    }

    @PutMapping("/updateStudent")
    public void update(@RequestBody Student student) {
        studentService.update(student);
    }

    @DeleteMapping("/deleteStudent/{id}")
    public void delete(@PathVariable Long id) {
        studentService.delete(id);
    }
}
