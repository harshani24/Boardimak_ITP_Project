package com.boardimak.main.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.boardimak.main.model.*;
import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.Account;
import com.stripe.model.Customer;
import com.stripe.model.PaymentIntent;
import com.stripe.model.Token;
import com.stripe.model.Transfer;
import com.stripe.net.RequestOptions;


@Service
public class StripeService {
	
	@Autowired
	UsersService usersservice;
	
	
	@Autowired
	PaymentService paymentservice;

	// Read the stripe secret api key
	@Value("${stripe.key.secret}")
	private String API_SECRET_KEY;
	
	// Method to connect with stripe and create a customer
	public String createCustomer(String token, String email) {
		// get the Buyer object using the email
        Users user = usersservice.getIdByEmail(email);
        
        if(user == null) { 
        	return "Wrong Email";
        }else if(user.getStripeId() != null) {
        	return "Alread Have An Account";
        }
        
        // initialize the Stripe id as null
		String StripeId = null;
		
        try {
        	// get the stripe Secret key from application.properties
            Stripe.apiKey = API_SECRET_KEY;
            Map<String, Object> customerParams = new HashMap<>();
            
            //add customer unique id here to track them in your web application
            customerParams.put("description", "Customer for " + user.getEmail());
            customerParams.put("email", user.getEmail());

            // ^ obtained with Stripe.js through the UI
            customerParams.put("source", token);
            
            
            //create a new customer
            Customer customer = Customer.create(customerParams);
            
            
            // get the new customer's unique customer Stripe id 
            StripeId = customer.getId();
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
        
       // set the stripe id in the Buyer object 
        user.setStripeId(StripeId);
       // update the stripe id of the customer in the buyer table
       usersservice.updateStripeID(user);
       
       return StripeId;
    } // end of create Customer Function
	
	
	
//	public int payMoney() {
//		System.out.println("working");
//		return 0;
//	} // 
	
	
	
	/* createAccount functions to create stripe accounts
	 * At the moment the function only accepts email 
	 * In the future it should accept a bank account token from the front end*/
	public String createAccount(String token, String email) throws StripeException {
		
		Stripe.apiKey = API_SECRET_KEY;
		
//		Owner owner = ownerservice.getAllusersByemail(email);.
		Users owner = usersservice.getIdByEmail(email);
		
		if(owner == null) {
			return "wrong email";
		}else if(owner.getAccountId() != null) {
			return "already has an account";
		}
		
		// Create a token to use for the Custom account creation
		String t = createAccountToken(owner);

		// Creating the Custom Account
		Map<String, Object> params = new HashMap<>();
		params.put("country", "US");
		params.put("type", "custom");
		params.put("default_currency", "usd");
		params.put("requested_capabilities", Arrays.asList("card_payments", "transfers"));
		
		// Got from the createAccountToken Method
		params.put("account_token", t); 
		
		// Got from stripe.js ( Front end )
		params.put("external_account", token);
		
		// create an account
		Account account = Account.create(params); 
		
		// get the account ID
		String accountId = account.getId();
		// set the Stripe account id of the modelclass
		owner.setAccountId(accountId);
		
		// update the database
		usersservice.saveOwner(owner);

		return accountId;
	} // end of createAccount method
	
	
	
	/*This method function to create a token for the stripe create account
	 * */
	
	public String createAccountToken(Users owner) throws StripeException {
		Stripe.apiKey = API_SECRET_KEY;
		
		Map<String, Object> tokenParams = new HashMap<String, Object>();
		Map<String, Object> accountParams = new HashMap<String, Object>();
		Map<String, Object> individualParams = new HashMap<String, Object>();
		individualParams.put("first_name", owner.getFirstName());
		individualParams.put("last_name", owner.getLastName());
		individualParams.put("email", owner.getEmail());
		accountParams.put("business_type", "individual");
		accountParams.put("individual", individualParams);
		accountParams.put("tos_shown_and_accepted", true);
		tokenParams.put("account", accountParams);
		
		Token t = Token.create(tokenParams);

		return t.getId();
	}
	
	
}
