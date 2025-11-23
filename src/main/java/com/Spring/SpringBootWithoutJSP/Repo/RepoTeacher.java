package com.Spring.SpringBootWithoutJSP.Repo;

import com.Spring.SpringBootWithoutJSP.Model.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class RepoTeacher {

    private final JdbcTemplate jdbcTemplate;
    String getAllQuery = "SELECT * FROM teachers";
    String addQuery = "INSERT INTO teachers(name, email) VALUES(?, ?)";
    String getByID = "SELECT id, name, email FROM teachers WHERE id = ?";
    String updateQuery = "UPDATE teachers SET name = ?, email = ? WHERE id = ?";
    String delete = "DELETE FROM teachers WHERE id = ?";

    @Autowired
    public RepoTeacher(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Teacher> findAll() {
        RowMapper<Teacher> mapper = (rs, rowNum) -> {
            Teacher teacher = new Teacher();
            teacher.setId(rs.getLong("ID"));
            teacher.setName(rs.getString("name"));
            teacher.setEmail(rs.getString("email"));
            return teacher;

        };
        return jdbcTemplate.query(getAllQuery, mapper);
    }

    public void add(Teacher teacher) {
        int rows = jdbcTemplate.update(addQuery, teacher.getName(), teacher.getEmail());
        System.out.println(rows + " Added");
    }


    public Teacher findByID(Long id) {
        RowMapper<Teacher> mapper = (rs, rowNum) -> {
            Teacher teacher = new Teacher();
            teacher.setId(rs.getLong("ID"));
            teacher.setName(rs.getString("name"));
            teacher.setEmail(rs.getString("email"));
            return teacher;

        };
        return jdbcTemplate.queryForObject(getByID, mapper, id);
    }

    public void update(Teacher teacher) {
        int rows = jdbcTemplate.update(updateQuery, teacher.getName(), teacher.getEmail(), teacher.getId());
        System.out.println(rows + " Updated");
    }

    public void deleteTeacher(Long id) {
        int rows = jdbcTemplate.update(delete, id);
        System.out.println(rows + " Teacher deleted");
    }
}
