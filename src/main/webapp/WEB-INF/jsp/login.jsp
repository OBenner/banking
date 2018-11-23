
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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


	<div class="col">
		<c:if test="${not empty msg}">
			<div class="msg">${msg}</div>
		</c:if>


		<form name="loginForm" action="/login" method="post">

			<c:if test="${not empty error}">
				<div class="error" style="color: #ff0000;">${error}</div>
			</c:if>

			<div class="form-group">
				<label for="username">User: </label>
				<input type="text" id="username" name="username" class="form-control" />
			</div>
			<div class="form-group">
				<label for="password">Passwrod:</label>
				<input type="password" id="password" name="password" class="form-control" />
			</div>
			<input type="submit" value="Submit" class="btn btn-default">
			<%--<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />--%>
		</form>
	</div> <!-- /container -->
</div>

</body>
</html>