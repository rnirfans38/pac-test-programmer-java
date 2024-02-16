package com.pac.test.web.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class TransactionResponse {

	public Long id;
	
	public String accountNumber;
	
	public Integer balance;
	
	public String transactionType;
	
	public String debitKredit;
	
	public Integer previousBalance;
	
	public Integer amount;
	
	public LocalDate createdOn;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public Integer getBalance() {
		return balance;
	}

	public void setBalance(Integer balance) {
		this.balance = balance;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	public String getDebitKredit() {
		return debitKredit;
	}

	public void setDebitKredit(String debitKredit) {
		this.debitKredit = debitKredit;
	}

	public Integer getPreviousBalance() {
		return previousBalance;
	}

	public void setPreviousBalance(Integer previousBalance) {
		this.previousBalance = previousBalance;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public LocalDate getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(LocalDate createdOn) {
		this.createdOn = createdOn;
	}

	
}
