<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
  
<!doctype html>
<html lang="en">
    <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

    <!-- Font Roboto 400, 500, 700 and 900-->
    <link href="https://fonts.googleapis.com/css?family=Roboto:400,500,700,900&display=swap" rel="stylesheet">

    <!-- Styles -->
    <link rel="stylesheet" href="assets/css/main.css">
    <link rel="stylesheet" href="assets/css/dashboard.css">
    <link rel="stylesheet" href="assets/css/users.css">
	<link rel="stylesheet" href="assets/css/owner-promotion.css">

    <title>All Promotions </title>
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
                                <img src="assets/icons/notification-icon.png" alt="Notification Icon">
                            </div>
                        </div>

                        <div class="wrapper-menu">
                                <ul>
									<c:if test="${user.userType == 'Employee' }">
										<a href="/dashboard"><li><img src="assets/icons/dashboard-icon.png" alt="Dashboard Icon">Dashboard</li></a>
		                                <a href="/admin/property"><li><img src="assets/icons/property-icon.png" alt="Properties Icon">Properties</li></a>
		                                <a href="bookings"><li><img src="assets/icons/booking-icon.png" alt="Bookings Icon">Bookings</li></a>
			                            <a href="/owner/proposal"><li><img src="../assets/icons/proposal.png" alt="Proposal Icon">Proposals</li></a>
			                            <a href="/admin-promotion"><li class="active"><img src="assets/icons/promotions-icon.png" alt="Promotions Icon">Promotions</li></a>
			                            <a href="/payment-details"><li><img src="assets/icons/payment-icon.png" alt="Payment Icon">Payments</li></a>
			                            <a href="cms"><li><img src="assets/icons/content-management-icon.png" alt="Contemtn Management Icon">Content Management</li></a>
			                            <a href="/show-ticket"><li><img src="assets/icons/support-icon.png" alt="Support Icon">Support</li></a>
									</c:if>
									
									<c:if test="${user.userType == 'Admin' }">
										<a href="/dashboard"><li><img src="assets/icons/dashboard-icon.png" alt="Dashboard Icon">Dashboard</li></a>
		                                <a href="/admin/property"><li><img src="assets/icons/property-icon.png" alt="Properties Icon">Properties</li></a>
		                                <a href="bookings"><li><img src="assets/icons/booking-icon.png" alt="Bookings Icon">Bookings</li></a>
		                                <a href="/users"><li><img src="assets/icons/users-icon.png" alt="Users Icon">Users</li></a>
		                                <a href="/owner/proposal"><li><img src="../assets/icons/proposal.png" alt="Proposal Icon">Proposals</li></a>
			                            <a href="/admin-promotion"><li class="active"><img src="assets/icons/promotions-icon.png" alt="Promotions Icon">Promotions</li></a>
			                            <a href="/payment-details"><li><img src="assets/icons/payment-icon.png" alt="Payment Icon">Payments</li></a>
			                            <a href="cms"><li><img src="assets/icons/content-management-icon.png" alt="Contemtn Management Icon">Content Management</li></a>
			                            <a href="/show-ticket"><li><img src="assets/icons/support-icon.png" alt="Support Icon">Support</li></a>
									</c:if>
                                </ul>
                        </div>

                        <div class="wrapper-help">
                            <a href=""><img src="assets/icons/help-icon.png" alt="Help icon">Help</a>
                        </div>
                    </div>
                    <div class="right-panel">
                        <div class="wrapper-body">
                            <h3>All Promotions</h3>
                            <a href="/pdfReportAdminPromotion" class="btn-blue btn-ticket">Print Report</a>
                            <a class="link-log-out" href="/logout">LOG OUT</a>
                       
								<!--  <button class="btn-blue btn-add-pro" data-toggle="modal" data-target=".add-promotion-modal">+Add Promotion</button>-->
							
                            <p>It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout.It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout</p>
                        </div>

                        <div class="dashboard-body">
                                <table class="table table-borderless">
                                <thead>
                                    <tr>
                                        
										<th scope="col">Property ID</th>
										<th scope="col">Amount</th>
										<th scope="col">Percentage</th>
										<th scope="col">New Price</th>
										<th scope="col">Status</th>
										<th scope="col">Start Date</th>
										<th scope="col">End Date</th>
                                        <th scope="col">Actions</th>
                                     
                                    </tr>
                                </thead>
                                <tbody>
								<c:forEach var="p" items="${promotion }">
                                    <tr>
                                        
										<td><p>${p.property_id}</p></td>
										 <td><p>${p.pro_price}</p></td>
										 <td><p>${p.percentage}</p></td>
										<td><p>${p.new_price}</p></td>
										 <td><c:if test="${p.status == 'Active'}">
										   <p class = "txt-green">Active</p>
										   </c:if> <c:if test="${p.status == 'Not Active'}">
										    <p class= "txt-red">Not Active</p>
											</c:if></td>
										    
										<td><p>${p.start_date}</p></td>
										<td><p>${p.end_date}</p></td>
                                 
								
									
                                        <td>
                                            <ul class="list-actions">
        
                                                <a href="/delete-promotion1?id=${p.id}"><li><img src="assets/icons/delete-icon.png" alt="Delete user icon"></li></a>
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


