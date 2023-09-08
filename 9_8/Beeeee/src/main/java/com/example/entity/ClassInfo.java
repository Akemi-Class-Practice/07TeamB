package com.example.entity;

import javax.persistence.*;

@Table(name = "class_info")
public class ClassInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;
    @Column(name = "price")
    private Integer price;

    @Column(name = "time")
    private String time;

    @Column(name = "yixuan")
    private Integer yixuan;

    @Column(name = "teacherId")
    private Long teacherId;
    @Transient
    private String teacherName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getScore() {
        return price;
    }

    public void setScore(Integer price) {
        this.price = price;
    }

   
    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }



    public Integer getYixuan() {
        return yixuan;
    }

    public void setYixuan(Integer yixuan) {
        this.yixuan = yixuan;
    }



    public Long getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Long teacherId) {
        this.teacherId = teacherId;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }
}
