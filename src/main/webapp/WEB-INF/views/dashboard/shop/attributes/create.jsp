   <div class="form-group">
	  <label for="name">Name: <span class="field-required">*</span></label>
	  <input type="text" class="form-control" id="name" name="name" required>
	  <span class="mute">The name is how it appears on your site.</span>
	</div>
	<div class="form-group">
	  <label for="slug">Slug: <span class="field-required">*</span></label>
	  <input type="text" class="form-control" id="name" name="slug" required>
	  <span class="mute">The "slug" is the URL-friendly version of the name. It is usually all lowercase and contains only letters, numbers, and hyphens.</span>
	</div>
	<div class="form-group">
	  <label for="description">Description:</label>
	  <textarea class="form-control" rows="2" id="description" name="description"></textarea>
	   <span class="mute">The description is not prominent by default; however, some themes may show it.</span>
	</div> <!-- <attribute-create></attribute-create>  --> 
	<div class="form-group">
	  <label for="parent">Parent Attribute: <span class="field-required">*</span></label>
	  <select class="form-control" id="parent" name="parent" required>
	    <option value="1">None</option>
	    <option value="4">2</option>
	    <option value="8">3</option>
	    <option value="3">4</option>
	  </select>
	   <span class="mute">Assign a parent term to create a hierarchy. The term Jazz, for example, would be the parent of Bebop and Big Band.</span>
	</div>
	<div class="form-group">               
      <div class="col-md-6 col-md-offset-3">
            <div class="alert alert-warning" style="display:none;">
			  <strong>Warning!</strong> <span></span>.
		</div>    
       </div>	           
   </div>
