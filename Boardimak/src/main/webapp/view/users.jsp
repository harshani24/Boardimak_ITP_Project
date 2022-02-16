<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>

<html lang="en">
    <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap Toggle Switch -->
    <link href="https://gitcdn.github.io/bootstrap-toggle/2.2.2/css/bootstrap-toggle.min.css" rel="stylesheet">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

    <!-- Font Roboto 400, 500, 700 and 900-->
    <link href="https://fonts.googleapis.com/css?family=Roboto:400,500,700,900&display=swap" rel="stylesheet">

    <!-- Styles -->
    <link rel="stylesheet" href="assets/css/main.css"/>
    <link rel="stylesheet" href="assets/css/dashboard.css">
    <link rel="stylesheet" href="assets/css/users.css">
    <link rel="stylesheet" href="assets/css/toggle-switch.css">

    <title>Users</title>
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
                                	<c:if test="${user.userType == 'Employee' }">
	                                    <a href="dashboard"><li><img src="assets/icons/dashboard-icon.png" alt="Dashboard Icon">Dashboard</li></a>
	                                    <a href="/admin/property"><li><img src="assets/icons/property-icon.png" alt="Properties Icon">Properties</li></a>
	                                    <a href="bookings"><li><img src="assets/icons/booking-icon.png" alt="Bookings Icon">Bookings</li></a>
	                                    <a href="promotions"><li><img src="assets/icons/promotions-icon.png" alt="Promotions Icon">Promotions</li></a>
	                                    <a href="/all-payments"><li><img src="assets/icons/payment-icon.png" alt="Payment Icon">Payments</li></a>
	                                    <a href="cms"><li><img src="assets/icons/content-management-icon.png" alt="Contemtn Management Icon">Content Management</li></a>
	                                    <a href="/show-ticket"><li><img src="assets/icons/support-icon.png" alt="Support Icon">Support</li></a>
                                    </c:if>
                                    <c:if test="${user.userType == 'Admin' }">
	                                    <a href="dashboard"><li><img src="assets/icons/dashboard-icon.png" alt="Dashboard Icon">Dashboard</li></a>
	                                    <a href="/admin/property"><li><img src="assets/icons/property-icon.png" alt="Properties Icon">Properties</li></a>
	                                    <a href="bookings"><li><img src="assets/icons/booking-icon.png" alt="Bookings Icon">Bookings</li></a>
	                                    <a href="/users"><li class="active"><img src="assets/icons/users-icon.png" alt="Users Icon">Users</li></a>
	                                    <a href="promotions"><li><img src="assets/icons/promotions-icon.png" alt="Promotions Icon">Promotions</li></a>
	                                    <a href="/all-payments"><li><img src="assets/icons/payment-icon.png" alt="Payment Icon">Payments</li></a>
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
                            <h3>All Users</h3>
                            <button class="btn-blue btn-adduser" data-toggle="modal" data-target="#exampleModal">+ Add user</button>
                            <a class="link-log-out" href="/logout">LOG OUT</a>
                            <p>It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout.</p>
                        </div>

                        <div class="dashboard-body">
                        <c:choose>
                        	<c:when test="${mode == 'USER_VIEW'}">
                        	<table class="table table-borderless">
                                <thead>
                                    <tr>
                                        <th scope="col">Name</th>
                                        <th scope="col">Status</th>
                                        <th scope="col">Phone</th>
                                        <th scope="col">Email</th>
                                        <th scope="col">Actions</th>
                                    </tr>
                                </thead>
                                <tbody>
                                	<c:forEach var="user" items="${users}">
	                                    <tr>
	                                        <td>
	                                            <div class="table-profile-picture">
	                                                <img src="assets/icons/profile-pic.png" alt="Profile picture">
	                                            </div>
	                                            <div class="table-profile-text">
	                                                <p class="table-name">${user.firstName} ${user.lastName}</p>
	                                                <p>${user.userType}</p>
	                                            </div>
	                                        </td>
	                                        <td><p class="txt-green">Active</p></td>
	                                        <td>${user.mobileNumber}</td>
	                                        <td>${user.email}</td>
	                                        <td>
	                                            <ul class="list-actions">
	                                                <a href="editUser?id=${user.id}">
	                                                    <li>
	                                                        <img src="assets/icons/edit-user-icon.png" alt="Edit user icon ">
	                                                    </li>
	                                                </a>
	                                                <li>
	                                                    <label class="switch">
	                                                        <input type="checkbox">
	                                                        <span class="slider round"></span>
	                                                    </label>
	                                                </li>
	                                                <a href="deleteUser?id=${user.id}" onclick="return confirm('Press a button!')">                                        
	                                                        <img src="assets/icons/delete-icon.png" alt="Delete user icon">
	                                                    </li>
	                                                </a>
	                                            </ul>
	                                        </td>
	                                    </tr>
                                    </c:forEach>
                                </tbody>
                            </table>	
                        	</c:when>
                        	
                        	<c:when test="${mode == 'USER_EDIT'}">
                        		<div class="wrapper-edit-user-form">
		                            <h4>EDIT USER</h4>
		                            <form action="saveUser" method="POST">
		                            	<input type="hidden" name="id" value="${user.id}">
		                                <div class="row">
		                                    <div class="col-md-6">
		                                        <input type="text" id="editFirstName" name="firstName" value="${user.firstName}" placeholder="FIRST NAME">
		                                    </div>
		                                    <div class="col-md-6">
		                                        <input type="text" id="editLastName" name="lastName" value="${user.lastName}" placeholder="LAST NAME">
		                                    </div>
		                                    <div class="col-md-7">
		                                        <input type="email" id="editEmail" name="email" value="${user.email}" placeholder="EMAIL ADDRESS">
		                                    </div>
		                                    <div class="col-md-5">
		                                        <select name="userType" id="editAccountType">
		                                            <option value="null">SELECT ACCOUNT TYPE</option>
		                                            <option value="Admin">ADMIN</option>
		                                            <option value="Employee">EMPLOYEE</option>
		                                        </select>
		                                    </div>
		                                    <div class="col-md-6">
		                                        <input type="text" id="editMobileNo" name="mobileNumber" value="${user.mobileNumber}" placeholder="MOBILE NUMBER">
		                                    </div>
		                                    <div class="col-md-12">
		                                        <button type="submit" class="btn-blue btn-edit" onclick="return validateEditUser()">SAVE USER</button>
		                                    </div>
		                                </div>
		                            </form>
		                        </div>
                        	</c:when>
                        	
                        </c:choose>                        

                        </div>
                    </div>
                </div>
            </div>
        </div>

        <!--Add user Modal-->
        <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-body">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">X</span>
                        </button>

                        <div class="wrapper-modal-body">
                            <h4>ADD USER</h4>
                            <form action="saveUser" method="POST">
                                <div class="row">
                                    <div class="col-md-6">
                                        <input type="text" name="firstName" id="creFirstName" placeholder="FIRST NAME">
                                    </div>
                                    <div class="col-md-6">
                                        <input type="text" name="lastName" id="creLastName" placeholder="LAST NAME">
                                    </div>
                                    <div class="col-md-7">
                                        <input type="email" name="email" id="creEmail" placeholder="EMAIL ADDRESS">
                                    </div>
                                    <div class="col-md-5">
                                        <select name="userType" id="">
                                            <option value="null">SELECT ACCOUNT TYPE</option>
                                            <option value="Admin">ADMIN</option>
                                            <option value="Employee">EMPLOYEE</option>
                                        </select>
                                    </div>
                                    <div class="col-md-6">
                                        <input type="text" name="mobileNumber" placeholder="MOBILE NUMBER">
                                    </div>
                                    <div class="col-md-12">
                                        <button class="btn-blue" type="submit" onclick="return validateAddUser()">ADD USER</button>
                                    </div>
                                </div>
                            </form>
                        </div>

                    </div>
                </div>
            </div>
        </div>

	<div class="modal" tabindex="-1" role="dialog">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title">Modal title</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<p>Modal body text goes here.</p>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-primary">Save changes</button>
					<button type="button" class="btn btn-secondary"
						data-dismiss="modal">Close</button>
				</div>
			</div>
		</div>
	</div>

	<!-- Optional JavaScript -->

    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>

    <!-- Bootstrap Toggle Switch -->
    <script src="https://gitcdn.github.io/bootstrap-toggle/2.2.2/js/bootstrap-toggle.min.js" async></script>

    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    
   <script type="text/javascript" src="assets/js/user-validator.js"></script>
    
    </body>
</html>