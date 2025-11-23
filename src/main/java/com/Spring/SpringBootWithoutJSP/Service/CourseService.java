package com.Spring.SpringBootWithoutJSP.Service;

import com.Spring.SpringBootWithoutJSP.Model.Course;
import com.Spring.SpringBootWithoutJSP.Repo.RepoCourse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {

    private final RepoCourse repoCourse;

    public CourseService(RepoCourse repoCourse) {
        this.repoCourse = repoCourse;
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
