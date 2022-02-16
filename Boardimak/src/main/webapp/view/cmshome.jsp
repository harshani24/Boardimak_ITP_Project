<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!doctype html>
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
<link rel="stylesheet" href="assets/css/users.css">
<link rel="stylesheet" href="assets/css/cms.css">

<style>
#addBlogButton:hover{
color:white;
}
</style>

<title>cmsHome</title>
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
							<h5>John Peter</h5>
							<p>Admin</p>
						</div>
						<div class="profile-notification">
							<img src="assets/icons/notification-icon.png"
								alt="Notification Icon">
						</div>
					</div>

					<div class="wrapper-menu">
						<ul>
							<a href="dashboard.html">
								<li><img src="assets/icons/dashboard-icon.png"
									alt="Dashboard Icon">Dashboard</li>
							</a>
							<a href="">
								<li><img src="assets/icons/property-icon.png"
									alt="Properties Icon">Properties</li>
							</a>
							<a href="/bookingsHomestu">
								<li><img src="assets/icons/booking-icon.png"
									alt="Bookings Icon">Bookings</li>
							</a>
							<a href="users.html">
								<li><img src="assets/icons/users-icon.png" alt="Users Icon">Users</li>
							</a>
							<a href="">
								<li><img src="assets/icons/promotions-icon.png"
									alt="Promotions Icon">Promotions</li>
							</a>
							<a href="payment-details.html">
								<li><img src="assets/icons/payment-icon.png"
									alt="Payment Icon">Payments</li>
							</a>
							<a href="/cmsHome">
								<li class="active"><img
									src="assets/icons/content-management-icon.png"
									alt="Contemtn Management Icon">Content Management</li>
							</a>
							<a href="">
								<li><img src="assets/icons/support-icon.png"
									alt="Support Icon">Support</li>
							</a>
						</ul>
					</div>

					<div class="wrapper-help">
						<a href=""><img src="assets/icons/help-icon.png"
							alt="Help icon">Help</a>
					</div>
				</div>
				<div class="right-panel">
					<div class="wrapper-body">
						<h3>Content Management</h3>
						<button class="btn-blue p-1 addBlogButtonss">
							<a href="/newBlog" id="addBlogButton">+ Add Blog</a>
						</button>
						<button class="btn-blue p-1 addBlogButtonss ml-2">
							<a href="/newTerm" id="addBlogButton">+ Add Term</a>
						</button>
						<button class="btn-blue p-1 addBlogButtonss ml-2">
							<a href="/newPolicy" id="addBlogButton">+ Add Policy</a>
						</button>
						<button class="btn-blue p-1 addBlogButtonss ml-2">
							<a href="/newFAQ" id="addBlogButton">+ Add FAQ</a>
						</button>
						<button class="btn-blue p-1 addBlogButtonss ml-2">
							<a href="/blogReport" id="addBlogButton">Blog report</a>
						</button>
						<button class="btn-blue p-1 addBlogButtonss ml-2">
							<a href="/cmsOtherReport" id="addBlogButton">CMS Other report</a>
						</button>
						
						<p>It is a long established fact that a reader will be
							distracted by the readable content of a page when looking at its
							layout. It is a long established fact that a reader will be
							distracted by the readable content of a page when looking at its
							layout.</p>
					</div>




					<section id="tabs">
						<div class="container mt-4">

							<div class="row">
								<div class="col-12 ">
									<nav class="col-6">
										<div class="nav nav-tabs nav-fill" id="nav-tab" role="tablist">
											<a class="nav-item nav-link active w-25" id="nav-home-tab"
												data-toggle="tab" href="#nav-home" role="tab"
												aria-controls="nav-home" aria-selected="true">Blogs</a> <a
												class="nav-item nav-link w-25" id="nav-profile-tab"
												data-toggle="tab" href="#nav-profile" role="tab"
												aria-controls="nav-profile" aria-selected="false">Documentations</a>

										</div>
									</nav>
									<div class="tab-content py-3 px-3 px-sm-0 " id="nav-tabContent">
										<div class="tab-pane fade show active" id="nav-home"
											role="tabpanel" aria-labelledby="nav-home-tab">
											<div class="dashboard-body">
												<table class="table table-borderless">
													<thead>
														<tr>
															<th scope="col">Title</th>
															<th scope="col">Written by</th>
															<!-- <th scope="col">Featured image</th> -->
															<th scope="col">Status</th>
															<th scope="col">Date and time</th>
															<th scope="col">Actions</th>

														</tr>
													</thead>
													<tbody>

														<c:forEach var="blogs" items="${blogs}">

															<tr>
																<td>
																	<p class="font-weight-bold" style="color: #2c305d">${blogs.title}</p>
																</td>
																<td>
																	<p>${blogs.author}</p>
																</td>
																<!-- <td><img src="" alt=""></td> -->
																<td><c:if test="${blogs.status == 'Published'}">
																		<p class="txt-green">Published</p>
																	</c:if> <c:if test="${blogs.status == 'Draft'}">
																		<p class="text-warning">Draft</p>
																	</c:if></td>
																<td>
																<p>2019-08-29 11:31:03.0</p>
																<%--  <p>${blogs.date_time}</p>  --%>
		
																</td>
																<td>
																	<ul class="list-actions">
																		<a href="/editBlog?id=${blogs.id}">
																			<li><img
																				src="assets/icons/home-060-edit-512.png"
																				width="20px" height="20px" alt="Edit user icon ">
																		</li>
																		</a>
																		<li></li>
																		<a href="/delete-blog?id=${blogs.id }">
																			<li><img src="assets/icons/delete-icon.png"
																				alt="Delete user icon"></li>
																		</a>
																	</ul>
																</td>
															</tr>

														</c:forEach>
														
													</tbody>
												</table>
											</div>

										</div>
										<div class="tab-pane fade" id="nav-profile" role="tabpanel"
											aria-labelledby="nav-profile-tab">
											<div class="dashboard-body">
												<table class="table table-borderless homeCMS">
													<thead>
														<tr>
															<th scope="col">Documentation</th>
															<th scope="col">Last updated</th>
															<th scope="col">Status</th>
															<th scope="col">Actions</th>

														</tr>
													</thead>
													<tbody>
													
													<c:forEach var="others" items="${others}">
													
														<tr>
															<td><c:if test="${others.type == 'TC'}">
																		<p class="font-weight-bold" style="color: #2c305d">Terms & conditions</p>
																	</c:if>
																	<c:if test="${others.type == 'FA'}">
																		<p class="font-weight-bold" style="color: #2c305d">FAQs</p>
																	</c:if>
																	<c:if test="${others.type == 'Policy'}">
																		<p class="font-weight-bold" style="color: #2c305d">Privacy Policy</p>
																	</c:if>
																
															</td>
															<td>
																<p>${others.date_time}</p>
															</td>

															<td>
																<c:if test="${others.status == 'Published'}">
																		<p class="txt-green">Published</p>
																	</c:if> <c:if test="${others.status == 'Draft'}">
																		<p class="text-warning">Draft</p>
																	</c:if>
															</td>
															<td>
																<ul class="list-actions">
																	<a href="/editcmsothers?id=${others.id}">
																		<li><img src="assets/icons/home-060-edit-512.png"
																			width="20px" height="20px" alt="Edit user icon ">
																	</li>
																	</a>
																	<li></li>
																	<a href="/delete-cmsothers?id=${others.id}">
																		<li><img src="assets/icons/delete-icon.png"
																			alt="Delete user icon"></li>
																	</a>
																</ul>
															</td>
														</tr>
														
														</c:forEach>
														
													</tbody>
												</table>
											</div>
										</div>

									</div>

								</div>
							</div>
						</div>
					</section>








				</div>
			</div>
		</div>
	</div>

	<!-- Optional JavaScript -->
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
		integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
		crossorigin="anonymous">
		
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