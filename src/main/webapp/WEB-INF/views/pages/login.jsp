<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<link href="<c:url value = " /static/css/login/login.css " />" rel="stylesheet">
<div class="container">
  <div class="row">
    <div class="col-md-offset-5 col-md-3">
        <c:if test="${succes==true}">
          <div class="">
            <div class="">
              <p><strong>Ви успішно увійшли до системи!</strong></p>
              <p><a href=<c:url value="/logout" /> class="">Вийти</a>
              </p>
            </div>
          </div>
        </c:if>

        <c:if test="${succes!=true}">
          <div class="form-login">
            <h4>Welcome</h4>
            <c:if test="${not empty param.error}">
              <div class="">
                <strong>Wrong password or login</strong>
              </div>
            </c:if>
            <form role="" action="${pageContext.request.contextPath}/login" method="POST">
                <input type="text" id="userName" class="form-control input-sm chat-input" name="login" placeholder="username" autofocus
                  required/>
              </br>
              <input type="password" id="userPassword" class="form-control input-sm chat-input" name="password" placeholder="password"
              />
              </br>
              <div class="wrapper">
            <span class="group-btn">
                <input type = "submit" value ="login" class="btn btn-primary btn-md">
            </span>
            <span class="group-btn">     
                <a href="${pageContext.request.contextPath}/registration" class="btn btn-primary btn-md">registration <i class="glyphicon glyphicon-registration-mark"></i></a>
            </span>
              </div>
            </form>
          </div>
        </c:if>
    </div>
  </div>
</div>