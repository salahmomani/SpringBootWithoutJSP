package com.Spring.SpringBootWithoutJSP.Service;

import com.Spring.SpringBootWithoutJSP.Model.Course;
import com.Spring.SpringBootWithoutJSP.Repo.RepoCourse;
import com.Spring.SpringBootWithoutJSP.Repo.RepoStudents;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {

    private final RepoCourse repoCourse;
    private final RepoStudents repoStudents;

    @Autowired
    public CourseService(RepoCourse repoCourse, RepoStudents repoStudents) {
        this.repoCourse = repoCourse;
        this.repoStudents = repoStudents;
    }


    public List<Course> findAll() {
        return repoCourse.findAll();
    }

    public void add(Course course) {
        repoCourse.add(course);
    }

    public void delete(Long id) {
        repoCourse.deleteCourse(id);
    }
}
