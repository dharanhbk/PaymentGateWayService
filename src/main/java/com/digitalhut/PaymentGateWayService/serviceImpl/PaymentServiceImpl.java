package com.digitalhut.PaymentGateWayService.serviceImpl;

import org.json.JSONObject;
import org.springframework.stereotype.Service;

import com.digitalhut.PaymentGateWayService.model.TransactionDetails;
import com.razorpay.Order;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;

@Service
public class PaymentServiceImpl {
	
	private static final String KEY ="rzp_test_ep8Ll03eeCfLL6";
	private static final String KEY_SECRET ="Sa6MYIGpefUi44fDhO6Jneug";
	private static final String CURRENCY="INR";

	public TransactionDetails createTransaction(Double amount) throws RazorpayException {
		JSONObject jsonObject =new JSONObject();
		jsonObject.put("amount", (amount*100));
		jsonObject.put("currency", CURRENCY);
		RazorpayClient razorpayClient = new RazorpayClient(KEY, KEY_SECRET);
		Order order = razorpayClient.orders.create(jsonObject);
		return prepareOrderDetails(order);		
	}
	
	private TransactionDetails prepareOrderDetails(Order order) {
		
		String orderId = order.get("id");
		Integer amount = order.get("amount");
		String currency=order.get("currency");
		TransactionDetails transactionDetails = new TransactionDetails(orderId,amount,KEY,currency);
		return transactionDetails;
	}
	
}
