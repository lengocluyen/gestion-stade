<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- Buttons -->
<div class="panel-box">
	<div class="titles">
		<h4>Buttons</h4>
	</div>
	<div class="row">
		<div class="col-md-6">
			<h2>Buttons</h2>

			<button type="button" class="btn btn-default">Default</button>

			<button type="button" class="btn btn-primary">Primary</button>

			<button type="button" class="btn btn-success">Success</button>

			<button type="button" class="btn btn-info">Info</button>

			<button type="button" class="btn btn-warning">Warning</button>

			<button type="button" class="btn btn-danger">Danger</button>

			<button type="button" class="btn btn-link">Link</button>

			<h2 class="spaced padding-top-mini">Buttons Disabled</h2>

			<button type="button" class="btn btn-lg btn-primary"
				disabled="disabled">Primary button</button>
			<button type="button" class="btn btn-default btn-lg"
				disabled="disabled">Button</button>

		</div>

		<div class="col-md-6">
			<h2>Buttons Sizes</h2>

			<p>
				<button type="button" class="btn btn-primary btn-lg">Large
					button</button>
				<button type="button" class="btn btn-default btn-lg">Large
					button</button>
			</p>
			<p>
				<button type="button" class="btn btn-primary">Default
					button</button>
				<button type="button" class="btn btn-default">Default
					button</button>
			</p>
			<p>
				<button type="button" class="btn btn-primary btn-sm">Small
					button</button>
				<button type="button" class="btn btn-default btn-sm">Small
					button</button>
			</p>
			<p>
				<button type="button" class="btn btn-primary btn-xs">Extra
					small button</button>
				<button type="button" class="btn btn-default btn-xs">Extra
					small button</button>
			</p>

		</div>
	</div>
</div>
<!-- End Buttons -->

<!-- Images -->
<div class="panel-box">
	<div class="titles">
		<h4>Images And Thumbails</h4>
	</div>
	<div class="row">
		<div class="col-md-6">
			<img class="img-rounded" alt="165x165"
				style="width: 165px; height: 165px;" src='<c:url value="/resources/img/img-theme/holder.png"/>'>
			<img class="img-circle" alt="165x165"
				style="width: 165px; height: 165px;" src='<c:url value="/resources/img/img-theme/holder.png"/>'>
			<img class="img-thumbnail" alt="165x165"
				style="width: 165px; height: 165px;" src='<c:url value="/resources/img/img-theme/holder.png"/>'>
		</div>
		<div class="col-md-6">
			<div class="row">
				<div class="col-md-4">
					<a class="thumbnail" href="#"> <img
						src='<c:url value="/resources/img/img-theme/holder.png"/>' alt="">
					</a>
				</div>
				<div class="col-md-4">
					<a class="thumbnail" href="#"> <img
						src='<c:url value="/resources/img/img-theme/holder.png"/>' alt="">
					</a>
				</div>
				<div class="col-md-4">
					<a class="thumbnail" href="#"> <img
						src='<c:url value="/resources/img/img-theme/holder.png"/>' alt="">
					</a>
				</div>
			</div>
		</div>
	</div>
</div>
<!-- End Images -->

