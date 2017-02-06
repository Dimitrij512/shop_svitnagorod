<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%> 

<div class = "container">
  <div class="row">
    <c:forEach items="${products}" var="product">
    <div class="col-sm-3 col-lg-3 col-md-3">
      <div class="thumbnail">
        <div class="hover">
           <img alt="" style="width: 50px; height: 50px;" src=<c:url value="/productInfo/${product.id}/image" />>
           <div class="caption">
                  <h4 class="pull-right">
                    <c:out value="$ ${product.price}" />
                  </h4>
                   <h4>
                      <c:out value="${product.name}" />
                  </h4>
                  <button id="${product.id}" class="btn btn-primary right-btn">
                    <span class="glyphicon glyphicon-shopping-cart" aria-hidden="true"></span> Add to Cart
                  </button>
           </div>
        </div>
      </div>
    </div>
    </c:forEach>
  </div>
</div>