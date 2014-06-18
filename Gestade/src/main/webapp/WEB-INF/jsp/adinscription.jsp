<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<div class="content-box">
	<div class="content-box-header">
		<h3>Affichage d'Inscription</h3>
	</div>

	<div class="content-box-content">
		<h3>Affichage d'Inscription</h3>
		<table class="data">
				<tr>
					<th>Inscription ID</th>
					<th>Utilisateur</th>
					<th>Nombre Place</th>
					<th>Date</th>
					<th>Confirmer</th>
					<th>Suppression</th>
				</tr>
				<c:forEach items="${ilist}" var="inscription">
					<tr>
						<td>${inscription.inscriptionID}</td>
						<td>${inscription.utilisateurID}</td>
						<td>${inscription.nombrePlace}</td>
						<td>${inscription.dateIncription}</td>
						<td>${inscription.confirmer}</td>
						<td><a
							href="/Covoso/annonce/inscriptiondelete/${inscription.inscriptionID}">delete</a></td>
					</tr>
				</c:forEach>
			</table>
	</div>
</div>
