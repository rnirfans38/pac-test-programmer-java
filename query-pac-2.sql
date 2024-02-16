SELECT ua.* 
			FROM account a
			JOIN user_atm ua ON a.account_number = ua.phone_number
			WHERE phone_number like (concat('%','082140507864','%')) and pin = 253701
SELECT ua.username, ua.phone_number, ua.pin
FROM user_atm ua
			JOIN account a ON  ua.phone_number = a.account_number
			WHERE phone_number like (concat('%','082140507864','%')) and pin = 253701
			