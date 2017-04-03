<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<input id="contextPath" type="hidden" value="${pageContext.request.contextPath}" />

<!-- Page Title -->
<div class="section section-breadcrumbs">
  <div class="container">
    <div class="row">
      <div class="col-md-12">
        <h1>${product.name}</h1>
      </div>
    </div>
  </div>
</div>

<div class="section">
  <div class="container">
    <div class="row">
      <div class="col-sm-6">
        <div class="product-image-large">
          <img src=<c:url value="/productInfo/${product.id}/image" /> alt="назва">
        </div>
      </div>
      <div class="col-sm-6 product-details">
        <h4>${product.name}</h4>
        <div class="price">
          <span></span> ${product.price} грн.
        </div>
        <h5>Опис</h5>
        <p>
          ${product.description}
        </p>
        <table class="shop-item-selections">
          <tr>
            <td>&nbsp;</td>
            <td>
              <button id="${product.id}" class="addTobakset btn btn-small">
                    <span class="glyphicon glyphicon-shopping-cart" aria-hidden="true"></span> в корзину
                  </button>
            </td>
          </tr>
        </table>
      </div>
    </div>
  </div>
</div>
<script src=<c:url value="/static/js/basket/basket.js" />></script>