package com.Spring.SpringBootWithoutJSP.Service;


import com.Spring.SpringBootWithoutJSP.Repo.EnrollmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnrollmentService {

    private final EnrollmentRepository repo;

    public EnrollmentService(EnrollmentRepository repo) {
        this.repo = repo;
    }

    public void enroll(long studentId, long courseId) {
        repo.enroll(studentId, courseId);
    }

    public List<String> findAll() {
        return repo.findAll();
    }
}