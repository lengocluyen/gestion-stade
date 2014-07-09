<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<div class="row">
	<div class="col-md-12">
		<h2>Page d'Inscription</h2>
	</div>
</div>
<form:form method="post" 
	action='/Gestade/inscription' commandName="account">
	<div class="row">
		<c:if test="${!empty message}">

			<div class="alert alert-warning">${message}</div>

		</c:if>
		<div class="form-group">
			<div class="col-md-6">
				<form:label path="phonenumber">
					<spring:message code="label.phonenumber" />
				</form:label>
				<form:input path="phonenumber" maxlength="100" class="form-control" />
			</div>
			<div class="col-md-6">

				<form:label path="password">
					<spring:message code="label.password" />
				</form:label>
				<form:input path="password" type="password" maxlength="100" class="form-control" />
			</div>
		</div>
	</div>
	<div class="row">
		<div class="form-group">
			<div class="col-md-6">
				<form:label path="username">
					<spring:message code="label.username" />
				</form:label>
				<form:input path="username" maxlength="100" class="form-control" />
			</div>
			<div class="col-md-6">

				<form:label path="fullname">
					<spring:message code="label.fullname" />
				</form:label>
				<form:input path="fullname" maxlength="100" class="form-control" />
			</div>
		</div>
	</div>
	<div class="row">
		<div class="col-md-1" style="margin-top:20px;">
			<input type="submit"  class="btn btn-lg btn-primary"  value="Submit">
		</div>
	</div>
</form:form>