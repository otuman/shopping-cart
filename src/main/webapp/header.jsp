<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>Jerotoma | ${title}</title>

    <!-- Bootstrap core CSS -->
    <link href="<%=request.getContextPath()%>/resources/vendors/bootstrap/css/bootstrap.min.css" rel="stylesheet">
   <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
    <link href="<%=request.getContextPath()%>/resources/css/jerotoma.min.css" rel="stylesheet">   
    
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
		            <li class="active"><a href="<%=request.getContextPath()%>">Home</a></li>
		            <li><a href="<%=request.getContextPath()%>/shop/products">Products</a></li>
		            <li><a href="<%=request.getContextPath()%>/about">About</a></li>
		            <li><a href="<%=request.getContextPath()%>/contact">Contact</a></li>
		          </ul>
		          <form class="navbar-form navbar-left">
			        <div class="form-group">
			          <input type="text" class="form-control" placeholder="Search">
			        </div>
			     </form>
			      <ul class="nav navbar-nav navbar-right">
			        <li><a href="<%=request.getContextPath()%>/cart/show"><i class="fa fa-shopping-cart fa-w" aria-hidden="true"></i> Cart <span class="badge">5</span></a></li>
			        <li><a href="<%=request.getContextPath()%>/checkout/show"><i class="fa fa-heart-o" aria-hidden="true"></i> Wishlist <span class="badge">5</span></a></li>
			        <li class="dropdown">
			          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">My Account<span class="caret"></span></a>
			          <ul class="dropdown-menu">
			            <li><a href="<%=request.getContextPath()%>/myaccount/login">Login</a></li>
			            <li><a href="<%=request.getContextPath()%>/myaccount/create">Register</a></li>
			            <li><a href="<%=request.getContextPath()%>/myaccount/support">Support</a></li>				           
			          </ul>
			        </li>
			      </ul>
		        </div><!--/.nav-collapse -->
		      </div>
		    </nav>
	   <div class="container">