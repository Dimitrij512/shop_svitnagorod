<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%> 


<h2>cart page</h2>

<button class="btn btn-default pull-right right-btn back-btn">Back</button>
<button class="btn btn-default pull-right right-btn">Sand</button>
<div class="container">
  <div class="row">
    <c:forEach items="${products}" var="product">
      <div class="col-sm-3 col-lg-3 col-md-3 product">
        <div class="thumbnail">
          <div class="hover">
            <img alt="" style="width: 50px; height: 50px;" src=<c:url value="/productInfo/${product.id}/image"
            />>
            <div class="caption">
              <h4 class="pull-right">
                <c:out value="$ ${product.price}" />
              </h4>
              <h4>
                <c:out value="${product.name}" />
              </h4>
              <h4>
                <input type="number" value="opera"> count
              </h4>
              <button id="${product.id}" class="delete pull-right btn btn-default right-btn">
                    <span class="glyphicon glyphicon-trash" aria-hidden="true"></span> Delete 
              </button>
            </div>
          </div>
        </div>
      </div>
    </c:forEach>
  </div>
</div>

<input id="contextPath" type="hidden" value="${pageContext.request.contextPath}" />
<!-- Main page script -->
<script src=<c:url value="/static/js/basket/basket.js" />></script>
