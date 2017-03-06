<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%> 

<!-- Page Title -->
<div class="section section-breadcrumbs">
  <div class="container">
    <div class="row">
      <div class="col-md-12">
        <h1>Реєстрація</h1>
      </div>
    </div>
  </div>
</div>


<div class="section">
  <div class="container">
    <div class="row">
      <div class="col-sm-5">
        <div class="basic-login">
          <form:form action="" method="POST" modelAttribute="registration" class="" enctype="multipart/form-data">
            <c:if test="${not empty param.registrationSuccess}">
              <div class="success">
                <strong>Вітаємо!</strong> Ваш аккаунт успішно створений!
              </div>
            </c:if>

            <div class="form-group">
              <label for="user_foto"><i class="icon-user"></i> <b>Ваше фото</b></label>
              <form:input type="file" path="avatar" id="user_foto" class="form-control" />
              <form:errors path="avatar" class="help-block" cssErrorClass="" />
            </div>
            <div class="form-group">
              <label for="user_name"><i class="icon-lock"></i> <b>Ім'я</b></label>
              <form:input name="name" id="user_name" path="name" class="form-control" cssErrorClass="error form-control" type="text" />
              <form:errors path="name" class="help-block" cssErrorClass="" />
            </div>
            <div class="form-group">
              <label for="user_surname"><i class="icon-lock"></i> <b>Фамілія</b></label>
              <form:input name="surname" id="user_surname" path="surname" class="form-control" cssErrorClass="error form-control" type="text"
              />
              <form:errors path="surname" class="help-block with-errors" cssErrorClass="" />
            </div>
            <div class="form-group">
              <label for="user_phone"><i class="icon-lock"></i> <b>Телефон</b></label>
              <form:input name="phone" id="user_phone" path="phone" class="form-control" cssErrorClass="error form-control" type="text"
              />
              <form:errors path="phone" class="help-block with-errors" cssErrorClass="" />
            </div>
            <div class="form-group">
              <label for="user_login"><i class="icon-lock"></i> <b>Email</b></label>
              <form:input type = "email" name="login" id="user_login" path="login" class="form-control" cssErrorClass="error form-control" />
              <form:errors path="login" class="help-block with-errors" cssErrorClass="" />
            </div>
            <div class="form-group">
              <label for="user_password"><i class="icon-lock"></i> <b>Пароль</b></label>
              <form:input name="password" id="user_password" path="password" class="form-control" cssErrorClass="error form-control" type="password"
              />
              <form:errors path="password" class="help-block with-errors" cssErrorClass="" />
            </div>
            <div class="form-group">
              <button type="submit" class="btn pull-right">Реєстрація</button>
              <div class="clearfix"></div>
            </div>
          </form:form>
        </div>
      </div>
    </div>
  </div>
</div>