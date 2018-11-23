


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
	<meta name="description" content="">
	<meta name="author" content="">
	<link rel="icon" href="../../favicon.ico">

	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>

<body>


<div class="container">
	<%@ include file="../jsp/menubar.jsp" %>




	</div> <!-- /container -->

	<!-- Main component for a primary marketing message or call to action -->
	<div class="container">
		<h3 style="color: red;">Register New User</h3>

			<form:form action="/register" name="registerForm" method="post"
					   onsubmit="return validateForm()" modelAttribute="user"
					   class="form-signin">
				<div class="form-group">
					<p>
						<label>Enter Username</label>
						<form:input path="username" placeholder="Username"
									class="form-control" />
					</p>
					<p>
						<label>Enter Password</label>
						<form:input path="password" placeholder="Password" class="form-control" />
					</p>


					<span>${errorMsg}</span> <input type="SUBMIT"
													class="btn btn-lg btn-primary btn-block" value="Submit" />
				</div>

			</form:form>
	</div>





</body>
</html>

