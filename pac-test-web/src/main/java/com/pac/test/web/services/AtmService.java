package com.pac.test.web.services;

import java.util.List;

import com.pac.test.web.dto.RegisterRequest;
import com.pac.test.web.dto.RegisterResponse;
import com.pac.test.web.dto.TransactionRequest;
import com.pac.test.web.dto.TransactionResponse;
import com.pac.test.web.dto.TransferRequest;
import com.pac.test.web.dto.TransferResponse;
import com.pac.test.web.model.CekSaldo;
import com.pac.test.web.model.Transaction;

public interface AtmService {

	// REGISTER SERVICE
	public abstract RegisterResponse register(RegisterRequest registerRequest);

	// CEK SALDO
	public abstract CekSaldo cekSaldo(String phoneNumber, Integer pin);

	// TRANSAKSI (Tarik Saldo)
	public abstract TransactionResponse tarikSaldo(TransactionRequest transactionRequest);

	// TRANSAKSI (Tarik Saldo)
	public abstract TransactionResponse setorTunai(TransactionRequest transactionRequest);

	// TRANSAKSI (Transfer)
	public abstract TransferResponse transfer(TransferRequest transferRequest);
	// TRANSAKSI ()
	// Input (phoneNumber, phoneNumberDestination, balance, pin) bikin request baru
	// Response (TransactionResponse + phoneNumberDestination, balance(sebelum dan
	// sesudah), balanceDestination (sebelum dan sesudah)
	// Pengondisian pin phoneNumber, phoneNumberDestination,
	// mapper account dan update account pengirim dan penerima
	// mapper transaction dan save pengirim dan penerima

	// HISTORY DATA
	public abstract List<Transaction> transaction(String accountNumber, Integer pin);
}
