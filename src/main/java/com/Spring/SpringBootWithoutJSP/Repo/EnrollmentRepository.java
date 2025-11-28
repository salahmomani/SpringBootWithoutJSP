package com.Spring.SpringBootWithoutJSP.Repo;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class EnrollmentRepository {


    private final JdbcTemplate jdbc;
    String enrollQuery = "INSERT INTO enrollments(student_id,course_id) VALUES(?,?)";
    String listQuery = """
                SELECT e.id, s.name AS student, c.code AS course
                FROM enrollments e
                JOIN students s ON s.id=e.student_id
                JOIN courses c ON c.id=e.course_id
            """;

    public EnrollmentRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public void enroll(long studentId, long courseId) {
        jdbc.update(enrollQuery, studentId, courseId);
    }

    public List<String> findAll() {

        return jdbc.query(listQuery, (rs, n) ->
                "#" + rs.getLong("id") + ": " +
                        rs.getString("student") + " -> " +
                        rs.getString("course"));
    }
}
