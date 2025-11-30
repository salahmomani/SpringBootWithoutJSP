package com.Spring.SpringBootWithoutJSP.Service;

import com.Spring.SpringBootWithoutJSP.Model.Exam;
import com.Spring.SpringBootWithoutJSP.Repo.RepoExam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExamService {

    private final RepoExam repoExam;

    @Autowired
    public ExamService(RepoExam repoExam) {
        this.repoExam = repoExam;
    }

    public void add(Exam exam) {
        repoExam.addExam(exam);
    }

    public List<Exam> getAll() {
        return repoExam.getAllExams();
    }

    public List<Exam> getByCourseId(Long courseId) {
        return repoExam.getExamsByCourseId(courseId);
    }

    public List<Exam> getByStudent(Long studentId) {
        return repoExam.getExamsByStudentId(studentId);
    }

    public void update(Exam exam) {
        repoExam.update(exam);
    }

    public void delete(Long id) {
        repoExam.delete(id);
    }
}
