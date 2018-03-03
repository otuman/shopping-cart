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
              <h3 class="box-title">Hover Data Table</h3><button class="btn btn-primary btn-sm pull-right" data-toggle="modal" data-target="#add-product-attribute">Add New</button>
            </div>
            <!-- /.box-header -->
            <div class="box-body">
              <table id="table-products-attribute" class="table table-bordered table-hover">
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
      </div>
      <div class="row">
        <div class="col-md-12">
            <!-- Modal -->
			<div id="add-product-attribute" class="modal fade" role="dialog">
			  <div class="modal-dialog">
			     <!-- Modal content-->
			    <div class="modal-content">
			     <form role="form" name="f" id="attribute-create-form" action="<c:url value='/dashboard/products/attributes/create?${_csrf.parameterName}=${_csrf.token}'></c:url>" method="POST">
 			      <div class="modal-header bg-success">
			        <button type="button" class="close" data-dismiss="modal">&times;</button>
			        <h4 class="modal-title">Add New Attribute</h4>
			      </div>
			      <div class="modal-body">
			      <jsp:include page="create.jsp"></jsp:include> 			       
			      </div>
			      <div class="modal-footer">
			        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
			        <button type="submit" class="btn btn-success">Save</button>
			      </div>
			     </form>
			    </div>			
			  </div>
			</div>    
       </div>
      </div>      
    </section>
    <!-- /.content -->
<jsp:include page = "../../footer-scripts.jsp" flush = "true" />  
<!-- page script -->
<script>
  $(function () {
  
    var dataTable = $('#table-products-attribute').DataTable({
         processing: true,
         serverSide: true,
         searching: false,
         ajax : "<c:url value='/dashboard/products/attributes/all'></c:url>",
         columns: [
          { "data": "name" },
          { "data": "description"},
          { "data": "slug" },
          { "data": "count"}          
      ]
    });
 
   
    	
   var createForm = $('#attribute-create-form');  	  
   $("div.alert.alert-warning").hide();
  	
  	createForm.validate({
  		
  		invalidHandler: function(event, validator) {
  		    // 'this' refers to the form
  		    var errors = validator.numberOfInvalids();
  		    if (errors) {
  		      var message = errors == 1
  		        ? 'You missed 1 field. It has been highlighted'
  		        : 'You missed ' + errors + ' fields. They have been highlighted';
  		      $("div.alert.alert-warning span").html(message);
  		      showWarning();
  		    } else {
  		      $("div.alert.alert-warning").hide();
  		    }
  		},
  		submitHandler: function(form) {
  			var formData = createForm.serializeArray();
  			var url  = createForm.attr('action');
  			postData(formData, url, dataTable);  		  
  		}
  	});
  	/* This method posts form data to the server */
  	function postData(data, url, dataTable){
  		
  		console.log(data);
  		
  		$.ajax({
  			url: url,                  // Url to which the request is send
  			type: "POST",             // Type of request to be send, called as method
  			data: data,               // Data sent to server, a set of key/value pairs (i.e. form fields and values)
  			success:function(response){
  				dataTable.ajax.reload();
  				$("#add-product-attribute").modal('hide');
  				console.log(response);
  			},
  			error:function(status, xhr, xgr){
  				console.log(status);
  			}			
  		});		
  	}	
  	
  	/* This method displays warnings to the user */
  	function showWarning(){
  		 $("div.alert.alert-warning").show();
  		setTimeout(function(){ 
  			 $("div.alert.alert-warning").hide();
  			}, 4000);
  	}
  	
  })
</script>
<jsp:include page = "../../../footer.jsp" flush = "true" />  