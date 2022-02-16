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
<title>Add Promotion</title>

	<link rel="stylesheet" href="assets/css/main.css">
    <link rel="stylesheet" href="assets/css/dashboard.css">
    <link rel="stylesheet" href="assets/css/owner-promotion.css">

<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>


</head>
    <body>
        <div class="section">
            <div class="container-fluid">
                <div class="row">
                    <div class="left-panel">
                        <div class="wrapper-profile">
                            <div class="profile-picture">
                                <img src="/assets/icons/profile-pic.png" alt="Profile picture">
                            </div>
                            <div class="profile-text">
                                <h5>John Snow</h5>
                                <p>Property Owner</p>
                            </div>
                            <div class="profile-notification">
                                <img src="/assets/icons/notification-icon.png" alt="Notification Icon">
                            </div>
                        </div>

                        <div class="wrapper-menu">
                               <ul>
                                    <a href="dashboard.html"><li ><img src="assets/icons/dashboard-icon.png" alt="Dashboard Icon">Dashboard</li></a>
                                    <a href=""><li><img src="assets/icons/property-icon.png" alt="Properties Icon">Properties</li></a>
                                    <a href=""><li><img src="assets/icons/booking-icon.png" alt="Bookings Icon">Bookings</li></a>
                                    <a href="users.html"><li><img src="assets/icons/users-icon.png" alt="Users Icon">Users</li></a>
                                    <a href="/show-promotion"><li class="active"><img src="assets/icons/promotions-icon.png" alt="Promotions Icon">Promotions</li></a>
                                    <a href="payment-details.html"><li><img src="assets/icons/payment-icon.png" alt="Payment Icon">Payments</li></a>
                                    <a href=""><li><img src="assets/icons/content-management-icon.png" alt="Contemtn Management Icon">Content Management</li></a>
                                    <a href=""><li><img src="assets/icons/support-icon.png" alt="Support Icon">Support</li></a>
                               </ul>
                        </div>

                        <div class="wrapper-help">
                            <a href=""><img src="/assets/icons/help-icon.png" alt="Help icon">Help</a>
                        </div>
                    </div>
                    <div class="right-panel">
                        <div class="wrapper-body">
                            <h3>All Promotions</h3>
                            <p>It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout.It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout</p>
                        </div>
                        <div class="dashboard-body">
                        <form class="modal-form" action="/add-promotion" method="post" name="form">
                          <input type="hidden" name="id" value="${p.id }" />
                        
                        	<div class="row">
                        	 <div class="col-md-8">
                                   <div class="form-group row">
                                    <label class=" col-form-label col-sm-4" for="exampleFormControlInput1">OwnerID</label>
	    							<input type="text" class="col-sm-8 " style="color:red;" id="Int1" placeholder="10000" name="user" value="${p.user }" readonly>
                                    </div>
                            </div>
                            
                           </div>
                           
                        
                        <div class="row">
                            <div class="col-md-8">
                              
                            
                                <div class="form-group row">
                                    <label class=" col-form-label col-sm-4" for="exampleFormControlInput1">PropertyID</label>
	    							<input type="text" class="col-sm-8 " style="color:red;" id="Int1" placeholder="10000" name="property_id" value="${p.property_id }" readonly>
                                    </div>
                            </div>
							
						</div>
						
						<div class="row">
                            <div class="col-md-8">
                                <div class="form-group row">
                                     <label class="col-form-label col-sm-4 " for="exampleFormControlInput1">Property price</label>
	    							 <input type="text" class="col-sm-8" style="color:blue;" id="Input1" placeholder="10000" name="pro_price" value="${p.pro_price }" readonly>
                                    </div>
                            </div>
                            
                              <div class="col-md-8">
                                <div class="form-group row">
                                     <label class="col-form-label col-sm-4 " for="exampleFormControlInput1">Percentage(%)</label>
	    								<input type="number" class="col-sm-8" style="color:black;"id="Input2" placeholder="10" name="percentage" value="${p.percentage}">
                                    </div>
                            </div>
							
						</div>
						
						 <!--    <div class="row">
                            <div class="col-md-8">
                                <div class="form-group row">
                                     <label class="col-form-label col-sm-4 " for="exampleFormControlInput1">New Price</label>
	    							<input type="text" class="col-sm-8" id="Input3" placeholder="9000" name="new_price" value="${p.new_price }">
                                    </div>
                            </div>
							
						</div> -->
						
						 <!--  <div class="row">
                            <div class="col-md-8">
                                <div class="form-group row">
                                     <label class=" col-form-label  col-sm-4" for="exampleFormControlInput1">Status</label>
	    							 <input type="text" class="col-sm-8" id="Input3" placeholder="Active/Not Active" name="status" value="${p.status }">
                                    </div>
                            </div>
							
						</div>  -->
						 
						
                       <div class="row">
                            <div class="col-md-6">
                                <div class="form-group row">
                                    <label class=" col-form-label col-sm-4" for="exampleFormControlInput1">Start Date</label>
	    							<input type="datetime-local" class="col-sm-8" id="Input3" placeholder="start date" name="start_date" value="${p.start_date }">
                                </div>   
                            </div>
                            <div class="col-md-6">
                                <div class="form-group row">
                                    <label class="col-form-label col-sm-4 " for="exampleFormControlInpu">End Date</label>
	    			               <input type="datetime-local" class="col-sm-8" id="Input3" placeholder="end date" name="end_date" value="${p.end_date }">
                                </div>
                            </div>
							
						
                       </div>
              
						
			<input type="submit" onclick="return validation()"
											class="btn-blue modal-btn" value="Edit Promotion" />
									
                   <!-- <button type="submit" class="btn-blue modal-btn"  onclick="return validation()">Edit Promotion</button> --> 
                 </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>

    <!-- Optional JavaScript -->
    
    	

	<script type="text/javascript">
		function validation() {
			var Discount = document.form.percentage.value;
		

			if (Discount == null || Discount == "") {
				alert("Discount can't be empty");
				return false;
			} else if (Discount == 0 ) {
				alert("You didn't offer any promotion");
				return false;
			} else if (Discount < 0) {
				alert("Please enter valid discount");
				return false;
			}else{
				alert("Successfully updated your promotion");
				return true;
			}
		}
	</script>
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="/assets/js/propertyValidate.js"></script> 
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
   
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
