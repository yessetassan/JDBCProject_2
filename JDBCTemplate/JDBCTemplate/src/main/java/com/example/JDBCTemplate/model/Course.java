package com.example.JDBCTemplate.model;

public class Course {

    private Integer id;
    private String name;
    private Integer related_id;

    public Course(String name, Integer related_id) {
        this.name = name;
        this.related_id = related_id;
    }

    public Course(Integer id, String name, Integer related_id) {
        this.id = id;
        this.name = name;
        this.related_id = related_id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getRelated_id() {
        return related_id;
    }

    public void setRelated_id(Integer related_id) {
        this.related_id = related_id;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", related_id=" + related_id +
                '}';
    }
}
