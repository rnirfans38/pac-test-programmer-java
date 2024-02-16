package com.pac.test.web.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.RequestParam;

import com.pac.test.web.model.Account;
import com.pac.test.web.model.CekSaldo;
import com.pac.test.web.model.UserAtmInterface;



public interface AccountRepository extends JpaRepository<Account, Long> {
	
	

	@Query(value = "SELECT a.balance \r\n"
			+ "FROM account a\r\n"
			+ "JOIN user_atm ua ON a.account_number = ua.phone_number\r\n"
			+ "WHERE phone_number like (concat('%',?1,'%')) and pin = ?2", nativeQuery = true)
	CekSaldo findByPhonePin(@RequestParam("phoneNumber")  String phoneNumber, @RequestParam("pin") Integer pin);
	
	
	@Query(value = "SELECT * from account WHERE account_number = ?1", nativeQuery = true)
	Account findAccount(String accountNumber);
	
	
	

	
	
}
