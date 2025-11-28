package com.Spring.SpringBootWithoutJSP.Service;


import com.Spring.SpringBootWithoutJSP.Repo.ScoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScoreService {

    private final ScoreRepository repo;

    @Autowired
    public ScoreService(ScoreRepository repo) {
        this.repo = repo;
    }

    public void add(Long examId, Long studentId, double score) {
        repo.addScore(examId, studentId, score);
    }

    public List<String> findAll() {
        return repo.findAll();
    }
}
