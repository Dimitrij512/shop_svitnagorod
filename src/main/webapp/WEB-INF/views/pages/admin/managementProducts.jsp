<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%> 

<div class="container" style="max-width:1000px; padding:40px 20px; background:#ebeff2">
  <h3>Create product</h3>
  <form:form action="" method="POST" modelAttribute="product" enctype="multipart/form-data" class="">
    <div class="form-group">
      <form:input type="file" path="image" name="img[]" class="file" />
      <div class="input-group">
        <span class="input-group-addon"><span class="glyphicon glyphicon-picture"></span></span>
        <input type="text" class="form-control" disabled placeholder="Upload Image" />
        <span class="input-group-btn">
        <button class="browse btn btn-info" type="button">
        <i class="glyphicon glyphicon-search"></i> Browse</button>
      </span>
      </div>
    </div>
    <div class="form-group">
      <div class="input-group"> <span class="input-group-addon"><span class="glyphicon glyphicon-text-background"></span></span>
        <form:input path="name" type="text" class="form-control" />
      </div>
    </div>
    <div class="form-group">
      <div class="input-group"> <span class="input-group-addon"><span class="glyphicon glyphicon-erase"></span></span>
        <form:textarea path="description" type="text" class="form-control" />
      </div>
    </div>
    <div class="form-group">
      <div class="input-group"> <span class="input-group-addon"><span class="glyphicon glyphicon-piggy-bank"></span></span>
        <form:input path="price" type="text" class="form-control" />
      </div>
    </div>
    <div class="form-group">
      <div class="input-group"> <span class="input-group-addon"><span class="glyphicon glyphicon-menu-hamburger"></span></span>
        <form:select id="" path="category_id" items="${categories}" class="form-control" data-placeholder="super category" itemLabel="name"
          itemValue="id" />
      </div>
    </div>
    <div class="form-group">
      <button type="submit" class="btn btn-success">create</button>
    </div>
  </form:form>
</div>

<table id = "products" class="table table-striped table-bordered">
  <thead>
    <tr>
      <th>IMAGE</th>
      <th>NAME</th>
      <th>DESCRIPTION</th>
      <th>PRICE</th>
      <th>CATGORY</th>
      <th>DELETE</th>
    </tr>
  </thead>
  <tbody>
    <c:forEach items="${products}" var="product">
      <tr>
        <td>
          <img alt="" style="width: 50px; height: 50px;" src=<c:url value="/productInfo/${product.id}/image" />>
        </td>
        <td>
          <c:out value="${product.name}"></c:out>
          <td>
            <c:out value="${product.description}"></c:out>
          </td>
          <td>
            <c:out value="${product.price}"></c:out>
          </td>
          <td>
            <c:forEach items="${categories}" var="category">
              <c:if test="${product.category_id == category.id}">
                <c:out value="${category.name}"></c:out>
              </c:if>
            </c:forEach>
          </td>
          <td>
            <button id="${product.id}" class="btn btn-danger delete">delete</button>
          </td>
      </tr>
    </c:forEach>
  </tbody>
</table>
<input id="contextPath" type="hidden" value="${pageContext.request.contextPath}" />

<!-- Main script -->
<script src=<c:url value="/static/js/products/product.js" />></script>