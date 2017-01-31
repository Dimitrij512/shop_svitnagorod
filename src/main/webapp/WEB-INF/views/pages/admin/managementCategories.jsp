<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%> 

<table class="table table-inverse">
  <thead>
    <tr>
       <th>ID</th>
       <th>IMAGE</th>
      <th>NAME</th>
      <th>SUPER CATEGORY</th>
      <th>DELETE</th>
    </tr>
  </thead>
  <tbody>
    <c:forEach items="${categories}" var="category">
      <tr>
        <td>
          <c:out value="${category.id}"></c:out>
        </td>
        <td>
          <img alt="" src=<c:url value="/categoryInfo/${category.id}/image" />>
        </td>
        <td>
          <c:out value="${category.name}"></c:out>
        </td>
         <td>
          <c:out value="${category.super_category_id}"></c:out>
        </td>
        <td>
          <button id="${category.id}" class="btn btn-danger delete">delete</button>
        </td>
      </tr>
    </c:forEach>
  </tbody>
</table>
<div class="">
  <form:form action="" method="POST" modelAttribute="category" class="form-group" enctype="multipart/form-data">
    <div class="col-md-3">
      <form:input path="image" type = "file"  class="form-control" />
    </div> 
    <div class="col-md-3">
      <form:input path="name" class="form-control" />
    </div>
    <div class="col-md-3">
      <form:select id="" path="super_category_id" items="${superCategories}" class="form-control" data-placeholder="super category" itemLabel="name"
	            itemValue="id"/>
    </div>
    <div class="coll-md-3">
      <button type="submit" class="btn btn-default">Submit</button>
    </div>
  </form:form>
</div>
<input id="contextPath" type="hidden" value="${pageContext.request.contextPath}" />

<!-- Main script -->
<script src=<c:url value="/static/js/categories/category.js" />></script>