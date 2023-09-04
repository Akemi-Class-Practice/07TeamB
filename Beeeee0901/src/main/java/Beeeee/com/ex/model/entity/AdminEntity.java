package Beeeee.com.ex.model.entity;


import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="admin")
public class AdminEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "admin_id")
	private Long adminId;
	
	
	@Column(name = "admin_name")
	private String adminName;
	
	@Column(name = "admin_email")
	private String adminEmail;
	
	@Column(name = "admin_password")
	private String adminPassword;
	
	@Column(name = "register_date")
	private LocalDateTime adminRegisterDate;
	
	@Column(name = "delete_flag")
	private Long adminDeleteFlag;

	public AdminEntity(String adminName, String adminEmail, String adminPassword, LocalDateTime adminRegisterDate) {
		this.adminName = adminName;
		this.adminEmail = adminEmail;
		this.adminPassword = adminPassword;
		this.adminRegisterDate = adminRegisterDate;
	}

	public AdminEntity() {
		
	}

	public Long getAdminId() {
		return adminId;
	}

	public void setAdminId(Long adminId) {
		this.adminId = adminId;
	}

	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public String getAdminEmail() {
		return adminEmail;
	}

	public void setAdminEmail(String adminEmail) {
		this.adminEmail = adminEmail;
	}

	public String getAdminPassword() {
		return adminPassword;
	}

	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}

	public LocalDateTime getAdminRegisterDate() {
		return adminRegisterDate;
	}

	public void setAdminRegisterDate(LocalDateTime adminRegisterDate) {
		this.adminRegisterDate = adminRegisterDate;
	}

	public Long getAdminDeleteFlag() {
		return adminDeleteFlag;
	}

	public void setAdminDeleteFlag(Long adminDeleteFlag) {
		this.adminDeleteFlag = adminDeleteFlag;
	}
	
	
	
	

}
