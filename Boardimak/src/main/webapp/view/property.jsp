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
    <link rel="stylesheet" href="assets/css/property.css">

    <title>Boardimak</title>
</head>
<body>

<header style="background-image: linear-gradient( rgba(0, 0, 0, 0.7),  rgba(0, 0, 0, 0.7)),url(assets/images/homePage.jpg);">
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
                            <a href="/owner/property" class="btn-white log-in"  uk-toggle="target: #modal-close-outside">LOG IN</a>
                            <a href="#" class="btn-white sign-up" uk-toggle="target: #modal-sign-up">SIGN UP</a>
                        </div>
                  </nav>


      </div>
      <div class="row" >
            <div class="col-md-8">
                <div id="carouselExampleIndicators" style="width: 100%; height: 80vh; margin:auto;" class="carousel slide" data-ride="carousel">
                    <ol class="carousel-indicators">
                      <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
                      <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
                      <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
                    </ol>
                    <div class="carousel-inner" style="border-radius: 20px;">
                      <div class="carousel-item active">
                        <img class="d-block w-100" style="width: 600px; height: 80vh;border-radius: 20px;" src="assets/images/pr1.jpg" alt="First slide">
                      </div>
                      <div class="carousel-item">
                        <img class="d-block w-100" style="width: 600px;height: 80vh;border-radius: 20px;" src="assets/images/pr4.jpeg" alt="Second slide">
                      </div>
                      <div class="carousel-item">
                        <img class="d-block w-100" style="width: 600px;height: 80vh;border-radius: 20px;" src="assets/images/pr3.jpg" alt="Third slide">
                      </div>
                    </div>
                    <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
                      <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                      <span class="sr-only">Previous</span>
                    </a>
                    <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
                      <span class="carousel-control-next-icon" aria-hidden="true"></span>
                      <span class="sr-only">Next</span>
                    </a>
                </div>
            </div>
            <div class="col-md-4">
                <div style="width: 100%; height: 80vh; margin:auto;background-color: blanchedalmond; border-radius: 10px;">
                    <div style="background-color: rgb(79, 122, 187);height: 50px; text-align: center;font-size: 25px;font-weight: 600">
                        property ID : <span style="color: blue">${property.id}</span>
                    </div>
                    
                    <ul style="margin-left:20px">
 						  <li>Address :${property.addressOne},${property.addressTwo},${property.city}</li>
  						  <li>Key Money:${property.keyMoney}</li>
						  <li>Monthly Payment:${property.monthlyPayment}</li>
						  
						  <c:forEach var="p" items="${promotion }">
												 <c:if test="${property.id == p.property_id}">
												     <c:if test="${p.status == 'Active'}">
	                                	    					<li>Discounted Monthly Price:${p.new_price}</li>

										          </c:if>  
									        </c:if>     
						 </c:forEach>
					</ul>
                    <button class="btn-blue">Book</button>
                    <button class="btn-blue" type="button" data-toggle="collapse" data-target="#collapseExample" aria-expanded="false" aria-controls="collapseExample">
                        Propose
                    </button>
                    <div class="collapse" id="collapseExample">
                      <div class = "col-md-10">
                        <form id = "messageForm" method="POST" action = "/submit/proposal" onsubmit = "return validateForm()">
                          <div class="form-group">
                      <label for="messageHead">Message Heading</label>
                     <input type="text" class="form-control" id="messageHead" name = "message_head" value = "${newProposal.message_head}" placeholder="Message Heading">
                  </div>
                            <div class="form-group">
                    <label for="message">Message:</label>
                    <textarea class="form-control" rows="5" id="message" name = "message_body" value = "${newProposal.message_body}"></textarea>
                  </div>
                  <input type = "hidden" id = "property_id" name = "property_id" value = "2">
                  <input type = "hidden" id = "user_id" name = "user_id" value = "2">
				<div class = "form-group">
					<p class = "txt-red" id = "error-types">
				</div>
                  <button class="btn-blue btn-center float-right" id="submitButton" type="submit" >
                                      Send
				</button>
				
               </form>
            </div>
                      </div>

                </div>
            </div>
        </div>
    </div>
</header>



    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    <script>
/*     $('#submitButton').click(function(){
    	var valid = validateForm();
    });
 */
    function validateForm(){
    	var head = $('#messageHead').val();
    	var message = $('#message').val();

    	if(head == "" || message == ""){
    		$( "#error-types" ).html( "Please enter a message" );
    		return false;
        	}
        }
    </script>
  </body>
</html>