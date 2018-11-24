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
    <%@ include file="templates/menubar.jsp" %>

</div>


<div class="container">
    <!-- Main component for a primary marketing message or call to action -->
    <div class="page-header">
        <h1>User information</h1>
    </div>
    <table class="table table-hover">
        <tr>
            <th>username</th>
            <th>phone</th>
            <th>email</th>

        </tr>
        <tr>
            <td>${user.username}</td>
            <td>${user.phone}</td>
            <td>${user.email}</td>
        </tr>
    </table>


    <div class="page-information">
        <h1>User accounts currency</h1>
    </div>
    <table class="table table-hover">
        <c:forEach items="${accounts}" var="accounts">
            <tr>
                <th>Account Number</th>
                <th>Currency Code</th>
                <th>Amount</th>

            </tr>
            <tr>
                <td><c:out value="${accounts.accountNumber}"/></td>
                <td><c:out value="${accounts.accCode}"/></td>
                <td><c:out value="${accounts.amount}"/></td>
            </tr>
        </c:forEach>
    </table>








    <%--<table class="table table-striped table-hover">--%>
        <%--<thead>--%>
        <%--<tr class="bg-success">--%>
            <%--<th>сode</th>--%>
            <%--<th>nominal</th>--%>
            <%--<th>name</th>--%>
            <%--<th>amount</th>--%>
        <%--</tr>--%>
        <%--</thead>--%>
        <%--<c:forEach items="${currencyList}" var="currency">--%>
            <%--<tr>--%>
                <%--<td>${currency.сode}</td>--%>
                <%--<td>${currency.nominal}</td>--%>
                <%--<td>${currency.name}</td>--%>
                <%--<td>${currency.value} RUB</td>--%>
            <%--</tr>--%>
        <%--</c:forEach>--%>
    <%--</table>--%>

    <%@ include file="templates/footer.jsp" %>
</div>

</body>
</html>