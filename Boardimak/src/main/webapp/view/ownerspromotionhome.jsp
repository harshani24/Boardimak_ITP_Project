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
	
	 <link rel="stylesheet" href="../assets/css/main.css">
    <link rel="stylesheet" href="../assets/css/dashboard.css">
    <link rel="stylesheet" href="../assets/css/owner-property.css">
    <link rel="stylesheet" href="../assets/css/toggle-switch.css">

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
                                    <a href="/dashboard"><li ><img src="assets/icons/dashboard-icon.png" alt="Dashboard Icon">Dashboard</li></a>
                                    <a href="/owner/property"><li><img src="assets/icons/property-icon.png" alt="Properties Icon">Properties</li></a>
                                    <a href=""><li><img src="assets/icons/booking-icon.png" alt="Bookings Icon">Bookings</li></a>
                                    <a href="/owner/proposal"><li><img src="../assets/icons/proposal.png" alt="Proposal Icon">Proposals</li></a>
                                    <a href="/show-promotion"><li class="active"><img src="assets/icons/promotions-icon.png" alt="Promotions Icon">Promotions</li></a>
                                    <a href="/payment-details"><li><img src="assets/icons/payment-icon.png" alt="Payment Icon">Payments</li></a>
                                    <a href="/ticket"><li><img src="assets/icons/support-icon.png" alt="Support Icon">Support</li></a>
                                </ul>
                        </div>

                        <div class="wrapper-help">
                            <a href=""><img src="assets/icons/help-icon.png" alt="Help icon">Help</a>
                        </div>
                    </div>
                    <div class="right-panel">
                        <div class="wrapper-body">
                            <h3>All Promotions</h3>
                            
                            	
								
								<a href="/pdfReportOwnerPromotion" class="btn-blue btn-ticket">Print Report</a>
								<a class="link-log-out" href="/logout">LOG OUT</a>
							
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
                                        <!--<th scope="col">Actions</th>  -->
                                     
                                    </tr>
                                </thead>
                                <tbody>
								<c:forEach var="p" items="${promotion }">
								   
								
                                    <tr>
                                        
										<td><p>${p.property_id}</p></td>
										 <td><p>${p.pro_price}</p></td>
										 <td><p>${p.percentage}</p></td>
										<td><p>${p.getNew_price()}</p></td>
										 <td><c:if test="${p.status == 'Active'}">
										   <p class = "txt-green">Active</p>
										   </c:if> <c:if test="${p.status == 'Not Active'}">
										    <p class= "txt-red">Not Active</p>
											</c:if></td>
										    
										<td><p>${p.start_date}</p></td>
										<td><p>${p.end_date}</p></td>
                                 
								
									
                                      <!--   <td>
                                            <ul class="list-actions">
                                                <li>
                                                	<a href="/edit-promotion?id=${p.id}">
                                                		<img src="assets/icons/home-060-edit-512.png" width="20px" height="20px" alt="Edit user icon ">
                                                	</a>
                                                </li>
                                                
                                                <li>
                                                    <c:if test = "${p.status == 'Active'}">
                                        				<a style="margin-left:5px;" href="/DeactivatePromotion?id=${p.id}">
                                                			 <img src="/assets/icons/deactivate.png" width="26px" height="26px" alt="Edit Promotion icon">
                                            			</a>
                                        			</c:if>
                                        			<c:if test = "${p.status == 'Not Active'}">
                                        				<a style="margin-left:5px;" href="/ActivatePromotion?id=${p.id}">
                                                			 <img src="/assets/icons/activate.png" width="26px" height="26px" alt="Edit Promotion icon">
                                            			</a>
                                        			</c:if>
                                                </li>
                                                
												<li>
                                                	<a href="/delete-promotion?id=${p.id}">
                                                		<img src="assets/icons/delete-icon.png" alt="Delete user icon">
                                                	</a>
                                                </li>
                                            </ul>
                                        </td>--> 
                                    </tr>
                                     
                                    </c:forEach>
                                </tbody>
								
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </div>



  
    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    </body>
</html>