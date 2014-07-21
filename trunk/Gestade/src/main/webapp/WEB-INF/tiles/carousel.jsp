
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="col-md-9">
	<!-- Nav Tabs -->
	<ul class="nav nav-tabs" id="myTab">
		<li class="active"><a href="#feature-news" data-toggle="tab">FEATURED
				EVENTS</a></li>
		<li><a href="#club-news" data-toggle="tab">CLUB TEAMS</a></li>
	</ul>
	<!-- End Nav Tabs -->

	<!-- Content Tabs -->
	<div class="tab-content">
		<!-- Tab One - Feature News -->
		<div class="tab-pane active" id="feature-news">
			<!-- blog post-->
			<ul id="events-carousel" class="events-carousel padding-top">
				<!-- Item blog post -->
				<c:forEach items="${emploidutemps}" var="data">
					<li>
						<div class="header-post">
							<div class="date">
								<span>${data.daymonth}</span> ${data.year}
							</div>
							<a href="#"><img src='<c:url value="${data.imagesrc}"/>'
								alt=""></a>
							<div class="meta-tag">
								<ul>
									<li><i class="fa fa-folder-open"></i><a href="#">Start: ${data.startHour}</a></li>
									<li><i class="fa fa-folder-open"></i><a href="#">End: ${data.endHour}</a></li>
								</ul>
							</div>
						</div>
						<div class="info-post">
							<h4>
								<a href="#">${data.title}</a>
							</h4>
							<p>Temps Total: ${data.body}</p>
						</div>
					</li>

				</c:forEach>
				<!-- End Item blog post -->
			</ul>
			<!-- End blog post-->
		</div>
		<!-- Tab One - Feature News -->



		<!-- Tab Theree - Club Teams -->
		<div class="tab-pane" id="club-news">
			<h3>Club Teams</h3>
			<!-- Clubs Carousel-->
			<ul id="clubs-carousel" class="clubs-teams">
				<!-- Item carousel club -->
				<li class="row">
					<!-- Item clubs -->
					<div class="col-sx-12 col-sm-6 col-md-6">
						<div class="item-clubs">
							<div class="img-clubs">
								<img src='<c:url value="/resources/img/clubs-team/1.png"/>'
									alt="" class="img-responsive">
							</div>
							<div class="info-clubs">
								<h4>
									<a href="#">Team 1</a>
								</h4>
								<p>Lorem ipsum dolor sit amet,ectetur adipiscing elit.</p>
							</div>
						</div>
					</div> <!-- End Item clubs --> <!-- Item clubs -->
					<div class="col-sx-12 col-sm-6 col-md-6">
						<div class="item-clubs">
							<div class="img-clubs">
								<img src='<c:url value="/resources/img/clubs-team/2.png"/>'
									alt="" class="img-responsive">
							</div>
							<div class="info-clubs">
								<h4>
									<a href="#">Team 2</a>
								</h4>
								<p>Lorem ipsum dolor sit amet, ctetur adipiscing elit.</p>
							</div>
						</div>
					</div> <!-- End Item clubs --> <!-- Item clubs -->
					<div class="col-sx-12 col-sm-6 col-md-6">
						<div class="item-clubs">
							<div class="img-clubs">
								<img src='<c:url value="/resources/img/clubs-team/3.png"/>'
									alt="" class="img-responsive">
							</div>
							<div class="info-clubs">
								<h4>
									<a href="#">Team 3</a>
								</h4>
								<p>Lorem ipsum dolor sit amet, coetur adipiscing elit.</p>
							</div>
						</div>
					</div> <!-- End Item clubs --> <!-- Item clubs -->
					<div class="col-sx-12 col-sm-6 col-md-6">
						<div class="item-clubs">
							<div class="img-clubs">
								<img src='<c:url value="/resources/img/clubs-team/4.png"/>'
									alt="" class="img-responsive">
							</div>
							<div class="info-clubs">
								<h4>
									<a href="#">Team 4</a>
								</h4>
								<p>Lorem ipsum dolor sit amet, contur adipiscing elit.</p>
							</div>
						</div>
					</div> <!-- End Item clubs -->
				</li>
				<!-- End Item carousel club -->

				<!-- Item carousel club -->
				<li class="row">
					<!-- Item clubs -->
					<div class="col-sx-12 col-sm-6 col-md-6">
						<div class="item-clubs">
							<div class="img-clubs">
								<img src='<c:url value="/resources/img/clubs-team/5.png"/>'
									alt="" class="img-responsive">
							</div>
							<div class="info-clubs">
								<h4>
									<a href="#">Team 5</a>
								</h4>
								<p>Lorem ipsum dolor sit amet,ectetur adipiscing elit.</p>
							</div>
						</div>
					</div> <!-- End Item clubs --> <!-- Item clubs -->
					<div class="col-sx-12 col-sm-6 col-md-6">
						<div class="item-clubs">
							<div class="img-clubs">
								<img src='<c:url value="/resources/img/clubs-team/6.png"/>'
									alt="" class="img-responsive">
							</div>
							<div class="info-clubs">
								<h4>
									<a href="#">Team 6</a>
								</h4>
								<p>Lorem ipsum dolor sit amet, ctetur adipiscing elit.</p>
							</div>
						</div>
					</div> <!-- End Item clubs --> <!-- Item clubs -->
					<div class="col-sx-12 col-sm-6 col-md-6">
						<div class="item-clubs">
							<div class="img-clubs">
								<img src='<c:url value="/resources/img/clubs-team/1.png"/>'
									alt="" class="img-responsive">
							</div>
							<div class="info-clubs">
								<h4>
									<a href="#">Team 7</a>
								</h4>
								<p>Lorem ipsum dolor sit amet, coetur adipiscing elit.</p>
							</div>
						</div>
					</div> <!-- End Item clubs --> <!-- Item clubs -->
					<div class="col-sx-12 col-sm-6 col-md-6">
						<div class="item-clubs">
							<div class="img-clubs">
								<img src='<c:url value="/resources/img/clubs-team/4.png"/>'
									alt="" class="img-responsive">
							</div>
							<div class="info-clubs">
								<h4>
									<a href="#">Team 8</a>
								</h4>
								<p>Lorem ipsum dolor sit amet, contur adipiscing elit.</p>
							</div>
						</div>
					</div> <!-- End Item clubs -->
				</li>
				<!-- End Item carousel club -->
			</ul>
			<!-- End Clubs Carousel-->
		</div>
		<!-- Tab Theree - Club Teams -->
	</div>
	<!-- Content Tabs -->
</div>
