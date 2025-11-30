package com.Spring.SpringBootWithoutJSP.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Exam {
    private Long id;
    private Long courseId;
    private Long studentId;
    private String name;
    private int maxScore;
}
