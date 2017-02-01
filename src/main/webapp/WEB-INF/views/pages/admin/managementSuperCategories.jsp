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
      <th>DELETE</th>
    </tr>
  </thead>
  <tbody>
    <c:forEach items="${superCategories}" var="spuerCategory">
      <tr>
        <td>
          <img alt="" style="width: 50px; height: 50px;" src=<c:url value="/superCategoryInfo/${spuerCategory.id}/image" />>
        </td>
        <td>
          <c:out value="${spuerCategory.id}"></c:out>
        </td>
        <td>
          <c:out value="${spuerCategory.name}"></c:out>
        </td>
        <td>
          <button id="${spuerCategory.id}" class="btn btn-danger delete">delete</button>
        </td>
      </tr>
    </c:forEach>
  </tbody>
</table>
<div class="">
  <form:form action="" method="POST" modelAttribute="spuerCategory" enctype="multipart/form-data" class="form-group">
    <div class="col-md-3">
      <form:input path="image" type = "file"  class="form-control" />
    </div>
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
<script src=<c:url value="/static/js/superCategories/superCategory.js" />></script>
