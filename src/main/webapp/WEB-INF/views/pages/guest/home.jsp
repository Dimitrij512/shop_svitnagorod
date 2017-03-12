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


<div class="section">
  <div class="container">
    <h2>Групи товарів</h2>
    <div class="row">
      <c:forEach items="${categoryes}" var="category">
        <div class="col-md-4 col-sm-6">
          <div class="portfolio-item">
            <div class="portfolio-image">
              <a href="page-portfolio-item.html"><img alt="alter name" style="width: 500px; height: 200px;" src=<c:url value="/categoryInfo/${category.id}/image" />></a>
            </div>
            <div class="portfolio-info">
              <ul>
                <li class="portfolio-project-name">
                  <c:out value="${category.name}" />
                </li>
                <li class="read-more"><a href="page-portfolio-item.html" class="btn">Подивитись</a></li>
              </ul>
            </div>
          </div>
        </div>
      </c:forEach>
    </div>
  </div>
</div>

<!-- Press Coverage -->

<div class="section">
  <div class="container">
    <div class="row">
      <div class="col-md-4 col-sm-6">
        <div class="service-wrapper">
          <img src="static/img/service-icon/diamond.png" alt="Service 1">
          <h3>Aliquam in adipiscing</h3>
          <p>Praesent rhoncus mauris ac sollicitudin vehicula. Nam fringilla turpis turpis, at posuere turpis aliquet sit amet condimentum
          </p>
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

<div class="section">
  <div class="container">
  <h2>Наші продукти</h2>
    <div class="row">
      <div class="col-md-12">
        <div class="products-slider">
          <c:forEach items="${products}" var="product">
            <div class="shop-item">
              <!-- Product Image -->
              <div class="image">
                <a href=""><img alt="alter name" src=<c:url value="/productInfo/${product.id}/image" />></a>
              </div>
              <!-- Product Title -->
              <div class="title">
                <h3>
                  <a href="">
                    <c:out value="${product.name}" />
                  </a>
                </h3>
              </div>
              <!-- Product Price -->
              <div class="price">
                <c:out value="${product.price}" /> грн.
              </div>
              <!-- ADD TO SHOPPING CART BUTTON -->
              <div class="actions">
                <button id="${product.id}" class="addTobakset btn btn-small">
                    <span class="glyphicon glyphicon-shopping-cart" aria-hidden="true"></span> в корзину
                  </button>
              </div>
            </div>
          </c:forEach>
        </div>
      </div>
    </div>
  </div>
</div>
  <!-- Template JS -->
<script src="<c:url value = "/static/js/template.js" />"></script>
<script src=<c:url value="/static/js/basket/basket.js" />></script>
