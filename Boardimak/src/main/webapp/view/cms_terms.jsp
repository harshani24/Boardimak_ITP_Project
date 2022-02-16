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
	href="path/to/font-awesome/css/font-awesome.min.css">
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
<link rel="stylesheet" href="assets/css/cms.css">

<title>CMS Terms and Conditions</title>
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
							<a href="">
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
						<h3 class="d-inline-block mb-4">
							Content Management <img
								src="assets/icons/arrow-point-to-right.png"> </img> Terms and Conditions
						</h3>
						<div class="addBlogButtons d-inline-block float-right mb-3">
							<!-- <button type="button"
								class="btn btn-outline-dark p-1 addBlogButtonss">Save</button>
							<button type="button"
								class="btn btn-outline-dark p-1 addBlogButtonss ml-2">Publish</button> -->

							<button type="submit" form="form1" 
								class="btn btn-outline-dark p-1 addBlogButtonss"
								onclick="return myFun()">Save</button>


							<button type="submit" form="form1" 
								class="btn btn-outline-dark p-1 addBlogButtonss"
								onclick="return myFunPub()">Publish</button>
						</div>


						<p>It is a long established fact that a reader will be
							distracted by the readable content of a page when looking at its
							layout. It is a long established fact that a reader will be
							distracted by the readable content of a page when looking at its
							layout.</p>
					</div>

					<div class=" row">
						<div id="addBlogForm" class="blog_body col-12">
							<div class="accordion" id="accordionExample">

								<br>

								<c:set var="count" value="0" scope="page" />

								<c:forEach var="others" items="${others}">





									<c:if test="${others.type == 'TC'}">

										<c:set var="count" value="${count + 1}" scope="page" />

										<p class="text-dark font-weight-bold">Terms and Conditions ${count}</p>
										<div class="card">
											<div class="card-header" id="headingTwo">
												<h2 class="mb-0">
													<button class="btn btn-link text-decoration-none"
														type="button" data-toggle="collapse"
														data-target="#collapse${count}" aria-expanded="true"
														aria-controls="collapseOne">
														<div class="d-block d-flex justify-content-start"
															style="width: 300px">
															<span
																class="d-block text-decoration-none text-dark font-weight-bold"
																style="">${others.title}
																&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp </span> <img
																class=" float-right"
																src="assets/icons/arrow-down-sign-to-navigate.png"
																alt="">
														</div>
													</button>
												</h2>
											</div>
											<div id="collapse${count}" class="collapse"
												aria-labelledby="headingTwo" data-parent="#accordionExample">
												<div class="card-body">${others.description}</div>
											</div>
										</div>
										<br>

									</c:if>

								</c:forEach>

							</div>
							<div class="container float-right">

								<button type="button"
									class="btn  btn-blue btn-adduser mt-4 mb-2 float-right"
									data-toggle="collapse" data-target="#demo">+ Add term</button>
								<div id="demo" class="collapse">
									<form action="/saveTerm" id="form1" name="addPolicy"
										method="POST">
										<input class="p-2 d-block inputBlogTitle w-100" type="text"
											name="title" id="title" placeholder="Title" value="${other.title}">
										<input class="p-2 d-none inputBlogTitle w-100" type="text"
											name="status" id="statusContent" placeholder="Title"
											value="${other.status}"> <input
											class="p-2 d-none inputBlogTitle w-100" type="text"
											name="type" id="typeContent" placeholder="Title"
											value="${other.type}">
										<c:if test="${other.id != 0}">
											<input class="p-2 d-none inputBlogTitle w-100" type="number"
											name="id" id="idContent" placeholder="ID" value="${other.id}">
										</c:if>

										<textarea class="mt-3 p-2 w-100" name="description"
											id="textAreaBlogBody" cols="16" rows="6"
											placeholder="Type Policy here">${other.description}</textarea>
										<!-- <input type="submit" value="Save"
											class="btn  btn-blue btn-adduser mt-4 float-right" onclick="myFun()"> -->

										<button type="submit" form="form1" 
											class="btn  btn-blue btn-adduser mt-4  float-right"
											onclick="return myFun()">Save</button>
										<button type="button"
											class="btn  btn-blue btn-adduser mt-4 mr-2 float-right"
											data-target="#demo" data-toggle="collapse">Cancel</button>
									</form>
								</div>

							</div>
						</div>




						<!-- <div class=" col-2 addBlogFormSideBox ml-5 h-50">
							<div
								class="blog_body addBlogFormRightBoxContent font-weight-bold pt-2 pl-2"
								style="width: 120%;">
								<p class="mb-2 text-dark d-inline">Status :</p>
								<span class="mb-2 d-inline-block text-success"> Published</span><br>
								<p class="mb-2 text-dark d-inline">Date created :</p>
								<span class="mb-2 d-inline-block"> 23 07 2019</span><br>
								<p class="mb-2 text-dark d-inline">Written by :</p>
								<span class="mb-2 d-inline-block"> Shafkan</span><br>
								<p class="mb-2 text-dark d-inline">Published on :</p>
								<span class="mb-2 d-inline-block">23 04 2019</span><br>
								<p class="mb-2 text-dark d-inline">Published by :</p>
								<span class="mb-2 d-inline-block"> Shafkan</span><br>
							</div>

						</div> -->

					</div>


				</div>
			</div>
		</div>
	</div>
	</div>


	
	
	<script type="text/javascript">
		var inputF = document.getElementById("statusContent");
		var inputF2 = document.getElementById("typeContent");
		var title = document.getElementById("title");
		var textAreaBlogBody = document.getElementById("textAreaBlogBody");

		function myFun() {

			if (title.value == "") {
				alert("Insert Title");
				return false;
			} else if (textAreaBlogBody.value == "") {
				alert("Insert Description");
				return false;
			} else {
				inputF.value = "Draft";
				inputF2.value = "TC";
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