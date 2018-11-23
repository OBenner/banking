<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
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
<title>Title</title>

<div class="container">


        <%@ include file="templates/menubar.jsp" %>


<table class="table table-striped table-hover">
    <thead>
    <tr class="bg-success">
        <th>сode</th>
        <th>nominal</th>
        <th>name</th>
        <th>value</th>
    </tr>
    </thead>
    <c:forEach items="${currencyList}" var="currency">
        <tr>
            <td>${currency.сode}</td>
            <td>${currency.nominal}</td>
            <td>${currency.name}</td>
            <td>${currency.value} RUB</td>
        </tr>
    </c:forEach>


</table>

    <%@ include file="templates/footer.jsp" %>
</div>
</body>
</html>
