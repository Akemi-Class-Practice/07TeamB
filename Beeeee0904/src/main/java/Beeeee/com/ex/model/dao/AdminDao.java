package Beeeee.com.ex.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import Beeeee.com.ex.model.entity.AdminEntity;
public interface AdminDao extends JpaRepository<AdminEntity, Long> {
	AdminEntity save(AdminEntity adminEntity);
	
	AdminEntity findByAdminEmail(String adminEmail);
	
	AdminEntity findByAdminEmailAndAdminPassword(String adminEmail,String adminPassword);
	
	
	
	
	
	
	

}
