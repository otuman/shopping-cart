 <jsp:include page = "../header.jsp" flush = "true" /> 
      <div class="starter-template">
        <h1>Contact Us</h1>
        <form class="form-horizontal">
		<fieldset>
		
		<!-- Form Name -->
		<h3>CATEGORY</h3>
		
		<!-- Select Basic -->
		<div class="form-group">
		  <label class="col-md-4 control-label" for="category_name">CATEGORY NAME</label>
		  <div class="col-md-4">
		    <select id="category_name" name="category_name" class="form-control">
		    </select>
		  </div>
		</div>
		
		<!-- Select Basic -->
		<div class="form-group">
		  <label class="col-md-4 control-label" for="category_name_fr">CATEGORY NAME FR</label>
		  <div class="col-md-4">
		    <select id="category_name_fr" name="category_name_fr" class="form-control">
		    </select>
		  </div>
		</div>
		
		<!-- Text input-->
		<div class="form-group">
		  <label class="col-md-4 control-label" for="add_date">ADD DATE</label>  
		  <div class="col-md-4">
		  <input id="add_date" name="add_date" placeholder="ADD DATE" class="form-control input-md" required="" type="text">
		    
		  </div>
		</div>
		
		<!-- Text input-->
		<div class="form-group">
		  <label class="col-md-4 control-label" for="add_by">ADD BY</label>  
		  <div class="col-md-4">
		  <input id="add_by" name="add_by" placeholder="ADD BY" class="form-control input-md" required="" type="text">
		    
		  </div>
		</div>
		
		<!-- Text input-->
		<div class="form-group">
		  <label class="col-md-4 control-label" for="modification_date">MODIFICATION DATE</label>  
		  <div class="col-md-4">
		  <input id="modification_date" name="modification_date" placeholder="MODIFICATION DATE" class="form-control input-md" required="" type="text">
		    
		  </div>
		</div>
		
		<!-- Button -->
		<div class="form-group">
		  <label class="col-md-4 control-label" for=""></label>
		  <div class="col-md-4">
		    <button id="" name="" class="btn btn-primary">Submit</button>
		  </div>
		</div>
		
		</fieldset>
		</form>
      </div>
<jsp:include page = "../footer-scripts.jsp" flush = "true" />  
<jsp:include page = "../footer.jsp" flush = "true" />  
   