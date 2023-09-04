package Beeeee.com.ex.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import Beeeee.com.ex.model.entity.TransactionHistoryEntity;

public interface TransactionDao extends JpaRepository<TransactionHistoryEntity, Long> {

}
