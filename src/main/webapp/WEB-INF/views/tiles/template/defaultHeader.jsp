
<nav class="navbar navbar-inverse custom-header">
    <div class="container-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar-collapse">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button><a class="navbar-brand navbar-link" href="${pageContext.request.contextPath}/">Company<span>logo </span> </a></div>
        
        <div class="collapse navbar-collapse" id="navbar-collapse">
            <ul class="nav navbar-nav links">
                <li role="presentation"><a href="${pageContext.request.contextPath}/">Home </a></li>
                <li role="presentation"><a href="${pageContext.request.contextPath}/products">Products</a></li>
                <li role="presentation"><a href="${pageContext.request.contextPath}/contactus">Contact Us</a></li>
                <li role="presentation"><a href="${pageContext.request.contextPath}/admin/welcome">For Admin</a></li>
                <li role="presentation"><a href="${pageContext.request.contextPath}/user/welcome">For User</a></li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" aria-expanded="false" href="#"> <span class="caret"></span><img src="assets/img/avatar.jpg" class="dropdown-image"></a>
                    <ul class="dropdown-menu dropdown-menu-right" role="menu">
                        <li><a href="#">Settings </a></li>
                        <li><a href="#">Payments </a></li>
                        <li><a href="#">Logout </a></li>
                    </ul>
                </li>
            </ul>
        </div>
    </div>
</nav>