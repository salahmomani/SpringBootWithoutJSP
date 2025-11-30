package com.Spring.SpringBootWithoutJSP.Repo;


import com.Spring.SpringBootWithoutJSP.Model.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RepoCourse {

    private final JdbcTemplate jdbcTemplate;
    String getAllQuery = "SELECT *FROM courses";
    String addQuery = "INSERT INTO courses(code, title) VALUES(?, ?)";
    String delete = "DELETE FROM courses WHERE id = ?";
    String findCoursesByStudentQuery =
            "SELECT c.id, c.code, c.title " +
                    "FROM courses c " +
                    "JOIN enrollments e ON e.course_id = c.id " +
                    "WHERE e.student_id = ?";

    @Autowired
    public RepoCourse(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    public List<Course> findAll() {
        RowMapper<Course> mapper = (rs, rowNum) -> {
            Course course = new Course();
            course.setId(rs.getLong("ID"));
            course.setCode(rs.getString("code"));
            course.setTitle(rs.getString("title"));
            return course;

        };
        return jdbcTemplate.query(getAllQuery, mapper);
    }

    public void add(Course course) {
        int rows = jdbcTemplate.update(addQuery, course.getCode(), course.getTitle());
        System.out.println(rows + "Course Added");
    }

    public void deleteCourse(Long id) {
        int rows = jdbcTemplate.update(delete, id);
        System.out.println(rows + " Course deleted");
    }
    public List<Course> findCoursesByStudent(Long studentId) {

        RowMapper<Course> mapper = (rs, rowNum) -> {
            Course c = new Course();
            c.setId(rs.getLong("id"));
            c.setCode(rs.getString("code"));
            c.setTitle(rs.getString("title"));
            return c;
        };

        return jdbcTemplate.query(findCoursesByStudentQuery, mapper, studentId);
    }
}
