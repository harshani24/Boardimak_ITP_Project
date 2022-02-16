<!doctype html>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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

<!-- Font Roboto 400, 500, 700 and 900-->
<link
	href="https://fonts.googleapis.com/css?family=Roboto:400,500,700,900&display=swap"
	rel="stylesheet">

<!-- Styles -->
<link rel="stylesheet" href="assets/css/main.css">
<link rel="stylesheet" href="assets/css/dashboard.css">
<link rel="stylesheet" href="assets/css/ticket.css">

<title>Ticket</title>
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
							<img src="assets/icons/notification-icon.png"
								alt="Notification Icon">
						</div>
					</div>

					<div class="wrapper-menu">
						<ul>
							<c:if test="${user.userType == 'Student'}">
								<a href="/dashboard"><li><img src="assets/icons/booking-icon.png" alt="Bookings Icon">Bookings</li></a>
								<a href="payment-details"><li><img src="assets/icons/payment-icon.png" alt="Payment Icon">Payments</li></a>
								<a href="/view/Proposals"><li><img src="assets/icons/transfer.png" style = "height:35px" Promotions Icon">Proposals</li></a>
								<a href="/ticket"><li class="active"><img src="assets/icons/support-icon.png" alt="Support Icon">Support</li></a>
							</c:if>
							
							<c:if test="${user.userType == 'Parent' }">
								<a href="/dashboard"><li><img src="assets/icons/booking-icon.png" alt="Bookings Icon">Bookings</li></a>
								<a href="payment-details"><li><img src="assets/icons/payment-icon.png" alt="Payment Icon">Payments</li></a>
								<a href="/view/Proposals"><li><img src="assets/icons/transfer.png" style = "height:35px" Promotions Icon">Proposals</li></a>
								<a href="/ticket"><li class="active"><img src="assets/icons/support-icon.png" alt="Support Icon">Support</li></a>
							</c:if>
								
							<c:if test="${user.userType == 'Owner' }">
								<a href="/dashboard"><li><img src="../assets/icons/dashboard-icon.png" alt="Dashboard Icon">Dashboard</li></a>
                                <a href="/owner/property"><li><img src="../assets/icons/property-icon.png" alt="Properties Icon">Properties</li></a>
                                <a href=""><li><img src="../assets/icons/booking-icon.png" alt="Bookings Icon">Bookings</li></a>
                                <a href="/owner/proposal"><li><img src="../assets/icons/proposal.png" alt="Proposal Icon">Proposals</li></a>
                                <a href="/show-promotion"><li><img src="../assets/icons/promotions-icon.png" alt="Promotions Icon">Promotions</li></a>                                
                                <a href="/all-payments"><li><img src="../assets/icons/payment-icon.png" alt="Payment Icon">Payments</li></a>
                                <a href="/ticket"><li class="active"><img src="../assets/icons/support-icon.png" alt="Support Icon">Support</li></a>
							</c:if>
							
							<c:if test="${user.userType == 'Employee' }">
								<a href="/dashboard"><li><img src="assets/icons/dashboard-icon.png" alt="Dashboard Icon">Dashboard</li></a>
                                <a href="/admin/property"><li><img src="assets/icons/property-icon.png" alt="Properties Icon">Properties</li></a>
                                <a href="bookings"><li><img src="assets/icons/booking-icon.png" alt="Bookings Icon">Bookings</li></a>
                                <a href="/owner/proposal"><li><img src="../assets/icons/proposal.png" alt="Proposal Icon">Proposals</li></a>
	                            <a href="/admin-promotion"><li><img src="assets/icons/promotions-icon.png" alt="Promotions Icon">Promotions</li></a>
	                            <a href="/all-payments"><li><img src="assets/icons/payment-icon.png" alt="Payment Icon">Payments</li></a>
	                            <a href="cms"><li><img src="assets/icons/content-management-icon.png" alt="Contemtn Management Icon">Content Management</li></a>
	                            <a href="/show-ticket"><li><img src="assets/icons/support-icon.png" alt="Support Icon">Support</li></a>
							</c:if>
							
							<c:if test="${user.userType == 'Admin' }">
								<a href="/dashboard"><li><img src="assets/icons/dashboard-icon.png" alt="Dashboard Icon">Dashboard</li></a>
                                <a href="/admin/property"><li><img src="assets/icons/property-icon.png" alt="Properties Icon">Properties</li></a>
                                <a href="bookings"><li><img src="assets/icons/booking-icon.png" alt="Bookings Icon">Bookings</li></a>
                                <a href="/owner/proposal"><li><img src="../assets/icons/proposal.png" alt="Proposal Icon">Proposals</li></a>
                                <a href="/users"><li><img src="assets/icons/users-icon.png" alt="Users Icon">Users</li></a>
	                            <a href="/admin-promotion"><li><img src="assets/icons/promotions-icon.png" alt="Promotions Icon">Promotions</li></a>
	                            <a href="/all-payments"><li><img src="assets/icons/payment-icon.png" alt="Payment Icon">Payments</li></a>
	                            <a href="cms"><li><img src="assets/icons/content-management-icon.png" alt="Contemtn Management Icon">Content Management</li></a>
	                            <a href="/show-ticket"><li><img src="assets/icons/support-icon.png" alt="Support Icon">Support</li></a>
							</c:if>
						</ul>
					</div>

					<div class="wrapper-help">
						<a href=""><img src="assets/icons/help-icon.png"
							alt="Help icon">Help</a>
					</div>
				</div>

				<c:choose>
					<c:when test="${mode=='MODE_HOME' }">

						<div class="right-panel">
						<!-- <a class="link-log-out" href="/logout">LOG OUT</a> -->
							<div class="wrapper-body">
								<h3>Dashboard</h3>
								<p>It is a long established fact that a reader will be
									distracted by the readable content of a page when looking at
									its layout. It is a long established fact that a reader will be
									distracted by the readable content of a page when looking at
									its layout.</p>
							</div>

							<div class="dashboard-body">
								<p>It is a long established fact that a reader will be
									distracted by the readable content of a page when looking at
									its layout. It is a long established fact that a reader will be
									distracted by the readable content of a page when looking at
									its layout.</p>
								<br>
								<p class="txt-red">I am red text</p>
								<p class="txt-orange">I am orange text</p>
								<p class="txt-green">I am green text</p>
								<br>
								<button class="btn-blue">BUTTON</button>
								<input type="text" placeholder="TESTING"></input>
							</div>
						</div>

					</c:when>

					<c:when test="${ mode=='MODE_TICKET'}">


						<div class="right-panel">
							<div class="wrapper-body">
								<h3>All Tickets</h3>
								<a href="/create-ticket" class="btn-blue btn-adduser"> + Add Ticket</a>
								<a class="link-log-out" href="/logout">LOG OUT</a>
								<p>It is a long established fact that a reader will be
									distracted by the readable content of a page when looking at
									its layout. It is a long established fact that a reader will be
									distracted by the readable content of a page when looking at
									its layout.</p>
							</div>

							<div class="dashboard-body">
								<table class="table table-borderless">
									<thead>
										<tr>
											<th scope="col">Ticket ID</th>
											<th scope="col">Subject</th>
											<th scope="col">Date</th>
											<th scope="col">Status</th>
											<th scope="col">Actions</th>

										</tr>
									</thead>
									<tbody>
										<c:forEach var="ticket1" items="${tickets }">
											<c:if test="${ticket1.email == user.email }">
												<tr>
													<td><a href="/open-Userticket?id=${ticket1.id }"
														class="TransactionID">${ticket1.id}</a></td>
													<td><p>${ticket1.subject}</p></td>
													<td><p>${ticket1.created_date}</p></td>
													<td><c:if test="${ticket1.status == 'Open'}">
															<p class="txt-green">Open</p>
														</c:if> <c:if test="${ticket1.status == 'Pending'}">
															<p class="text-warning">Pending</p>
														</c:if> <c:if test="${ticket1.status == 'Resloved'}">
															<p class="txt-red">Resolved</p>
														</c:if></td>
													<td>
														<ul class="list-actions">
															<a href="/edit-user?id=${ticket1.id }"><li><img
																class="icon-edit"	src="assets/icons/edit-user-icon.png"  style = "width:22px; height:22px;"
																	alt="Edit user icon "></li></a>
															<li></li>
															<a href="/delete-user?id=${ticket1.id }"><li>
															<img src="assets/icons/delete-icon.png"  style = "width:22px; height:22px;"
																class="icon-delete"	alt="Delete user icon">
																	</li></a>
														</ul>
													</td>
												</tr>
											</c:if>
										</c:forEach>
									</tbody>
								</table>
							</div>
						</div>


					</c:when>

					<c:when test="${ mode=='MODE_REGISTER'}">

						<div class="right-panel">
							<div class="wrapper-body">
								<h3>Support Tickets > Create Ticket</h3>
								<a class="link-log-out" href="/logout">LOG OUT</a>
								<p>It is a long established fact that a reader will be
									distracted by the readable content of a page when looking at
									its layout. It is a long established fact that a reader will be
									distracted by the readable content of a page when looking at
									its layout.</p>
							</div>

							<div class="dashboard-body">
								<form class="create-ticket-form" method="POST"
									action="save-user" name="form">
									
									<input type="hidden" name="id" value="${ticket1.id }" />
									
									<input
										type="hidden" name="status" value="Open" />
										
									<input type="hidden" class="formtext" name="name" id="uname" placeholder="Name"
										value="${user.firstName }">
										
									<input type="hidden" class="formtext" name="email" id="uemail" placeholder="Email"
										value="${user.email }"><br> <br>
									
									<input type="text" class="formtext" name="subject" placeholder="Subject"
										id="usubject" value="${ticket1.subject }"><br> <br>
									
									<textarea id="subject" class="inputtext" name="content" placeholder="Message"
										id="ucontent" value="${ticket1.content }" placeholder="Message.."></textarea>
									
									<div class="submitbutton">
										<input type="submit" onclick="return validation()"
											class="btn-blue btn-create" value="Create" />
									</div>
								</form>

							</div>
						</div>

					</c:when>

					<c:when test="${ mode=='MODE_UPDATE'}">

						<div class="right-panel">
							<div class="wrapper-body">
								<h3>Support Tickets > Edit ticket</h3>
								<a class="link-log-out" href="/logout">LOG OUT</a>
								<p>It is a long established fact that a reader will be
									distracted by the readable content of a page when looking at
									its layout. It is a long established fact that a reader will be
									distracted by the readable content of a page when looking at
									its layout.</p>
							</div>

							<div class="dashboard-body">
								<form class="create-ticket-form" id="form1" method="POST"
									action="save-user" name=" ">
									<input type="hidden" name="id" value="${ticket1.id }" /> <input
										type="hidden" name="status" id="statusContent"
										value="${ticket1.status }" />
									
									<input type="hidden" class="formtext" name="name" 
										value="${user.firstName }">
									
									<input type="hidden" class="formtext" name="email"
										value="${user.email }"><br> <br>

									<input type="text" class="formtext" name="subject" placeholder="Subject"
										value="${ticket1.subject }"><br> <br>
									
									<textarea id="subject" class="inputtext" name="content" placeholder="Message"
										value="${ticket1.content }" placeholder="Message.." required></textarea>
									
									<div class="submitbutton">
										<input type="submit" class="btn-blue btn-create"
											value="Update" />
									</div>
								</form>

							</div>
						</div>
					</c:when>


					<c:when test="${ mode=='OPEN_USERTICKET'}">
						<div class="right-panel">
							<div class="wrapper-body">
								<h3>
									Support Tickets >
									<h3>Ticket ID:TIC-${ticket1.id }</h3>
								</h3>
								<a href="/closeTicket" class="btn-blue btn-ticket">Close</a>
								<ul>
									<li>Status : <c:if test="${ticket1.status == 'Open'}">
											<h8 class="txt-green">Open</h8>
										</c:if> <c:if test="${ticket1.status == 'Pending'}">
											<h8 class="text-warning">Pending</h8>
										</c:if> <c:if test="${ticket1.status == 'Resloved'}">
											<h8 class="txt-red">Resolved</h8>
										</c:if>
									</li>
									<li>Created On : <h8>${ticket1.created_date}</h8></li>
									<li>Email : <h8>${ticket1.email}</h8></li>
								</ul>
							</div>

							<div class="dashboard-body">
								<h6>About : ${ticket1.subject}</h6>
								</br>
								<h8>${ticket1.name}</h8>
								<p>
									Dear Administor,${ticket1.content}<br> thank you
								</p>
								<c:forEach var="reply" items="${replys }">
									<c:if test="${ticket1.id == reply.ticket_id}">
										<c:choose>
											<c:when test="${reply.user_id == 1}">
												<div class="message">
													<h8>${ticket1.name}</h8>
													<p>${reply.reply_msg}</p>
												</div>
											</c:when>
											<c:otherwise>
												<div class="reply">
													<h8>Administrator</h8>
													<p>${reply.reply_msg}</p>
												</div>
											</c:otherwise>
										</c:choose>
									</c:if>
								</c:forEach>
								<br> <a href="/ticket-UserReply?id=${ticket1.id }"
									class="btn-blue btn-add-prop">Reply</a>
							</div>
						</div>
					</c:when>

					<c:when test="${ mode=='OPEN_USERREPLY'}">
						<div class="right-panel">
							<div class="wrapper-body">
								<h3>
									Support Tickets >
									<h3>Ticket ID:TIC-${ticket1.id }</h3>
								</h3>
								<button class="btn-blue btn-ticket">Close</button>
								<ul>
									<li>Status : <c:if test="${ticket1.status == 'Open'}">
											<h8 class="txt-green">Open</h8>
										</c:if> <c:if test="${ticket1.status == 'Pending'}">
											<h8 class="text-warning">Pending</h8>
										</c:if> <c:if test="${ticket1.status == 'Resloved'}">
											<h8 class="txt-red">Resolved</h8>
										</c:if>
									</li>
									<li>Created On : <h8>${ticket1.created_date}</h8></li>
									<li>Email : <h8>${ticket1.email}</h8></li>
								</ul>
							</div>

							<div class="dashboard-body">
								<h6>About : ${ticket1.subject}</h6>
								</br>
								<h8>${ticket1.name}</h8>
								<p>
									Dear Administor,${ticket1.content}<br> thank you.
								</p>

								<c:forEach var="reply" items="${replys }">
									<c:if test="${ticket1.id == reply.ticket_id}">
										<c:choose>
											<c:when test="${reply.user_id == 1}">
												<div class="message">
													<h8>${ticket1.name}</h8>
													<p>${reply.reply_msg}</p>
												</div>
											</c:when>
											<c:otherwise>
												<div class="reply">
													<h8>Administrator</h8>
													<p>${reply.reply_msg}</p>
												</div>
											</c:otherwise>
										</c:choose>
									</c:if>
								</c:forEach>


								<form action="replyTicket" method="POST">
									<input type="hidden" name="id" value="${reply.id }" /> <input
										type="hidden" name="ticket_id" value="${ticket1.id }" /> <input
										type="hidden" name="user_id" value="1" />
									<textarea id="subject" class="inputtext" name="reply_msg"
										placeholder="Your Reply.." required></textarea>
									<button class="btn-blue btn-add-prop">Reply</button>
								</form>
							</div>
						</div>
			</div>
		</div>
	</div>


	</c:when>
	</c:choose>
	<!-- Optional JavaScript -->

	<script type="text/javascript">
		function validation() {
			var Name = document.form.name.value;
			var Email = document.form.email.value;
			var Content = document.form.content.value;

			if (Name == null || Name == "") {
				alert("Name can't be blank");
				return false;
			} else if (Email == null || Email == "") {
				alert("Email can't be blank");
				F
				return false;

			} else if (Content == null || Content == "") {
				alert("please Enter your message");
				return false;
			}
		}
	</script>

	<!--  	<script type="text/javascript">
		function validation() {
		    var email, name, subject, content;

		    name = document.getElementById('uname');
		    email = document.getElementById('uemail');
		    subject = document.getElementById('usubject');
		    content = document.getElementById('ucontent');
		    
		    if ( email.value === '' && name.value === '' && subject.value === '' && content.value === '') {
		        changeInputColor(email);
		        changeInputColor(name);
		        changeInputColor(subject);
		        changeInputColor(content);		        
		        alert("Field can't be blank");
		        return false;
		    } else if ( name.value != '' && email.value === '' && subject.value === '' && content.value === '') {
			        changeInputColor(subject);
			        changeInputColor(email);
			        changeInputColor(content);
			        alert("Subject,Name And Content can't be blank");
			        return false;
		    } else if ( email.value != '' && name.value != '' && subject.value === '' && content.value === '') {
		        changeInputColor(subject);
		        changeInputColor(content);
		        alert("Subject And Content can't be blank");
		        return false;
		    } else if ( email.value != '' && name.value != '' && subject.value != '' && content.value === '') {
		        changeInputColor(content);
		        alert("Content can't be Empty");
		        return false;
		    } else if ( email.value === '' && name.value === '' && subject.value != '' && content.value === '') {
		        changeInputColor(email);
		        changeInputColor(name);
		        changeInputColor(content);
		        alert("field can't be Empty");
		        return false; 
		    } else if ( email.value === '' && name.value === '' && subject.value === '' && content.value != '') {
		        changeInputColor(email);
		        changeInputColor(name);
		        changeInputColor(subject);
		        alert("field can't be Empty");
		        return false;    
		    } else {
		    	return true;
		    }
		}

		function changeInputColor(inputField) {
		    inputField.style.borderColor = "#ff7272";
		    inputField.style.backgroundColor = "#ffe0e070";
		}

		
		
		</script>
	
	-->

	<!-- Optional JavaScript -->



	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
		integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
		integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
		integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
		crossorigin="anonymous"></script>
</body>
</html>