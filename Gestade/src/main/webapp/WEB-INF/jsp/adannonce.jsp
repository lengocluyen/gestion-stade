<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<div class="content-box">
	<div class="content-box-header">
		<h3>Gestion d'utilisateur</h3>
	</div>

	<div class="content-box-content">
		<h3>Liste d'utilisateur</h3>
		<c:if test="${!empty uList.entities}">
			<table>
				<tr>
					<th>Inscription</th>
					<th>Ville Depart</th>
					<th>Endroit Depart</th>
					<th>Ville Arrivee</th>
					<th>Endroit Arrivee</th>
					<th>Titre</th>
					<th>Date Depart</th>
					<th>Heure Depart</th>
					<th>Prix</th>
					<th>Update</th>
					<th>Suppression</th>
				</tr>
				<c:forEach items="${uList.entities}" var="annonce">
					<tr>
					<td><a
							href="/Covoso/annonce/inscription/${annonce.annonceID}">Afficher</a></td>
						
						<td>${annonce.villeDepartNom}</td>
						<td>${annonce.endroitDepart}</td>
						<td>${annonce.villeArriveeNom}</td>
						<td>${annonce.endroitArrivee}</td>
						<td>${annonce.titre}</td>
						<td>${annonce.dateDepart}</td>
						<td>${annonce.heureDepart}</td>
						<td>${annonce.prix}</td>
						<td><a
							href="/Covoso/annonce/edit/${annonce.annonceID}">edit</a></td>
						<td><a
							href="/Covoso/annonce/delete/${annonce.annonceID}">delete</a></td>
					
					</tr>
				</c:forEach>
			</table>
		</c:if>
		<div align="center">
			<c:if test="${!uList.nav.firstPage}">
				<a href="/Covoso/annonce/index">First</a>&nbsp;
			</c:if>
			<c:forEach var="i" items="${uList.nav.indexList}">
				<c:choose>
					<c:when test="${i != uList.nav.currentPage}">
						<a href="/Covoso/annonce/index/${i}">${i}</a>&nbsp;
					</c:when>
					<c:otherwise>
						<b>${i}</b>&nbsp;
					</c:otherwise>
				</c:choose>
			</c:forEach>
			<c:if test="${!uList.nav.lastPage}">
				<a href="/Covoso/annonce/index/${uList.nav.pageCount}">Last</a>
			</c:if>
		</div>
	</div>
	
<c:if test="${!empty message}">
	<div class="notification information">${message}</div>
</c:if>
<div class="content-box">
	<div class="content-box-header">
		<h3>
			<c:if test="${!empty title}">${title}</c:if>
		</h3>
	</div>

	<div class="content-box-content">
		<h3>
			<c:if test="${!empty title}">${title}</c:if>
		</h3>
		<form:form method="post" action="${action}" commandName="annonce">
			<table>
				<tr>
					<td width="170px"><form:label path="villeDepart">
							<spring:message code="label.villeDepart" />
						</form:label></td>
					<td><form:select path="villeDepart">
							<form:options items="${listVille}" itemLabel="Nom"
								itemValue="VilleID" />
						</form:select></td>
				</tr>
				<tr>
					<td><form:label path="endroitDepart">
							<spring:message code="label.endroitDepart" />
						</form:label></td>
					<td><form:input style="width: 740px;height:50px"
							path="endroitDepart" /></td>
				</tr>
				<tr>
					<td><form:label path="villeArrivee">
							<spring:message code="label.villeArrivee" />
						</form:label></td>
					<td><form:select path="villeArrivee">
							<form:options items="${listVille}" itemLabel="Nom"
								itemValue="VilleID" />
						</form:select></td>
				</tr>
				<tr>
					<td><form:label path="endroitArrivee">
							<spring:message code="label.endroitArrivee" />
						</form:label></td>
					<td><form:input style="width: 740px;height:50px"
							path="endroitArrivee" /></td>
				</tr>

				<tr>
					<td><form:label path="titre">
							<spring:message code="label.titre" />
						</form:label></td>
					<td><form:input style="width: 740px;" path="titre"
							class="medium" /></td>
				</tr>

				<tr>
					<td><form:label path="description">
							<spring:message code="label.description" />
						</form:label></td>
					<td><form:input type="multilive"
							style="width: 740px;height:100px" path="description" /></td>
				</tr>

				<tr>
					<td><form:label path="dateDepart">
							<spring:message code="label.dateDepart" />
						</form:label></td>
					<td><form:input path="dateDepart" class="datepickers" /></td>
				</tr>

				<tr>
					<td><form:label path="heureDepart">
							<spring:message code="label.heureDepart" />
						</form:label></td>
					<td><form:input path="heureDepart" /></td>
				</tr>
				<tr>
					<td><form:label path="totalTemp">
							<spring:message code="label.totalTemp" />
						</form:label></td>
					<td><form:input path="totalTemp" /></td>
				</tr>
				<tr>
					<td><form:label path="prix">
							<spring:message code="label.prix" />
						</form:label></td>
					<td><form:input path="prix" /></td>
				</tr>
				<tr>
					<td><form:label path="nombrePlace">
							<spring:message code="label.nombrePlace" />
						</form:label></td>
					<td><form:input path="nombrePlace" /></td>
				</tr>
				<tr>
					<td><form:label path="autresEndroitsPasses">
							<spring:message code="label.autresEndroitsPasses" />
						</form:label></td>
					<td><form:input style="width: 740px;height:50px"
							path="autresEndroitsPasses" /></td>
				</tr>
				<tr>
					<td><form:label path="voitureID">
							<spring:message code="label.voitureID" />
						</form:label></td>
					<td><form:select path="voitureID">
							<form:options items="${listVoiture}" itemLabel="Type"
								itemValue="VoitureID" />
						</form:select></td>
				</tr>

				<tr>
					<td colspan="2"><input type="submit"
						value="<spring:message code="label.submit"/>" /></td>
				</tr>
			</table>
		</form:form>
	</div>
	<div class="clear"></div>
</div>
<script>
	$('document').ready(function() {
		// Datepicker

		$('.datepickers').datepicker({
			showAnim : 'fadeIn'
		});
		//$('.datepickers').after('<img class="datepickericon" src="../resources/images/icons/calendar.png" alt="calendar" />');

	});
</script>

<div class="clear"></div>
</div>