<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<div class="panel-box" style="padding-bottom:15px;">
	<div class="titles">
		<h4>S'identifier</h4>
	</div>
	<form:form method="post" action="/Gestade/login" commandName="account">
		<div class="row">
			<c:if test="${!empty message}">
				<div class="alert alert-warning">${message}</div>
			</c:if>
			<div class="form-group">
				<div class="col-md-5">
					<form:label path="username">
							Pseudo
						</form:label>
					<form:input style="text-align:left;" path="username" type="text"
						maxlength="100" class="form-control" />

				</div>
				<div class="col-md-5">

					<form:label path="password">
							Mot de passe
						</form:label>
					<form:input path="password" type="password" maxlength="100"
						class="form-control" />

				</div>
				<div class="col-md-2" style="margin-top: 28px;">
					<input type="submit" class="btn btn-primary" value='Login' />
				</div>
			</div>
		</div>
	</form:form>
</div>