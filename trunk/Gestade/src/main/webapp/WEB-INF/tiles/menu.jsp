<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!-- <ul id="main-nav">
	<c:forEach items="${menu}" var="menu">
		<li><a href="${menu.url}" class="${menu.isCurrent}">
				${menu.name} </a></li>
	</c:forEach>
</ul> -->
<!-- end #nav -->
<nav class="mainmenu">
	<div class="container">
		<!-- Menu-->
		<ul class="sf-menu" id="menu">
			<li class="selected"><a href="index-2.html">Home</a></li>
			<li class="current"><a href="about.html">About</a>
				<ul class="sub-current">
					<li><a href="about.html">About Us</a></li>
					<li><a href="events.html">Events</a></li>
					<li><a href="club-teams.html">Club Teams</a></li>
				</ul></li>
			<li><a href="sports.html">Sports</a>
				<div class="sf-mega">
					<div class="col-md-3">
						<h4>Sports Navigation</h4>
						<ul>
							<li><a href="sports.html">Football Soccer</a></li>
							<li><a href="sports.html">Motocross</a></li>
							<li><a href="sports.html">Bmx</a></li>
							<li><a href="sports.html">Skater</a></li>
						</ul>
					</div>

					<div class="col-md-3">
						<h4>Club Teams</h4>
						<div class="img-hover">
							<img src='<c:url value="/resources/img/blog/1.jpg"/>' alt="" class="img-responsive">
							<div class="overlay">
								<a href="sports.html">+</a>
							</div>
						</div>
					</div>

					<div class="col-md-3">
						<h4>Players And Staff</h4>
						<div class="img-hover">
							<img src='<c:url value="/resources/img/blog/2.jpg"/>' alt="" class="img-responsive">
							<div class="overlay">
								<a href="sports.html">+</a>
							</div>
						</div>
					</div>

					<div class="col-md-3">
						<h4>Locations</h4>
						<div class="img-hover">
							<img src='<c:url value="/resources/img/blog/3.jpg"/>' alt="" class="img-responsive">
							<div class="overlay">
								<a href="sports.html">+</a>
							</div>
						</div>
					</div>
				</div></li>
			<li class="current"><a href="gallery-4-columns.html">Gallery</a>
				<ul class="sub-current">
					<li><a href="gallery-2-columns.html">Gallery 2 Columns</a></li>
					<li><a href="gallery-3-columns.html">Gallery 3 Columns</a></li>
					<li><a href="gallery-4-columns.html">Gallery 4 Columns</a></li>
				</ul></li>
			<li class="current"><a href="#">Features</a>
				<ul class="sub-current">
					<li class="current"><a href="#">Pages</a>
						<ul class="sub-current">
							<li><a href="page-full-width.html">Full Width</a></li>
							<li><a href="page-left-sidebar.html">Left Sidebar</a></li>
							<li><a href="page-right-sidebar.html">Right Sidebar</a></li>
							<li><a href="page-404.html">404 Page</a></li>
							<li><a href="page-faq.html">FAQ</a></li>
							<li><a href="sitemap.html">Sitemap</a></li>
						</ul></li>
					<li class="current"><a href="#">Headers</a>
						<ul class="sub-current">
							<li><a href="feature-header-1.html">Header Version 1</a></li>
							<li><a href="feature-header-2.html">Header Version 2</a></li>
							<li><a href="feature-header-3.html">Header Version 3</a></li>
						</ul></li>
					<li class="current"><a href="#">Footers</a>
						<ul class="sub-current">
							<li><a href="feature-footer-1.html#footer">Footer
									Version 1</a></li>
							<li><a href="feature-footer-2.html#footer">Footer
									Version 2</a></li>
							<li><a href="feature-footer-3.html#footer">Footer
									Version 3</a></li>
						</ul></li>
					<li><a href="feature-grid-system.html">Grind System</a></li>
					<li><a href="feature-typograpy.html">Tipograpy</a></li>
					<li><a href="feature-icons.html">Icons</a></li>
					<li><a href="feature-shortcodes.html">Shortcodes</a></li>
					<li class="current"><a href="#">Third Level</a>
						<ul class="sub-current">
							<li><a href="#">menu item</a></li>
							<li><a href="#">menu item</a></li>
							<li><a href="#">menu item</a></li>
						</ul></li>
				</ul></li>
			<li class="current"><a href="single-news.html">News</a>
				<ul class="sub-current">
					<li><a href="news-left-sidebar.html">News Lef Sidebar</a></li>
					<li><a href="news-right-sidebar.html">News Right Sidebar</a></li>
					<li><a href="news-no-sidebar.html">News No Sidebar</a></li>
					<li><a href="single-news.html">Single News</a></li>
				</ul></li>
			<li><a href="contact.html">Contact</a></li>
		</ul>
		<!-- End Menu-->
	</div>
</nav>
