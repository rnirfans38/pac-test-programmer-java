package com.pac.test.web.services;

import java.time.LocalDate;

import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pac.test.web.dto.Mapper;
import com.pac.test.web.dto.RegisterRequest;
import com.pac.test.web.dto.RegisterResponse;
import com.pac.test.web.dto.TransactionRequest;
import com.pac.test.web.dto.TransactionResponse;
import com.pac.test.web.dto.TransferRequest;
import com.pac.test.web.dto.TransferResponse;
import com.pac.test.web.model.Account;
import com.pac.test.web.model.CekSaldo;
import com.pac.test.web.model.Transaction;
import com.pac.test.web.model.UserAtm;
import com.pac.test.web.repository.AccountRepository;
import com.pac.test.web.repository.TransactionRepository;
import com.pac.test.web.repository.UserAtmRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class AtmServiceImpl implements AtmService {
	@Autowired
	private AccountRepository accountRepository;

	@Autowired
	private UserAtmRepository userAtmRepository;

	@Autowired
	private TransactionRepository transactionRepository;

	@Autowired
	private Mapper mapper;

	// REGISTER SERVICE
	@Override
	public RegisterResponse register(RegisterRequest registerRequest) {
		// TODO map register request ke model account (data dari frontend)
		Account account = new Account();
		account.setAccountNumber(registerRequest.getPhoneNumber());
		account.setBalance(registerRequest.getBalance());

		// TODO simpan ke database account
		Account addAccount = this.accountRepository.save(account);

		// TODO map register request ke model user (data dari frontend)
		UserAtm userAtm = new UserAtm();
		userAtm.setUsername(registerRequest.getUsername());
		userAtm.setPhoneNumber(registerRequest.getPhoneNumber());
		userAtm.setPin(registerRequest.getPin());

		// TODO simpan ke database user atm
		UserAtm addUserAtm = this.userAtmRepository.save(userAtm);

		// TODO map request ke respon
		RegisterResponse registerResponse = mapper.mapper(registerRequest, new TypeToken<RegisterResponse>() {
		}.getType());
		registerResponse.setRegisterId(addUserAtm.getId());
		return registerResponse;
	}

	@Override
	public CekSaldo cekSaldo(String phoneNumber, Integer pin) {

		CekSaldo cekSaldoResponse = this.accountRepository.findByPhonePin(phoneNumber, pin);

		CekSaldo response = mapper.mapper(cekSaldoResponse, new TypeToken<CekSaldo>() {
		}.getType());

		Integer saldo = cekSaldoResponse.getBalance();
		return cekSaldoResponse;

	}

	// kirim body phonenumber pin balance
	@Override
	public TransactionResponse tarikSaldo(TransactionRequest transactionRequest) {

		// Input uang dan phone number
		// Kemudian pin

		UserAtm userAtm = this.userAtmRepository.ByPhonePin(transactionRequest.getPhoneNumber(),
				transactionRequest.getPin());
		String phone = userAtm.getPhoneNumber();
		Integer pin = userAtm.getPin();

		if (transactionRequest.getPhoneNumber().equals(phone) && transactionRequest.getPin().equals(pin)) {

			Account account = this.accountRepository.findAccount(transactionRequest.getPhoneNumber());
			Integer balanceAwal = account.getBalance(); // 1000000

			Integer balanceAkhir = balanceAwal - transactionRequest.balance;

			// map ke transactions
			Transaction transaction = new Transaction();
			transaction.setAccountNumber(account.getAccountNumber());
			transaction.setBalance(balanceAkhir);
			transaction.setTransactionType("Tarik Tunai"); // belum ada
			transaction.setDebitKredit("Debit"); // perlu logic
			transaction.setPreviousBalance(balanceAwal);
			transaction.setAmount(1); // masih bingung
			transaction.setCreatedOn(LocalDate.now());

			// save ke transactions
			Transaction addTransaction = this.transactionRepository.save(transaction);

			// save ke account
			account.setId(account.getId());
			account.setAccountNumber(account.getAccountNumber());
			account.setBalance(balanceAkhir);
			account.setModifiedOn(LocalDate.now());

			Account updateAccount = this.accountRepository.save(account);
			// map ke response
			TransactionResponse transactionResponse = mapper.mapper(transaction, new TypeToken<TransactionResponse>() {
			}.getType());

			return transactionResponse;
		} else {
			return null;
		}
	}

	@Override
	public TransactionResponse setorTunai(TransactionRequest transactionRequest) {
		UserAtm userAtm = this.userAtmRepository.ByPhonePin(transactionRequest.getPhoneNumber(),
				transactionRequest.getPin());
		String phone = userAtm.getPhoneNumber();
		Integer pin = userAtm.getPin();

		if (transactionRequest.getPhoneNumber().equals(phone) && transactionRequest.getPin().equals(pin)) {

			Account account = this.accountRepository.findAccount(transactionRequest.getPhoneNumber());
			Integer balanceAwal = account.getBalance(); // 1000000

			Integer balanceAkhir = balanceAwal + transactionRequest.balance;

			// map ke transactions
			Transaction transaction = new Transaction();
			transaction.setAccountNumber(account.getAccountNumber());
			transaction.setBalance(balanceAkhir);
			transaction.setTransactionType("Setor Tunai"); // belum ada
			transaction.setDebitKredit("Kredit"); // perlu logic
			transaction.setPreviousBalance(balanceAwal);
			transaction.setAmount(1); // masih bingung
			transaction.setCreatedOn(LocalDate.now());

			// save ke transactions
			Transaction addTransaction = this.transactionRepository.save(transaction);

			// save ke account
			account.setId(account.getId());
			account.setAccountNumber(account.getAccountNumber());
			account.setBalance(balanceAkhir);
			account.setModifiedOn(LocalDate.now());

			Account updateAccount = this.accountRepository.save(account);
			// map ke response
			TransactionResponse transactionResponse = mapper.mapper(transaction, new TypeToken<TransactionResponse>() {
			}.getType());

			return transactionResponse;
		} else {
			return null;
		}
	}
	
	@Override
	public  TransferResponse transfer(TransferRequest transferRequest) {
		UserAtm userAtm = this.userAtmRepository.ByPhonePin(transferRequest.getPhoneNumber(),
				transferRequest.getPin());
		String phone = userAtm.getPhoneNumber();
		Integer pin = userAtm.getPin();
		
		UserAtm cekPhoneDestination = this.userAtmRepository.ByPhone(transferRequest.getPhoneNumberDestination());
		
		TransferResponse response = new TransferResponse();
		if(cekPhoneDestination.getPhoneNumber() == null) {
			response.massage = "Destination invalid";
			return response;
		}
		
		if (transferRequest.getPhoneNumber().equals(phone) && transferRequest.getPin().equals(pin)) {

			Account account = this.accountRepository.findAccount(transferRequest.getPhoneNumber());
			Integer balanceAwal = account.getBalance(); // 1000000

			Integer balanceAkhir = balanceAwal - transferRequest.balance;

			// map ke transactions
			Transaction transaction = new Transaction();
			transaction.setAccountNumber(account.getAccountNumber());
			transaction.setBalance(balanceAkhir);
			transaction.setTransactionType("Transfer"); // belum ada
			transaction.setDebitKredit("Debit"); // perlu logic
			transaction.setPreviousBalance(balanceAwal);
			transaction.setAmount(transferRequest.balance); // masih bingung
			transaction.setCreatedOn(LocalDate.now());
	
			// save ke transactions
			Transaction addTransaction = this.transactionRepository.save(transaction);
			
			// save ke account
			account.setId(account.getId());
			account.setAccountNumber(account.getAccountNumber());
			account.setBalance(balanceAkhir);
			account.setModifiedOn(LocalDate.now());

			Account updateAccount = this.accountRepository.save(account);
			
			// map ke destinasi
			Account accountPhoneDestination = this.accountRepository.findAccount(transferRequest.getPhoneNumberDestination());
			Integer balanceAwalDestination = accountPhoneDestination.getBalance(); // 1000000

			Integer balanceAkhirDestination = balanceAwalDestination + transferRequest.balance;
			
			// map ke transactions
			Transaction transactionDest = new Transaction();
			transactionDest.setAccountNumber(accountPhoneDestination.getAccountNumber());
			transactionDest.setBalance(balanceAkhirDestination);
			transactionDest.setTransactionType("Transfer"); // belum ada
			transactionDest.setDebitKredit("Kredit"); // perlu logic
			transactionDest.setPreviousBalance(balanceAwalDestination);
			transactionDest.setAmount(transferRequest.balance); // masih bingung
			transactionDest.setCreatedOn(LocalDate.now());
	
			// save ke transactions
			Transaction addTransactionDest = this.transactionRepository.save(transactionDest);
			
			// save ke account
			accountPhoneDestination.setId(accountPhoneDestination.getId());
			accountPhoneDestination.setAccountNumber(accountPhoneDestination.getAccountNumber());
			accountPhoneDestination.setBalance(balanceAkhirDestination);
			accountPhoneDestination.setModifiedOn(LocalDate.now());

			Account updateAccountDest = this.accountRepository.save(accountPhoneDestination);
			
			// map ke response
			response = mapper.mapper(transaction, new TypeToken<TransferResponse>() {
			}.getType());

			response.massage = "Success";
			return response;
		} else {
			response.massage = "Pin invalid";
			return response;
		}
	}
	

}
