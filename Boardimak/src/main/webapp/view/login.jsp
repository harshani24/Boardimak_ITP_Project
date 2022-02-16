<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">
    <head>
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

        <!-- Custom styles -->
        <link rel="stylesheet" href="assets/css/main.css">
        <link rel="stylesheet" href="assets/css/signin.css">
        <link rel="stylesheet" href="assets/css/forgot-password.css">

        <title>Boardimak | Beta</title>
    </head>
    <body>
        <div class="section">
            <div class="container">
                <div class="row">
                    <div class="col-md-12">
                        <div class="wrapper-back-home">
                            <img src="assets/icons/left-arrow.png" alt="Left arrow">
                            <p>Back to <a href="/">HOME</a></p>
                        </div>
                    </div>
                </div>
                
                <div class="row row-body">
                    <div class="col-md-6 custom-col-left">
                    	<c:choose>
                    		<%-- Register view --%>
                    		<c:when test="${mode == 'VIEW_REGISTER'}">
                				<div class="form-title">
		                            <h3>SIGN IN</h3>
		                            <p>ENTER YOUR EMAIL AND PASSWORD TO SIGN IN</p>
		                        </div>
		                        
		                        <div class="form-wrapper">
		                        	<p style="color: red" id="errorReg"></p>
		                            <form action="registerAccount" method="POST">
			                            <div class="row row-register-form">
				                            <div class="col-md-6">
			                            		<input type="text" name="firstName" placeholder="FIRST NAME" id="regFirstName" required>
			                            	</div>
			                            	<div class="col-md-6">
			                            		<input type="text" name="lastName" placeholder="LAST NAME" id="regLastName" required>
			                            	</div>
			                            	<div class="col-md-6">
			                            		<select name="userType" id="regAccountType">
			                            			<option value="null">SELECT ACCOUNT TYPE</option>
			                            			<option value="Owner">PROPERTY OWNER</option>
			                            			<option value="Parent">PARENT</option>
			                            			<option value="Student">STUDENT</option>
			                            		</select>
			                            	</div>
			                            	<div class="col-md-6">
			                            		<input type="number" name="mobileNumber" placeholder="MOBILE NUMBER">
			                            	</div>
			                            	<div class="col-md-12">
			                            		<input type="email" name="email" placeholder="EMAIL" id="regEmail" required>
			                            	</div>
			                            	<div class="col-md-12">
			                            		<input type="password" name="password" placeholder="PASSWORD" id="regPassword" required>
			                            	</div>
			                            	<div class="col-md-12">
			                            		<input type="password" placeholder="CONFIRM PASSWORD" id="confirmPassword" required>
			                            	</div>
			                            	<div class="col-md-12">
			                            		<button type="submit" class="btn-blue" onclick="return validateRegister()">SIGN UP</button>
			                            	</div>
			                            </div>
		                            </form>
		                        </div>
		                        <div class="wrapper-links wrapper-links-forgot-password">
                            		<p>ALREADY HAVE AN ACCOUNT? <a href="login">LOGIN</a></p>
                        		</div>
                			</c:when>
                    	
                    		<%-- Login view --%>
                			<c:when test="${mode == 'VIEW_LOGIN'}">
		                		<div class="form-title">
		                            <h3>SIGN IN</h3>
		                            <p>ENTER YOUR EMAIL AND PASSWORD TO SIGN IN</p>
		                        </div>
		                        
		                        <div class="form-wrapper">
		                        	<p style="color: red" id="errorLogin"></p>
		                        	<div class="wrapper-spring-sec-validation">
		                        		<%-- ${SPRING_SECURITY_LAST_EXCEPTION.message} --%>
		                        	</div>
		                            <form action="login" method="POST">
		                                <input type="email" id="loginEmail" placeholder="EMAIL" name="username" required>
		                                <input type="password" id="loginPassword" placeholder="PASSWORD" name="password" required>
		                                <button class="btn-blue" id="btn-login" type="submit" onclick="return validateLogin()">SIGN IN</button>
		                            </form>
		                        </div>
		                        <div class="wrapper-links">
		                            <a href="reset-password">FORGOT PASSWORD?</a>
		                            <a href="register">CREATE AN ACCOUNT</a>
		                        </div>
                			</c:when>
                		
                			<%-- Reset password view --%>
                			<c:when test="${mode == 'VIEW_RESET_PASSWORD'}">
                			<div class="form-title">
	                            <h3>RESET PASSWORD</h3>
	                            <p>ENTER YOUR EMAIL ADDRESS ASSOCIATED <br> WITH YOUR ACCOUNT</p>
                        	</div>
                        	
                        	<div class="form-wrapper">
                            	<form action="">
                                	<input type="email" placeholder="EMAIL" required>
                                	<button class="btn-blue">SEND RESET LINK</button>
                            	</form>
                        	</div>
                        	
                        	<div class="wrapper-links wrapper-links-forgot-password">
                            	<p>REMEMBER PASSWORD? <a href="login">LOGIN</a></p>
                        	</div>
                		</c:when>
                
                		</c:choose>
                    
                    </div>
                    <div class="col-md-6 cus-col-right">
                        <div class="wrapper-illustration">
                            <img src="assets/images/signin-illustration.png" alt="Sign in illustration">
                        </div>
                    </div>
                    <div class="wrapper-help">
                        <a href=""><img src="assets/icons/help-icon.png" alt="Help icon">Help</a>
                    </div>
                </div>
            </div>
        </div>

        <!-- Optional JavaScript -->
        <!-- jQuery first, then Popper.js, then Bootstrap JS -->
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
        
        <script type="text/javascript" src="assets/js/validator.js"></script>
    </body>
</html>