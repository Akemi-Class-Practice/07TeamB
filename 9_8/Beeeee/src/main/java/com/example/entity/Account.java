package com.example.entity;

import javax.persistence.*;

public class Account {
// mysql
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
//	// postgresql
//	@Id
//	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "admin_info_id_seq")
//	@SequenceGenerator(name = "admin_info_id_seq", sequenceName = "admin_info_id_seq", allocationSize = 1)
//	@Column(name = "id")
//	private Long id;


    @Column(name = "name")
    private String name;
    @Column(name = "password")
    private String password;

    @Column(name = "email")
    private String email;
    @Column(name = "level")
    private Integer level;
    @Transient
    private String newPassword;


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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public String getEmail() {
        return email;
    }

    public void setAge(String email) {
        this.email = email;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }


}
