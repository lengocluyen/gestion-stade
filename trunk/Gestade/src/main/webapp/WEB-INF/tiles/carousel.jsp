
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="col-md-9">
	<!-- Nav Tabs -->
	<ul class="nav nav-tabs" id="myTab">
		<li class="active"><a href="#feature-news" data-toggle="tab">Liste d'Inscription de Stade</a></li>
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
	</div>
	<!-- Content Tabs -->
</div>
