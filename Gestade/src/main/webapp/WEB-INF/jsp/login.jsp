<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<div id="login">
	<div class="content-box">
		<div class="content-box-header">
			<h3>Login</h3>
		</div>

		<div class="content-box-content">
			<c:if test="${!empty message}">
				<div class="notification information">${message}</div>
			</c:if>

			<form:form method="post" action="/Covoso/login" commandName="compte">
				<div class="login-box">
					<span> <form:label path="login">
							<spring:message code="label.username" />
						</form:label>
					</span> <br />
					<form:input style="text-align:left;" path="login" type="text" />
				</div>

				<div class="login-box">
					<span> <form:label path="password">
							<spring:message code="label.password" />
						</form:label>
					</span> <br />
					<form:input path="password" type="password" />
				</div>
				<div class="clear"></div>
				<input type="submit" style="margin-top: 15px;"
					value='<spring:message code="label.login"/>' />
			</form:form>
		</div>
	</div>
	<!-- end .content-box -->
</div>
<!-- end #login -->