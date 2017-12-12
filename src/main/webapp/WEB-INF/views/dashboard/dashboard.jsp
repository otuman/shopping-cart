  <jsp:include page = "../header.jsp" flush = "true" /> 
      <div class="starter-template">
	      <div class="row">
			<div class="col-sm-6 col-md-4 col-md-offset-4">
					<div class="panel panel-default">
						<div class="panel-heading">
							<strong> You are Logged In</strong>
						</div>
						<div class="panel-body">
						<h2> Hello, ${username}</h2>
						<div class="alert alert-success" role="alert">
						  ${message}
						</div>
					   </div>
				</div>
			</div>
		</div>
	</div>
<jsp:include page = "../footer.jsp" flush = "true" />  