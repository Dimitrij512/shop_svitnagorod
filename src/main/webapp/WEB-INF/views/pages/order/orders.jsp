<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<table class="table">
  <thead>
    <tr>
      <th>name</th>
      <th>email</th>
      <th>adress</th>
      <th>phone</th>
      <th>date</th>
    </tr>
  </thead>
  <tbody>
    <c:forEach items="${orders}" var="order">
      <tr id="${order.id}" class="dataRow">
        <td>
          <c:out value="${order.name}"></c:out>
        </td>
        <td>
          <c:out value="${order.email}"></c:out>
        </td>
        <td>
          <c:out value="${order.adress}"></c:out>
        </td>
        <td>
          <c:out value="${order.phone}"></c:out>
        </td>
        <td>
          <c:out value="${order.timestamp}"></c:out>
        </td>
      </tr>
    </c:forEach>
  </tbody>
</table>