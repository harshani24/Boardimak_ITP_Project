<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
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
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>

<!-- Font Roboto 400, 500, 700 and 900-->
<link
	href="https://fonts.googleapis.com/css?family=Roboto:400,500,700,900&display=swap"
	rel="stylesheet">

<!-- Styles -->
<link rel="stylesheet" href="assets/css/main.css">
<link rel="stylesheet" href="assets/css/dashboard.css">
<link rel="stylesheet" href="assets/css/pay-property.css">

<title>Add Bank account</title>
</head>

<body>
	<section class="register-payment-body">
		<div class="container">
			<div class="row">
				<div class="col-md-5">
					<div id="create-acc-section">
						<div class="register-heading">
							<h1 align="center">You are all done</h1>
							<h4 align="center">In order to purchase a property you will
								need to add a payment method</h4>
						</div>
						<div class="form-body">
							<form id="payment-form">
								<div class="form-group">
									<label for="Name">Name</label> <input type="text"
										class="form-control" id="Name" placeholder="Name">

								</div>
								<div class="form-group">
									<p class="txt-red" id="error-name">
								</div>
								<div class="form-group">
									<label for="email">Email address</label> <input type="email"
										class="form-control" id="email" placeholder="Email">
								</div>
								<div class="form-group">
									<p class="txt-red" id="error-email">
								</div>
								<div class="form-group">
									<label for="accoutNo">Bank Account Number</label> <input
										type="textl" class="form-control" id="accountNo"
										placeholder="Account Number">

								</div>
								<div class="form-group">
									<p class="txt-red" id="error-accNo">
								</div>
								<div class="form-group">
									<label for="routingNumber">Routing Number</label> <input
										type="text" class="form-control" id="routingNumber"
										placeholder="Routing Number">

								</div>
								<div class="form-group">
									<p class="txt-red" id="error-routeNo">
								</div>
								<div class="form-group">
									<label for="mobileNo">Mobile Number</label> <input type="text"
										class="form-control" id="mobileNo" placeholder="Mobile Number">

								</div>
								<div class="form-group">
									<p class="txt-red" id="error-mobileNo">
								</div>
								<div class="form-group">
									<p class="txt-red" id="error-types">
								</div>
								<div class="form-group pt-2">
									<button class="btn-blue btn-center" id="submitButton"
										type="button">Create account</button>
								</div>
							</form>
						</div>
					</div>
					<div id="success-section">
						<h1 align="center" class="txt-green">congratulations!</h1>
						<h3 align="center">You are all done!</h3>
						<img src = "assets/images/celebrate.png" alt = "congradulations image" class = "success-image">
						<a href="/" class="success-section-link float-right">Continue
							to the site!</a>
					</div>
				</div>
				<div class="col-md-1">
					<div class="vl-reg"></div>
				</div>
				<div class="col-md-5">
					<img src="assets/images/house3.png" alt="house-image"
						class="house3-account">
				</div>
			</div>
		</div>
	</section>

	<script src="https://js.stripe.com/v3/"></script>
	<script src="assets/js/account.js"></script>
</body>

</html>