<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>


<c:if test="${!empty uList.entities}">
	<div class="panel-box">
		<div class="titles">
			<h4>Liste de compte</h4>
		</div>
		<div class="row">
			<div class="col-md-12">

				<table class="table table-striped">
					<thead>
						<tr>
							<th>#</th>
							<th>Phone Number</th>
							<th>User Name</th>
							<th>FullName</th>
							<th>Date Create</th>
							<th>Last Login</th>
							<th>Edit</th>
							<th>Delete</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${uList.entities}" var="account">
							<tr>
								<td>${account.accountID}</td>
								<td>${account.phonenumber}</td>
								<td>${account.username}</td>
								<td>${account.fullname}</td>
								<td>${account.dateCreate}</td>
								<td>${account.lastLogin}</td>
								<td><a href="/Gestade/account/edit/${account.accountID}">edit</a></td>
								<td><a href="/Gestade/account/delete/${account.accountID}">delete</a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>

			</div>
			<div class="col-md-12">
				<ul class="pagination pagination-sm">

					<c:if test="${!uList.nav.firstPage}">

						<li><a href="/Gestade/account/index">«</a></li>
					</c:if>
					<c:forEach var="i" items="${uList.nav.indexList}">
						<c:choose>
							<c:when test="${i != uList.nav.currentPage}">
								<li><a href="/Gestade/account/index/${i}">${i}</a></li>
							</c:when>
							<c:otherwise>
								<li><a class="active" href="#">${i}</a></li>
							</c:otherwise>
						</c:choose>
					</c:forEach>
					<c:if test="${!uList.nav.lastPage}">
						<li><a href="/Gestade/account/index/${uList.nav.pageCount}">»</a></li>
					</c:if>
				</ul>

			</div>
		</div>

	</div>
</c:if>
<div class="panel-box">
	<div class="titles">
		<h4>Ajoute d'un Compte</h4>
	</div>
	<form:form class="form-theme" method="post" action="${action}"
		commandName="account">
		<div class="row">
			<c:if test="${!empty message}">

				<div class="alert alert-success">${message}</div>

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
					<form:input path="password" maxlength="100" class="form-control" />
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
			<div class="col-md-12">
				<input type="submit" value="Submit" class="btn btn-lg btn-primary">
			</div>
		</div>
	</form:form>
</div>