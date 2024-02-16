package com.pac.test.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pac.test.web.dto.RegisterRequest;
import com.pac.test.web.dto.RegisterResponse;
import com.pac.test.web.dto.TransactionRequest;
import com.pac.test.web.dto.TransactionResponse;
import com.pac.test.web.dto.TransferRequest;
import com.pac.test.web.dto.TransferResponse;
import com.pac.test.web.model.CekSaldo;
import com.pac.test.web.services.AtmService;

import ch.qos.logback.core.encoder.JsonEscapeUtil;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.pac.test.web.dto.ErrorResponse;

@RestController
@RequestMapping("/atm/")
public class AtmController {

	@Autowired
	private AtmService atmService;

	@PostMapping("register")
	public ResponseEntity<RegisterResponse> register(@RequestBody RegisterRequest registerRequest) {
		try {
			var response = atmService.register(registerRequest);
			return new ResponseEntity<>(response, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
		}
	}

	@GetMapping("ceksaldo")
	public ResponseEntity<CekSaldo> cekSaldo(@RequestParam("phoneNumber") String phoneNumber,
			@RequestParam("pin") Integer pin) {
		try {
			CekSaldo cekSaldoResponse = atmService.cekSaldo(phoneNumber, pin);

			// Memeriksa apakah respons tidak null dan memiliki saldo
			if (cekSaldoResponse != null && cekSaldoResponse.getBalance() != null) {
				// Mengambil saldo dari respons
				Integer saldo = cekSaldoResponse.getBalance();
				// Lakukan apa yang Anda inginkan dengan saldo di sini
				System.out.println("Saldo Anda adalah: " + saldo);
			} else {
				// Handle jika saldo tidak ditemukan atau respons null
				System.out.println("Saldo tidak ditemukan atau respons tidak valid.");
			}
			return new ResponseEntity<>(cekSaldoResponse, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
		}
	}

	@PostMapping("tariktunai")
	public ResponseEntity<TransactionResponse> tarikSaldo(@RequestBody TransactionRequest transactionRequest) {
		try {
			if (transactionRequest.getBalance() % 50000 == 0) {
				TransactionResponse tarikSaldoResponse = atmService.tarikSaldo(transactionRequest);
//				ErrorResponse errorResponse = new ErrorResponse();
//				errorResponse.setCode("200");
//				ObjectMapper mapper = new JsonMapper();
//				String response = mapper.writeValueAsString(tarikSaldoResponse);
//				errorResponse.setErrorResponse("Succes");
//				errorResponse.setMassage(response);
				return new ResponseEntity<>(tarikSaldoResponse, HttpStatus.OK);
			} else {
//				ErrorResponse errorResponse = new ErrorResponse();
//				errorResponse.setCode("500");
//				errorResponse.setMassage("Masukkan uang kelipatan Rp.50.000");
//				errorResponse.setErrorResponse("Internal Server Error");
				return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
			}

		} catch (Exception e) {

			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("setortunai")
	public ResponseEntity<TransactionResponse> setorTunai(@RequestBody TransactionRequest transactionRequest) {
		try {
			if (transactionRequest.getBalance() % 50000 == 0) {
				TransactionResponse setorTunaiResponse = atmService.setorTunai(transactionRequest);
				return new ResponseEntity<>(setorTunaiResponse, HttpStatus.OK);
			} else {
				return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
			}
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("transfer")
	public ResponseEntity<TransferResponse> transfer(@RequestBody TransferRequest transferRequest) {
		try {
			if (transferRequest.getBalance() % 50000 == 0) {
				TransferResponse transferResponse = atmService.transfer(transferRequest);
				return new ResponseEntity<>(transferResponse, HttpStatus.OK);
			} else {
				return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
			}
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
