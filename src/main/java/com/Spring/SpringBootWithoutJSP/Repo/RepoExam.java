package com.Spring.SpringBootWithoutJSP.Repo;

import com.Spring.SpringBootWithoutJSP.Model.Exam;
import com.Spring.SpringBootWithoutJSP.Model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class RepoExam {

    List<Exam> exams = new ArrayList<>();
    private final JdbcTemplate jdbcTemplate;
    String addQuery = "INSERT INTO exams(course_id,name,max_score) VALUES(?,?,?)";
    String getAllQuery = "SELECT e.id AS exam_id, e.course_id, e.name AS exam_name, e.max_score " +
            "FROM exams e " +
            "JOIN scores sc ON sc.exam_id = e.id " +
            "WHERE sc.student_id = ?";

    @Autowired
    public RepoExam(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void addExam(Exam exam) {
        int rows = jdbcTemplate.update(addQuery, exam.getCourseId(), exam.getName(), exam.getMaxScore());
        System.out.println(rows + " Added");
    }

    public Student student;

    public List<Exam> getAll(Long studentId) {

        RowMapper<Exam> mapper = (rs, rowNum) -> {
            Exam exam = new Exam();
            exam.setId(rs.getLong("exam_id"));
            exam.setCourseId(rs.getLong("course_id"));
            exam.setName(rs.getString("exam_name"));
            exam.setMaxScore(rs.getInt("max_score"));
            return exam;
        };

        return jdbcTemplate.query(getAllQuery, mapper, studentId);
    }

}