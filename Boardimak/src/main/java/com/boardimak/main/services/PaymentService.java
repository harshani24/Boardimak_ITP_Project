package com.boardimak.main.services;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.boardimak.main.model.Payments;
import com.boardimak.main.model.Property;
import com.boardimak.main.model.User;
import com.boardimak.main.model.Users;
import com.boardimak.main.repository.PaymentRepo;
import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.Card;
import com.stripe.model.Customer;
import com.stripe.model.PaymentIntent;

@Service
public class PaymentService {

	@Value("${stripe.key.secret}")
	private String API_SECRET_KEY;
	
	/*--------------------------------------------*/
	/*Autowired methods*/
	@Autowired
	private PaymentRepo paymentRepo;
	
	@Autowired
	UsersService usersservice;
	
	@Autowired
	PropertyService prService;
	/*--------------------------------------------*/
	
	// Method to save a payment to the database
	public void createPayment(Payments p) {
		paymentRepo.save(p);
	}
	
	
	// Methods to create an object of Payment using payment intent object
	public void createPaymentObject(PaymentIntent p, int ownerId) {
		
		long amount = (long) (p.getAmount() * 182);
		String method = "visa";
		String status = p.getStatus();
		String payment_token = p.getId();
		Date d = new Date((long)p.getCreated() * 1000);
		SimpleDateFormat simpledateformat = new SimpleDateFormat("dd/MM/yyyy");
		String date = simpledateformat.format(d);
		String stripe_id = p.getCustomer().toString();
		String account_id = p.getOnBehalfOf().toString();

		
		Payments pay = new Payments(amount, status, ownerId, method, payment_token, date, stripe_id, account_id);
		createPayment(pay);
	}
	
	// Method to read all the payments from the database 
	// Another methd should be created after session
	public List<Payments> showAll() {
		List<Payments> properties = new ArrayList<>();
			for(Payments propertyObject : paymentRepo.findAll()) {
				properties.add(propertyObject);
			}
		return properties;
	}
	
	public Payments showById(int id) {
		return paymentRepo.findById(id).get();
	}
	
	// PaymentHelper helps to communicate with the payments controller
	public String paymentHelper(int propertyId, Users user, String password) throws StripeException {
		String payment;
		
		// Checking if a valid user
		if(!user.getPassword().equals(password)){
			return "password was incorrect";
		}else {
			Property property = prService.getAProperty(propertyId);
			if(property == null) {
				return "no property";
			}else {
				payment = createPayment(user, property);
			}
			
		}
		return payment;
	}
	
	// Get payments by stripe Id 
	public List<Payments> allByStripeId(String stripeId){
		List<Payments> payments = new ArrayList<>();
		for(Payments propertyObject : paymentRepo.getAllByStripeId(stripeId)) {
			payments.add(propertyObject);
		}
	return payments;
	}
	
	// Get payments by account Id
	public List<Payments> allByAccountId(String accountId){
		List<Payments> payments = new ArrayList<>();
		for(Payments propertyObject : paymentRepo.getAllByAccountId(accountId)) {
			payments.add(propertyObject);
		}
	return payments;
	}
	

	// Method to connect with stripe and get a payment intent
	public String createPayment(Users user, Property property) throws StripeException {
		
		Stripe.apiKey = API_SECRET_KEY;
		String stripeID = user.getStripeId();
		Users owner = usersservice.getUser(property.getOwnerId());
		// get values amount
		int monthly = Integer.parseInt(property.getMonthlyPayment());
		int key = Integer.parseInt(property.getKeyMoney());
		long tot = (monthly + key) / 182;

		System.out.println(tot);
		
		ArrayList<String> paymentMethodTypes = new ArrayList<>();
		paymentMethodTypes.add("card");
		Map<String, Object> params = new HashMap<>();
		params.put("amount", tot);
		params.put("currency", "usd");
		params.put("customer", stripeID);
		params.put("payment_method", Customer.retrieve(stripeID).getDefaultSource().toString());
		params.put(
		    "payment_method_types",
		    paymentMethodTypes
		);
//		params.put("application_fee_amount", 500);
//		params.put("capture_method", "automatic");
//		params.put("confirm", true);
//		params.put("confirmation_method", "automatic");
		params.put("on_behalf_of", owner.getAccountId());

		PaymentIntent paymentintent = PaymentIntent.create(params);
		createPaymentObject(paymentintent, property.getOwnerId());
		return "done";
	}
	
}
