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
			<form:form method="post" action="${action}" commandName="compte">
			<table>
				<tr>
					<td><form:label path="login">
							<spring:message code="label.login" />
						</form:label></td>
					<td><form:input path="login" /></td>
				</tr>
				<tr>
					<td><form:label path="password">
							<spring:message code="label.password" />
						</form:label></td>
					<td><form:input path="password" /></td>
				</tr>
				<tr>
					<td><form:label path="type">
							<spring:message code="label.type" />
						</form:label></td>
					<td><form:input path="type"/></td>
				</tr>
				<tr>
					<td><form:label path="utilisateurid">
							<spring:message code="label.utilisateurID" />
						</form:label></td>
					<td><form:input path="utilisateurid" /></td>
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
					<th>Login</th>
					<th>Type</th>
					<th>Avatar</th>
					<th>Utilisateur</th>
					<th>&nbsp;</th>
					<th>&nbsp;</th>
				</tr>
				<c:forEach items="${uList.entities}" var="compte">
					<tr>
						<td>${compte.login}</td>
						<td>${compte.type}</td>
						<td>${compte.avatar}</td>
						<td>${compte.utilisateurid}</td>
						<td><a href="/Covoso/compte/edit/${compte.login}">edit</a></td>
						<td><a href="/Covoso/compte/delete/${compte.login}">delete</a></td>
					</tr>
				</c:forEach>
			</table>
		</c:if>
		<div align="center">
			<c:if test="${!uList.nav.firstPage}">
				<a href="/Covoso/compte/index">First</a>&nbsp;
			</c:if>
			<c:forEach var="i" items="${uList.nav.indexList}">
				<c:choose>
					<c:when test="${i != uList.nav.currentPage}">
						<a href="/Covoso/compte/index/${i}">${i}</a>&nbsp;
					</c:when>
					<c:otherwise>
						<b>${i}</b>&nbsp;
					</c:otherwise>
				</c:choose>
			</c:forEach>
			<c:if test="${!uList.nav.lastPage}">
				<a
					href="/Covoso/compte/index/${uList.nav.pageCount}">Last</a>
					</c:if>
		</div>
	</div>
	<div class="clear"></div>
</div>