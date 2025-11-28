package com.Spring.SpringBootWithoutJSP.Repo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ScoreRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public ScoreRepository(JdbcTemplate jdbc) {
        this.jdbcTemplate = jdbc;
    }

    String addQuery =
            "MERGE INTO scores (exam_id, student_id, score) KEY (exam_id, student_id) VALUES (?, ?, ?)";

    String listQuery = """
                SELECT sc.id, s.name AS student, c.code AS course,
                       e.name AS exam, sc.score
                FROM scores sc
                JOIN exams e ON e.id=sc.exam_id
                JOIN students s ON s.id=sc.student_id
                JOIN courses c ON c.id=e.course_id
            """;

    public List<String> findAll() {


        return jdbcTemplate.query(listQuery, (rs, i) ->
                "#" + rs.getLong("id") + " " +
                        rs.getString("student") + " " +
                        rs.getString("course") + " " +
                        rs.getString("exam") + ": " +
                        rs.getBigDecimal("score")
        );
    }

    public void addScore(long examId, long studentId, double score) {
        jdbcTemplate.update(addQuery, examId, studentId, score);
    }
}
