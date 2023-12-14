package com.digitalhut.PaymentGateWayService.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class TransactionDetails {
	
	private String transactionId;
	
	private Integer amount;
	
	private String key;
	
	private String currency;

}
