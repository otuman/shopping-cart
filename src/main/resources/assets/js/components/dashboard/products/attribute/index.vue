<template>
	<div class="row">
	  <div class="col-md-12">
		   
	  </div>
	</div>
 </template>
 <script>
    export default{
    	props:['columns','sortKey', 'sortOrders'],
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