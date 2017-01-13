<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<div class="">
  <div class="">
    <div class="">
      <div class="">
        <c:if test="${succes==true}">
          <div class="">
            <div class="">
              <p><strong> You has entered to system! </strong></p>
              <p><a href=<c:url value="/logout" /> class=""> Logout </a></p>
            </div>
          </div>
        </c:if>

        <c:if test="${succes!=true}">
          <div class="">
            <div class="">
              <h3>Enter to system please</h3>
            </div>
            <c:if test="${not empty param.error}">
              <div class="">
                <strong>Wrong login or password!</strong>
              </div>
            </c:if>

            <form role="" action="${pageContext.request.contextPath}/login" method="POST">
              <fieldset>
                <input class="" name="login" placeholder="Enter your login" autofocus required>
                <input class="" type="password" name="password" placeholder="enter your password" required>
                <input type="submit" class="" value="Log in" />
              </fieldset>
            </form>
            <nav><a href="${pageContext.request.contextPath}/registration">Registraton</a></nav>
          </div>
        </c:if>
      </div>
    </div>
  </div>
</div>