<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%> 

<table class="table table-inverse">
  <thead>
    <tr>
      <th>IMAGE</th>
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
          <img alt="" src=<c:url value="/productInfo/${product.id}/image" />>
        </td>
          <c:out value="${product.name}"></c:out>
        <td>
          <c:out value="${product.description}"></c:out>
        </td>
        <td>
          <c:out value="${product.price}"></c:out>
        </td>
        <td>
 			<c:out value="${product.category_id}"></c:out>
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
      <form:input path="image" type = "file"  class="form-control" />
    </div>
    <div class="col-md-3">
      <form:input path="name" class="form-control" />
    </div>
    <div class="col-md-3">
      <form:input path="description" class="form-control" />
    </div>
    <div class="col-md-3">
      <form:input path="price" class="form-control" />
    </div>
    <div class="col-md-3">
	    
	    <form:select id="" path="category_id" items="${categories}" class="form-control" data-placeholder="category" itemLabel="name"
	            itemValue="id" cssErrorClass="error form-control" />
    </div>
    <div class="coll-md-3">
      <button type="submit" class="btn btn-default">Submit</button>
    </div>
  </form:form>
</div>
<input id="contextPath" type="hidden" value="${pageContext.request.contextPath}" />

<!-- Main script -->
<script src=<c:url value="/static/js/products/product.js" />></script>