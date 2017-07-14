<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>Starter Template for Bootstrap</title>

    <!-- Bootstrap core CSS -->
    <link href="<%=request.getContextPath()%>/resources/vendors/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="<%=request.getContextPath()%>/resources/css/jerotoma.min.css" rel="stylesheet">   
    
  </head>
  <body>
		<nav class="navbar navbar-inverse navbar-fixed-top">
		      <div class="container">
		        <div class="navbar-header">
		          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
		            <span class="sr-only">Toggle navigation</span>
		            <span class="icon-bar"></span>
		            <span class="icon-bar"></span>
		            <span class="icon-bar"></span>
		          </button>
		          <a class="navbar-brand" href="<%=request.getContextPath()%>">Project name</a>
		        </div>
		        <div id="navbar" class="collapse navbar-collapse">
		          <ul class="nav navbar-nav">
		            <li class="active"><a href="<%=request.getContextPath()%>">Home</a></li>
		            <li><a href="<%=request.getContextPath()%>/shop/products">Products</a></li>
		            <li><a href="<%=request.getContextPath()%>/about">About</a></li>
		            <li><a href="<%=request.getContextPath()%>/contact">Contact</a></li>
		          </ul>
		        </div><!--/.nav-collapse -->
		      </div>
		    </nav>
	   <div class="container">