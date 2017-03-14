<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<input id="contextPath" type="hidden" value="${pageContext.request.contextPath}" />

<div class="section section-breadcrumbs">
  <div class="container">
    <div class="row">
      <div class="col-md-12">
        <h1><c:out value="${categoryName}" /></h1>
      </div>
    </div>
  </div>
</div>

<div class="section">
  <div class="container">
    <div class="row">
    <c:forEach items="${products}" var="product">
      <div class="col-md-4 col-sm-6">
        <div class="portfolio-item">
          <div class="portfolio-image">
            <a href=""><img src=<c:url value="/productInfo/${product.id}/image" /> alt="назва"></a>
          </div>
          <div class="portfolio-info-fade">
            <ul>
              <li class="portfolio-project-name"> <c:out value="${product.name}" /></li>
              <li class="read-more"><button id="${product.id}" class="addTobakset btn btn-small">
                    <span class="glyphicon glyphicon-shopping-cart" aria-hidden="true"></span> в корзину
                  </button></li>
              <li class="read-more"><a href="${pageContext.request.contextPath}/productDetail/${product.id}" class="btn">детальніше</a></li>
            </ul>
          </div>
        </div>
      </div>
      </c:forEach>
    </div>
  </div>
</div>
<script src=<c:url value="/static/js/basket/basket.js" />></script>