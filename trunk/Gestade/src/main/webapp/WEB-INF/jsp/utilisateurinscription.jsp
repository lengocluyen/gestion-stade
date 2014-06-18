<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>


<div class="content-box">
	<div class="content-box-header">
		<h3>Inscription de Covoiturage</h3>
	</div>

	<div class="content-box-content">
		<h3>Information de Covoiturage</h3>
		
		<table>
			<tr>
				<td width="170px"><spring:message code="label.utilisateur" />
				</td>
				<td>${utilisateurAuteur.nom}${utilisateurAuteur.prenom}</td>
			</tr>
			<tr>
				<td width="170px"><spring:message code="label.villeDepart" />
				</td>
				<td>${villeDepart.nom}</td>
			</tr>
			<tr>
				<td> <spring:message code="label.endroitDepart" />
				</td>
				<td>${annonce.endroitDepart}</td>
			</tr>
			<tr>
				<td><spring:message code="label.villeArrivee" /></td>
				<td>${villeArrivee.nom}</td>
			</tr>
			<tr>
				<td><spring:message code="label.endroitArrivee" /></td>
				<td>${annonce.endroitArrivee}</td>
			</tr>

			<tr>
				<td><spring:message code="label.titre" /></td>
				<td>${annonce.titre}</td>
			</tr>

			<tr>
				<td><spring:message code="label.description" /></td>
				<td>${annonce.description}</td>
			</tr>

			<tr>
				<td><spring:message code="label.dateDepart" /></td>
				<td>${annonce.dateDepart}</td>
			</tr>

			<tr>
				<td><spring:message code="label.heureDepart" /></td>
				<td>${annonce.heureDepart}</td>
			</tr>
			<tr>
				<td><spring:message code="label.totalTemp" /></td>
				<td>${annonce.totalTemp}</td>
			</tr>
			<tr>
				<td><spring:message code="label.prix" /></td>
				<td>${annonce.prix}</td>
			</tr>
			<tr>
				<td><spring:message code="label.nombrePlace" /></td>
				<td>${annonce.nombrePlace}</td>
			</tr>
			<tr>
				<td><spring:message code="label.autresEndroitsPasses" /></td>
				<td>${annonce.autresEndroitsPasses}</td>
			</tr>
			<tr>
				<td><spring:message code="label.voitureID" /></td>
				<td>${voiture.nom}</td>
			</tr>
			<tr>
				<td><spring:message code="label.dateCreate" /></td>
				<td>${annonce.dateCreate}</td>
			</tr>
		</table>
		<c:if test="${!empty viewinscription}">
			
		<h3>Inscription d'un nouveau Covoiturage</h3>
		<c:if test="${!empty message}">
			<div class="notification information">${message}</div>
		</c:if>
		<form:form method="post" action="${action}"
			commandName="inscription">
			<div class="content-box-content">

				<table>
					<tr>
						<td><form:label path="nombrePlace">
								<spring:message code="label.nombrePlace" />
							</form:label></td>
						<td><form:input path="nombrePlace" /></td>
					</tr>
					<tr>
						<td colspan="2"><input type="submit"
							value="<spring:message code="label.submit"/>" /></td>
					</tr>
				</table>
			</div>

		</form:form>
		
		</c:if>
		<c:if test="${empty viewinscription}">
		<h3>List d'Inscription de la Covoiturage</h3>
		<table class="data">
				<tr>
					<th>Inscription ID</th>
					<th>Utilisateur</th>
					<th>Telephone</th>
					<th>Nombre Place</th>
					<!-- <th>Date</th> -->
					</tr>
				<c:forEach items="${annoncelis}" var="inscription">
					<tr>
						<td>${inscription.inscriptionId}</td>
						<td>${inscription.utilisateurNom}</td>
						<td>${inscription.utilisateurTelephone}</td>
						<td>${inscription.nombrePlace}</td>
						<td>${inscription.dateInscription}</td>
						</tr>
				</c:forEach>
			</table>
		</c:if>
		<div class="clear"></div>
	</div>
</div>