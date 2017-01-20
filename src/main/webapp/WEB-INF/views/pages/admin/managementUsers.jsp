<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%> 

<table class="table table-inverse">
  <thead>
    <tr>
      <th>NAME</th>
      <th>SURNAME</th>
      <th>LOGIN</th>
      <th>ROLE</th>
    </tr>
  </thead>
  <tbody>
    <c:forEach items="${users}" var="user">
      <tr>
        <td>
          <c:out value="${user.name}"></c:out>
        </td>
        <td>
          <c:out value="${user.surname}"></c:out>
        </td>
        <td>
          <c:out value="${user.login}"></c:out>
        </td>
        <td>
          <c:out value="${user.role}"></c:out>
        </td>
        <td>
          <button id="${user.id}" class="btn btn-danger delete">delete</button>
        </td>
      </tr>
    </c:forEach>
  </tbody>
</table>

<input id="contextPath" type="hidden" value="${pageContext.request.contextPath}" />

<!-- Main script -->
<script src=<c:url value="/static/js/users/user.js" />></script>