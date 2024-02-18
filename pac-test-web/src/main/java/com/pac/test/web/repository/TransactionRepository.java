package com.pac.test.web.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.pac.test.web.model.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
	
	@Query(value = "SELECT t.* FROM transaction t\r\n"
			+ "JOIN user_atm ua ON t.account_number = ua.phone_number\r\n"
			+ "WHERE t.account_number = ?1 and ua.pin = ?2", nativeQuery = true)
	List<Transaction> transaction(String accountNumber, Integer pin);
	

	
}
