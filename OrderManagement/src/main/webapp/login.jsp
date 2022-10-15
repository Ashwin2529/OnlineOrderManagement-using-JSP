<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Online Order Management</title>
<link rel="stylesheet" href="admin.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script type="text/javascript" src="customer.js"></script>
</head>
<body>
<nav class="Nav">
	<h1 id="txt">Online Order Management</h1>
	<div class="loginType">
		<button id="but" onclick="adminForm();">Admin</button>
		<button id="but" onclick="custForm();">Customer</button>
	</div>
</nav>
<div id="main" class="main">
	<div class="Login" id="adminForm" style="display: none">
		<h1>Admin Login</h1>
		<form action="adminLogin" method="post">
			<input type="text" name="userId" placeholder="Enter User Id">
			<input type="password" name="userPassword" placeholder="Enter User Password">
			<input type="submit" value="Login">
		</form>
	</div>
	<div class="Login" id="custForm" style="display: none">
		<h1>Customer Login</h1>
		<form action="custLogin" method="post">
			<input type="text" name="custId" id="custId" placeholder="Enter Customer Id">
			<input type="password" name="custPassword" id="custPassword" placeholder="Enter Customer Password">
			<input type="submit" value="Login">
		</form>
	</div>
</div>
</body>
</html>