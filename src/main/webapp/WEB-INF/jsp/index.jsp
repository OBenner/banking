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

    <!-- Register new account news -->
    <c:if test="${pageContext.request.userPrincipal.name == null}">
        <div class="jumbotron">
            <h1>Navbar example</h1>
            <p>This example is a quick exercise to illustrate how the default, static navbar and fixed to top navbar
                work. It includes the responsive CSS and HTML, so it also adapts to your viewport and device.</p>
            <p>
                <a class="btn btn-lg btn-primary" href="${pageContext.request.contextPath}/register" role="button">Create
                    New Account&raquo;</a>
            </p>
        </div>
    </c:if>

    <c:if test="${pageContext.request.userPrincipal.name != null}">
        <div class="jumbotron">
            <h1>Navbar example</h1>
            <p> News.</p>
            <p>
                <a class="btn btn-lg btn-primary" href="#" role="button">Operation 1</a>
            </p>
            <p>
                <a class="btn btn-lg btn-primary" href="#" role="button">Operation 2</a>
            </p>
        </div>

    </c:if>

    <%@ include file="templates/footer.jsp" %>
</div> <!-- /container -->


</body>
</html>