<!-- Modal -->

<!-- <div class="modal fade add-promotion-modal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg" role="document">
      <div class="modal-content">
        <div class="modal-header">
          <h5 class="modal-title" id="exampleModalLabel">Add Promotion</h5>
          <button type="button" class="close" data-dismiss="modal" aria-label="Close">
            <span aria-hidden="true">&times;</span>
          </button>
        </div>
        <div class="modal-body">
               
                
       <form class="modal-form" action="add-promotion" method="post">
                        <div class="row">
                            <div class="col-md-8">
                            <input type="hidden" name="id" value="${p.id }" />
                                <div class="form-group row">
                                    <label class=" col-form-label col-sm-4" for="exampleFormControlInput1">PropertyID</label>
	    							<input type="text" class="col-sm-8 " id="Int1" placeholder="10000" name="property_id" value="${p.property_id }">
                                    </div>
                            </div>
							
						</div>
						
						<div class="row">
                            <div class="col-md-8">
                                <div class="form-group row">
                                     <label class="col-form-label col-sm-4 " for="exampleFormControlInput1">Property price</label>
	    							 <input type="text" class="col-sm-8" id="Input1" placeholder="10000" name="pro_price" value="${p.pro_price }">
                                    </div>
                            </div>
                            
                              <div class="col-md-8">
                                <div class="form-group row">
                                     <label class="col-form-label col-sm-4 " for="exampleFormControlInput1">Percentage(%)</label>
	    								<input type="text" class="col-sm-8" id="Input2" placeholder="10" name="percentage" value="${p.percentage}">
                                    </div>
                            </div>
							
						</div>
						
						   <div class="row">
                            <div class="col-md-8">
                                <div class="form-group row">
                                     <label class="col-form-label col-sm-4 " for="exampleFormControlInput1">New Price</label>
	    							<input type="text" class="col-sm-8" id="Input3" placeholder="9000" name="new_price" value="${p.new_price }">
                                    </div>
                            </div>
							
						</div>
						
						   <div class="row">
                            <div class="col-md-8">
                                <div class="form-group row">
                                     <label class=" col-form-label  col-sm-4" for="exampleFormControlInput1">Status</label>
	    							 <input type="text" class="col-sm-8" id="Input3" placeholder="Active/Not Active" name="status" value="${p.status }">
                                    </div>
                            </div>
							
						</div>
						 
						
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
              

                    <button type="submit" class="btn-blue modal-btn">Add Promotion</button>
                 </form>
        </div>
      </div>
    </div>
  </div>-->
  
    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    </body>
</html>