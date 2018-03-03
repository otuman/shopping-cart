 <template>
	<div class="row">
	  <div class="col-md-12">
	     <div class="form-group">
		  <label for="usr">Name:</label>
		  <input type="text" class="form-control" id="usr">
		</div>
		<div class="form-group">
		  <label for="pwd">Password:</label>
		  <input type="password" class="form-control" id="pwd">
		</div>
	  </div>
	</div>
 </template>
 <script>
    export default{
    	data(){
    		return {
    			items:[],
    		}
    	},
    	mounted(){
    		console.log("created in attribute");
    	}
    }
 
 </script>