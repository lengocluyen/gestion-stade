<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
	
	<c:if test="${!empty message}">
<div class="notification information">
	${message}
</div>
</c:if>
<div class="content-box">
	<div class="content-box-header">
		<h3><c:if test="${!empty title}">${title}</c:if></h3>
	</div>

	<div class="content-box-content">
		<h3><c:if test="${!empty title}">${title}</c:if></h3>
			<form:form method="post" action="${action}" commandName="voiture">
			<table>
				<tr>
					<td><form:label path="type">
							<spring:message code="label.type" />
						</form:label></td>
					<td><form:input path="type" /></td>
				</tr>
				<tr>
					<td><form:label path="nombrePlace">
							<spring:message code="label.nombrePlace" />
						</form:label></td>
					<td><form:input path="nombrePlace" /></td>
				</tr>
				<tr>
					<td><form:label path="utilisateurID">
							<spring:message code="label.utilisateurID" />
						</form:label></td>
					<td><form:input path="utilisateurID"/></td>
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

<div class="content-box">
	<div class="content-box-header">
		<h3>Gestion de compte</h3>
	</div>

	<div class="content-box-content">
		<h3>Liste de compte</h3>
		<c:if test="${!empty uList.entities}">
			<table class="data">
				<tr>
					<th>VoitureID</th>
					<th>Type</th>
					<th>Nombre Place</th>
					<th>UtilisateurID</th>
					<th>&nbsp;</th>
					<th>&nbsp;</th>
				</tr>
				<c:forEach items="${uList.entities}" var="voiture">
					<tr>
						<td>${voiture.voitureID}</td>
						<td>${voiture.type}</td>
						<td>${voiture.nombrePlace}</td>
						<td>${voiture.utilisateurID}</td>
						<td><a href="/Covoso/voiture/edit/${voiture.voitureID}">edit</a></td>
						<td><a href="/Covoso/voiture/delete/${voiture.voitureID}">delete</a></td>
					</tr>
				</c:forEach>
			</table>
		</c:if>
		<div align="center">
			<c:if test="${!uList.nav.firstPage}">
				<a href="/Covoso/voiture/index">First</a>&nbsp;
			</c:if>
			<c:forEach var="i" items="${uList.nav.indexList}">
				<c:choose>
					<c:when test="${i != uList.nav.currentPage}">
						<a href="/Covoso/voiture/index/${i}">${i}</a>&nbsp;
					</c:when>
					<c:otherwise>
						<b>${i}</b>&nbsp;
					</c:otherwise>
				</c:choose>
			</c:forEach>
			<c:if test="${!uList.nav.lastPage}">
				<a
					href="/Covoso/voiture/index/${uList.nav.pageCount}">Last</a>
					</c:if>
		</div>
	</div>
	<div class="clear"></div>
</div>