<!-- Accordion -->
<div class="panel-box">
	<div class="titles">
		<h4>Accordion</h4>
	</div>
	<div class="row">
		<div class="accrodation">
			<!-- section 1 -->
			<span class="acc-trigger"><a href="#">Mision</a></span>
			<div class="acc-container" style="display: none;">
				<div class="content">Pellentesque habitant morbi tristique
					senectus et netus et malesuada fames ac turpis egestas. Vestibulum
					tortor quam, feugiat vitae, ultricies eget, tempor sit amet, ante.
					Donec eu libero sit amet quam egestas semper. Aenean ultricies mi
					vitae est. Mauris placerat eleifend leo. Quisque sit amet est et
					sapien ullamcorper pharetra. Vestibulum erat wisi, condimentum sed,
					commodo vitae, ornare sit amet, wisi. Aenean fermentum, elit eget
					tincidunt condimentum, eros ipsum rutrum orci, sagittis tempus
					lacus enim ac dui. Donec non enim in turpis pulvinar facilisis. Ut
					felis. Praesent dapibus, neque id cursus faucibus, tortor neque
					egestas augue, eu vulputate magna eros eu erat. Aliquam erat
					volutpat.</div>
			</div>

			<!-- section 2 -->
			<span class="acc-trigger"><a href="#">Vision</a></span>
			<div class="acc-container" style="display: none;">
				<div class="content">Pellentesque habitant morbi tristique
					senectus et netus et malesuada fames ac turpis egestas. Vestibulum
					tortor quam, feugiat vitae, ultricies eget, tempor sit amet, ante.
					Donec eu libero sit amet quam egestas semper. Aenean ultricies mi
					vitae est. Mauris placerat eleifend leo. Quisque sit amet est et
					sapien ullamcorper pharetra. Vestibulum erat wisi, condimentum sed,
					commodo vitae, ornare sit amet, wisi. Aenean fermentum, elit eget
					tincidunt condimentum, eros ipsum rutrum orci, sagittis tempus
					lacus enim ac dui. Donec non enim in turpis pulvinar facilisis. Ut
					felis. Praesent dapibus, neque id cursus faucibus, tortor neque
					egestas augue, eu vulputate magna eros eu erat. Aliquam erat
					volutpat.</div>
			</div>

			<!-- section 3 -->
			<span class="acc-trigger"><a href="#">What we offer?</a></span>
			<div class="acc-container" style="display: none;">
				<div class="content">Pellentesque habitant morbi tristique
					senectus et netus et malesuada fames ac turpis egestas. Vestibulum
					tortor quam, feugiat vitae, ultricies eget, tempor sit amet, ante.
					Donec eu libero sit amet quam egestas semper. Aenean ultricies mi
					vitae est. Mauris placerat eleifend leo. Quisque sit amet est et
					sapien ullamcorper pharetra. Vestibulum erat wisi, condimentum sed,
					commodo vitae, ornare sit amet, wisi. Aenean fermentum, elit eget
					tincidunt condimentum, eros ipsum rutrum orci, sagittis tempus
					lacus enim ac dui. Donec non enim in turpis pulvinar facilisis. Ut
					felis. Praesent dapibus, neque id cursus faucibus, tortor neque
					egestas augue, eu vulputate magna eros eu erat. Aliquam erat
					volutpat.</div>
			</div>

			<!-- section 4 -->
			<span class="acc-trigger"><a href="#">Our services</a></span>
			<div class="acc-container" style="display: none;">
				<div class="content">Pellentesque habitant morbi tristique
					senectus et netus et malesuada fames ac turpis egestas. Vestibulum
					tortor quam, feugiat vitae, ultricies eget, tempor sit amet, ante.
					Donec eu libero sit amet quam egestas semper. Aenean ultricies mi
					vitae est. Mauris placerat eleifend leo. Quisque sit amet est et
					sapien ullamcorper pharetra. Vestibulum erat wisi, condimentum sed,
					commodo vitae, ornare sit amet, wisi. Aenean fermentum, elit eget
					tincidunt condimentum, eros ipsum rutrum orci, sagittis tempus
					lacus enim ac dui. Donec non enim in turpis pulvinar facilisis. Ut
					felis. Praesent dapibus, neque id cursus faucibus, tortor neque
					egestas augue, eu vulputate magna eros eu erat. Aliquam erat
					volutpat.</div>
			</div>

			<!-- section 5 -->
			<span class="acc-trigger"><a href="#">Features</a></span>
			<div class="acc-container" style="display: none;">
				<div class="content">Pellentesque habitant morbi tristique
					senectus et netus et malesuada fames ac turpis egestas. Vestibulum
					tortor quam, feugiat vitae, ultricies eget, tempor sit amet, ante.
					Donec eu libero sit amet quam egestas semper. Aenean ultricies mi
					vitae est. Mauris placerat eleifend leo. Quisque sit amet est et
					sapien ullamcorper pharetra. Vestibulum erat wisi, condimentum sed,
					commodo vitae, ornare sit amet, wisi. Aenean fermentum, elit eget
					tincidunt condimentum, eros ipsum rutrum orci, sagittis tempus
					lacus enim ac dui. Donec non enim in turpis pulvinar facilisis. Ut
					felis. Praesent dapibus, neque id cursus faucibus, tortor neque
					egestas augue, eu vulputate magna eros eu erat. Aliquam erat
					volutpat.</div>
			</div>

			<!-- section 6 -->
			<span class="acc-trigger"><a href="#">Product Sales</a></span>
			<div class="acc-container" style="display: none;">
				<div class="content">Pellentesque habitant morbi tristique
					senectus et netus et malesuada fames ac turpis egestas. Vestibulum
					tortor quam, feugiat vitae, ultricies eget, tempor sit amet, ante.
					Donec eu libero sit amet quam egestas semper. Aenean ultricies mi
					vitae est. Mauris placerat eleifend leo. Quisque sit amet est et
					sapien ullamcorper pharetra. Vestibulum erat wisi, condimentum sed,
					commodo vitae, ornare sit amet, wisi. Aenean fermentum, elit eget
					tincidunt condimentum, eros ipsum rutrum orci, sagittis tempus
					lacus enim ac dui. Donec non enim in turpis pulvinar facilisis. Ut
					felis. Praesent dapibus, neque id cursus faucibus, tortor neque
					egestas augue, eu vulputate magna eros eu erat. Aliquam erat
					volutpat.</div>
			</div>
		</div>
	</div>
