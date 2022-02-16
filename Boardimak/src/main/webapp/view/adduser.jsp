<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  

<!doctype html>
<html lang="en"> 


<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta http-equiv="Pragma" content="no-cache">
<meta http-equiv="Cache-Control" content="no-cache">
<meta http-equiv="Expires" content="sat, 01 Dec 2001 00:00:00 GMT">
<title>Add User</title>

<link rel="stylesheet" href="assets/css/main.css">
    <link rel="stylesheet" href="assets/css/dashboard.css">
    <link rel="stylesheet" href="assets/css/settings.css">

<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>




</head>
<body>
<div class="p-right-panel">
    <div class="p-wrapper-body">
    <h1 id="para">Add User </h1>
     
	 <div class="pf-wrapper-body">
    <form  class="form" action="add-users" method="post">
   		<div class="row">
    		<div class="col-md-6">
    		<%-- <input type="hidden" name="id" value="${ u.id }" /> --%>
	  			
	  			
	  			<div class="form-group row">
	    			<label class="col-sm-4 col-form-label" for="exampleFormControlInput1">First Name</label>
	    			<input type="text" class="form-control col-sm-8" id="Input1" placeholder="Saman" name="firstname" value="${u.firstname }">
	  			</div>
	  			<div class="form-group row">
	    			<label class="col-sm-4 col-form-label" for="exampleFormControlInput1">Last Name</label>
	    			<input type="text" class="form-control col-sm-8" id="Input2" placeholder="Perera" name="lastname" value="${u.lastname}">
	  			</div>
				<div class="form-group row">
	    			<label class="col-sm-4 col-form-label" for="exampleFormControlInput1">Email</label>
	    			<input type="text" class="form-control col-sm-8" id="Input3" placeholder="hasara123@gmail.com" name="email" value="${u.email }">	
	  			</div>
	  			<div class="form-group row">
	    			<label class="col-sm-4 col-form-label" for="exampleFormControlInput1">Address Line1</label>
	    			<input type="text" class="form-control col-sm-8" id="Input3" placeholder="Aruggoda" name="address1" value="${u.address1 }">
	  			</div>
		
	  			<div class="form-group row">
	    			<label class="col-sm-4 col-form-label" for="exampleFormControlInput1">Address Line2</label>
	    			<input type="text" class="form-control col-sm-8" id="Input3" placeholder="Panadura" name="address2" value="${u.address2 }">
	  			</div>
	  			
	  			<div class="form-group row">
	    			<label class="col-sm-4 col-form-label" for="exampleFormControlInput1">Phone Number</label>
	    			<input type="text" class="form-control col-sm-8" id="Input3" placeholder="0754814756" name="phone_num" value="${u.phone_num }">
	  			</div>
		
	  			
  				<input type="submit" class="btn btn-primary" value="Add User" />
  			
 			</div>
  		</div>
	</form>
	 </div>
    </div>
</div>
</body>
</html>