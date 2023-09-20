package com.example.entity;

import javax.persistence.Column;
import javax.persistence.Table;

@Table(name = "admin_info")
public class AdminInfo extends Account {
//	// postgresql管理员添加不了，说是id设置null
//	@Column(nullable = false)
//	private Long id;



}
