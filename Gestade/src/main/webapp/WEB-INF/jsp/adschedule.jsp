<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>


	<div class="row">
		<div class="col-md-12">
			<h2>Schedule Management</h2>
		</div>
	</div>

	<form:form class="form-theme" method="post" action="${action}"
		commandName="schedule">
		<div class="row">
			<c:if test="${!empty message}">

				<div class="alert alert-success">${message}</div>

			</c:if>
			<h4><c:if test="${!empty title}">${title}</c:if></h4>
			<div class="form-group">
				<div class="col-md-6">
					<form:label path="accountID">
						<spring:message code="label.accountID" />
					</form:label>
					<form:input path="accountID" maxlength="100" class="form-control" />
				</div>
				<div class="col-md-6">

					<form:label path="stadeID">
						<spring:message code="label.stadeID" />
					</form:label>
					<form:input path="stadeID" maxlength="100" class="form-control" />
				</div>
			</div>
		</div>
		<div class="row">
			<div class="form-group">
				<div class="col-md-4">
					<form:label path="dateOrder">
						<spring:message code="label.dateOrder" />
					</form:label>
					<form:input path="dateOrder" maxlength="100" class="form-control" />
				</div>
				<div class="col-md-4">

					<form:label path="fromHour">
						<spring:message code="label.fromHour" />
					</form:label>
					<form:input path="fromHour" maxlength="100" class="form-control" />
				</div>
								<div class="col-md-4">

					<form:label path="toHour">
						<spring:message code="label.toHour" />
					</form:label>
					<form:input path="toHour" maxlength="100" class="form-control" />
				</div>
			</div>
		</div>
<div class="form-group">
				<div class="col-md-6">
					<form:label path="price">
						<spring:message code="label.price" />
					</form:label>
					<form:input path="price" maxlength="100" class="form-control" />
				</div>
				<div class="col-md-6">

					<form:label path="promotion">
						<spring:message code="label.promotion" />
					</form:label>
					<form:input path="promotion" maxlength="100" class="form-control" />
				</div>
			</div>
		<div class="row">
			<div class="col-md-12">
				<input type="submit" value="Submit" class="btn btn-lg btn-primary">
			</div>
		</div>
	</form:form>

<c:if test="${!empty uList.entities}">
	<div class="row">
		<div class="col-md-12">

			<h4>Data list</h4>
			<table class="table table-striped">
				<thead>
					<tr>
						<th>#</th>
						<th>Account</th>
						<th>Stade</th>
						<th>Date Order</th>
						<th>From Hour</th>
						<th>To Hour</th>
						<th>Total Time</th>
						<th>Price</th>
						<th>Promotion</th>
						<th>Edit</th>
						<th>Delete</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${uList.entities}" var="schedule">
						<tr>
							<td>${schedule.scheduleID}</td>
							<td>${schedule.accountID}</td>
							<td>${schedule.stadeID}</td>
							<td>${schedule.dateOrder}</td>
							<td>${schedule.fromHour}</td>
							<td>${schedule.toHour}</td>
							<td>${schedule.totalTime}</td>
							<td>${schedule.price}</td>
							<td>${schedule.promotion}</td>
							<td><a href="/Gestade/schedule/edit/${schedule.sscheduleID}">edit</a></td>
							<td><a href="/Gestade/schedule/delete/${schedule.scheduleID}">delete</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>

		</div>
		<div class="col-md-12">
			<ul class="pagination pagination-sm">

				<c:if test="${!uList.nav.firstPage}">
				
					<li><a href="/Gestade/schedule/index">«</a></li>
				</c:if>
				<c:forEach var="i" items="${uList.nav.indexList}">
					<c:choose>
						<c:when test="${i != uList.nav.currentPage}">
							<li><a href="/Gestade/schedule/index/${i}">${i}</a></li>
						</c:when>
						<c:otherwise>
							<li><a class="active" href="#">${i}</a></li>
						</c:otherwise>
					</c:choose>
				</c:forEach>
				<c:if test="${!uList.nav.lastPage}">
				<li><a href="/Gestade/schedule/index/${uList.nav.pageCount}">»</a></li>
				</c:if>
			</ul>

		</div>
	</div>
</c:if>