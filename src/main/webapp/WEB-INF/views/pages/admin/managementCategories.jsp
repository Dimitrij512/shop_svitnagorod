<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%> 

<table class="table table-inverse">
  <thead>
    <tr>
      <th>NAME</th>
    </tr>
  </thead>
  <tbody>
    <c:forEach items="${categories}" var="category">
      <tr>
        <td>
          <c:out value="${category.name}"></c:out>
        </td>
      </tr>
    </c:forEach>
  </tbody>
</table>