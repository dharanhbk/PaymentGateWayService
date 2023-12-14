package com.digitalhut.PaymentGateWayService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.digitalhut.PaymentGateWayService.model.TransactionDetails;
import com.digitalhut.PaymentGateWayService.serviceImpl.PaymentServiceImpl;
import com.razorpay.RazorpayException;

@RestController
@RequestMapping("/transaction")
public class PaymentController {
	
	@Autowired
	PaymentServiceImpl paymentService;
	
	@GetMapping({"/{amount}"})
	public ResponseEntity<TransactionDetails> createTransaction(@PathVariable("amount") Double amount) throws RazorpayException {
		return new ResponseEntity<TransactionDetails>(paymentService.createTransaction(amount), HttpStatus.OK);
	}

}
