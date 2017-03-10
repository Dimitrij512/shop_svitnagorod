<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%> 


<div class="section section-breadcrumbs">
  <div class="container">
    <div class="row">
      <div class="col-md-12">
        <ul class="breadcrumb">
				  <li class="breadcrumb-item"><a href="${pageContext.request.contextPath}/admin/settingWebsite/superCategory">Супер категорії</a></li>
				  <li class="breadcrumb-item"><a href="${pageContext.request.contextPath}/admin/settingWebsite/categories">Категорії</a></li>
				  <li class="breadcrumb-item"><a href="${pageContext.request.contextPath}/admin/settingWebsite/products">Продукти</a></li>
				  <li class="breadcrumb-item"><a href="${pageContext.request.contextPath}/admin/settingWebsite/users">Користувачі</a></li>
				  <li class="breadcrumb-item"><a href="${pageContext.request.contextPath}/admin/settingWebsite/banners">Банери</a></li>
      </ul>
      </div>
    </div>
  </div>
</div>

<input id="contextPath" type="hidden" value="${pageContext.request.contextPath}" />

<!-- Message on this page -->
<p id="messageField"></p>
<!-- Main page script -->
<script src=<c:url value="/static/js/order/order.js" />></script>
