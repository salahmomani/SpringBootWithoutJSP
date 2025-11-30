package com.Spring.SpringBootWithoutJSP.Controller;

import com.Spring.SpringBootWithoutJSP.Model.Exam;
import com.Spring.SpringBootWithoutJSP.Service.ExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/exam")
public class ExamController {

    private final ExamService examService;

    @Autowired
    public ExamController(ExamService examService) {
        this.examService = examService;
    }

    @PostMapping("/add")
    public String addExam(@RequestBody Exam exam) {
        examService.add(exam);
        return "Exam Added Successfully!";
    }

    @GetMapping("/all")
    public List<Exam> getAll() {
        return examService.getAll();
    }

    @GetMapping("/course/{courseId}")
    public List<Exam> getByCourse(@PathVariable Long courseId) {
        return examService.getByCourseId(courseId);
    }

    @GetMapping("/student/{studentId}")
    public List<Exam> getByStudent(@PathVariable Long studentId) {
        return examService.getByStudent(studentId);
    }


    @PutMapping("/edit")
    public String update(@RequestBody Exam exam) {
        examService.update(exam);
        return "Exam Updated Successfully";
    }
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id) {
        examService.delete(id);
    }
}
