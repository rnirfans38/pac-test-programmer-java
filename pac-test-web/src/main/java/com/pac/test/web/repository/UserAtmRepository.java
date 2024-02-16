package com.pac.test.web.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.RequestParam;

import com.pac.test.web.model.UserAtm;
import com.pac.test.web.model.UserAtmInterface;



public interface UserAtmRepository extends JpaRepository<UserAtm, Long> {

	@Query(value = "SELECT ua.id, ua.username, ua.phone_number, ua.pin, ua.created_by, ua.created_on, ua.modified_by, ua.modified_on,"
			+ "ua.deleted_by, ua.deleted_on, ua.is_delete\r\n"
			+ "FROM user_atm ua\r\n"
			+ "			JOIN account a ON  ua.phone_number = a.account_number\r\n"
			+ "			WHERE ua.phone_number = ?1 and ua.pin = ?2", nativeQuery = true)
	UserAtm ByPhonePin(String phoneNumber, Integer pin);
	
	@Query(value = "SELECT ua.id, ua.username, ua.phone_number, ua.pin, ua.created_by, ua.created_on, ua.modified_by, ua.modified_on,"
			+ "ua.deleted_by, ua.deleted_on, ua.is_delete\r\n"
			+ "FROM user_atm ua\r\n"
			+ "			JOIN account a ON  ua.phone_number = a.account_number\r\n"
			+ "			WHERE ua.phone_number = ?1", nativeQuery = true)
	UserAtm ByPhone(String phoneNumber);
	
}
