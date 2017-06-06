<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%> 

<!-- Page Title -->
<div class="container" style="max-width:500px; padding:40px 20px; background:#ebeff2">
  <h3>Створення/редагування категорії</h3>
  <form:form action="" method="POST" modelAttribute="category" enctype="multipart/form-data">
    <div class="form-group">
    <c:if test="${category.id > 0}"> --%>
        <img alt="" style="width: 50px; height: 50px;" src=<c:url value="/categoryInfo/${category.id}/image"/>> --%>
    </c:if>
      <form:input type="file" path="image" name="img[]" class="file" />
      <div class="input-group">
        <span class="input-group-addon"><span class="glyphicon glyphicon-picture"></span></span>
        <input type="text" class="form-control" disabled placeholder="завантажити зображення" />
        <span class="input-group-btn">
        <button class="browse btn btn-info" type="button">
        <i class="glyphicon glyphicon-search"></i> завантажити</button>
      </span>
      </div>
    </div>
    <div class="form-group">
      <div class="input-group"> <span class="input-group-addon"><span class="glyphicon glyphicon-text-background"></span></span>
        <form:input path="name" type="text" class="form-control" placeholder="назва категорії" />
        <form:errors path="name" class="help-block" cssErrorClass="" />
      </div>
    </div>
    <div class="form-group">
         <form:select id="" path="superCategory" items="${superCategories}" class="form-control" data-placeholder="super_category"
      	 itemLabel="name" itemValue="id" />
    </div>   
    <div class="form-group">
      <button type="submit" class="btn btn-success">Створити</button>
    </div>
  </form:form>
</div>