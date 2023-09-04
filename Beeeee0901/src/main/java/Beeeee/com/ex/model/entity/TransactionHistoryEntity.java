package Beeeee.com.ex.model.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="transaction_history")

public class TransactionHistoryEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "transaction_id")
	private Long transactionId;
	
	@Column(name = "user_id")
	private Long userId;
	
	@Column(name = "amount")
	private Long amount;
	
	@Column(name = "transaction_date")
	private LocalDateTime transactionDate;

	public TransactionHistoryEntity(Long userId, Long amount, LocalDateTime transactionDate) {
		this.userId = userId;
		this.amount = amount;
		this.transactionDate = transactionDate;
	}

	public TransactionHistoryEntity() {
		
	}

	public Long getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(Long transactionId) {
		this.transactionId = transactionId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getAmount() {
		return amount;
	}

	public void setAmount(Long amount) {
		this.amount = amount;
	}

	public LocalDateTime getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(LocalDateTime transactionDate) {
		this.transactionDate = transactionDate;
	}
	
	

}
