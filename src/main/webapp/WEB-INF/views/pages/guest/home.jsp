<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%> 


<input id="contextPath" type="hidden" value="${pageContext.request.contextPath}" />
<!-- Main page script -->

<!-- Homepage Slider -->
<div class="homepage-slider">
  <div id="sequence">
    <ul class="sequence-canvas">
      <c:forEach items="${banners}" var="banner">
        <li class="bg4">
          <h2 class="title">${banner.title}</h2>
          <h3 class="subtitle">${banner.subtitle}</h3>
          <img class="slide-img" src=<c:url value="/bannerInfo/${banner.id}/image" /> alt="Slide 1" />
        </li>
      </c:forEach>
    </ul>
    <div class="sequence-pagination-wrapper">
      <ul class="sequence-pagination">
        <c:set var="iter" value="${1}" />
        <c:forEach items="${banners}" var="banner">
          <li>${iter}</li>
          <c:set var="iter" value="${iter + 1}" />
        </c:forEach>
      </ul>
    </div>
  </div>
</div>
<!-- End Homepage Slider -->

<!-- Press Coverage -->
<div class="section">
  <div class="container">
    <div class="row">
      <div class="col-md-4 col-sm-6">
        <div class="in-press press-wired">
          <a href="#">Morbi eleifend congue elit nec sagittis. Praesent aliquam lobortis tellus, nec consequat vitae</a>
        </div>
      </div>
      <div class="col-md-4 col-sm-6">
        <div class="in-press press-mashable">
          <a href="#">Morbi eleifend congue elit nec sagittis. Praesent aliquam lobortis tellus, nec consequat vitae</a>
        </div>
      </div>
      <div class="col-md-4 col-sm-6">
        <div class="in-press press-techcrunch">
          <a href="#">Morbi eleifend congue elit nec sagittis. Praesent aliquam lobortis tellus, nec consequat vitae</a>
        </div>
      </div>
    </div>
  </div>
</div>
<!-- Press Coverage -->

<!-- Services -->
<div class="section">
  <div class="container">
    <div class="row">
      <div class="col-md-4 col-sm-6">
        <div class="service-wrapper">
          <img src="static/img/service-icon/diamond.png" alt="Service 1">
          <h3>Aliquam in adipiscing</h3>
          <p>Praesent rhoncus mauris ac sollicitudin vehicula. Nam fringilla turpis turpis, at posuere turpis aliquet sit amet condimentum</p>
          <a href="#" class="btn">Read more</a>
        </div>
      </div>
      <div class="col-md-4 col-sm-6">
        <div class="service-wrapper">
          <img src="static/img/service-icon/ruler.png" alt="Service 2">
          <h3>Curabitur mollis</h3>
          <p>Suspendisse eget libero mi. Fusce ligula orci, vulputate nec elit ultrices, ornare faucibus orci. Aenean lectus sapien, vehicula</p>
          <a href="#" class="btn">Read more</a>
        </div>
      </div>
      <div class="col-md-4 col-sm-6">
        <div class="service-wrapper">
          <img src="static/img/service-icon/box.png" alt="Service 3">
          <h3>Vivamus mattis</h3>
          <p>Phasellus posuere et nisl ac commodo. Nulla facilisi. Sed tincidunt bibendum cursus. Aenean vulputate aliquam risus rutrum scelerisque</p>
          <a href="#" class="btn">Read more</a>
        </div>
      </div>
    </div>
  </div>
</div>
<!-- End Services -->

<div class="container">
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
              <button id="${product.id}" class="addTobakset btn btn-primary right-btn">
                    <span class="glyphicon glyphicon-shopping-cart" aria-hidden="true"></span> Add to Cart
                  </button>
            </div>
          </div>
        </div>
      </div>
    </c:forEach>
  </div>
</div>


  <!-- Template JS -->
<script src="<c:url value = "/static/js/template.js" />"></script>
<script src=<c:url value="/static/js/basket/basket.js" />></script>
