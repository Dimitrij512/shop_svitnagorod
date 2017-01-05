<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML>
<html>

<body>
  <div class="">
    <div class="">
      <div class="">
        <h1>
          <a href="#">Wrong</a>
		</h1>
      </div>
    </div>
    <div class="">
      <p>
        ERROR
      </p>
      <a href="#" onclick="window.history.back();">Return</a>
      <a href=<c:url value="/guest/" />>Start page</a>
    </div>
  </div>
</body>

</html>