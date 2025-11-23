package com.Spring.SpringBootWithoutJSP.Repo;


import com.Spring.SpringBootWithoutJSP.Model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class RepoStudents {
    private final JdbcTemplate jdbcTemplate;
    String getAllQuery = "select * from students ";
    String addQuery = "INSERT INTO students(name,email) VALUES(?,?)";
    String getByID = "select * from students where id=?";
    String update = "UPDATE students SET name = ?, email = ? WHERE id = ?";
    String delete = "DELETE FROM students WHERE id = ?";

    @Autowired
    public RepoStudents(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Student> findAll() {
        RowMapper<Student> mapper = (rs, rowNum) -> {
            Student student = new Student();
            student.setId(rs.getLong("ID"));
            student.setName(rs.getString("NAME"));
            student.setEmail(rs.getString("EMAIL"));
            return student;
        };
        return jdbcTemplate.query(getAllQuery, mapper);
    }

    public void add(Student student) {
        int rows = jdbcTemplate.update(addQuery, student.getName(), student.getEmail());
        System.out.println(rows + " Added   ");
    }


    public Student findByID(Long id) {
        RowMapper<Student> mapper = (rs, rowNum) -> {
            Student student = new Student();
            student.setId(rs.getLong("ID"));
            student.setName(rs.getString("name"));
            student.setEmail(rs.getString("email"));
            return student;

        };
        return jdbcTemplate.queryForObject(getByID, mapper, id);
    }

    public void update(Student student) {
        int rows = jdbcTemplate.update(update, student.getName(), student.getEmail(), student.getId());
        System.out.println(rows + " Updated");
    }

    public void deleteStudent(Long id) {
        int rows = jdbcTemplate.update(delete, id);
        System.out.println(rows + " Student deleted");
    }


}