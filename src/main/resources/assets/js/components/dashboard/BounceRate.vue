<template>
   <!-- small box -->
          <div class="small-box bg-green">
            <div class="inner">
              <h3>{{count}}<sup style="font-size: 20px">%</sup></h3>

              <p>Bounce Rate</p>
            </div>
            <div class="icon">
              <i class="ion ion-stats-bars"></i>
            </div>
            <a href="#" class="small-box-footer">More info <i class="fa fa-arrow-circle-right"></i></a>
          </div>
</template>

<script>
  export default{
	  data(){
		  return {
			  count: 53,
		  }
	  },
	  mounted(){
	    console.log('Component mounted.') 
	  }
  }
</script>