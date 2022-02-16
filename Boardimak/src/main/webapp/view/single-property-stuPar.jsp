<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%><!DOCTYPE html>

<html lang="en">

<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">

<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script> <!-- Jquery min file is added there for do not add the slim version -->
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>


<!-- Font Roboto 400, 500, 700 and 900-->
<link
	href="https://fonts.googleapis.com/css?family=Roboto:400,500,700,900&display=swap"
	rel="stylesheet">

<!-- Styles -->
<link rel="stylesheet" href="assets/css/main.css" />
<link rel="stylesheet" href="assets/css/dashboard.css">
<link rel="stylesheet" href="/static/css/cms.css">
<style>
<style>
.container{
width:1400px;
}
</style>

<title>Single property</title>
</head>

<body>
	<div class="container">
		<div class="topPropertyImage mb-4">
			<img width="100%" height="600px"
				src="/displayImageBook/${property.id}" alt="">
		</div>

		<div class="propertydetails ml-2">
			<p class="font-weight-bolder text-dark" style="font-size: 40px">Property
				in malbe</p>
			<div class="ml-3 row shadow-lg p-5 mb-2 bg-white rounded">
				<div class="col">
					<p class="text-dark font-weight-bold" style="font-size: 20px"><img alt="" src="assets/icons/circular-shape-silhouette.png" width="11px" class="mb-1">
						Address : <span class=" font-weight-light">${property.addressOne }
							${property.addressTwo } ${property.city }</span>
					</p>
					<p class="text-dark font-weight-bold" style="font-size: 20px"><img alt="" src="assets/icons/circular-shape-silhouette.png" width="11px" class="mb-1"> Contact
						No :</p>
					<p class="text-dark font-weight-bold" style="font-size: 20px"><img alt="" src="assets/icons/circular-shape-silhouette.png" width="11px" class="mb-1">
						Monthly Payment: <span class=" font-weight-light">${property.monthlyPayment }</span>
					</p>
					         <%--  <c:forEach var="p" items="${promotion }">
												 <c:if test="${property.id == p.property_id}">
												     <c:if test="${p.status == 'Active'}">
												
														<p class="text-dark font-weight-bold" style="font-size: 20px"><img alt="" src="assets/icons/circular-shape-silhouette.png" width="11px" class="mb-1">
										                     Discounted Monthly Price : <span class=" font-weight-light">${p.new_price}/=</span>
											             </p>
										          </c:if>  
									        	</c:if>     
							</c:forEach> --%>
					
					<p class="text-dark font-weight-bold" style="font-size: 20px"><img alt="" src="assets/icons/circular-shape-silhouette.png" width="11px" class="mb-1">
						Key Money : <span class=" font-weight-light">${property.keyMoney }</span>
					</p>

					
					<p class="text-dark font-weight-bold" style="font-size: 20px"><img alt="" src="assets/icons/circular-shape-silhouette.png" width="11px" class="mb-1">
						Description : <span class=" font-weight-light">${property.description }</span>
					</p>
					<p class="text-dark font-weight-bold" style="font-size: 20px"><img alt="" src="assets/icons/circular-shape-silhouette.png" width="11px" class="mb-1">
						Other Facilities : <span class=" font-weight-light">${property.otherFacilities }</span>
					</p>

				</div>
				<div class="border border-dark col-1 border-bottom-0 border-top-0 border-right-0 "></div>
				<div class="col">
					<p class="text-dark font-weight-bold" style="font-size: 20px"><img alt="" src="assets/icons/circular-shape-silhouette.png" width="11px" class="mb-1">
						No of Rooms : <span class=" font-weight-light">${property.noOfRooms }
						</span>
					</p>
					<p class="text-dark font-weight-bold" style="font-size: 20px"><img alt="" src="assets/icons/circular-shape-silhouette.png" width="11px" class="mb-1">
						Air Condition : <span class=" font-weight-light">${property.airCondition }</span>
					</p>
					<p class="text-dark font-weight-bold" style="font-size: 20px"><img alt="" src="assets/icons/circular-shape-silhouette.png" width="11px" class="mb-1">
						Monthly Payment: <span class=" font-weight-light">${property.monthlyPayment }</span>
					</p>
					<p class="text-dark font-weight-bold" style="font-size: 20px"><img alt="" src="assets/icons/circular-shape-silhouette.png" width="11px" class="mb-1">
						Time Period : <span class=" font-weight-light">${property.timePeriod }</span>
					</p>

					<p class="text-dark font-weight-bold" style="font-size: 20px"><img alt="" src="assets/icons/circular-shape-silhouette.png" width="11px" class="mb-1">
						Parking : <span class=" font-weight-light">${property.parking }</span>
					</p>
				</div>

			</div>
		</div>

		<div class="dropdownBookNow">


			<div class="container float-right">

				<button type="button"
					class="btn  btn-blue btn-adduser mt-2 mb-2 float-right"
					data-toggle="collapse" data-target="#demo">Book Now</button>

				<!-- Modal Opening button for login -->
				<button type="button" class="btn btn-blue float-right mt-2 mr-2" data-toggle="modal"
					data-target="#loginModal">Buy Now</button>
					
					<div class="form-group">
					<p class="txt-green" id="HiddenText">
				</div>
					
					<!-- Proposal collapse button -->
				<button class="btn-blue mt-2" type="button" data-toggle="collapse"
					data-target="#collapseExample" aria-expanded="false"
					aria-controls="collapseExample">Propose</button>

