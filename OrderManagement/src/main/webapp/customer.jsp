<%@ taglib uri="/struts-tags" prefix="s" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Customer</title>
<link rel="stylesheet" href="admin.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script type="text/javascript" src="customer.js"></script>
</head>
<body>
	<nav class="Nav">
        <h1 class="wlcmMsg" id="customerId"></h1>
        <ul class="adminFun">
            <li><a href="javascript:viewitems();">View Items</a></li>
            <li><a href="javascript:placeOrder();">Place order</a></li>
            <li><a href="javascript:viewOrderHistory();">View Order History</a></li>
        </ul>
            <button class="butLogout"><a href="custLogout">Logout</a></button>
        
    </nav>
    <input type="hidden" id="hiddenUsrId" value="<%= request.getParameter("custId") %>">
	<div id="customer_workplace">
	</div>
</body>
</html>