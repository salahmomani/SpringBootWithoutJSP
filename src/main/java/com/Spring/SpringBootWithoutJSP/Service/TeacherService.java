package com.Spring.SpringBootWithoutJSP.Service;

import com.Spring.SpringBootWithoutJSP.Model.Teacher;
import com.Spring.SpringBootWithoutJSP.Repo.RepoTeacher;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherService {

    private final RepoTeacher repoTeacher;

    public TeacherService(RepoTeacher repoTeacher) {
        this.repoTeacher = repoTeacher;
    }

    public List<Teacher> findAll() {
        return repoTeacher.findAll();
    }

    public void add(Teacher teacher) {
        repoTeacher.add(teacher);
    }

    public Teacher findByID(Long id) {
        return repoTeacher.findByID(id);
    }

    public void update(Teacher teacher) {
        repoTeacher.update(teacher);
    }

    public void deleteTeacher(Long id) {
        repoTeacher.deleteTeacher(id);
    }
}