<%-- 				<div id="demo" class="collapse">
					<form action="/bookaProperty" id="form1" method="post">

						<textarea class="mt-3 p-2 w-100" name="massege"
							id="textAreaBlogBody" cols="16" rows="6"
							placeholder="Massege to owner">${bookings.massege }</textarea>

						<input class="p-2 d-none inputBlogTitle w-100" type="text"
							name="status" id="status" placeholder="Title"
							value="${bookings.status}"> <input
							class="p-2 d-none inputBlogTitle w-100" type="text"
							name="propertyID" id="propertyID" value="${bookings.propertyID}">
						<input class="p-2 d-none inputBlogTitle w-100" type="text"
							name="ownerID" id="ownerID" value="${bookings.ownerID}">

						<input
							class="p-2 d-none inputBlogTitle w-100" type="text"
							name="owner_name" id="owner_name" 
							value="${bookings.owner_name}">

						<input class="p-2 d-none inputBlogTitle w-100" type="text"
							name="user_Name" id="user_Name" value="${bookings.user_Name}">

						<button type="submit" form="form1"
							class="btn btn-blue btn-adduser mt-4 float-right"
							onclick="return myFun()">Book</button>

						<button type="button"
							class="btn  btn-blue btn-adduser mt-4 mr-2 float-right"
							data-target="#demo" data-toggle="collapse">Cancel</button>
					</form>
				</div> --%>
				
				
						<div class="collapse" id="collapseExample">
					<div class="col-md-10">
						<form id="messageForm">
							<div class="form-group">
								<input type="hidden" value="${property.id}"
									id="propertyIdForPropose"> <label for="messageHead">Message
									Heading</label> <input type="text" class="form-control"
									id="messageHead" name="message_head"
									placeholder="Message Heading">
							</div>
							<div class="form-group">
								<label for="message">Message:</label>
								<textarea class="form-control" rows="5" id="message"
									name="message_body"></textarea>
							</div>
							<div class="form-group">
								<p class="txt-red" id="proposalError">
							</div>
							<button class="btn-blue btn-center float-right"
								id="proposalSubmit" type="button">Send</button>

						</form>
					</div>
				</div>

				<div id="demo" class="collapse">
					<form action="/bookaProperty" id="form1" method="post">

						<textarea class="mt-3 p-2 w-100" name="massege"
							id="textAreaBlogBody" cols="16" rows="6"
							placeholder="Massege to owner">${bookings.massege }</textarea>

						<input class="p-2 d-none inputBlogTitle w-100" type="text"
							name="status" id="status" placeholder="Title"
							value="${bookings.status}">
						 <input
							class="p-2 d-none inputBlogTitle w-100" type="text"
							name="propertyID"  id="propertyID"
							value="${property.id}"> 
						<input
							class="p-2 d-none inputBlogTitle w-100" type="text"
							name="ownerID" id="ownerID" 
							value="${bookings.ownerID}">
							<input
							class="p-2 d-none inputBlogTitle w-100" type="text"
							name="user_email" id="userEmail" 
							value="${bookings.user_email}">
							<input
							class="p-2 d-none inputBlogTitle w-100" type="text"
							name="owner_email" id="owner_email" 
							value="${bookings.owner_email}">
							
							
							<%-- <input
							class="p-2 d-none inputBlogTitle w-100" type="text"
							name="owner_name" id="owner_name" 
							value="${bookings.owner_name}"> --%>
							
							<input
							class="p-2 d-none inputBlogTitle w-100" type="text"
							name="user_Name" id="user_Name" 
							value="${bookings.user_Name}">

						<button type="submit" form="form1" 
							class="btn btn-blue btn-adduser mt-4 float-right"
							onclick="return myFun()">Book</button>

						<button type="button"
							class="btn  btn-blue btn-adduser mt-4 mr-2 float-right"
							data-target="#demo" data-toggle="collapse">Cancel</button>
					</form>
				</div>

				<!-- Modal for User login for confirm payment-->
				<div class="modal fade" id="loginModal" tabindex="-1" role="dialog"
					aria-labelledby="exampleModalLabel" aria-hidden="true">
					<div class="modal-dialog" role="document">
						<div class="modal-content">
							<div class="modal-header">
								<h5 class="modal-title" id="exampleModalLabel">Modal title</h5>
								<button type="button" class="close" data-dismiss="modal"
									aria-label="Close">
									<span aria-hidden="true">&times;</span>
								</button>
							</div>
							<div class="modal-body">
								<form id="payment-form">

									<input type="hidden" value="${property.id}" id="propertyId">
									<!-- <div class="form-group"> -->
										<!-- <label for="email">Email address</label> <input type="email"
											class="form-control" id="email" aria-describedby="emailHelp"
											placeholder="Enter email">

									</div>
									<div class="form-group">
										<p class="txt-red" id="error-email">
									</div> -->
										<div class="form-group">
											<label for="password">Email address</label> <input
												type="password" class="form-control" id="password"
												aria-describedby="emailHelp" placeholder="Enter password">

										</div>
										<div class="form-group">
											<p class="txt-red" id="error">
										</div>
								</form>
							</div>
							<div class="modal-footer">
								<button type="button" class="btn btn-secondary"
									data-dismiss="modal">Close</button>
								<div>
									<button class="btn-blue" id="btnPayLogin" type="button">Confirm
										Pay</button>
								</div>
							</div>
						</div>
					</div>
				</div>
				<!-- End of the modal form -->
		</div>
	</div>

	<script src="assets/js/payment.js"></script> <!-- External Java script file for payments -->
	<script type="text/javascript">
		var propertyID = document.getElementById("propertyID");
		var ownerID = document.getElementById("ownerID");
	/* 	var userEmail = document.getElementById("userEmail");
		var ownerEmail = document.getElementById("owner_email"); */
		var status1 = document.getElementById("status");
		var textAreaMassegeBody = document.getElementById("textAreaBlogBody");
		
	/* 	var  owner_name = document.getElementById("owner_name"); */
		var user_Name = document.getElementById("user_Name");

		function myFun() {
			
			if (textAreaMassegeBody.value == "") {
				alert("Insert Massege");
				return false;
			}else{
				ownerID.value = "2";
				
				status1.value = "Pending";
			/* 	propertyID.value = "10098""; */
			/* 	userEmail.value = "aruniprashani@gmail.com"
				ownerEmail.value = "ayeshlak1998@gmail.com" */
				user_Name.value= "Prashani";
				/* owner_name.value = "Aruni"; */
			}

			
		}
		
		
		function myFunPub() {

			if (title.value == "") {
				alert("Insert Title");
				return false;
			} else if (textAreaBlogBody.value == "") {
				alert("Insert Description");
				return false;
			} else {
				inputF.value = "Published";
				inputF2.value = "TC";
			}

		}
		
	</script>
	
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
		integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
		crossorigin="anonymous">
		
	</script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
		integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
		crossorigin="anonymous">
		
	</script>
</body>

</html>