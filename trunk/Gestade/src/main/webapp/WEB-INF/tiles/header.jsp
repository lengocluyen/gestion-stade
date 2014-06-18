<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- <div id="header_buttons">
	<c:if test="${!empty sessionScope.utilisateur}">
		<a style="color: white">${sessionScope.utilisateur.nom}
			${sessionScope.utilisateur.prenom}</a>

		<c:if test="${!empty sessionScope.admin}">
			<a href="/Covoso/gestion/accueil">Admin page</a>
		</c:if>
		<a href="/Covoso/logout">logout</a>
	</c:if>

</div>-->
<div class="headerbox">
	<div class="container">
		<div class="row">
			<!-- Logo-->
			<div class="col-md-3 logo">
				<a href="index-2.html" title="Return Home"> <img
					src='<c:url value="/resources/img/logo.png"/>' alt="Logo" class="logo_img">
				</a>
			</div>
			<!-- End Logo-->

			<!-- Adds Header-->
			<div class="col-md-9 adds">
				<a
					href="http://themeforest.net/user/iwthemes/portfolio?ref=iwthemes"
					target="_blank"> <img src='<c:url value="/resources/img/adds/banner.jpg"/>' alt=""
					class="img-responsive">
				</a>
			</div>
			<!-- End Adds Header-->
		</div>
	</div>
</div>