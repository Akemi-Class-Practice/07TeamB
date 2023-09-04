package Beeeee.com.ex.model.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="users")
public class UserEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private Long userId;
	
	@Column(name = "user_name")
	private String userName;
	
	@Column(name = "user_email")
	private String userEmail;
	
	@Column(name = "user_password")
	private String userPassword;
	
	@Column(name = "register_date")
	private LocalDateTime userRegisterDate;
	
	@Column(name = "delete_flag")
	private Long userDeleteFlag;

	public UserEntity(String userName, String userEmail, String userPassword,
			LocalDateTime userRegisterDate) {
		this.userName = userName;
		this.userEmail = userEmail;
		this.userPassword = userPassword;
		this.userRegisterDate = userRegisterDate;
		
	}

	public UserEntity() {
		
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public LocalDateTime getUserRegisterDate() {
		return userRegisterDate;
	}

	public void setUserRegisterDate(LocalDateTime userRegisterDate) {
		this.userRegisterDate = userRegisterDate;
	}

	public Long getUserDeleteFlag() {
		return userDeleteFlag;
	}

	public void setUserDeleteFlag(Long userDeleteFlag) {
		this.userDeleteFlag = userDeleteFlag;
	}
	
	
	

}
