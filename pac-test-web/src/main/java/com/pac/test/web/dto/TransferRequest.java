package com.pac.test.web.dto;

public class TransferRequest {
	
	public String phoneNumber;
	
	public String phoneNumberDestination;

	public Integer balance;

	public Integer pin;

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getPhoneNumberDestination() {
		return phoneNumberDestination;
	}

	public void setPhoneNumberDestination(String phoneNumberDestination) {
		this.phoneNumberDestination = phoneNumberDestination;
	}

	public Integer getBalance() {
		return balance;
	}

	public void setBalance(Integer balance) {
		this.balance = balance;
	}

	public Integer getPin() {
		return pin;
	}

	public void setPin(Integer pin) {
		this.pin = pin;
	}

	
}
