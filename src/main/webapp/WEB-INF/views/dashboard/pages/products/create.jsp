 <%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
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
      <form role="form" name="f" id="product-create-form" action="<c:url value='/dashboard/products/create'></c:url>" method="POST" enctype="multipart/form-data">
           <div class="row">
              <div class="col-md-6">	                    
				  <div class="form-group">
				    <label for="product-title">Product Title: <span class="field-required">*</span></label>
				    <input type="text" name="product_title" class="form-control" id="product-title" required>
				  </div>
				  <div class="form-group">
				    <label for="product-price">Product Price: <span class="field-required">*</span></label>
				    <input type="text" name="product_price" class="form-control" id="product-price" required >
				  </div>
				  <div class="form-group">
				    <label for="product-quantity">Product Quantity: <span class="field-required">*</span></label>
				    <input type="number" name="product_quantity" class="form-control" id="product-quantity" required>
				  </div>
				  <div class="form-group">
					  <label for="product-description">Product Description: <span class="field-required">*</span></label>
					  <textarea class="form-control" name="product_description" rows="5" id="product-description" required></textarea>
				</div>				 				
              </div>
              <div class="col-md-6">
                  <div class="form-group">
				    <label for="product-categories">Product Category(s): <span class="field-required">*</span></label>
				    <select multiple class="form-control" name="product_categories" id="product-categories" required>
					    <option>1</option>
					    <option>2</option>
					    <option>3</option>
					    <option>4</option>
					</select>
				  </div>
				   <div class="form-group">
				    <label for="product-attributes">Product Attribute(s): <span class="field-required">*</span></label>
				    <select multiple class="form-control" name="product_attributes" id="product-attributes" required>
					    <option>1</option>
					    <option>2</option>
					    <option>3</option>
					    <option>4</option>
					</select>
				  </div>
				   <div class="form-group">
				    <label for="product-image">Product Image:<span class="field-required">*</span></label>
				    <input type="file" name="product_image" class="form-control" id="product-image">
				  </div>
				  <div class="form-group">
				    <label for="product-image">Product Gallery:</span></label>
				    <input type="file"  multiple name="product_image" class="form-control" id="product-image">
				  </div>
              </div>	           
         </div>
         <div class="row">               
	         <div class="col-md-4 col-md-offset-4">
	             <sec:csrfInput />
	             <input type="submit" class="btn btn-success btn-block btn-lg" value="Create Product" />
	         </div>	           
         </div>
       </form>
    </section>
    <!-- /.content -->
<jsp:include page = "../../footer.jsp" flush = "true" />  

<script>
<!-- -->
  $(document).ready(function(){
	var createForm = $('#product-create-form');
	createForm.validate();	
	createForm.on('submit', function(e){
		 
		var data = $(this).serializeArray(),
		    url  = $(this).attr('action');
		postData(data,url);
		
		return false;
	});	
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

