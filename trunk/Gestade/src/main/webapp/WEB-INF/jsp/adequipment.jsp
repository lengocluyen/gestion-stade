<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>


<c:if test="${!empty uList.entities}">
<div class="panel-box">
	<div class="titles">
		<h4>Liste d'equipments</h4>
	</div>

	<div class="row">
		<div class="col-md-12">

			<table class="table table-striped">
				<thead>
					<tr>
						<th>#</th>
						<th>Name</th>
						<th>Quantity</th>
						<th>User Import</th>
						<th>Date Import</th>
						<th>Edit</th>
						<th>Delete</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${uList.entities}" var="equipment">
						<tr>
							<td>${equipment.equipmentID}</td>
							<td>${equipment.name}</td>
							<td>${equipment.quantity}</td>
							<td>${equipment.userImport}</td>
							<td>${equipment.dateImport}</td>
							<td><a href="/Gestade/equipment/edit/${equipment.equipmentID}">edit</a></td>
							<td><a href="/Gestade/equipment/delete/${equipment.equipmentID}">delete</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>

		</div>
		<div class="col-md-12">
			<ul class="pagination pagination-sm">

				<c:if test="${!uList.nav.firstPage}">
				
					<li><a href="/Gestade/equipment/index">«</a></li>
				</c:if>
				<c:forEach var="i" items="${uList.nav.indexList}">
					<c:choose>
						<c:when test="${i != uList.nav.currentPage}">
							<li><a href="/Gestade/equipment/index/${i}">${i}</a></li>
						</c:when>
						<c:otherwise>
							<li><a class="active" href="#">${i}</a></li>
						</c:otherwise>
					</c:choose>
				</c:forEach>
				<c:if test="${!uList.nav.lastPage}">
				<li><a href="/Gestade/equipment/index/${uList.nav.pageCount}">»</a></li>
				</c:if>
			</ul>

		</div>
	</div>
	</div>
</c:if>
<div class="panel-box">
	<div class="titles">
		<h4>Ajoute d'un equipment</h4>
	</div>

	<form:form class="form-theme" method="post" action="${action}"
		commandName="equipment">
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

					<form:label path="quantity">
						<spring:message code="label.quantity" />
					</form:label>
					<form:input path="quantity" maxlength="100" class="form-control" />
				</div>
			</div>
		</div>
		<div class="row">
			<div class="form-group">
				<div class="col-md-6">
					<form:label path="userImport">
						<spring:message code="label.userImport" />
					</form:label>
					<form:input path="userImport" maxlength="100" class="form-control" />
				</div>
				<div class="col-md-6">

					<form:label path="dateImport">
						<spring:message code="label.dateImport" />
					</form:label>
					<form:input path="dateImport" maxlength="100" class="form-control" />
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