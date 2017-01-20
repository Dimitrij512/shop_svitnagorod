<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%> 

<table class="table table-inverse">
  <thead>
    <tr>
      <th>NAME</th>
      <th>DELETE</th>
    </tr>
  </thead>
  <tbody>
    <c:forEach items="${categories}" var="category">
      <tr>
        <td>
          <c:out value="${category.name}"></c:out>
        </td>
        <td>
          <button id="${category.id}" class="btn btn-danger delete">delete</button>
        </td>
      </tr>
    </c:forEach>
  </tbody>
</table>
<div class="">
  <form:form action="" method="POST" modelAttribute="category" class="form-group">
    <div class="col-md-3">
      <form:input path="name" class="form-control" />
    </div>
    <div class="coll-md-3">
      <button type="submit" class="btn btn-default">Submit</button>
    </div>
  </form:form>
</div>
<input id="contextPath" type="hidden" value="${pageContext.request.contextPath}" />

<!-- Main script -->
<script src=<c:url value="/static/js/categories/category.js" />></script>