<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>
<html lang="en">
    <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

    <!-- Font Roboto 400, 500, 700 and 900-->
    <link href="https://fonts.googleapis.com/css?family=Roboto:400,500,700,900&display=swap" rel="stylesheet">

    <!-- Styles -->
    <link rel="stylesheet" href="assets/css/main.css">
    <link rel="stylesheet" href="assets/css/dashboard.css">

    <title>Payment Details</title>
</head>
    <body>
        <div class="section">
            <div class="container-fluid">
                <div class="row">
                    <div class="left-panel">
                        <div class="wrapper-profile">
                            <div class="profile-picture">
                                <img src="assets/icons/profile-pic.png" alt="Profile picture">
                            </div>
                            <div class="profile-text">
                                <h6><c:out value="${user.firstName} ${user.lastName}"/></h6>
                                <p><c:out value="${user.userType}"/></p>
                            </div>
                            <div class="profile-notification">
                                <img src="assets/icons/notification-icon.png" alt="Notification Icon">
                            </div>
                        </div>

                        <div class="wrapper-menu">
                            <ul>
                                <c:if test="${user.userType == 'Student' }">
									<a href=""><li><img src="assets/icons/booking-icon.png" alt="Bookings Icon">Bookings</li></a>
									<a href="/payment-details"><li class="active"><img src="assets/icons/payment-icon.png" alt="Payment Icon">Payments</li></a>
									 <a href="/view/Proposals"><li><img src="../assets/icons/transfer.png" style = "height:35px" Promotions Icon">Proposals</li></a>
									<a href="/ticket"><li><img src="assets/icons/support-icon.png" alt="Support Icon">Support</li></a>
								</c:if>
								
								<c:if test="${user.userType == 'Parent' }">
									<a href=""><li><img src="assets/icons/booking-icon.png" alt="Bookings Icon">Bookings</li></a>
									<a href="/payment-details"><li class="active"><img src="assets/icons/payment-icon.png" alt="Payment Icon">Payments</li></a>
									<a href="/ticket"><li><img src="assets/icons/support-icon.png" alt="Support Icon">Support</li></a>
								</c:if>
								
								<c:if test="${user.userType == 'Owner' }">
									<a href="/dashboard"><li><img src="../assets/icons/dashboard-icon.png" alt="Dashboard Icon">Dashboard</li></a>
	                                <a href="/owner/property"><li><img src="../assets/icons/property-icon.png" alt="Properties Icon">Properties</li></a>
	                                <a href=""><li><img src="../assets/icons/booking-icon.png" alt="Bookings Icon">Bookings</li></a>
	                                <a href="/owner/proposal"><li><img src="../assets/icons/proposal.png" alt="Proposal Icon">Proposals</li></a>
	                                <a href="/show-promotion"><li><img src="../assets/icons/promotions-icon.png" alt="Promotions Icon">Promotions</li></a>                                
	                                <a href="/payment-details"><li class="active"><img src="../assets/icons/payment-icon.png" alt="Payment Icon">Payments</li></a>
	                                <a href="/ticket"><li><img src="../assets/icons/support-icon.png" alt="Support Icon">Support</li></a>
								</c:if>
								
								<c:if test="${user.userType == 'Employee' }">
									<a href="/dashboard"><li><img src="assets/icons/dashboard-icon.png" alt="Dashboard Icon">Dashboard</li></a>
		                            <a href="/admin/property"><li><img src="assets/icons/property-icon.png" alt="Properties Icon">Properties</li></a>
		                            <a href="bookings"><li><img src="assets/icons/booking-icon.png" alt="Bookings Icon">Bookings</li></a>
			                        <a href="/owner/proposal"><li><img src="../assets/icons/proposal.png" alt="Proposal Icon">Proposals</li></a>
			                        <a href="/admin-promotion"><li><img src="assets/icons/promotions-icon.png" alt="Promotions Icon">Promotions</li></a>
			                        <a href="/all-payments"><li class="active"><img src="assets/icons/payment-icon.png" alt="Payment Icon">Payments</li></a>
			                        <a href="cms"><li><img src="assets/icons/content-management-icon.png" alt="Contemtn Management Icon">Content Management</li></a>
			                        <a href="/show-ticket"><li><img src="assets/icons/support-icon.png" alt="Support Icon">Support</li></a>
								</c:if>
									
								<c:if test="${user.userType == 'Admin' }">
									<a href="/dashboard"><li ><img src="assets/icons/dashboard-icon.png" alt="Dashboard Icon">Dashboard</li></a>
		                            <a href="/admin/property"><li><img src="assets/icons/property-icon.png" alt="Properties Icon">Properties</li></a>
		                            <a href="bookings"><li><img src="assets/icons/booking-icon.png" alt="Bookings Icon">Bookings</li></a>
		                            <a href="/users"><li><img src="assets/icons/users-icon.png" alt="Users Icon">Users</li></a>
		                            <a href="/owner/proposal"><li><img src="../assets/icons/proposal.png" alt="Proposal Icon">Proposals</li></a>
			                        <a href="/admin-promotion"><li><img src="assets/icons/promotions-icon.png" alt="Promotions Icon">Promotions</li></a>
			                        <a href="/all-payments"><li class="active"><img src="assets/icons/payment-icon.png" alt="Payment Icon">Payments</li></a>
			                        <a href="cms"><li><img src="assets/icons/content-management-icon.png" alt="Contemtn Management Icon">Content Management</li></a>
			                        <a href="/show-ticket"><li><img src="assets/icons/support-icon.png" alt="Support Icon">Support</li></a>
								</c:if>
                            </ul>
                        </div>

                        <div class="wrapper-help">
                            <a href=""><img src="assets/icons/help-icon.png" alt="Help icon">Help</a>
                        </div>
                    </div>
                    <div class="right-panel">
                        <div class="wrapper-body">
                            <h3>Payments</h3>
                            <a class="link-log-out" href="/logout">LOG OUT</a>
                            <p>It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout.</p>
                        </div>

                        <div class="dashboard-body">
                            <table class="table table-borderless">
                                <thead>
                                    <tr>
                                        <th scope="col">Transaction ID</th>
                                        <th scope="col">Payment type</th>
                                        <th scope="col">Amount</th>
                                        <th scope="col">Status</th>
                                        <th scope="col">Date</th>
                                        <th scope="col">Invoice</th>
                                    </tr>
                                </thead>
                                <tbody>
                                <c:forEach var="payment" items="${payments}">
                                    <tr>
                                        <td><p>${payment.getPayment_token()}</p></td>
                                        <td><p>${payment.getPaymentMethod()}</p></td>
                                        <td><p>Rs.${payment.getAmount()}</p></td>
                                        <td>
                                            <p class = "txt-green">${payment.getStatus()}</p>
                                        </td>
                                        <td>
                                            <p>${payment.getDate()}</p>
                                        </td>
                                        <td><a href = "paymentInvoice?id=${payment.payment_id}"><img src = "/assets/icons/download.png"></a>
                                    </tr>
                                 </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </div>
