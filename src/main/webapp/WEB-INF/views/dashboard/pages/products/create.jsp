 <%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@ page isELIgnored="false"%>
 <jsp:include page ="../../header.jsp" flush = "true" /> 
   
   <!-- Content Header (Page header) -->
    <section class="content-header">
      <h1>${ title } <small>${subtitle }</small></h1>
      <ol class="breadcrumb">
        <li><a href="<c:url value='/dashboard'></c:url>"><i class="fa fa-dashboard"></i> Dashboard</a></li>
        <li class="active">${title}</li>
      </ol>
       <hr>
    </section>
   
    <!-- Main content -->
    <section class="content">
         <div class="row">               
	         <div class="col-md-6"></div>	           
         </div>
      <form id="product-create-form" action="<c:url value='/dashboard/products/create'></c:url>" method="POST" enctype="multipart/form-data">
         <div class="row">
              <div class="col-md-6">	                    
				  <div class="form-group">
				    <label for="product-title">Product Title:</label>
				    <input type="text" name="product_title" class="form-control" id="product-title">
				  </div>
				  <div class="form-group">
				    <label for="product-price">Product Price:</label>
				    <input type="text" name="product_price" class="form-control" id="product-price">
				  </div>
				  <div class="form-group">
				    <label for="product-quantity">Product Quantity:</label>
				    <input type="number" name="product_quantity" class="form-control" id="product-quantity">
				  </div>
				  <div class="form-group">
					  <label for="product-description">Product Description:</label>
					  <textarea class="form-control" name="product_description" rows="5" id="product-description"></textarea>
				</div>				 				
              </div>
              <div class="col-md-6">
                  <div class="form-group">
				    <label for="product-categories">Product Category(s):</label>
				    <select multiple class="form-control" name="product_categories" id="product-categories">
					    <option>1</option>
					    <option>2</option>
					    <option>3</option>
					    <option>4</option>
					</select>
				  </div>
				   <div class="form-group">
				    <label for="product-attributes">Product Attribute(s):</label>
				    <select multiple class="form-control" name="product_attributes" id="product-attributes">
					    <option>1</option>
					    <option>2</option>
					    <option>3</option>
					    <option>4</option>
					</select>
				  </div>
				   <div class="form-group">
				    <label for="product-image">Product Image:</label>
				    <input type="file" name="product_image" class="form-control" id="product-image">
				  </div>
				  <div class="form-group">
				    <label for="product-image">Product Gallery:</label>
				    <input type="file"  multiple name="product_image" class="form-control" id="product-image">
				  </div>
              </div>	           
         </div>
         <div class="row">               
	         <div class="col-md-4 col-md-offset-4">
	             <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
	             <button type="submit" class="btn btn-success btn-block btn-lg">Create Product</button>
	         </div>	           
         </div>
       </form>
    </section>
    <!-- /.content -->
<jsp:include page = "../../footer.jsp" flush = "true" />  

<script type="text/javascript">
<!-- -->
  $(document).ready(function(){
	var createForm = $('#product-create-form');
		
	createForm.on('submit', function(){
		 
		var data = createForm.serializeArray();
		postData(data,createForm.attr('action'));
		
		return false;
	})
	
	
	
	
	function postData(data, url){
		
		$.ajax({
			method:'POST',
			url:url,
			data:data,
			success:function(response){
				console.log(response);
			},
			error:function(status, xhr, xgr){
				console.log(status);
			}
			
		});
		
	}
	
	  
  });


</script>

