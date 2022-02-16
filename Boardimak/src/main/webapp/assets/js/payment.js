$('#btnPayLogin').click(function(){
    var valid = validateForm();
});



function validateForm(){
	var propertyId = $('#propertyId').val();
//	var email = $('#email').val();
	var password = $('#password').val();
	
	if(password == ""){
		$( "#error" ).html( "All the field should be filled" );
		return false;
	}else{
	    $.post(
	            "/pay-owner",
	            {propertyId: propertyId, password: password},
	            function (data) {
	           	 var r = data;
	           	 
	           	 if(r.isWorking === "wrongPass"){
	           		 $( "#error" ).html( "Please check your password" );
	           	 }else{
	           		 $('#loginModal').modal('hide');
	           		$( "#HiddenText" ).html( "Payment was successful!" );
	           		$("#BuyNowBtn").attr("disabled", true);
	           	 }
	            }, 'json');
	}
}
//
$('#proposalSubmit').click(function(){
    var valid = proposalSubmit();
});

function proposalSubmit(){
	var propertyId = $('#propertyIdForPropose').val();
	var mHead = $('#messageHead').val();
	var mBody = $('#message').val();

	if(mHead == "" || mBody == ""){
		$( "#proposalError" ).html( "Please enter a message" );
		return false;
    }else{
    	$.post(
	            "/submit-proposal",
	            {propertyId: propertyId, mHead: mHead, mBody: mBody},
	            function (data) {
	           	 var r = data;
	           	 
	           	 if(r.isWorking === "done"){
	           		 console.log("done");
	           		$('#collapseExample').collapse('hide');
	           	 $( "#HiddenText" ).html( "Proposal Submited Successfully!" );
	           	 }
//	           	 else{
//	           		 $('#loginModal').modal('hide');
	           		 
////	           		 $('#success-section').css("display", "block");
//	           		$("#BuyNowBtn").attr("disabled", true);
//	           	 }
	            }, 'json');
    }
}

