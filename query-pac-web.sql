SELECT a.balance 
FROM account a
JOIN user_atm ua ON a.account_number = ua.phone_number
WHERE phone_number like (concat('%','082140507864','%')) and pin = 253701