<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%> 


<%-- <link href="<c:url value='/static/css/registration.css' />" rel="stylesheet"></link> --%>

<div class="container-fluid">
	 <form:form action="" method="POST" modelAttribute="registration" class=""> 
      <div class="row">      
           <div class="col-md-3 col-sm-3 col-lg-3">
              <label for="name">NAME</label>
               <form:input name="name" path="name" class="form-control" type="text"/>    
           </div>            
      </div>
      <div class="row">      
           <div class="col-md-3 col-sm-3 col-lg-3">
              <label for="surname">SURNAME</label>
               <form:input name="surname" path="surname" class="form-control" type="text"/>    
           </div>            
      </div>
      <div class="row">
           <div class="col-md-3 col-sm-3 col-lg-3">
              <label for="email">LOGIN</label>
               <form:input name="email" path="login" class="form-control"/>             
           </div>            
      </div>
      <div class="row">
           <div class="col-md-3 col-sm-3 col-lg-3">
              <label for="password">PASSWORD</label>
               <form:input name="password" path="password" class="form-control" type="password"/>             
           </div>            
      </div>
      <hr>
	      <div class="row">
	          <div class="col-md-6 col-sm-6 col-xs-6 col-lg-6">
	           <button type = "submit" class="btn btn-default logbutton">Sign up</button>           
	          </div>          
	      </div>  
    </form:form>
</div>