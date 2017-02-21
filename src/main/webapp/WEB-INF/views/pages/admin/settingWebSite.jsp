<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%> 

<ul class="breadcrumb">
	<li class="breadcrumb-item"><a href="${pageContext.request.contextPath}/admin/settingWebsite/superCategory">Super Categories</a></li>
	<li class="breadcrumb-item"><a href="${pageContext.request.contextPath}/admin/settingWebsite/categories">Categories</a></li>
	<li class="breadcrumb-item"><a href="${pageContext.request.contextPath}/admin/settingWebsite/products">Products</a></li>
	<li class="breadcrumb-item"><a href="${pageContext.request.contextPath}/admin/settingWebsite/users">Users</a></li>
</ul>

<input id="contextPath" type="hidden" value="${pageContext.request.contextPath}" />

<p id="messageField"></p>
<!-- Main page script -->
<script src=<c:url value="/static/js/order/order.js" />></script>
