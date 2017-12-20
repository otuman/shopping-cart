<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<c:url var='contextPath' value='/'></c:url>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <sec:csrfMetaTags/>
    <meta charset="utf-8">    
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>Jerotoma | ${title}</title>

    <!-- Bootstrap core CSS -->
    <link href="${contextPath}resources/vendors/bootstrap/css/bootstrap.min.css" rel="stylesheet">
   <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
    <link href="${contextPath}resources/css/jerotoma.min.css" rel="stylesheet">   
    
  </head>
  <body>
		<nav class="navbar navbar-default navbar-fixed-top">
		      <div class="container">
		        <div class="navbar-header">
		          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
		            <span class="sr-only">Toggle navigation</span>
		            <span class="icon-bar"></span>
		            <span class="icon-bar"></span>
		            <span class="icon-bar"></span>
		          </button>
		          <a class="navbar-brand" href="<%=request.getContextPath()%>">Jerotoma</a>
		        </div>
		        <div id="navbar" class="collapse navbar-collapse">
		         
		          <ul class="nav navbar-nav">
		            <li class="active"><a href="${contextPath}">Home</a></li>
		            <li><a href="${contextPath}shop/products">Products</a></li>
		            <li><a href="${contextPath}about">About</a></li>
		            <li><a href="${contextPath}contact">Contact</a></li>
		          </ul>
		          <form class="navbar-form navbar-left">
			        <div class="form-group">
			          <input type="text" value="" class="form-control" placeholder="Search">
			        </div>
			     </form>
			      <ul class="nav navbar-nav navbar-right">
			        <li><a href="${contextPath}cart/show"><i class="fa fa-shopping-cart fa-w" aria-hidden="true"></i> Cart <span class="badge">5</span></a></li>
			        <li><a href="${contextPath}checkout/show"><i class="fa fa-heart-o" aria-hidden="true"></i> Wishlist <span class="badge">5</span></a></li>
			        <sec:authorize access="isAuthenticated()">
						<!-- <sec:authentication property="principal.username" />  -->
						<li><a href="${contextPath}dashboard">Dashboard</a></li>		    
				    </sec:authorize>
				    <sec:authorize access="isAnonymous()">
								 <li class="dropdown">
						          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">My Account <span class="caret"></span></a>
						          <ul class="dropdown-menu">
						            <li><a href="${contextPath}myaccount/login">Login</a></li>
						            <li><a href="${contextPath}myaccount/create">Register</a></li>
						            <li><a href="${contextPath}myaccount/support">Support</a></li>				           
						          </ul>
						        </li>
					</sec:authorize>			        
			      </ul>
		        </div><!-- /.navbar-collapse -->
               </div><!-- /.container -->
		    </nav>
		   <div class="container">
	  