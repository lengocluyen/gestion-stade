<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>


<div class="content-box">
	<div class="content-box-header">
		<h3>Utilisateur et Compte</h3>
	</div>

	<div class="content-box-content">
		<h3>Mis a jour d'un nouveau compte</h3>
		<c:if test="${!empty message}">
			<div class="notification information">${message}</div>
		</c:if>
		<form:form method="post" action="${action}" commandName="uc">
			<div class="content-box-content">

				<table>
					<tr>
						<td><form:label path="utilisateur.nom">
								<spring:message code="label.nom" />
							</form:label></td>
						<td><form:input path="utilisateur.nom" /></td>
					</tr>
					<tr>
						<td><form:label path="utilisateur.prenom">
								<spring:message code="label.prenom" />
							</form:label></td>
						<td><form:input path="utilisateur.prenom" /></td>
					</tr>
					<!-- <tr>
						<td><form:label path="utilisateur.dateNaissance">
								<spring:message code="label.dateNaissance" />
							</form:label></td>
						<td style="position: relative; display: block;"><form:input
								path="utilisateur.dateNaissance" class="datepickers" /></td>
					</tr> -->
					<tr>
						<td><form:label path="utilisateur.email">
								<spring:message code="label.email" />
							</form:label></td>
						<td><form:input path="utilisateur.email" /></td>
					</tr>
					<tr>
						<td><form:label path="utilisateur.telephone">
								<spring:message code="label.telephone" />
							</form:label></td>
						<td><form:input path="utilisateur.telephone" /></td>
					</tr>

					<tr>
						<td><form:label path="compte.login">
								<spring:message code="label.login" />
							</form:label></td>
						<td><form:input path="compte.login" /></td>
					</tr>
					<tr>
						<td><form:label path="compte.password">
								<spring:message code="label.password" />
							</form:label></td>
						<td><form:input type="password" path="compte.password" /></td>
					</tr>
					<tr>
						<td><form:label path="compte.type">
								<spring:message code="label.type" />
							</form:label></td>
						<td><form:checkbox path="compte.type" value="Conducteur" />
							Conducteur&nbsp;&nbsp;&nbsp; <form:checkbox path="compte.type"
								value="Utilisateur" />Utilisatuer</td>
					</tr>
					<tr>
						<td colspan="2"><input type="submit"
							value="<spring:message code="label.submit"/>" /></td>
					</tr>
				</table>
			</div>

		</form:form>
		<div class="clear"></div>
		<script>
			$('document').ready(function() {
				// Datepicker

				$('.datepickers').datepicker({
					showAnim : 'fadeIn'
				});
				//$('.datepickers').after('<img class="datepickericon" src="../resources/images/icons/calendar.png" alt="calendar" />');

			});
		</script>

	</div>
</div>