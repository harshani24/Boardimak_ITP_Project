<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>

<html lang="en">

<head>
	<!-- Required meta tags -->
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

	<!-- Bootstrap CSS -->
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
		integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

	<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
	<!-- Jquery min file is added there for do not add the slim version -->
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>


	<!-- Font Roboto 400, 500, 700 and 900-->
	<link href="https://fonts.googleapis.com/css?family=Roboto:400,500,700,900&display=swap" rel="stylesheet">

	<!-- Styles -->
	<link rel="stylesheet" href="assets/css/main.css" />
	 <link rel="stylesheet" href="assets/css/index.css">
	<link rel="stylesheet" href="assets/css/dashboard.css">
	<link rel="stylesheet" href="/static/css/cms.css">
	<style>
		<style>.container {
			width: 1400px;
		}
	</style>

	<title>Single property</title>
</head>

<body>

<header style="background-image: url(assets/images/homePage.jpg);">
  <div class="container">
      <div class="row">

            <nav class="navbar navbar-expand-lg">
                    <a class="navbar-brand" href="/">Boardimak</a>
                    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
                      <span class="navbar-toggler-icon"></span>
                    </button>
                    <div class="collapse navbar-collapse" id="navbarNavDropdown">
                      <ul class="navbar-nav">
                        <li class="nav-item">
                            <a class="nav-link" href="#">HOW IT WOKRS</a>
                        </li>  
                        <li class="nav-item">
                          <a class="nav-link" href="#">ABOUT US <span class="sr-only">(current)</span></a>
                        </li>
                        <li class="nav-item">
                          <a class="nav-link" href="#">BLOGS</a>
                        </li>
                        <li class="nav-item">
                          <a class="nav-link" href="#">CONTACT US</a>
                        </li>
                      </ul>
                    </div>
                    <div class="home-buttons">
                            <a href="/login" class="btn-blue log-in"  uk-toggle="target: #modal-close-outside">LOG IN</a>
                            <a href="#" class="btn-blue sign-up" uk-toggle="target: #modal-sign-up">SIGN UP</a>
                        </div>
                  </nav>


      </div>
      <div class="row">
          <p id="Home-heading">BOOK YOUR <br> BOARDING HERE</p>
      </div>
  </div>
</header>
	<div class="container">

		<div class="propertydetails ml-2 mt-5">

			<c:forEach var="blogs" items="${blogs}">

				<div class="ml-3 row shadow-lg p-5 mb-2 bg-white rounded mt-3">

					<div id="iamge" class="col-4">
						
						<img src="/displayImageBlog/${blogs.id}" alt="" width="300px" height="250px">
					</div>

					<div id="content" class="float-right ml-2 mt-3 col-7">
						<h3>${blogs.title}</h3>
						<p class=" mt-3">${blogs.description}
						</p>
						<p class="float-right">By ${blogs.author}</p>
					</div>



				</div>

			</c:forEach>

		</div>





		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
			integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous">

			</script>
		<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
			integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous">

			</script>
</body>

</html>