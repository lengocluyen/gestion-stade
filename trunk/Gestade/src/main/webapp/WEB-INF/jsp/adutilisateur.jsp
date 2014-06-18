<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

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
		<form:form method="post" action="${action}" commandName="utilisateur">
			<table>
				<tr>
					<td><form:label path="nom">
							<spring:message code="label.nom" />
						</form:label></td>
					<td><form:input path="nom" /></td>
				</tr>
				<tr>
					<td><form:label path="prenom">
							<spring:message code="label.prenom" />
						</form:label></td>
					<td><form:input path="prenom" /></td>
				</tr>
				<tr>
					<td><form:label path="dateNaissance">
							<spring:message code="label.dateNaissance" />
						</form:label></td>
					<td style="position: relative; display: block;"><form:input
							path="dateNaissance" class="datepickers" /></td>
				</tr>
				<tr>
					<td><form:label path="email">
							<spring:message code="label.email" />
						</form:label></td>
					<td><form:input path="email" /></td>
				</tr>
				<tr>
					<td><form:label path="telephone">
							<spring:message code="label.telephone" />
						</form:label></td>
					<td><form:input path="telephone" /></td>
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

<div class="content-box">
	<div class="content-box-header">
		<h3>Gestion d'utilisateur</h3>
	</div>

	<div class="content-box-content">
		<h3>Liste d'utilisateur</h3>
		<c:if test="${!empty uList.entities}">
			<table class="data">
				<tr>
					<th>Name</th>
					<th>Email</th>
					<th>Telephone</th>
					<th>Date Naissance</th>
					<th>Date Create</th>
					<th>Date Update</th>
					<th>&nbsp;</th>
					<th>&nbsp;</th>
				</tr>
				<c:forEach items="${uList.entities}" var="utilisateur">
					<tr>
						<td>${utilisateur.prenom},${utilisateur.nom}</td>
						<td>${utilisateur.email}</td>
						<td>${utilisateur.telephone}</td>
						<td>${utilisateur.dateNaissance}</td>
						<td>${utilisateur.dateCreate}</td>
						<td>${utilisateur.dateUpdate}</td>
						<td><a
							href="/Covoso/utilisateur/edit/${utilisateur.utilisateurID}">edit</a></td>
						<td><a
							href="/Covoso/utilisateur/delete/${utilisateur.utilisateurID}">delete</a></td>
					</tr>
				</c:forEach>
			</table>
		</c:if>
		<div align="center">
			<c:if test="${!uList.nav.firstPage}">
				<a href="/Covoso/utilisateur/index">First</a>&nbsp;
			</c:if>
			<c:forEach var="i" items="${uList.nav.indexList}">
				<c:choose>
					<c:when test="${i != uList.nav.currentPage}">
						<a href="/Covoso/utilisateur/index/${i}">${i}</a>&nbsp;
					</c:when>
					<c:otherwise>
						<b>${i}</b>&nbsp;
					</c:otherwise>
				</c:choose>
			</c:forEach>
			<c:if test="${!uList.nav.lastPage}">
				<a href="/Covoso/utilisateur/index/${uList.nav.pageCount}">Last</a>
			</c:if>
		</div>
	</div>
	<div class="clear"></div>
</div>