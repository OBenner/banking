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

    <row>
        <div class="col-md-9">
             <form class="form-horizontal" action="/transfer" method="POST" id="transferForm">

                        <div class="form-group">
                            <label for="accountFrom" class="col-md-4 control-label input-sm">Списать со счета:</label>
                            <div class="col-md-5">
                                <select class="form-control input-sm" name="accountFrom" id="accountFrom">
                                    <option  value="-1" selected="selected">Счет списания</option>
                                    <c:forEach items="${accounts}" var="accounts">
                                        <option value="${accounts.accountNumber}">${accounts.accountNumber} / ${accounts.amount} ${accounts.accCode}</option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="accountTo" class="col-md-4 control-label input-sm">Счет зачисления:</label>
                            <div class="col-md-5">
                                <select class="form-control input-sm" name="accountTo" id="accountTo">
                                    <option value="-1" selected="selected">Счет зачисления</option>
                                    <c:forEach items="${accounts}" var="accounts">
                                        <option  value="${accounts.accountNumber}">${accounts.accountNumber} / ${accounts.amount} ${accounts.accCode}</option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="inputAccTo" class="col-md-4 control-label input-sm">Сумма:</label>
                             <div class="col-md-5 input-sm">
                                <input type="text" class="form-control input-sm" name="changeAmount" id="changeAmount"/>
                             </div>
                        </div>

                        <div class="form-group">
                            <div class="col-md-9">
                                <button type="submit" class="btn btn-default pull-right">Перевести</button>
                            </div>
                        </div>
             </form>
        </div>
    </row>

    <div class="navbar-fixed-bottom row-fluid">
        <%@ include file="templates/footer.jsp" %>
    </div>

</div>

</body>

</html>