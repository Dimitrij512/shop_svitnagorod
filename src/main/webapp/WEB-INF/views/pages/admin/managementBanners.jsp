<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%> 

<div class="container" style="max-width:1000px; padding:40px 20px; background:#ebeff2">
  <h3>Створення банера</h3>
  <form:form action="" method="POST" modelAttribute="banner" enctype="multipart/form-data" class="">
    <div class="form-group">
      <form:input type="file" path="image" name="img[]" class="file" />
      <div class="input-group">
        <span class="input-group-addon"><span class="glyphicon glyphicon-picture"></span></span>
        <input type="text" class="form-control" disabled placeholder="Upload Image" />
        <span class="input-group-btn">
        <button class="browse btn btn-info" type="button">
        <i class="glyphicon glyphicon-search"></i> завантажити</button>
      </span>
      </div>
    </div>
    <div class="form-group">
      <div class="input-group"> <span class="input-group-addon"><span class="glyphicon glyphicon-text-background"></span></span>
        <form:input path="title" type="text" class="form-control" />
      </div>
    </div>
    <div class="form-group">
      <div class="input-group"> <span class="input-group-addon"><span class="glyphicon glyphicon-erase"></span></span>
        <form:textarea path="subtitle" type="text" class="form-control" />
      </div>
    </div>
    <div class="form-group">
      <div class="input-group"> <span class="input-group-addon"><span class="glyphicon glyphicon-piggy-bank"></span></span>
        <form:input path="enable" type="text" class="form-control" />
      </div>
    </div>
    <div class="form-group">
      <button type="submit" class="btn btn-success">Створити</button>
    </div>
  </form:form>
</div>

<table id = "banners" class="table table-striped table-bordered">
  <thead>
    <tr>
      <th>Зображення</th>
      <th>Заголовок</th>
      <th>Підзаголовок</th>
      <th>Включений</th>
    </tr>
  </thead>
  <tbody>
    <c:forEach items="${banners}" var="banner">
      <tr>
        <td>
          <img alt="" style="width: 100px; height: 100px;" src=<c:url value="/bannerInfo/${banner.id}/image" />>
        </td>
        <td>
          <c:out value="${banner.title}"></c:out>
          <td>
            <c:out value="${banner.subtitle}"></c:out>
          </td>
          <td>
            <c:out value="${banner.enable}"></c:out>
          </td>
          <td>
            <button id="${banner.id}" class="btn btn-danger delete">Видалити</button>
          </td>
      </tr>
    </c:forEach>
  </tbody>
</table>
<input id="contextPath" type="hidden" value="${pageContext.request.contextPath}" />

<!-- Main script -->
<script src=<c:url value="/static/js/banner/banner.js" />></script>