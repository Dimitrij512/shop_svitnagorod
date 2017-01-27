<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%> 

<table class="table table-inverse">
  <thead>
    <tr>
      <th>NAME</th>
      <th>DESCRIPTION</th>
      <th>PRICE</th>
      <th>CATGORY</th>
    </tr>
  </thead>
  <tbody>
    <c:forEach items="${products}" var="product">
      <tr>
        <td>
          <c:out value="${product.name}"></c:out>
        </td>
        <td>
          <c:out value="${product.description}"></c:out>
        </td>
        <td>
          <c:out value="${product.price}"></c:out>
        </td>
        <td>
<%--           <c:out value="${product.category.name}"></c:out> --%>
        </td>
        
        <td>
          <button id="${product.id}" class="btn btn-danger delete">delete</button>
        </td>
      </tr>
    </c:forEach>
  </tbody>
</table>
<div class="">
  <form:form action="" method="POST" modelAttribute="product" class="form-group">
    <div class="col-md-3">
      <form:input path="name" class="form-control" />
    </div>
    <div class="col-md-3">
      <form:input path="description" class="form-control" />
    </div>
    <div class="col-md-3">
      <form:input path="price" class="form-control" />
    </div>
<!--     <div class="col-md-3"> -->
<%--       <form:input path="category" class="form-control" /> --%>
<!--     </div> -->
    <div class="coll-md-3">
      <button type="submit" class="btn btn-default">Submit</button>
    </div>
  </form:form>
</div>
<input id="contextPath" type="hidden" value="${pageContext.request.contextPath}" />

<!-- Main script -->
<script src=<c:url value="/static/js/products/product.js" />></script>