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
      <div class="row">
        <div class="col-md-12">
          <div class="box">
            <div class="box-header">
              <h3 class="box-title">Hover Data Table</h3>
            </div>
            <!-- /.box-header -->
            <div class="box-body">
              <table id="table-products-category" class="table table-bordered table-hover">
                <thead>
		            <tr>
		                <th>Name</th>
		                <th>Description</th>
		                <th>Slug</th>
		                <th>Count</th>		                
		            </tr>
		        </thead>
		        <tfoot>
		            <tr>
		                <th>Name</th>
		                <th>Description</th>
		                <th>Slug</th>
		                <th>Count</th>		                
		            </tr>
		        </tfoot>
              </table>
            </div>
           </div>
           </div>
    
    
     
    </section>
    <!-- /.content -->
<jsp:include page = "../../../footer-scripts.jsp" flush = "true" />  

<!-- page script -->
<script>
  $(function () {
  
    $('#table-products-category').DataTable({
      'paging'      : true,
      'lengthChange': false,
      'searching'   : false,
      'ordering'    : true,
      'info'        : true,
      'autoWidth'   : false,
      "ajax": "<c:url value='/dashboard/products/categories/all'></c:url>",
      "columns": [
          { "data": "name" },
          { "data": "description" },
          { "data": "slug" },
          { "data": "count" }          
      ]
    })
  })
</script>

<jsp:include page = "../../../footer.jsp" flush = "true" />  