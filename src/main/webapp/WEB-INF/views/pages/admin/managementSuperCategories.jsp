<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%> 
<div class="row">
  <div class="col-md-12">
    <form:form action="" method="POST" modelAttribute="spuerCategory" enctype="multipart/form-data"
      class="form-group">
      <div class="col-md-3">
        <form:input type="file" path="image" name="img[]" class="file" />
        <div class="input-group">
          <span class="input-group-addon"><span class="glyphicon glyphicon-picture"></span></span>
          <input type="text" class="form-control" disabled placeholder="Upload Image" />
          <span class="input-group-btn">
        <button class="browse btn btn-primary" type="button">
        <i class="glyphicon glyphicon-search"></i> Browse</button>
      </span>

        </div>
      </div>
      <div class="col-md-3">
        <div class="input-group"> <span class="input-group-addon"><span>name</span></span>
          <form:input path="name" type="text" class="form-control" />
        </div>
      </div>
      <div class="coll-md-3">
        <button type="submit" class="btn btn">Submit</button>
      </div>
      </form:form>

  </div>
</div>
<table class="table table-inverse">
  <thead>
    <tr>
      <th>IMAGE</th>
      <th>NAME</th>
      <th>DELETE</th>
    </tr>
  </thead>
  <tbody>
    <c:forEach items="${superCategories}" var="spuerCategory">
      <tr>
        <td>
          <img alt="" style="width: 50px; height: 50px;" src=<c:url value="/superCategoryInfo/${spuerCategory.id}/image"
          />>
        </td>
        <td>
          <c:out value="${spuerCategory.name}"></c:out>
        </td>
        <td>
         <button id="myBtn">DELETE</button>
          <div id="myModal" class="modal">
            <!-- Modal content -->
            <div class="modal-content">
              <div class="modal-header">
                <span class="close">&times;</span>
                <h2>Delete SuperCategory</h2>
              </div>
              <div class="modal-body">
                <p>Do you really want delete this super category ?? ??</p>
                <p>If you will delete this category also will be deleted all categrories and products of this super category !!!</p>
              </div>
              <div class="modal-footer">
                <button id="${spuerCategory.id}" class="btn btn-danger delete">OK</button>
              </div>
            </div>
          </div>
        </td>
      </tr>
    </c:forEach>
  </tbody>
</table>
<input id="contextPath" type="hidden" value="${pageContext.request.contextPath}"
/>
<!-- Main script -->
<script src=<c:url value="/static/js/superCategories/superCategory.js" />></script>