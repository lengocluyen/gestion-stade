<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<c:if test="${!empty uList.entities}">
	<div class="panel-box">
		<div class="titles">
			<h4>Liste de Stade</h4>
		</div>
		<div class="row">
			<div class="col-md-12">
				<table class="table table-striped">
					<thead>
						<tr>
							<th>#</th>
							<th>Name</th>
							<th>Position</th>
							<th>Type</th>
							<th>State</th>
							<th>Edit</th>
							<th>Delete</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${uList.entities}" var="stade">
							<tr>
								<td>${stade.stadeID}</td>
								<td>${stade.name}</td>
								<td>${stade.position}</td>
								<td>${stade.type}</td>
								<td>${stade.state}</td>
								<td><a href="/Gestade/stade/edit/${stade.stadeID}">edit</a></td>
								<td><a href="/Gestade/stade/delete/${stade.stadeID}">delete</a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>

			</div>
			<div class="col-md-12">
				<ul class="pagination pagination-sm">

					<c:if test="${!uList.nav.firstPage}">

						<li><a href="/Gestade/stade/index">«</a></li>
					</c:if>
					<c:forEach var="i" items="${uList.nav.indexList}">
						<c:choose>
							<c:when test="${i != uList.nav.currentPage}">
								<li><a href="/Gestade/stade/index/${i}">${i}</a></li>
							</c:when>
							<c:otherwise>
								<li><a class="active" href="#">${i}</a></li>
							</c:otherwise>
						</c:choose>
					</c:forEach>
					<c:if test="${!uList.nav.lastPage}">
						<li><a href="/Gestade/stade/index/${uList.nav.pageCount}">»</a></li>
					</c:if>
				</ul>

			</div>
		</div>
	</div>
</c:if>
<div class="panel-box">
	<div class="titles">
		<h4>Ajoute d'un Stade</h4>
	</div>
	<form:form class="form-theme" method="post" action="${action}"
		commandName="stade">
		<div class="row">
			<c:if test="${!empty message}">

				<div class="alert alert-success">${message}</div>

			</c:if>
			<div class="form-group">
				<div class="col-md-6">
					<form:label path="name">
						<spring:message code="label.name" />
					</form:label>
					<form:input path="name" maxlength="100" class="form-control" />
				</div>
				<div class="col-md-6">

					<form:label path="position">
						<spring:message code="label.position" />
					</form:label>
					<form:input path="position" maxlength="100" class="form-control" />
				</div>
			</div>
		</div>
		<div class="row">
			<div class="form-group">
				<div class="col-md-6">
					<form:label path="type">
						<spring:message code="label.type" />
					</form:label>
					<form:input path="type" maxlength="100" class="form-control" />
				</div>
				<div class="col-md-6">

					<form:label path="state">
						<spring:message code="label.state" />
					</form:label>
					<form:input path="state" maxlength="100" class="form-control" />
				</div>
			</div>
		</div>

		<div class="row">
			<div class="form-group">
				<div class="col-md-12">
					<form:label path="description">
						<spring:message code="label.description" />
					</form:label>
					<textarea maxlength="5000" rows="10" class="form-control"
						name="description" id="description" style="height: 138px;"></textarea>
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
