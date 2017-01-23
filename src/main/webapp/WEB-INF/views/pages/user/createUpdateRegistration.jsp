<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%> 


<div class="container-fluid">
  <form:form action="" method="POST" modelAttribute="registration" class="" enctype="multipart/form-data">

    <c:if test="${not empty param.registrationSuccess}">
      <div class="">
        <strong>Success!</strong> Account has been successfully created!
      </div>
    </c:if>
    <div class="row">
    <div class = "col-md-3 col-sm-3 col-lg-3">
     <label for="avatar"> AVATAR </label>
     <form:input type ="file" path="avatar" class="form-control"/>
    </div>
    </div>
    
    <div class="row">
      <div class="col-md-3 col-sm-3 col-lg-3">
        <label for="name">NAME</label>
        <form:input name="name" path="name" class="form-control" cssErrorClass="error form-control" type="text" />
        <form:errors path="name" class="help-block with-errors" cssErrorClass="" />
      </div>
    </div>
    <div class="row">
      <div class="col-md-3 col-sm-3 col-lg-3">
        <label for="surname">SURNAME</label>
        <form:input name="surname" path="surname" class="form-control" cssErrorClass="error form-control" type="text" />
        <form:errors path="surname" class="help-block with-errors" cssErrorClass="" />
      </div>
    </div>
    <div class="row">
      <div class="col-md-3 col-sm-3 col-lg-3">
        <label for="email">LOGIN</label>
        <form:input name="email" path="login" class="form-control" cssErrorClass="error form-control" />
        <form:errors path="login" class="help-block with-errors" cssErrorClass="" />     
      </div>
    </div>
    <div class="row">
      <div class="col-md-3 col-sm-3 col-lg-3">
        <label for="password">PASSWORD</label>
        <form:input name="password" path="password" class="form-control" cssErrorClass="error form-control" type="password" />
        <form:errors path="password" class="help-block with-errors" cssErrorClass="" /> 
      </div>
    </div>
    <hr>
    <div class="row">
      <div class="col-md-6 col-sm-6 col-xs-6 col-lg-6">
        <button type="submit" class="btn btn-default logbutton">Sign up</button>
      </div>
    </div>
  </form:form>
</div>