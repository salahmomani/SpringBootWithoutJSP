package com.Spring.SpringBootWithoutJSP.Service;

import com.Spring.SpringBootWithoutJSP.Model.Student;
import com.Spring.SpringBootWithoutJSP.Repo.RepoStudents;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {


    private final RepoStudents repoStudents;

    public StudentService(RepoStudents repoStudents) {
        this.repoStudents = repoStudents;
    }

    public List<Student> findAll() {
        return repoStudents.findAll();
    }

    public void add(Student student) {
        repoStudents.add(student);
    }

    public Student findByID(Long id) {
        return repoStudents.findByID(id);
    }

    public void update(Student student) {
        repoStudents.update(student);
    }

    public void delete(Long id) {
        repoStudents.deleteStudent(id);
    }
}
