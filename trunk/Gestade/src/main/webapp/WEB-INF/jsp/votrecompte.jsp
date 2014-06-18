<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<div class="content-box">
	<div class="content-box-header">
		<h3>Votre Compte</h3>
	</div>

	<div class="content-box-content">
		<h3>Infomartion de votre compte</h3>

		<div class="column-left">
			<h3>Votre profile</h3>
			<table class="data">
				<tr>
					<td>Nom</td>
					<td>${utilisateur.prenom}${utilisateur.nom}</td>
				</tr>
				<tr>
					<td>Email</td>
					<td>${utilisateur.email}</td>
				</tr>
				<tr>
					<td>Date Naissance</td>
					<td>${utilisateur.dateNaissance}</td>
				</tr>
				<tr>
					<td>Date Create</td>
					<td>${utilisateur.dateCreate}</td>
				</tr>
				<tr>
					<td>Date Update</td>
					<td>${utilisateur.dateUpdate}</td>
				</tr>
				<tr>
					<td><a
						href="/Covoso/utilisateurcompteupdate/${utilisateur.utilisateurID}">edit</a>
					</td>
				</tr>
			</table>
		</div>
		<div class="column-right">
			<h3>Votre compte</h3>
			<table class="data">
				<tr>
					<td>Login</td>
					<td>${compte.login}</td>
				</tr>
				<tr>
					<td>Type</td>
					<td>${compte.type}</td>
				</tr>
				<tr>
					<td>Avatar</td>
					<td>${compte.avatar}</td>
				</tr>
			</table>
			<h3>Vos voitures</h3> <a href="/Covoso/voitureinsert">[Ajoute]</a>
			<table class="data">
				<tr>
					<th>VoitureID</th>
					<th>Type</th>
					<th>Nombre Place</th>
					<th>&nbsp;</th>
					<th>&nbsp;</th>
				</tr>
				<tr>
			<c:forEach items="${listVoiture}" var="voiture">
					<tr>
						<td>${voiture.voitureID}</td>
						<td>${voiture.type}</td>
						<td>${voiture.nombrePlace}</td>
						<td><a href="/Covoso/voitureupdate/${voiture.voitureID}">edit</a></td>
					</tr>
				</c:forEach>
				</tr>
			</table>
		</div>
		<div class="clear"></div>
	</div>
</div>