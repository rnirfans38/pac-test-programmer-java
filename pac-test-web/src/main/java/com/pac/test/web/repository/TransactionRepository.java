package com.pac.test.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.pac.test.web.model.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
	
	
}
