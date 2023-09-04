package Beeeee.com.ex.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import Beeeee.com.ex.model.entity.UserEntity;

public interface UserDao extends JpaRepository<UserEntity, Long> {

}
