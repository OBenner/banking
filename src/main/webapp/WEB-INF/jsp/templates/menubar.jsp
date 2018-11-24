<!-- Static navbar -->
<nav class="navbar navbar-default">
    <div class="container-fluid">

        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar"
                    aria-expanded="false" aria-controls="navbar">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="${pageContext.request.contextPath}/">Neoflex Banking</a>
        </div>


        <div id="navbar" class="navbar-collapse collapse">
            <ul class="nav navbar-nav">
                <li class="active"><a href="#">Home</a></li>
                <li><a href="#">About</a></li>
                <li><a href="#">Contact</a></li>
                <li><a href="/currency">Currency List</a></li>

                <c:if test="${pageContext.request.userPrincipal.name != null}">
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button"
                           aria-haspopup="true" aria-expanded="false">Account<span class="caret"></span></a>
                        <ul class="dropdown-menu">
                            <li><a href="/info">Information</a></li>
                            <li><a href="/createAcc">Create account</a></li>
                            <li><a href="#">Something else here</a></li>
                            <li role="separator" class="divider"></li>
                            <li class="dropdown-header">Nav header</li>
                            <li><a href="#">Separated link</a></li>
                            <li><a href="#">One more separated link</a></li>
                        </ul>
                    </li>
                </c:if>
            </ul>


            <ul class="nav navbar-nav navbar-right">
                <c:if test="${pageContext.request.userPrincipal.name != null}">
                    <li><a>Welcome: ${pageContext.request.userPrincipal.name}</a></li>
                    <li><a href="/logout">Logout</a></li>
                </c:if>

                <c:if test="${pageContext.request.userPrincipal.name == null}">
                    <li><a href="/login">Login</a></li>
                    <li><a href="/register">Register</a></li>
                </c:if>
            </ul>
        </div><!--/.nav-collapse -->
    </div><!--/.container-fluid -->
</nav>