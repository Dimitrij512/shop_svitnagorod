<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%> 


<p class="text-center">
    <button class="btn btn-default" data-toggle="modal" data-target="#loginModal">Створити нову категорію</button>
</p>

<div class="modal fade" id="loginModal" tabindex="-1" role="dialog" aria-labelledby="Login" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
                <h5 class="modal-title">Створення категорії</h5>
            </div>

            <div class="modal-body">
                <!-- The form is placed inside the body of modal -->
							<form:form action="" method="POST" modelAttribute="spuerCategory" enctype="multipart/form-data" class="form-inline">
							      <div class="form-group">
							        <div class="col-lg-12">
							          <form:input type="file" path="image" name="img[]" class="file" />
							          <div class="input-group">
							            <span class="input-group-addon"><span class="glyphicon glyphicon-picture"></span></span>
							            <input type="text" class="form-control" disabled placeholder="зображення категорії" />
							            <span class="input-group-btn">
							        <button class="browse btn btn-info" type="button">
							        <i class="glyphicon glyphicon-search"></i> завантажити</button>
							      </span>
							          </div>
							        </div>
							      </div>
							      <div class="form-group">
							        <div class="col-lg-12">
							          <div class="input-group"> <span class="input-group-addon"><span>назва</span></span>
							            <form:input path="name" type="text" class="form-control" />
							          </div>
							        </div>
							      </div>
							      <div class="form-group">
							        <div class="col-lg-12">
							          <button type="submit" class="btn btn-success">створити</button>
							        </div>
							      </div>
							    </form:form>
            </div>
        </div>
    </div>
</div>


<table id = "superCategories"  class="table table-striped table-bordered">
  <thead>
    <tr>
      <th>Зображення</th>
      <th>Назва</th>
      <th>Видалити</th>
    </tr>
  </thead>
  <tbody>
    <c:forEach items="${superCategories}" var="spuerCategory">
      <tr>
        <td>
          <img alt="" style="width: 50px; height: 50px;" src=<c:url value="/superCategoryInfo/${spuerCategory.id}/image" />>
        </td>
        <td>
          <c:out value="${spuerCategory.name}"></c:out>
        </td>
        <td>
          <a id="myBtn" class="btn btn-danger btn-sm btnModal">
            <span class="glyphicon glyphicon-remove"></span>видалити</a>
          <div id="myModal" class="modal">
            <!-- Modal content -->
            <div class="modal-content">
              <div class="modal-header">
                <span class="close">&times;</span>
                <h2>Видалення категорії</h2>
              </div>
              <div class="modal-body">
                <p>Ви дійсно хочете видалити цю категорію ?? ??</p>
                <p>Якщо ви  видалите цю категорію також будуть видалені всі підкатегорії і продукти тих категорії</p>
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
<input id="contextPath" type="hidden" value="${pageContext.request.contextPath}" />
<!-- Main script -->
<script src=<c:url value="/static/js/superCategories/superCategory.js" />></script>