package com.Spring.SpringBootWithoutJSP.Controller;

import com.Spring.SpringBootWithoutJSP.Model.Exam;
import com.Spring.SpringBootWithoutJSP.Service.ExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ExamController {


    private final ExamService examService;

    @Autowired
    public ExamController(ExamService examService) {
        this.examService = examService;
    }

    @PostMapping("/addExam")
    public void add(@RequestBody Exam exam) {
        examService.add(exam);
    }

    @GetMapping("/getAllForExam/{id}")
    public List<Exam> getAll(@PathVariable Long id) {
        return examService.getAll(id);
    }

}
