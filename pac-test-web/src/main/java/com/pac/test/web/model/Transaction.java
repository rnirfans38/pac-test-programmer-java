package com.pac.test.web.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.persistence.Table;

@Entity
@Table(name = "transaction")
public class Transaction {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	public Long id;

	@Column(name = "account_number")
	public String accountNumber;

	@Column(name = "balance")
	public Integer balance;
	
	@Column(name = "transaction_type")
	public String transactionType;
	
	@Column(name = "debit_kredit")
	public String debitKredit;
	
	@Column(name = "previous_balance")
	public Integer previousBalance;
	
	@Column(name = "amount")
	public Integer amount;
	
	@Column(name = "created_by")
	public String createdBy;

	@Column(name = "created_on")
	public LocalDate createdOn;

	@Column(name = "modified_by")
	public String modifiedBy;

	@Column(name = "modified_on")
	public LocalDate modifiedOn;

	@Column(name = "deleted_by")
	public String deletedBy;

	@Column(name = "deleted_on")
	public LocalDate deletedOn;

	@Column(name = "is_delete")
	public Boolean isDelete;

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

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public LocalDate getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(LocalDate createdOn) {
		this.createdOn = createdOn;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public LocalDate getModifiedOn() {
		return modifiedOn;
	}

	public void setModifiedOn(LocalDate modifiedOn) {
		this.modifiedOn = modifiedOn;
	}

	public String getDeletedBy() {
		return deletedBy;
	}

	public void setDeletedBy(String deletedBy) {
		this.deletedBy = deletedBy;
	}

	public LocalDate getDeletedOn() {
		return deletedOn;
	}

	public void setDeletedOn(LocalDate deletedOn) {
		this.deletedOn = deletedOn;
	}

	public Boolean getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(Boolean isDelete) {
		this.isDelete = isDelete;
	}

	
	

	

}
