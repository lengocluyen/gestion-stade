<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- content Column Left -->
<div class="col-xs-12 col-md-6 col-lg-7">
	<!-- Recent Post -->
	<div class="panel-box">

		<div class="titles">
			<h4>Recent News</h4>
		</div>

		<!-- Post Item -->
		<div class="post-item">
			<div class="row">
				<div class="col-md-4">
					<div class="img-hover">
						<img src='<c:url value="/resources/img/blog/1.jpg"/>' alt="" class="img-responsive">
						<div class="overlay">
							<a href="single-news.html">+</a>
						</div>
					</div>
				</div>
				<div class="col-md-8">
					<h4>
						<a href="single-news.html">Porto Alegre and Cuiabá to welcome
							Valcke</a>
					</h4>
					<p class="data-info">
						January 3, 2014 / <i class="fa fa-comments"></i><a href="#">0</a>
					</p>
					<p>
						Lorem ipsum dolor sit amet, consectetur adipiscing elit. Phasellus
						rutrum, libero id imperdiet elementum, nunc... <a
							href="single-news.html">Read More [+]</a>
					</p>
				</div>
			</div>
		</div>
		<!-- End Post Item -->

		<!-- Post Item -->
		<div class="post-item">
			<div class="row">
				<div class="col-md-4">
					<div class="img-hover">
						<img src='<c:url value="/resources/img/blog/2.jpg"/>' alt="" class="img-responsive">
						<div class="overlay">
							<a href="single-news.html">+</a>
						</div>
					</div>
				</div>
				<div class="col-md-8">
					<h4>
						<a href="single-news.html">Porto Alegre and Cuiabá to welcome
							Valcke</a>
					</h4>
					<p class="data-info">
						January 9, 2014 / <i class="fa fa-comments"></i><a href="#">5</a>
					</p>
					<p>
						Lorem ipsum dolor sit amet, consectetur adipiscing elit. Phasellus
						rutrum, libero id imperdiet elementum, nunc... <a
							href="single-news.html">Read More [+]</a>
					</p>
				</div>
			</div>
		</div>
		<!-- End Post Item -->

		<!-- Post Item -->
		<div class="post-item">
			<div class="row">
				<div class="col-md-4">
					<div class="img-hover">
						<img src='<c:url value="/resources/img/blog/3.jpg"/>' alt="" class="img-responsive">
						<div class="overlay">
							<a href="single-news.html">+</a>
						</div>
					</div>
				</div>
				<div class="col-md-8">
					<h4>
						<a href="single-news.html">Porto Alegre and Cuiabá to welcome
							Valcke</a>
					</h4>
					<p class="data-info">
						January 4, 2014 / <i class="fa fa-comments"></i><a href="#">3</a>
					</p>
					<p>
						Lorem ipsum dolor sit amet, consectetur adipiscing elit. Phasellus
						rutrum, libero id imperdiet elementum, nunc... <a
							href="single-news.html">Read More [+]</a>
					</p>
				</div>
			</div>
		</div>
		<!-- End Post Item -->
	</div>
	<!-- End Recent Post -->

	<!-- Experts -->
	<!-- <div class="panel-box">
		<div class="titles">
			<h4>Sports Experts</h4>
		</div>

		<div class="row">
			<div class="col-xs-6 col-sm-3 col-md-4 col-lg-3">
				<div class="box-info">
					<img src='<c:url value="/resources/img/experts/1.png"/>' alt="" class="img-responsive">
					<h5 class="entry-title">
						<a href="#">Lorem ipsum dolor sit amet</a>
					</h5>
					<p class="date-box">Abril 15, 2014</p>
				</div>
			</div>
			<div class="col-xs-6 col-sm-3 col-md-4 col-lg-3">
				<div class="box-info">
					<img src='<c:url value="/resources/img/experts/2.png"/>' alt="" class="img-responsive">
					<h5 class="entry-title">
						<a href="#">Lorem ipsum dolor sit amet</a>
					</h5>
					<p class="date-box">Abril 15, 2014</p>
				</div>
			</div>
			<div class="col-xs-6 col-sm-3 col-md-4 col-lg-3">
				<div class="box-info">
					<img src='<c:url value="/resources/img/experts/3.png"/>' alt="" class="img-responsive">
					<h5 class="entry-title">
						<a href="#">Lorem ipsum dolor sit amet</a>
					</h5>
					<p class="date-box">Abril 15, 2014</p>
				</div>
			</div>
			<div class="col-xs-6 col-sm-3 col-md-4 col-lg-3">
				<div class="box-info">
					<img src='<c:url value="/resources/img/experts/4.png"/>' alt="" class="img-responsive">
					<h5 class="entry-title">
						<a href="#">Lorem ipsum dolor sit amet</a>
					</h5>
					<p class="date-box">Abril 15, 2014</p>
				</div>
			</div>
			<div class="col-xs-6 col-sm-3 col-md-4 col-lg-3">
				<div class="box-info">
					<img src='<c:url value="/resources/img/experts/5.png"/>' alt="" class="img-responsive">
					<h5 class="entry-title">
						<a href="#">Lorem ipsum dolor sit amet</a>
					</h5>
					<p class="date-box">Abril 15, 2014</p>
				</div>
			</div>
			<div class="col-xs-6 col-sm-3 col-md-4 col-lg-3">
				<div class="box-info">
					<img src='<c:url value="/resources/img/experts/3.png"/>' alt="" class="img-responsive">
					<h5 class="entry-title">
						<a href="#">Lorem ipsum dolor sit amet</a>
					</h5>
					<p class="date-box">Abril 15, 2014</p>
				</div>
			</div>
			<div class="col-xs-6 col-sm-3 col-md-4 col-lg-3">
				<div class="box-info">
					<img src='<c:url value="/resources/img/experts/4.png"/>' alt="" class="img-responsive">
					<h5 class="entry-title">
						<a href="#">Lorem ipsum dolor sit amet</a>
					</h5>
					<p class="date-box">Abril 15, 2014</p>
				</div>
			</div>
			<div class="col-xs-6 col-sm-3 col-md-4 col-lg-3">
				<div class="box-info">
					<img src='<c:url value="/resources/img/experts/1.png"/>' alt="" class="img-responsive">
					<h5 class="entry-title">
						<a href="#">Lorem ipsum dolor sit amet</a>
					</h5>
					<p class="date-box">Abril 15, 2014</p>
				</div>
			</div>

		</div>
	</div>
	 -->
	<!-- End Experts -->
