package com.Spring.SpringBootWithoutJSP.Controller;

import com.Spring.SpringBootWithoutJSP.Service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/score")
public class ScoreController {

    private final ScoreService scoreService;

    @Autowired
    public ScoreController(ScoreService scoreService) {
        this.scoreService = scoreService;
    }

    @PostMapping("/add/{examId}/{studentId}/{score}")
    public String add(
            @PathVariable Long examId,
            @PathVariable Long studentId,
            @PathVariable double score
    ) {
        scoreService.add(examId, studentId, score);
        return "Score saved";
    }

    @GetMapping("/list")
    public List<String> findAll() {
        return scoreService.findAll();
    }
}
