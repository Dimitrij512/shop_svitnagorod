
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>

<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">

  <title>
    <tiles:getAsString name="title" />
  </title>

  <!-- Bootstrap -->
  <link href="<c:url value='/static/bootstrap/css/bootstrap.min.css' />" rel="stylesheet"></link>
  <link href="<c:url value='/static/css/social/icomoon-social.css' />" rel="stylesheet"></link>
  <link href='http://fonts.googleapis.com/css?family=Open+Sans:400,700,600,800' rel='stylesheet' type='text/css'>
  <link href="<c:url value='/static/css/leaflet.css' />" rel="stylesheet"></link>
  <!-- Main CSS
	<link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
	 -->
  <link href="<c:url value='/static/css/main.css' />" rel="stylesheet"></link>

  <script src="<c:url value = "/static/js/modernizr-2.6.2-respond-1.1.0.min.js " />"></script>

  <!-- Modal window CSS -->
  <link href="<c:url value='/static/css/modalWindow.css'/>" rel="stylesheet"></link>

  <!-- Bootstrap Data table css-->
  <link href="<c:url value = "/static/js/bootstrap-dataTables/css/dataTables.bootstrap.min.css" />" rel="stylesheet">

  <!-- jQuery -->

  <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
  <script>
    window.jQuery || document.write('<script src="/static/js/jquery.min.js"><\/script>')
  </script>
    <!-- Bootstrap JS -->
    <script src="<c:url value = "/static/bootstrap/js/bootstrap.min.js " />"></script>

    <script src="http://cdn.leafletjs.com/leaflet-0.5.1/leaflet.js"></script>

    <script src="<c:url value = "/static/js/jquery.fitvids.js " />"></script>
    <script src="<c:url value = "/static/js/jquery.sequence-min.js " />"></script>
    <script src="<c:url value = "/static/js/jquery.bxslider.js " />"></script>

    <script src="<c:url value = "/static/js/jquery.bxslider.js " />"></script>

    <!-- WebSocket JS -->
    <script src="<c:url value = "/static/js/web_socket/sockjs.min.js " />"></script>
    <script src="<c:url value = "/static/js/web_socket/stomp.min.js " />"></script>

<!--     Main JS -->
	<script src="<c:url value = "/static/js/main.js" />"></script> 


	 
    <!-- Bootstrap Data table js-->
    <script src="<c:url value = "/static/js/bootstrap-dataTables/js/jquery.dataTables.min.js " />"></script>
    <script src="<c:url value = "/static/js/bootstrap-dataTables/js/dataTables.bootstrap.min.js " />"></script>
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