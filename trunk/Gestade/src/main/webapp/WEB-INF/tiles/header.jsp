<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="headerbox">
	<div class="container">
		<div class="row">
			<!-- Logo-->
			<div class="col-md-7 logo">
				<label style="text-shadow: 0.1em 0.1em 0.2em black;font-size: 40px;font-weight:bolder;line-height:  1.5;color: #FFB43F;">GESTION DE STADE DE FOOTBAL
				</label>
			</div>
			<!-- End Logo-->

			<!-- Adds Header-->
			<div class="col-md-5 adds">
				<div style="float: right">
					<c:if test="${!empty sessionScope.account}">
						Bienvenue ${sessionScope.account.fullname}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;

						<c:if test="${!empty sessionScope.isadmin}">
							<a href="/Gestade/gestion/accueil">Admin page</a>
						</c:if>
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<a href="/Gestade/logout">logout</a>
					</c:if>

				</div>
			</div>
			<!-- End Adds Header-->
		</div>
	</div>
</div>