package com.Spring.SpringBootWithoutJSP.Model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Exam {
    private Long id;
    private Long courseId;
    private String name;
    private int maxScore;
    public Exam() {
    }

    public Exam(Long id, Long courseId, String name, int maxScore) {
        this.id = id;
        this.courseId = courseId;
        this.name = name;
        this.maxScore = maxScore;
    }

}
