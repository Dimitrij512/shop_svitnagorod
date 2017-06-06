<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%> 

<p class="text-center">
  <a href="${pageContext.request.contextPath}/admin/settingWebsite/createUpdateCategory" class="btn btn-primary"> створити категорію</a>
</p>

<table id = "categories" class="table table-striped table-bordered">
  <thead>
    <tr>
      <th>Зображення</th>
      <th>Назва</th>
      <th>Супер категорія</th>
      <th>Видалити</th>
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
          	<c:if test="${category.superCategory.id == superCategory.id}">
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
                <h2>Видалення категорії</h2>
              </div>
              <div class="modal-body">
                <p>Ви дійсно бажаєте видалити цю категорію?</p>
                <p>Якщо ви видалити категорію, автоматично будуть видалені всі продукти даної категорії !!!</p>
              </div>
              <div class="modal-footer">
                <button id="${category.id}" class="btn btn-danger delete">Видалити</button>
                <button id="" class="btn btn-danger delete">Редагувати</button>
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