</div>
<!-- End content Left -->

<!-- content Sidebar Center -->
<aside class="col-xs-6 col-sm-6 col-md-3 col-lg-3">
	<!-- Locations -->
	<div class="panel-box">

		<div class="titles">
			<h4>Locations</h4>
		</div>
		<!-- Locations Carousel -->
		<ul class="single-carousel">
			<li><img src='<c:url value="/resources/img/blog/1.jpg"/>' alt="" class="img-responsive">
				<div class="info-single-carousel">
					<h4>Rio de Janeiro</h4>
					<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit,
						incididunt ut labore et dolore magna aliqua. Ut enim ad minim
						veniam,quis nostrud exercitation ullamco laboris nisi ut aliquip
						ex ea commodo cillum dolore eu fugiat nulla pariatur.</p>
				</div></li>
			<li><img src='<c:url value="/resources/img/blog/2.jpg"/>' alt="" class="img-responsive">
				<div class="info-single-carousel">
					<h4>Brazilia</h4>
					<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit,
						incididunt ut labore et dolore magna aliqua. Ut enim ad minim
						veniam,quis nostrud exercitation ullamco laboris nisi ut aliquip
						ex ea commodo cillum dolore eu fugiat nulla pariatur.</p>
				</div></li>
			<li><img src='<c:url value="/resources/img/blog/3.jpg"/>' alt="" class="img-responsive">
				<div class="info-single-carousel">
					<h4>Sao Paulo</h4>
					<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit,
						incididunt ut labore et dolore magna aliqua. Ut enim ad minim
						veniam,quis nostrud exercitation ullamco laboris nisi ut aliquip
						ex ea commodo cillum dolore eu fugiat nulla pariatur.</p>
				</div></li>
		</ul>
		<!-- Locations Carousel -->
	</div>
	<!-- End Locations -->

	<!-- Video presentation --><!-- 
	<div class="panel-box">
		<div class="titles">
			<h4>Presentation</h4>
		</div>
		<div class="row">
			<div class="col-md-12">
				<h4>Rio de Janeiro</h4>
				<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit,
					incididunt ut labore et dolore magna aliqua. Ut enim ad minim
					veniam,quis nostrud exercitation ullamco laboris nisi ut aliquip ex
					ea commodo cillum dolore eu fugiat nulla pariatur.</p>
			</div>
		</div>
	</div>-->
	<!-- End Video presentation-->

	<!-- Widget Text-->
	<div class="panel-box">
		<div class="titles">
			<h4>Widget Text</h4>
		</div>
		<div class="row">
			<div class="col-md-12">
				<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit,
					incididunt ut labore et dolore.</p>
			</div>
		</div>
	</div>
	<!-- End Widget Text-->
