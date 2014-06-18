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
		<form:form method="post" action="${action}" commandName="ville">
			<table>
				<tr>
					<td><form:label path="nom">
							<spring:message code="label.nom" />
						</form:label></td>
					<td><form:input path="nom" /></td>
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
		<h3>Gestion de Ville</h3>
	</div>

	<div class="content-box-content">
		<h3>Liste de Ville</h3>
		<c:if test="${!empty uList.entities}">
			<table class="data">
				<tr>
					<th>Ville ID</th>
					<th>Nome</th>
					<th>Mis à jour</th>
					<th>Suppression</th>
				</tr>
				<c:forEach items="${uList.entities}" var="ville">
					<tr>
						<td>${ville.villeID}</td>
						<td>${ville.nom}</td>
						<td><a
							href="/Covoso/ville/edit/${ville.villeID}">edit</a></td>
						<td><a
							href="/Covoso/ville/delete/${ville.villeID}">delete</a></td>
					</tr>
				</c:forEach>
			</table>
		</c:if>
		<div align="center">
			<c:if test="${!uList.nav.firstPage}">
				<a href="/Covoso/ville/index">First</a>&nbsp;
			</c:if>
			<c:forEach var="i" items="${uList.nav.indexList}">
				<c:choose>
					<c:when test="${i != uList.nav.currentPage}">
						<a href="/Covoso/ville/index/${i}">${i}</a>&nbsp;
					</c:when>
					<c:otherwise>
						<b>${i}</b>&nbsp;
					</c:otherwise>
				</c:choose>
			</c:forEach>
			<c:if test="${!uList.nav.lastPage}">
				<a href="/Covoso/ville/index/${uList.nav.pageCount}">Last</a>
			</c:if>
		</div>
	</div>
	<div class="clear"></div>
</div>