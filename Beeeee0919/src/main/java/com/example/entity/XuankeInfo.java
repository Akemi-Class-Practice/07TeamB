package com.example.entity;

import javax.persistence.*;

@Table(name = "xuanke_info")
public class XuankeInfo {

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


   
    @Column(name = "yuuzaId")
    private Long yuuzaId;
    @Column(name = "status")
    private String status;
    @Column(name = "teacher")
    private String teacher;
    
    @Transient
    private String yuuzaName;

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

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

   

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }


    public Long getYuuzaId() {
        return yuuzaId;
    }

    public void setYuuzaId(Long yuuzaId) {
        this.yuuzaId = yuuzaId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

   

    public String getYuuzaName() {
        return yuuzaName;
    }

    public void setYuuzaName(String yuuzaName) {
        this.yuuzaName = yuuzaName;
    }
}
