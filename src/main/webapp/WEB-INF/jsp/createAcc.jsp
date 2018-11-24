


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<%@ page import="enum" %>--%>
<%@ page import="ru.neoflex.banking.model.CurrencyEnum" %>
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




</div> <!-- /container -->

<!-- Main component for a primary marketing message or call to action -->
<div class="container">
    <h3 style="color: red;">Create Currency Account</h3>

    <form:form action="/createAcc" name="registerForm" method="post"
               onsubmit="return validateForm()" modelAttribute="accCode"
               class="form-signin">
        <div class="form-group">
            <p>
                <label>Choose currency code</label>
                <select class="selectpicker" id ="accCode" name ="accCode">
                    <c:forEach items="<%=CurrencyEnum.values()%>" var="accCode">
                        <option value = "${accCode.name()}">${accCode.name()}</option>
                    </c:forEach>
                </select>
            </p>


            <span>${errorMsg}</span> <input type="SUBMIT"
                                            class="btn btn-lg btn-primary btn-block" value="Submit" />
        </div>

    </form:form>

    <%@ include file="templates/footer.jsp" %>
</div>





</body>
</html>

