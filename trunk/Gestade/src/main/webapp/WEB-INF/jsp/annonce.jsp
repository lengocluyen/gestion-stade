<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>


<div class="content-box">
	<div class="content-box-header">
		<h3>Annonce</h3>
	</div>

	<div class="content-box-content">
		<h3>Liste d'annonce</h3>
		<div class="content-box-content">
			<table>
				<tr>
					<th>Ville Depart	</th>
					<th>Endroit Depart	</th>
					<th>Ville Arrivee	</th>
					<th>Endroit Arrivee	</th>
					<th>Autre endroit passe	</th>
					<th>Titre	</th>
					<th>Date Depart</th>
					<th>Heure Depart</th>
					<th>Prix</th>
					<th>Details</th>
				</tr>
				<c:forEach items="${aList.entities}" var="annonce">
				<tr>
					<td>${annonce.villeDepartNom}</td>
					<td>${annonce.endroitDepart}</td>
					<td>${annonce.villeArriveeNom}</td>
					<td>${annonce.endroitArrivee}</td>
					<td>${annonce.autresEndroitsPasses}</td>
					<td>${annonce.titre}</td>
					<td>${annonce.dateDepart}</td>
					<td>${annonce.heureDepart}</td>
					<td>${annonce.prix}</td>
					<td><a href="/Covoso/uinscription/${annonce.annonceID}">View & Inscription</a></td>
				</tr>
				</c:forEach>
			</table>
		</div>
		<div align="center">
			<c:if test="${!aList.nav.firstPage}">
				<a href="/Covoso/">First</a>&nbsp;
			</c:if>
			<c:forEach var="i" items="${aList.nav.indexList}">
				<c:choose>
					<c:when test="${i != aList.nav.currentPage}">
						<a href="/Covoso/accueil/${i}">${i}</a>&nbsp;
					</c:when>
					<c:otherwise>
						<b>${i}</b>&nbsp;
					</c:otherwise>
				</c:choose>
			</c:forEach>
			<c:if test="${!aList.nav.lastPage}">
				<a href="/Covoso/accueil/${aList.nav.pageCount}">Last</a>
			</c:if>
		</div>
	</div>
</div>