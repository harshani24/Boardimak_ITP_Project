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
    <link rel="stylesheet" href="assets/css/settings.css">

    <title>Dashboard</title>
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
                        <h5>John Peter</h5>
                        <p>Parent</p>
                    </div>
                    <div class="profile-notification">
                        <img src="assets/icons/notification-icon.png" alt="Notification Icon">
                    </div>
                </div>

                <div class="wrapper-menu">
                    <ul>
                        <a href="dashboard.html"><li class="active"><img src="assets/icons/dashboard-icon.png" alt="Dashboard Icon">Dashboard</li></a>
                        <a href=""><li><img src="assets/icons/property-icon.png" alt="Properties Icon">Properties</li></a>
                        <a href=""><li><img src="assets/icons/booking-icon.png" alt="Bookings Icon">Bookings</li></a>
                        <a href="users.html"><li><img src="assets/icons/users-icon.png" alt="Users Icon">Users</li></a>
                        <a href="all-promotions.html"><li><img src="assets/icons/promotions-icon.png" alt="Promotions Icon">Promotions</li></a>
                        <a href="payment-details.html"><li><img src="assets/icons/payment-icon.png" alt="Payment Icon">Payments</li></a>
                        <a href=""><li><img src="assets/icons/content-management-icon.png" alt="Contemtn Management Icon">Content Management</li></a>
                        <a href=""><li><img src="assets/icons/support-icon.png" alt="Support Icon">Support</li></a>
                    </ul>
                </div>

                <div class="wrapper-help">
                    <a href=""><img src="assets/icons/help-icon.png" alt="Help icon">Help</a>
                </div>
            </div>
            <div class="right-panel">
                <div class="wrapper-body">
                    <h3>Settings</h3>
                    <p>It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout.</p>
                </div>

                <div class="dashboard-body">
                    <form method="POST" action="/user/update">
                        <div class="row">
                            <div class="col-md-6">
                                <input type="text" placeholder="FIRST NAME" name="firstName" value="${user.firstName}">
                            </div>
                            <div class="col-md-6">
                                <input type="text" placeholder="LAST NAME" name="lastName" value="${user.lastName}">
                            </div>
                            <div class="col-md-6">
                                <input type="text" placeholder="EMAIL" name="email" value="${user.email}">
                            </div>
                            <div class="col-md-6">
                                <input type="text" placeholder="ADDRESS LINE 1" name="addressLine1" value="${user.addressLine1}">
                            </div>
                            <div class="col-md-6">
                                <input type="text" placeholder="ADDRESS LINE 2" name="addressLine2" value="${user.addressLine2}">
                            </div>
                            <div class="col-md-6">
                                <input type="text" placeholder="PHONE NUMBER" name="phoneNumber" value="${user.phoneNumber}">
                            </div>
                            <div class="col-md-12">
                                <button class="btn-blue">EDIT USER</button>
                            </div>
                        </div>
                    </form>
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