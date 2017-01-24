<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

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
       <sec:authorize access="isAuthenticated()">
       	        <div>
	      		<sec:authentication var="user" property="principal" />
	       		<p>${user.username}</p>
      		 </div>
	      <ul class="nav navbar-nav navbar-right">
	        <li class="dropdown">

		          <a class="dropdown-toggle" data-toggle="dropdown" aria-expanded="false" href="#">
		          <span class="caret"></span><img class = "img-circle" alt="not image" src=<c:url value="/usersInfo/${user.username}/avatar"/>></a>

	          <ul class="dropdown-menu dropdown-menu-right" role="menu">
	            <li><a href="#">Settings your accaunt </a></li>
	            <li><a href="${pageContext.request.contextPath}/admin/settingWebsite">Settings webSite </a></li>
	            <li><a href="${pageContext.request.contextPath}/logout">Logout </a></li>
	          </ul>
	        </li>
	      </ul>
      </sec:authorize>
      <sec:authorize access = "isAnonymous()" >
      	   <ul class="nav navbar-nav links navbar-right">
 			<li role="presentation"><a href="${pageContext.request.contextPath}/login">Enter</a></li>
	      </ul>
      </sec:authorize>
    </div>
  </div>
</nav>