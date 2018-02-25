<template>
   <!-- small box -->
          <div class="small-box bg-aqua"> 
            <div class="inner">
              <h3>{{count}}</h3>
              <p>New Orders</p>
            </div>
            <div class="icon">
              <i class="ion ion-bag"></i>
            </div>
            <a href="#" class="small-box-footer">More info <i class="fa fa-arrow-circle-right"></i></a>
           </div>
</template>

<script>
  export default{
	  data(){
		  return {
			  count: 150,
		  }
	  },
	  mounted(){
	    console.log('Component mounted.') 
	  }
  }
</script>