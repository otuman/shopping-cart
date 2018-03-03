 <%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@ page isELIgnored="false"%>
 <jsp:include page ="../../header.jsp" flush = "true" /> 
   
   <!-- Content Header (Page header) -->
    <section class="content-header">
      <h1>${ title } <small>Control panel</small></h1>
      <ol class="breadcrumb">
        <li><a href="<c:url value='/dashboard'></c:url>"><i class="fa fa-dashboard"></i> Dashboard</a></li>
        <li class="active">${title}</li>
      </ol>
       <hr>
    </section>
   
    <!-- Main content -->
    <section class="content">
     
    </section>
    <!-- /.content -->
<jsp:include page = "../../footer-scripts.jsp" flush = "true" />  
<jsp:include page = "../../../footer.jsp" flush = "true" />    