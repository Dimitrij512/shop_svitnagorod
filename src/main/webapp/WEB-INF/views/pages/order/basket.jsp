<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%> 

     <!-- Page Title -->
<div class="section section-breadcrumbs">
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<h1>Корзина покупок</h1>
			</div>
		</div>
	</div>
</div>
      
      <div class="section">
   	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<!-- Action Buttons -->
			<div class="pull-right">
				<a href="${pageContext.request.contextPath}/getOrder" class="btn"><i class="glyphicon glyphicon-shopping-cart icon-white"></i> Оформити замовлення</a>
			</div>
		</div>
	</div>
	<div class="row">

		<div class="col-md-12">
			<!-- Shopping Cart Items -->
			<table class="shopping-cart">
			  <c:set var="summOrder" value="${0}" />
    <c:forEach items="${products}" var="product">
    <c:set var="summOrder" value="${summOrder + product.price}" />
    
				<!-- Shopping Cart Item -->
				<tr>
					<!-- Shopping Cart Item Image -->
					<td class="image"><a href=""> <img alt="" style="width: 90px; height: 90px;" src=<c:url value="/productInfo/${product.id}/image"
            />></a></td>
					<!-- Shopping Cart Item Description & Features -->
					<td>
						<div class="cart-item-title"><a href=""><c:out value="${product.name}" /></a></div>
					</td>
					<!-- Shopping Cart Item Quantity -->
					<td class="quantity">
						<input id = "${product.id}price" type="hidden" value="${product.price}">
						<input id = "${product.id}" class="form-control input-sm input-micro numberProducts" type="number" value="1">
					</td>
					<!-- Shopping Cart Item Price -->
					<td class="price"><input id="${product.id}summ" class="price form-control input-sm input-micro" type="text" value="${product.price}" readonly="readonly"></td>
					<!-- Shopping Cart Item Actions -->
					<td class="actions">
						<a class="btn btn-xs btn-grey delete" id="${product.id}"><i class="glyphicon glyphicon-trash"></i></a>
					</td>
				</tr>
		 </c:forEach>
			</table>
			<!-- End Shopping Cart Items -->
		</div>
	</div>
	<div class="row">
		<!-- Promotion Code -->
		<div class="col-md-4  col-md-offset-0 col-sm-6 col-sm-offset-6">
			<div class="cart-promo-code">
				<div class="input-group">
					<span class="input-group-btn">
					</span>
				</div>
			</div>
		</div>
		<!-- Shipment Options -->
		<div class="col-md-4 col-md-offset-0 col-sm-6 col-sm-offset-6">
			<div class="cart-shippment-options">
				<div class="input-append">
				</div>
			</div>
		</div>
		
		<!-- Shopping Cart Totals -->
		<div class="col-md-4 col-md-offset-0 col-sm-6 col-sm-offset-6">
			<table class="cart-totals">
				<tr>
				</tr>
				<tr class="cart-grand-total">
					<td><b>Загальна сума</b></td>
					<td><b><input id="orderSumm" class = " price input-sm input-micro" type="text" value="${summOrder}" readonly="readonly"></b></td>
				</tr>
			</table>
			<!-- Action Buttons -->
				<div class="pull-right">
					<a href="${pageContext.request.contextPath}/getOrder" class="btn"><i class="glyphicon glyphicon-shopping-cart icon-white"></i> Оформити замовлення</a>
				</div>
			</div>
		</div>
	</div>
</div>

<input id="contextPath" type="hidden" value="${pageContext.request.contextPath}" />
<!-- Main page script -->
<script src=<c:url value="/static/js/basket/basket.js" />></script>
