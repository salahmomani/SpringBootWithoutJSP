package com.Spring.SpringBootWithoutJSP.Repo;

import com.Spring.SpringBootWithoutJSP.Model.Exam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class RepoExam {

    private final JdbcTemplate jdbcTemplate;

    private static final String addQuery =
            "INSERT INTO exams(course_id, name, max_score) VALUES (?, ?, ?)";

    private static final String getAllQuery =
            "SELECT * FROM exams";

    private static final String getByCourse =
            "SELECT * FROM exams WHERE course_id = ?";

    private static final String getByStudent =
            "SELECT e.* FROM exams e " +
                    "JOIN scores sc ON sc.exam_id = e.id " +
                    "WHERE sc.student_id = ?";
    private static final String UPDATE =
            "UPDATE exams SET course_id = ?, name = ?, max_score = ? WHERE id = ?";

    private static final String DELETE =
            "DELETE FROM exams WHERE id = ?";

    @Autowired
    public RepoExam(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private final RowMapper<Exam> examMapper = (rs, rowNum) -> {
        Exam exam = new Exam();
        exam.setId(rs.getLong("id"));
        exam.setCourseId(rs.getLong("course_id"));
        exam.setName(rs.getString("name"));
        exam.setMaxScore(rs.getInt("max_score"));
        return exam;
    };

    public void addExam(Exam exam) {
        jdbcTemplate.update(addQuery,
                exam.getCourseId(),
                exam.getName(),
                exam.getMaxScore());
    }

    public List<Exam> getAllExams() {
        return jdbcTemplate.query(getAllQuery, examMapper);
    }

    public List<Exam> getExamsByCourseId(Long courseId) {
        return jdbcTemplate.query(getByCourse, examMapper, courseId);
    }

    public List<Exam> getExamsByStudentId(Long studentId) {
        return jdbcTemplate.query(getByStudent, examMapper, studentId);
    }
    public void update(Exam exam) {
        jdbcTemplate.update(UPDATE,
                exam.getCourseId(),
                exam.getName(),
                exam.getMaxScore(),
                exam.getId());
    }

    public void delete(Long id) {
        jdbcTemplate.update(DELETE, id);
    }
}
