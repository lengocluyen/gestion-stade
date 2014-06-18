<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div id="logo">Solution Covoiturage</div>

<div id="header_buttons">
	<c:if test="${!empty sessionScope.utilisateur}">
		<a style="color: white">${sessionScope.utilisateur.nom}
			${sessionScope.utilisateur.prenom}</a>

		<c:if test="${!empty sessionScope.admin}">
			<a href="/Covoso/">Utilisateur page</a>
		</c:if>
		<a href="/Covoso/logout">logout</a>
	</c:if>

</div>