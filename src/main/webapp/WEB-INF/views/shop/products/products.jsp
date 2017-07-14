<jsp:include page = "/header.jsp" flush = "true" /> 
      <div class="starter-template">
        <h1>Product</h1> 
        <div class="row"> 
              <div class="col-md-12">
                <div class="card" style="width: 20rem;">
				  <img class="card-img-top" src="" alt="Card image cap">
				  <div class="card-block">
				    <h4 class="card-title">Card title</h4>
				    <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
				    <a href="<%=request.getContextPath()%>/shop/products/tomatos" class="btn btn-primary">Go somewhere</a>
				  </div>
				</div>
              </div>
        </div>
      </div>
<jsp:include page = "/footer.jsp" flush = "true" /> 