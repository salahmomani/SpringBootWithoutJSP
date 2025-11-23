package com.Spring.SpringBootWithoutJSP.Controller;

import com.Spring.SpringBootWithoutJSP.Model.Teacher;
import com.Spring.SpringBootWithoutJSP.Service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TeacherController {

    private final TeacherService teacherService;


    @Autowired
    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @GetMapping("/getAllTeachers")
    public List<Teacher> findAll() {
        return teacherService.findAll();
    }

    @PostMapping("/addTeacher")
    public void add(@RequestBody Teacher teacher) {
        teacherService.add(teacher);
    }

    @GetMapping("/getByIDTeacher")
    public Teacher findByID(@PathVariable Long id) {
        return teacherService.findByID(id);
    }

    @PutMapping("/updateTeacher")
    public void update(@RequestBody Teacher teacher) {
        teacherService.update(teacher);
    }

    @DeleteMapping("/deleteTeacher/{id}")
    public void delete(@PathVariable Long id) {
        teacherService.deleteTeacher(id);
    }
}
