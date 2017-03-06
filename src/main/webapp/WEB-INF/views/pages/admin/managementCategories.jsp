<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%> 

<div class="row">
  <div class="col-lg-9">
    <form:form action="" method="POST" modelAttribute="category" enctype="multipart/form-data" class="form-inline">
      <div class="form-group">
        <div class="col-lg-12">
         <form:input type="file" path="image" name="img[]"  class="file" />
          <div class="input-group">
            <span class="input-group-addon"><span class="glyphicon glyphicon-picture"></span></span>
            <input type="text" class="form-control" disabled placeholder="Upload Image" />
            <span class="input-group-btn">
              <button class="browse btn btn-info" type="button">
              <i class="glyphicon glyphicon-search"></i> Browse</button>
              </span>
          </div>
        </div>
      </div>
      <div class="form-group">
        <div class="col-lg-12">
          <div class="input-group"> <span class="input-group-addon"><span>name</span></span>
            <form:input path="name" type="text" class="form-control" />
          </div>
        </div>
      </div>
      <div class="form-group">
        <div class="col-lg-12">
           <form:select id="" path="super_category_id" items="${superCategories}" class="form-control" data-placeholder="super category"
        	itemLabel="name" itemValue="id" />  
        </div>
      </div> 
      <div class="form-group">
        <div class="col-lg-12">
          <button type="submit" class="btn btn-success">Submit</button>
        </div>
      </div>
    </form:form>
  </div>
</div>

<table id = "categories" class="table table-striped table-bordered">
  <thead>
    <tr>
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
          <img alt="" style="width: 50px; height: 50px;" src=<c:url value="/categoryInfo/${category.id}/image"/>>
        </td>
        <td>
          <c:out value="${category.name}"></c:out>
        </td>
        <td>
         <c:forEach items="${superCategories}" var="superCategory">
         	<c:if test="${category.super_category_id == superCategory.id}">
         		<c:out value="${superCategory.name}"></c:out>
         	</c:if>
         </c:forEach> 
        </td>
        <td>
           <a id="myBtn" class="btn btn-danger btn-sm btnModal">
          	 <span class="glyphicon glyphicon-remove"></span>remove</a>
          <div id="myModal" class="modal">
          
            <!-- Modal content -->
            <div class="modal-content">
              <div class="modal-header">
                <span class="close">&times;</span>
                <h2>Delete Category</h2>
              </div>
              <div class="modal-body">
                <p>Do you really want delete this category ?? ??</p>
                <p>If you will delete this category also will be deleted all products of this category !!!</p>
              </div>
              <div class="modal-footer">
                <button id="${category.id}" class="btn btn-danger delete">OK</button>
              </div>
            </div>
          </div>
        </td>
      </tr>
    </c:forEach>
  </tbody>
</table>

<input id="contextPath" type="hidden" value="${pageContext.request.contextPath}" />

<!-- Main script -->
<script src=<c:url value="/static/js/categories/category.js" />></script>