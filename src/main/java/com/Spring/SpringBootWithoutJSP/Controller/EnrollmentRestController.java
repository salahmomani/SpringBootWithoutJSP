package com.Spring.SpringBootWithoutJSP.Controller;


import com.Spring.SpringBootWithoutJSP.Service.EnrollmentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EnrollmentRestController {

    private final EnrollmentService service;

    public EnrollmentRestController(EnrollmentService service) {
        this.service = service;
    }

    @GetMapping("/findAllEnrollment")
    public List<String> list() {
        return service.findAll();
    }

    @PostMapping("/enroll/{studentId}/{courseId}")
    public String enroll(
            @PathVariable long studentId,
            @PathVariable long courseId) {

        service.enroll(studentId, courseId);
        return "Enrolled successfully";
    }
}