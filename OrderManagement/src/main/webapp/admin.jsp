<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin</title>
<link rel="stylesheet" href="admin.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script type="text/javascript" src="admin.js"></script>
</head>
<body>
	<nav class="Nav">
        <h1 class="wlcmMsg">Welcome Admin</h1>
        <ul class="adminFun">
            <li><a href="javascript:addCustomer();">Add Customer</a></li>
            <li><a href="javascript:addItem();">Add Item</a></li>
            <li><a href="javascript:addCoupon();">Add Coupon</a></li>
            <li><a href="javascript:viewCustomer();">View Customer</a></li>
            <li><a href="javascript:viewItem();">View Item</a></li>
            <li><a href="javascript:viewCoupon();">View Coupon</a></li>
            <li><a href="javascript:updateCustomer();">Update User</a></li>
            <li><a href="javascript:updateItem();">Update Item</a></li>
            <li><a href="javascript:topSelling();">View Top Selling Items</a></li>
        </ul>
        <button class="butLogout"><a href="adminLogout">Logout</a></button>
    </nav> 
    <div id="Details">
	</div>
</body>
</html>