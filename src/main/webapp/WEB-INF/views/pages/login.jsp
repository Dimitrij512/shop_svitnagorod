<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<div class="section section-breadcrumbs">
  <div class="container">
    <div class="row">
      <div class="col-md-12">
        <h1>Логінізація</h1>
      </div>
    </div>
  </div>
</div>

<div class="section">
  <div class="container">
    <c:if test="${succes==true}">
      <div class="">
        <div class="success">
          <p><strong>Ви успішно увійшли до системи!</strong></p>
          <p><a href=<c:url value="/logout" /> class="">Вийти</a>
          </p>
        </div>
      </div>
    </c:if>
    <div class="row">
      <div class="col-sm-5">
        <div class="basic-login">
          <c:if test="${not empty param.error}">
            <div class="warning">
              <strong>Помилка вводу !</strong>
            </div>
          </c:if>
          
          <c:if test="${succes!=true}">
            <form role="" action="${pageContext.request.contextPath}/login" method="POST">
              <div class="form-group">
                <label for="login-username"><i class="icon-user"></i> <b>Ваш eлектронна пошта</b></label>
                <input class="form-control" id="userName" name="login" type="text" placeholder="">
              </div>
              <div class="form-group">
                <label for="login-password"><i class="icon-lock"></i> <b>Пароль</b></label>
                <input class="form-control" id="userPassword" type="password" name="password" placeholder="">
              </div>
              <div class="form-group">
                <button type="submit" value="login" class="btn pull-right">Ввійти</button>
                <div class="clearfix"></div>
              </div>
            </form>
          </c:if>
        </div>
      </div>

      <div class="col-sm-7 social-login">
      
         <p>Увійдіть через Facebook</p>

         <form action="signin/facebook" method="POST" class="">
	          <input type="hidden" name="scope" value="email, public_profile" />
	            <button type="submit" class="btn btn-primary btn-block">Увіти через Facebook</button>
          </form>
            <div class="clearfix"></div>
        <div class="not-member">
        
          <p>Ви не зареєстровані? <a href="${pageContext.request.contextPath}/registration">Зареєструватись</a></p>
        </div>
        </div>
      </div>
    </div>
  </div>
