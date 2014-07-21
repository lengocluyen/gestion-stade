<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<div class="panel-box">
	<div class="titles" style="margin-bottom: 0px;">
		<h4>Emploi du temps</h4>
	</div>
	<form:form method="post"
		action="/Gestade/emploidutemps" commandName="schedule">
		<div class="row">
			<c:if test="${!empty message}">

				<div class="alert alert-success">${message}</div>

			</c:if>
			<div class="form-group">
				<div class="col-md-8">

					<form:label path="stadeID">
						<spring:message code="label.stadeID" />
					</form:label>
					<form:select path="stadeID" class="form-control">
						<form:options items="${stadelist}" itemLabel="name"
							itemValue="stadeID" />
					</form:select>
				</div>
				<div class="col-md-4" style="margin-top:25px;">
					<input type="submit" value="Submit" class="btn btn-lg btn-primary">
				</div>
			</div>
		</div>
	</form:form>

	<c:if test="${!empty linkview}">
		<div class="row" style="height: 1785px; margin-top: 0px">
			<iframe style="position: relative;" id="iframschedule" width='100%'
				height='100%' frameborder='0' scrolling='no' src="${linkview}">
			</iframe>
		</div>
	</c:if>
</div>