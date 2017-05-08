<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%> 


<p class="text-center">
  <a href="${pageContext.request.contextPath}/admin/settingWebsite/createUpdateSuperCategory" class="btn btn-primary"> створити категорію</a>
</p>

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
            <span class="glyphicon glyphicon-remove"></span>  видалити</a>
          <a id="" class="btn btn-danger btn-sm" href=<c:url value="/admin/settingWebsite/createUpdateSuperCategory/${spuerCategory.id}" />>
            <span class="glyphicon glyphicon-pencil"></span>  Редагувати</a>
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