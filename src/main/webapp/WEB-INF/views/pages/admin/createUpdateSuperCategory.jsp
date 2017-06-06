<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%> 

<!-- Page Title -->

<div class="section">
  <div class="container">
    <div class="row">
      <div class="col-sm-5">
        <div class="basic-login">

          <form:form action="" method="POST" modelAttribute="spuerCategory" class="" enctype="multipart/form-data">
            <div class="form-group">
            <c:if test="${spuerCategory.id > 0}">
              <img  class = "img-circle" alt="" style="width: 50px; height: 50px;" src=<c:url value="/superCategoryInfo/${spuerCategory.id}/image" />>
            </c:if>
              <label for="user_foto"><i class="icon-user"></i> <b>Зображення</b></label>
               <form:input type="file" path="image" name="img[]" id="user_foto" class="file"/>
              <div class="input-group">
                <input type="text" class="form-control" disabled/>
                <span class="input-group-btn">
                  <button class="browse btn btn-info" type="button">
                  <i class="glyphicon glyphicon-search"></i> завантажити</button>
                </span>
              </div>
              <form:errors path="image" class="help-block" cssErrorClass="" />
            </div>
            <div class="form-group">
              <label for="user_name"><i class="icon-lock"></i> <b>Назва категорії</b></label>
              <form:input name="name" id="user_name" path="name" class="form-control" cssErrorClass="error form-control" type="text" />
              <form:errors path="name" class="help-block" cssErrorClass="" />
            </div>                        
            <div class="form-group">
              <button type="submit" class="btn pull-right">Зберегти</button>
              <div class="clearfix"></div>
            </div>
          </form:form>
        </div>
      </div>
    </div>
  </div>
</div>