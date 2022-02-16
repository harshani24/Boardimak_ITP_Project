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
                            <h3>My Promotions</h3>
                            
                                   <input type="hidden" name="user" value="${user.id }" />
                            
                            	<button class="btn-blue btn-add-pro" data-toggle="modal" data-target=".add-promotion-modal" >+Add Promotion</button>
								</button>
								
								<a href="/oneOwnerPromotion?user=${user.id}" class="btn-blue btn-ticket">Print Report</a>
								<a href="/allOwnerPromotion" class="btn-blue btn-ticket">All Promotions</a>
								
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
                                        <th scope="col">Actions</th>
                                     
                                    </tr>
                                </thead>
                                <tbody>
								<c:forEach var="p" items="${promotion }">
								   <c:if test = "${p.user == user.id }">
								     
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
                                 
								
									
                                        <td>
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
                                        </td>
                                    </tr>
                                      </c:if>
                                    </c:forEach>
                                </tbody>
								
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </div>


<!-- Modal -->

  <div class="modal fade add-promotion-modal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg" role="document">
      <div class="modal-content">
        <div class="modal-header">
          <h5 class="modal-title" id="exampleModalLabel">Add Promotion</h5>
          <button type="button" class="close" data-dismiss="modal" aria-label="Close">
            <span aria-hidden="true">&times;</span>
          </button>
        </div>
        <div class="modal-body">
        
         <div class="dashboard-body">
               
            <c:forEach var="property" items="${properties}">
            			<c:if test = "${property.ownerId == user.id }">
                          	 <c:if test = "${property.status == 'Active'}">

                          	 
                          	 <a href="/open-property?id=${property.id }" >
                          	 	
                          	 
                            	<div class="card">
                                	<img class="card-img-top" src="/displayImage/${property.id}" alt="Property image">
                                	<div class="card-body">
                                		<div class = "row">
                                			<div class = "col-sm-8">
                                			 <h6>ID:<a href="/open-property?id=${property.id }" class="card-tags">${property.id}</a></h6>
			                                	  <!--<h6>ID: <span class="card-tags">${property.id}</span></h6>  -->
                                	    	</div>
                                        	
                                        </div>
                                        <div class = "row">
                                			<div class = "col-sm-12">
                                	    		<h6>Price:<a href="/open-property?id=${property.id }" class="card-tags">${property.monthlyPayment}</a></h6> 
                                	    			<!--<span class="card-tags">${property.monthlyPayment}/month</span> -->
                                	    		</h6>
                                        	</div>
                                        </div>
                                        
                                         <c:forEach var="p" items="${promotion }">
												 <c:if test="${property.id == p.property_id}">
												     <c:if test="${p.status == 'Active'}">
												
													  	 <div class = "row">
	                                					<div class = "col-sm-12">
	                                	    				   </pre><a href="/show-promotion" class="card-tags1">Rs.${p.new_price}/month</a></h6>
	                                	    					<!--<span class="card-tags1">Rs.${p.new_price}/month</span> -->
	                                	    				
	                                        			</div>
	                                        		</div>
										          </c:if> 
										          
										              <c:if test="${p.status == 'Not Active'}">
												
													  	 <div class = "row">
	                                					<div class = "col-sm-12">
	                                	    				   </pre><a href="/show-promotion" class="card-tags1">Promotion is deactivated</a>
	                                	    					<!--<span class="card-tags1">Rs.${p.new_price}/month</span> -->
	                                	    				
	                                        			</div>
	                                        		</div>
										          </c:if> 
									        	</c:if>  
									        	
									        	
								          </c:forEach>
                                        
                                        
                                        <div class = "row">
                                			<div class = "col-sm-12">
                                	    		<h6>Status: 
                                	    			<c:if test = "${property.status == 'Active'}">
                                	    			     <a href="/open-property?id=${property.id }" class="card-tags txt-green">${property.status}</a></h6>
                                        				<!--<span class="card-tags txt-green">
                                	    					${property.status}
                                	    				</span>  -->
                                        			</c:if>
                                        			<c:if test = "${property.status == 'Offline'}">
                                        			    <a href="/open-property?id=${property.id }" class="card-tags txt-green" style="color:red;">${property.status}</a></h6>
                                        				<!--<span class="card-tags txt-green" style="color:red;">
                                	    					${property.status}
                                	    				</span>  -->
                                        			</c:if>
                                	    			
                                	    			
                                            	</h6> 
                                        	</div>
                                        </div>
                                	</div>
                            	</div>
                            	</a>
                              </c:if>
                          </c:if>
                     </c:forEach>
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