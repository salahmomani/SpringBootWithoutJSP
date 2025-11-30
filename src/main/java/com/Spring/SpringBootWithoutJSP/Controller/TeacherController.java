package com.Spring.SpringBootWithoutJSP.Controller;

import com.Spring.SpringBootWithoutJSP.Model.Teacher;
import com.Spring.SpringBootWithoutJSP.Service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teacher")

public class TeacherController {

    private final TeacherService teacherService;


    @Autowired
    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @GetMapping("/getAll")
    public List<Teacher> findAll() {
        return teacherService.findAll();
    }

    @PostMapping("/add")
    public void add(@RequestBody Teacher teacher) {
        teacherService.add(teacher);
    }

    @GetMapping("/getByID")
    public Teacher findByID(@PathVariable Long id) {
        return teacherService.findByID(id);
    }

    @PutMapping("/update")
    public void update(@RequestBody Teacher teacher) {
        teacherService.update(teacher);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id) {
        teacherService.deleteTeacher(id);
    }
}
