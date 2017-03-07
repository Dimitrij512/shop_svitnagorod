<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<div class="container">
  <h2>Замовлення</h2>
  <p><strong>Нотатка:</strong> Інформація про замовлення :</p>
  <div class="panel-group" id="accordion">
  <c:forEach items="${orders}" var="order">
    <div class="panel panel-default">
      <div class="panel-heading">
        <h4 class="panel-title">
          <a data-toggle="collapse" data-parent="#accordion" href="#order${order.id}">${order.timestamp}</a>
        </h4>
      </div>
      <div id= "order${order.id}" class="panel-collapse collapse in">
        <div class="panel-body">
         Information of order : <c:out value="${order.name}"></c:out> - 
               <c:out value="${order.adress}"></c:out> - <c:out value="${order.email}"></c:out> - <c:out value="${order.phone}"></c:out>
        	 
        	 <c:forEach items="${order.orderDetails}" var="orderDetails">
        	  <img alt="" style="width: 50px; height: 50px;" src=<c:url value="/productInfo/${orderDetails.product.id}/image"/>>
             	Product : <c:out value="${orderDetails.product.name}"></c:out>
             	Price : <c:out value="${orderDetails.product.price}"></c:out>
             	Count : <c:out value="${orderDetails.count}"></c:out>
             </c:forEach>
        </div>
      </div>
    </div>
     </c:forEach>
  </div> 
</div>
<input id="contextPath" type="hidden" value="${pageContext.request.contextPath}" />
    