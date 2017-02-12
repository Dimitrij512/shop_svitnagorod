<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%> 

<div class="container" style="max-width:1000px; padding:40px 20px; background:#ebeff2">
  <h3>Create order</h3>
  <form:form action="" method="POST" modelAttribute="order" class="">
    <div class="form-group">
      <div class="input-group"> <span class="input-group-addon"><span class="glyphicon glyphicon-text-background"></span></span>
        <form:input path="name" type="text" class="form-control" />
      </div>
    </div>
    <div class="form-group">
      <div class="input-group"> <span class="input-group-addon"><span class="glyphicon glyphicon-erase"></span></span>
        <form:textarea path="adress" type="text" class="form-control" />
      </div>
    </div>
    <div class="form-group">
      <div class="input-group"> <span class="input-group-addon"><span class="glyphicon glyphicon-piggy-bank"></span></span>
        <form:input path="email" type="email" class="form-control" />
      </div>
    </div>
    <div class="form-group">
      <div class="input-group"> <span class="input-group-addon"><span class="glyphicon glyphicon-piggy-bank"></span></span>
        <form:input path="phone" type="text" class="form-control" />
      </div>
    </div>

    <div class="form-group">
      <button type="submit" class="btn btn-success">sand</button>
    </div>
  </form:form>
</div>