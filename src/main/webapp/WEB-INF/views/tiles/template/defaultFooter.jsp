<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<!-- Footer -->
<div class="footer">
  <div class="container">
    <div class="row">
      <div class="col-footer col-md-3 col-xs-6">
        <h3>Our Latest Work</h3>
        <div class="portfolio-item">
          <div class="portfolio-image">
          <c:set var="context" value="${pageContext.request.contextPath}" />
            <a href=""><img src="${context}\static\img\photoFooter.jpg" alt="Project Name"></a>
          </div>
        </div>
      </div>
      <div class="col-footer col-md-3 col-xs-6">
        <h3>Navigate</h3>
        <ul class="no-list-style footer-navigate-section">
          <li><a href="page-blog-posts.html">Blog</a></li>
          <li><a href="page-portfolio-3-columns-2.html">Portfolio</a></li>
          <li><a href="page-products-3-columns.html">eShop</a></li>
          <li><a href="page-services-3-columns.html">Services</a></li>
          <li><a href="page-pricing.html">Pricing</a></li>
          <li><a href="page-faq.html">FAQ</a></li>
        </ul>
      </div>

      <div class="col-footer col-md-4 col-xs-6">
        <h3>Contacts</h3>
        <p class="contact-us-details">
          <b>Address:</b> 123 Fake Street, LN1 2ST, London, United Kingdom<br/>
          <b>Phone:</b> +44 123 654321<br/>
          <b>Fax:</b> +44 123 654321<br/>
          <b>Email:</b> <a href="mailto:getintoutch@yourcompanydomain.com">getintoutch@yourcompanydomain.com</a>
        </p>
      </div>
      <div class="col-footer col-md-2 col-xs-6">
        <h3>Stay Connected</h3>
        <ul class="footer-stay-connected no-list-style">
          <li>
            <a href="#" class="facebook"></a>
          </li>
          <li>
            <a href="#" class="twitter"></a>
          </li>
          <li>
            <a href="#" class="googleplus"></a>
          </li>
        </ul>
      </div>
    </div>
    <div class="row">
      <div class="col-md-12">
        <div class="footer-copyright">&copy; 2017 mPurpose. All rights reserved.</div>
      </div>
    </div>
  </div>
</div>