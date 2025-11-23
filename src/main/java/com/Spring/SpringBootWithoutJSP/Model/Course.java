package com.Spring.SpringBootWithoutJSP.Model;

public class Course {
    private Long id;
    private String code;
    private String title;

    public Course() {
    }

    public Course(Long id, String code, String title) {
        this.id = id;
        this.code = code;
        this.title = title;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
