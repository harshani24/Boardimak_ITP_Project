<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>
<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta http-equiv="Pragma" content="no-cache">
	<meta http-equiv="Cache-Control" content="no-cache">
	<meta http-equiv="Expires" content="sat, 01 Dec 2001 00:00:00 GMT">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

    <!-- Custom styles -->
    <link rel="stylesheet" href="assets/css/main.css">
    <link rel="stylesheet" href="assets/css/index.css">
    
        <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

    <title>Boardimak</title>
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
                  <li class="nav-item active">
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
                  <a href="/register" class="btn-blue sign-up" uk-toggle="target: #modal-sign-up">SIGN UP</a>
              </div>
          </nav>


      </div>
      <div class="row">
          <p id="Home-heading">BOOK YOUR <br> BOARDING HERE</p>
      </div>
  </div>
</header>
<section>
  <div class="container" id="infinite">
        <h5 class="avl-property">AVAILABLE PROPERTIES</h5>
              <c:forEach var="property" items="${properties}">
                  <c:if test = "${property.status == 'Active'}">
                      <a href="/sigleProperty?id=${property.id}">
                          <div class="card">
                              <img class="card-img-top" src="/displayImage/${property.id}" alt="Property image">
                          <div class="card-body">
                          <div class = "row">
                              <div class = "col-sm-8">
                                	<h6>City: <span class="card-tags">${property.city}</span></h6>
                              </div>
                          </div>
                          <div class = "row">
                              <div class = "col-sm-12">
                                	  <h6>Price: 
                                	    		<span class="card-tags">Rs.${property.monthlyPayment}/month</span>
                                	  </h6>
                              </div>
                          </div>
                                        
                              <c:forEach var="p" items="${promotion }">
	                                  <c:if test="${property.id == p.property_id}">
											                  <c:if test="${p.status == 'Active'}">
													                  <div class = "row">
	                                					    <div class = "col-sm-12">
	                                	    				    <span class="card-tags1">New: Rs.${p.new_price}/month</span>
	                                        			</div>
	                                        	</div>
										                    </c:if> 
 											              </c:if>
 										          </c:forEach>
                          
                          </div>
                          </div>
                      </a>
                  </c:if>
              </c:forEach>
  </div>
</section>
</body>
</html>