</div>
<!-- End Accordion -->

<!-- Alerts -->
<div class="panel-box">
	<div class="titles">
		<h4>Alerts</h4>
	</div>
	<div class="row">
		<div class="col-md-12">
			<p>Styles for success, info, warning, and error messages</p>

			<div class="alert alert-success">
				<strong>Well done!</strong> You successfully read this important
				alert message.
			</div>

			<div class="alert alert-info">
				<strong>Heads up!</strong> This alert needs your attention, but it's
				not super important.
			</div>

			<div class="alert alert-warning">
				<strong>Warning!</strong> Best check yo self, you're not looking too
				good.
			</div>

			<div class="alert alert-danger">
				<strong>Oh snap!</strong> Change a few things up and try submitting
				again.
			</div>
		</div>
	</div>
</div>
<!-- End Alerts -->

<!-- Progress Bar -->
<div class="panel-box">
	<div class="titles">
		<h4>Progress Bar</h4>
	</div>
	<!-- Style One -->
	<div class="row">
		<div class="col-md-12">
			<div class="pro_bar">
				<h5 class="nocaps">Futbol Soccer</h5>
				<div id="progress_bar" class="ui-progress-bar ui-container">
					<div class="ui-progress">
						<span class="ui-label"><b class="value">90%</b></span>
					</div>
				</div>
				<!-- end section -->

				<br>

				<h5 class="nocaps">Bmx Sport</h5>
				<div id="progress_bar2" class="ui-progress-bar ui-container">
					<div class="ui-progress two">
						<span class="ui-label"><b class="value">72%</b></span>
					</div>
				</div>
				<!-- end section -->

				<br>

				<h5 class="nocaps">Motocross</h5>
				<div id="progress_bar3" class="ui-progress-bar ui-container">
					<div class="ui-progress three">
						<span class="ui-label"><b class="value">80%</b></span>
					</div>
				</div>
				<!-- end section -->

				<br>

				<h5 class="nocaps">Golfd</h5>
				<div id="progress_bar4" class="ui-progress-bar ui-container">
					<div class="ui-progress four">
						<span class="ui-label"><b class="value">94%</b></span>
					</div>
				</div>
				<!-- end section -->
			</div>
		</div>
	</div>
	<!-- End Style One -->
