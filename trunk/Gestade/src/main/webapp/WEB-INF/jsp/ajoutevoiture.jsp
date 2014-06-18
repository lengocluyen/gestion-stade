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
					<td colspan="2"><input type="submit"
						value="<spring:message code="label.submit"/>" /></td>
				</tr>
			</table>
		</form:form>
	</div>
	<div class="clear"></div>
</div>
