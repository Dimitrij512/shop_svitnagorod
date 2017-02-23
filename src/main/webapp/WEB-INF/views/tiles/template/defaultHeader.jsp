<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<!-- Navigation & Logo-->
<div class="mainmenu-wrapper">
  <div class="container">
    <div class="menuextras">
      <div class="extras">
        <ul>
          <li class="shopping-cart-items"><i class="glyphicon glyphicon-shopping-cart icon-white"></i> <a href="${pageContext.request.contextPath}/basket"><b>3 items</b></a></li>
          <sec:authorize access="isAuthenticated()">
            <div>
              <sec:authentication var="user" property="principal" />
            </div>
            <ul class="nav navbar-nav navbar-right">
              <li class="dropdown">
                <a class="dropdown-toggle" data-toggle="dropdown" aria-expanded="false">${user.username}
							          <span class="caret"></span>
							          <img class = "img-circle" style="width: 30px; height: 30px;" alt="not image" src=<c:url value="/usersInfo/${user.username}/avatar"/>></a>
                <ul class="dropdown-menu dropdown-menu-right" role="menu">
                  <li><a href="#">Settings your accaunt </a></li>
                  <li><a href="${pageContext.request.contextPath}/admin/settingWebsite">Settings webSite </a></li>
                  <li><a href="${pageContext.request.contextPath}/logout">Logout </a></li>
                </ul>
              </li>
            </ul>
          </sec:authorize>
          <sec:authorize access="isAnonymous()">
            <ul class="nav navbar-nav links navbar-right">
              <li><a href="${pageContext.request.contextPath}/login" style="padding-top:0px"><b>Mій аккаунт</b></a></li>
            </ul>
          </sec:authorize>


        </ul>
      </div>
    </div>
    <nav id="mainmenu" class="mainmenu">
      <ul>
        <li class="logo-wrapper">
          <a href=""><img src="static/img/mPurpose-logo.png" alt="Multipurpose Twitter Bootstrap Template"></a>
        </li>
        <li class="active">
          <a href="${pageContext.request.contextPath}/">Головна</a>
        </li>
        <li>
          <a href="${pageContext.request.contextPath}/contactus">Контакти</a>
        </li>
        <li class="has-submenu">
          <a href="${pageContext.request.contextPath}/products">Наша продукція</a>
          <div class="mainmenu-submenu">
            <div class="mainmenu-submenu-inner">
            </div>
            <!-- /mainmenu-submenu-inner -->
          </div>
          <!-- /mainmenu-submenu -->
        </li>
        <li>
          <a href="${pageContext.request.contextPath}/user/welcome">Доставка</a>
        </li>
      </ul>
    </nav>
  </div>
</div>