</div>
<!-- End Progress Bar -->

<!-- Tooltips -->
<div class="panel-box">
	<div class="titles">
		<h4>Tooltips</h4>
	</div>
	<div class="row">
		<div class="col-md-12 tooltip-hover">
			<p>
				Tight pants next level keffiyeh <a data-toggle="tooltip" href="#"
					data-original-title="Default tooltip">you probably</a> haven't
				heard of them. Photo booth beard raw denim letterpress vegan
				messenger bag stumptown. Farm-to-table seitan, mcsweeney's fixie
				sustainable quinoa 8-bit american apparel <a data-toggle="tooltip"
					href="#" data-original-title="Another tooltip">have a</a> terry
				richardson vinyl chambray.
			</p>
		</div>
	</div>
</div>
<!-- End Tooltips -->

<div class="row">
	<div class="col-md-6">
		<!-- Slide Bootstrap -->
		<div class="panel-box">
			<div class="titles">
				<h4>Bootstrap Slide</h4>
			</div>
			<!-- Mini SLide -->
			<div class="row">
				<div id="carousel-example-generic" class="carousel slide"
					data-ride="carousel">
					<ol class="carousel-indicators">
						<li data-target="#carousel-example-generic" data-slide-to="0"
							class="active"></li>
						<li data-target="#carousel-example-generic" data-slide-to="1"
							class=""></li>
						<li data-target="#carousel-example-generic" data-slide-to="2"
							class=""></li>
					</ol>
					<div class="carousel-inner">
						<div class="item active">
							<img src='<c:url value="/resources/img/blog/1.jpg"/>' alt="">
						</div>
						<div class="item">
							<img src='<c:url value="/resources/img/blog/2.jpg"/>' alt="">
						</div>
						<div class="item">
							<img src='<c:url value="/resources/img/blog/3.jpg"/>' alt="">
						</div>
					</div>
					<a class="left carousel-control" href="#carousel-example-generic"
						data-slide="prev"> <span
						class="glyphicon glyphicon-chevron-left"></span>
					</a> <a class="right carousel-control" href="#carousel-example-generic"
						data-slide="next"> <span
						class="glyphicon glyphicon-chevron-right"></span>
					</a>
				</div>
			</div>
			<!-- End Mini SLide -->
		</div>
		<!-- End Slide Bootstrap -->
	</div>

	<div class="col-md-6">
		<!-- Tooltips -->
		<div class="panel-box">
			<div class="titles">
				<h4>Paginations</h4>
			</div>
			<div class="row">

				<div class="col-md-12">
					<ul class="pagination pagination-lg">
						<li><a href="#">«</a></li>
						<li class="active"><a href="#">1</a></li>
						<li><a href="#">2</a></li>
						<li><a href="#">3</a></li>
						<li><a href="#">4</a></li>
						<li><a href="#">5</a></li>
						<li><a href="#">»</a></li>
					</ul>
				</div>

				<div class="col-md-12">
					<ul class="pagination">
						<li><a href="#">«</a></li>
						<li class="active"><a href="#">1</a></li>
						<li><a href="#">2</a></li>
						<li><a href="#">3</a></li>
						<li><a href="#">4</a></li>
						<li><a href="#">5</a></li>
						<li><a href="#">»</a></li>
					</ul>
				</div>

				<div class="col-md-12">
					<ul class="pagination pagination-sm">
						<li><a href="#">«</a></li>
						<li class="active"><a href="#">1</a></li>
						<li><a href="#">2</a></li>
						<li><a href="#">3</a></li>
						<li><a href="#">4</a></li>
						<li><a href="#">5</a></li>
						<li><a href="#">»</a></li>
					</ul>
				</div>
			</div>
		</div>
		<!-- End Tooltips -->
	</div>
</div>
