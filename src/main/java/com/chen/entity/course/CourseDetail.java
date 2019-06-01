package com.chen.entity.course;

public class CourseDetail {
    private Integer id;

    private Short section;

    private String detail;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Short getSection() {
        return section;
    }

    public void setSection(Short section) {
        this.section = section;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail == null ? null : detail.trim();
    }
}