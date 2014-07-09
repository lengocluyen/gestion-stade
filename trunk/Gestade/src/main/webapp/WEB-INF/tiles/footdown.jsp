<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="footer-down">
	<div class="container">
		<div class="col-md-5">
			<p>&copy; 2014 GESTION DE STADE DE FOOTBAL 2014</p>
		</div>
		<div class="col-md-7">
			<!-- Nav Footer-->
			<ul class="nav-footer">
				<c:forEach items="${menu}" var="menu">
					<li><a href="${menu.url}" class="${menu.isCurrent}">
							${menu.name} </a></li>
				</c:forEach>
			</ul>
			<!-- End Nav Footer-->
		</div>
	</div>
</div>