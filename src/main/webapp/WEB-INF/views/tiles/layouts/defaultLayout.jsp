<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title><tiles:getAsString name="title" /></title>
	
	<!-- Bootstrap -->
	<link href="<c:url value='/static/bootstrap/css/bootstrap.min.css' />"  rel="stylesheet"></link>
	<link href="https://fonts.googleapis.com/css?family=Cookie"  rel="stylesheet" >
	
	<!-- Main CSS -->
	<link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
	
	 <!-- Modal window CSS -->
  <link href="<c:url value='/static/css/modalWindow.css'/>" rel="stylesheet"></link>
  
    <!-- Bootstrap Data table css-->
  <link href="<c:url value = "/static/js/bootstrap-dataTables/css/dataTables.bootstrap.min.css" />" rel="stylesheet">

	  <!-- jQuery -->
	<script src="<c:url value = "/static/js/jquery.min.js" />"></script>
	  <!-- Bootstrap JS -->
	<script src="<c:url value = "/static/bootstrap/js/bootstrap.min.js" />"></script>
	
		  <!-- Main JS -->
	<script src="<c:url value = "/static/js/main.js" />"></script>
	
	  <!-- Bootstrap Data table js-->
  <script src="<c:url value = "/static/js/bootstrap-dataTables/js/jquery.dataTables.min.js" />"></script>
  <script src="<c:url value = "/static/js/bootstrap-dataTables/js/dataTables.bootstrap.min.js" />"></script>
</head>
 
<body>
		<header id="header">
			<tiles:insertAttribute name="header" />
		</header>
	
		<section id="sidemenu">
<%-- 			<tiles:insertAttribute name="menu" /> --%>
		</section>
			
		<section id="site-content">
			<tiles:insertAttribute name="body" />
		</section>
		
		<footer id="footer">
			<tiles:insertAttribute name="footer" />
		</footer>
</body>
</html>