</aside>
<!-- End content Sidebar Center -->

<!-- content Sidebar Right -->
<aside class="col-xs-6 col-sm-6 col-md-3 col-lg-2">
	<!-- Diary -->
	<div class="panel-box">
		<div class="titles">
			<h4>
				<i class="fa fa-calendar"></i>Diary
			</h4>
		</div>
		<!-- List Diary -->
		<div class="row">
			<div class="col-md-12">
				<p>Lorem ipsum dolor sit amet,elit sit consectetur.</p>
				<ul class="list-diary">
					<!-- Item List Diary -->
					<li>
						<h5>
							LIGA BBVA <span>06-05-2014 - 11:00</span>
						</h5>
						<ul class="club-logo">
							<li><img src='<c:url value="/resources/img/clubs-logos/1.png"/>' alt="">
								<h6>Real Madrid</h6></li>
							<li><img src='<c:url value="/resources/img/clubs-logos/2.png"/>' alt="">
								<h6>Valladolid</h6></li>
						</ul>
					</li>
					<!-- End Item List Diary -->

					<!-- Item List Diary -->
					<li>
						<h5>
							LIGA BBVA <span>06-05-2014 - 11:00</span>
						</h5>
						<ul class="club-logo">
							<li><img src='<c:url value="/resources/img/clubs-logos/1.png"/>' alt="">
								<h6>Real Madrid</h6></li>
							<li><img src='<c:url value="/resources/img/clubs-logos/2.png"/>' alt="">
								<h6>Valladolid</h6></li>
						</ul>
					</li>
					<!-- End Item List Diary -->

					<!-- Item List Diary -->
					<li>
						<h5>
							LIGA BBVA <span>06-05-2014 - 11:00</span>
						</h5>
						<ul class="club-logo">
							<li><img src='<c:url value="/resources/img/clubs-logos/1.png"/>' alt="">
								<h6>Real Madrid</h6></li>
							<li><img src='<c:url value="/resources/img/clubs-logos/2.png"/>' alt="">
								<h6>Valladolid</h6></li>
						</ul>
					</li>
					<!-- End Item List Diary -->
				</ul>
			</div>
		</div>
		<!-- End List Diary -->
	</div>
	<!-- End Diary -->

	<!-- Adds Sidebar -->
	<!-- <div class="panel-box">
		<a href="#"
			target="_blank"> <img src='<c:url value="/resources/img/adds/sidebar.png"/>'
			class="img-responsive" alt="">
		</a>
	</div> -->
	<!-- End Adds Sidebar -->
</aside>
<!-- End content Sidebar Right -->
