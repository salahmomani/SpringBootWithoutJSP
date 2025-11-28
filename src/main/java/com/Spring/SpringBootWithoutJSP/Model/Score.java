package com.Spring.SpringBootWithoutJSP.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Score {
    private Long id;
    private Long examId;
    private Long studentId;
    private double score;

}
