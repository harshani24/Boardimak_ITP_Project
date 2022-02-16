var stripe = Stripe('pk_test_fiNmKZ5r1VOsJqi4PLEnRqsu006QD8Fb6K');

	            // Create an instance of Elements.
	            var elements = stripe.elements();
	         	
	            
	            $('#submitButton').click(function(){
	            	var valid = validateForm();
	            });
	            
	            function validateForm(){
	            	/*Read data from the form*/
	            	var email = $('#email').val();
	            	var name = $('#Name').val();
	            	var accountNo = $('#accountNo').val();
	            	var routingNumber = $('#routingNumber').val();
	            	var mobileNo = $('#mobileNo').val();
	            	
	            	console.log(email);
	            	
	            	/* validation Regular Expressions*/
	            	var phoneRGEX = /^[(]{0,1}[0-9]{3}[)]{0,1}[-\s\.]{0,1}[0-9]{3}[-\s\.]{0,1}[0-9]{4}$/;
	            	var nameRGEX = /^[a-zA-Z]+(([',. -][a-zA-Z ])?[a-zA-Z]*)*$/;
	            	var emailRGEX = /^[a-zA-Z0-9.!#$%&’*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\.[a-zA-Z0-9-]+)*$/;
	            	var numbersRGEX = /^[0-9]*$/;
	            	/* ------------------------------------------------------------------- */
	            	
	            	if(email== "" || name == "" || accountNo == "" || routingNumber == "" || mobileNo == ""){
	            		$( "#error-types" ).html( "All the field should be filled" );
		            	return false;
		            }else if(!nameRGEX.test(name)){
		            	$( "#error-name" ).html( "Please enter a valid name" );
		            	return false;
		            }else if(!emailRGEX.test(email)){
		            	$( "#error-email" ).html( "Please enter a valid email" );
		            	return false;
		            }else if(!numbersRGEX.test(accountNo)){
		            	$( "#error-accNo" ).html( "Please enter a valid Account Number" );
		            	return false;
		            }else if(!numbersRGEX.test(routingNumber)){
		            	$( "#error-routeNo" ).html( "Please enter a valid Routing Number" );
		            	return false;
		            }else if(!phoneRGEX.test(mobileNo)){
		            	$( "#error-mobileNo" ).html( "Please enter a valid Mobile Number" );
		            	return false;
		            }
	            	else{
		            	handleDetails();
		            }
	            }
	             
 	          	//handle card submission
	            function handleDetails() {
                    var routingNumber = "" + document.getElementById('routingNumber');
                    var acNo = "" + document.getElementById('accountNo');
                    stripe.createToken('bank_account', {
                        country: 'US',
                        currency: 'usd',
                        routing_number: $('#routingNumber').val(),
                        account_number: $('#accountNo').val(),
                        account_holder_name: $('#Name').val(),
                        account_holder_type: 'individual'
                      }).then(function(result) {
                        if (result.error) {
                            // Inform the user if there was an error.
                            alert(result.error.message);
	                        // var errorElement = document.getElementById('card-errors');
	                        // errorElement.textContent = result.error.message;
	                    } else {
	                        // Send the token to your server.
	                        var token = result.token.id;
                            var email = $('#email').val();
	                        $.post(
	                             "/create-account",
	                             {token: token, email: email},
	                             function (data) {
	                            	 var r = data;
	                            	 
	                            	 if(r.isWorking === 'wrongEmail'){
	                            		 console.log("check the email address");
	                            		 $( "#error-types" ).html( "The email should be the one you entered when creating the account" );
	                            	 }else if(r.isWorking === "hasAccount"){
	                            		 $( "#error-types" ).html( "You have already registerd an account" );
	                            	 }else{
//	                            		 window.location.href="http://localhost:7070/";
	                            		 $('#create-acc-section').css("display", "none");
	                            		 $('#success-section').css("display", "block");
	                            	 }
	                             }, 'json');
	                    }
                      });
	          	}