var stripe = Stripe('pk_test_fiNmKZ5r1VOsJqi4PLEnRqsu006QD8Fb6K');

	            // Create an instance of Elements.
	            var elements = stripe.elements();
	
	            // Create an instance of the card Element.
	            var card = elements.create('card');
	
	            // Add an instance of the card Element into the `card-element` <div>.
	            card.mount('#card-element');
	            
	         	// Handle real-time validation errors from the card Element.
	            card.addEventListener('change', function (event) {
	                var displayError = document.getElementById('card-errors');
	                if (event.error) {
	                    displayError.textContent = event.error.message;
	                } else {
	                    displayError.textContent = '';
	                }
	            });
	            
	            $('#submitButton').click(function(){
	            	var valid = validateForm();
	            });
	            
	            function validateForm(){
	            	/*Read data from the form*/
	            	var email = $('#email').val();
	            	
	            	/* validation Regular Expressions*/
	            	var emailRGEX = /^[a-zA-Z0-9.!#$%&’*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\.[a-zA-Z0-9-]+)*$/;
	            	/* ------------------------------------------------------------------- */
	            	
	            	if(email== "" ){
	            		$( "#error-email" ).html( "Email should not be empty" );
		            	return false;
		            }else if(!emailRGEX.test(email)){
		            	$( "#error-email" ).html( "Please enter a valid email" );
		            	return false;
		            }else{
		            	handlePayments();
		            }
	            }
	            
 	          	//handle card submission
	            function handlePayments() {
	                stripe.createToken(card).then(function (result) {
	                    if (result.error) {
	                        // Inform the user if there was an error.
	                        var errorElement = document.getElementById('card-errors');
	                        errorElement.textContent = result.error.message;
	                    } else {
	                        // Send the token to your server.
	                        var token = result.token.id;
	                        var email = $('#email').val();
	                        $.post(
	                            "/createCust",
	                            {token: token, email: email},
	                            function (data) {
	                            	var result = data;
	                            	if(result.isWorking === 'wrongEmail'){
	                            		 console.log("check the email address");
	                            		 $( "#error-types" ).html( "The email should be the one you entered when creating the account" );
	                            	 }else if(result.isWorking === "hasAccount"){
	                            		 $( "#error-types" ).html( "You have already registerd an account" );
	                            	 }else{
//	                            		 window.location.href="http://localhost:7070/";
	                            		 $('#payment-section').css("display", "none");
	                            		 $('#success-section').css("display", "block");
	                            		 
	                            	 }
	                            }, 'json');
	                    }
	                });
	          	}