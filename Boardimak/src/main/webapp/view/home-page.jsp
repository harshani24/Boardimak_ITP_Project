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

    <!-- Font Roboto 400, 500, 700 and 900-->
    <link href="https://fonts.googleapis.com/css?family=Roboto:400,500,700,900&display=swap" rel="stylesheet">

    <!-- Styles -->
    <link rel="stylesheet" href="assets/css/main.css">
    <link rel="stylesheet" href="assets/css/dashboard.css">
    <link rel="stylesheet" href="assets/css/owner-property.css">
    <link rel="stylesheet" href="assets/css/toggle-switch.css">
    <link rel="stylesheet" href="assets/css/edit.css">
  
    <title>Scroll</title>

<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

</head>
<body>
 

<div class="infinite">

   <div class="card">
       <img class="card-img-top" src="assets/images/propertyImg1.png" alt="Propertie image">
          <div class="card-body">
               <h6>ID: <span class="card-tags">105246</span></h6>
               <h6>Price: <span class="card-tags">5000.00/price</span></h6>
               <h6>Status: <span class="card-tags">Active</span></h6> 
           </div>
    </div>
    <div class="card">
       <img class="card-img-top" src="assets/images/propertyImg1.png" alt="Propertie image">
          <div class="card-body">
               <h6>ID: <span class="card-tags">105246</span></h6>
               <h6>Price: <span class="card-tags">5000.00/price</span></h6>
               <h6>Status: <span class="card-tags">Active</span></h6> 
           </div>
    </div>
    <div class="card">
       <img class="card-img-top" src="assets/images/propertyImg1.png" alt="Propertie image">
          <div class="card-body">
               <h6>ID: <span class="card-tags">105246</span></h6>
               <h6>Price: <span class="card-tags">5000.00/price</span></h6>
               <h6>Status: <span class="card-tags">Active</span></h6> 
           </div>
    </div>
    <div class="card">
       <img class="card-img-top" src="assets/images/propertyImg1.png" alt="Propertie image">
          <div class="card-body">
               <h6>ID: <span class="card-tags">105246</span></h6>
               <h6>Price: <span class="card-tags">5000.00/price</span></h6>
               <h6>Status: <span class="card-tags">Active</span></h6> 
           </div>
    </div>
    <div class="card">
       <img class="card-img-top" src="assets/images/propertyImg1.png" alt="Propertie image">
          <div class="card-body">
               <h6>ID: <span class="card-tags">105246</span></h6>
               <h6>Price: <span class="card-tags">5000.00/price</span></h6>
               <h6>Status: <span class="card-tags">Active</span></h6> 
           </div>
    </div>
    <div class="card">
       <img class="card-img-top" src="assets/images/propertyImg1.png" alt="Propertie image">
          <div class="card-body">
               <h6>ID: <span class="card-tags">105246</span></h6>
               <h6>Price: <span class="card-tags">5000.00/price</span></h6>
               <h6>Status: <span class="card-tags">Active</span></h6> 
           </div>
    </div>
    <div class="card">
       <img class="card-img-top" src="assets/images/propertyImg1.png" alt="Propertie image">
          <div class="card-body">
               <h6>ID: <span class="card-tags">105246</span></h6>
               <h6>Price: <span class="card-tags">5000.00/price</span></h6>
               <h6>Status: <span class="card-tags">Active</span></h6> 
           </div>
    </div>
    <div class="card">
       <img class="card-img-top" src="assets/images/propertyImg1.png" alt="Propertie image">
          <div class="card-body">
               <h6>ID: <span class="card-tags">105246</span></h6>
               <h6>Price: <span class="card-tags">5000.00/price</span></h6>
               <h6>Status: <span class="card-tags">Active</span></h6> 
           </div>
    </div>
    
</div>



 <script type="text/javascript">
 $(window).scroll(function () { 
    if ($(window).scrollTop() >= $(document).height() - $(window).height() - 100) {
       //Add something at the end of the page
       $('.infinite').append('<div class="card"><img class="card-img-top" src="assets/images/propertyImg1.png" alt="Propertie image"><div class="card-body"><h6>ID: <span class="card-tags">105246</span></h6><h6>Price: <span class="card-tags">5000.00/price</span></h6><h6>Status: <span class="card-tags">Active</span></h6></div></div>');
    }
 });
</script> 


</body>
</html>