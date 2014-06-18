<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<div class="content-box column-left main ">
	<div class="content-box-header">
		<h3>Trouvez votre covoiturage parmi plus d'un million de trajets
			à venir</h3>
	</div>
	<!-- end .content-box-header -->
	<div class="content-box-content">
		<form:form method="post" action="/Covoso/recherche"
			commandName="recherchebox">
			<fieldset id="recherche-box">
				<div>
					<span> <form:label path="endroitDepart">
							<spring:message code="label.endroitDepart" />
						</form:label>
					</span> <br />
					<form:input style="width:170px;" path="endroitDepart" />
					<br /> <span> <form:label path="villeDepart">
							<spring:message code="label.villeDepart" />
						</form:label>
					</span> <br />
					<form:select path="villeDepart">
						<form:options items="${listVille}" itemLabel="Nom"
							itemValue="VilleID" />
					</form:select>
				</div>
				<div>
					
					<span> <form:label path="endroitArrivee">
							<spring:message code="label.endroitArrivee" />
						</form:label>
					</span> <br />
					<form:input style="width:170px;" path="endroitArrivee" />
					<br /> <span> <form:label path="villeArrivee">
							<spring:message code="label.villeArrivee" />
						</form:label>
					</span> <br />
					<form:select path="villeArrivee">
						<form:options items="${listVille}" itemLabel="Nom"
							itemValue="VilleID" />
					</form:select>
				</div>
				<div style="display: block; position: relative">
					<span> <form:label path="dateDepart">
							<spring:message code="label.dateDepart" />
						</form:label>
						<script>
						$('document')
								.ready(
										function() {

											$('.dg').datepicker({
												showAnim : 'fadeIn'
											});
											$('.dg').datepicker({dateFormat: 'dd-mm-yyyy' });
											$('.dg').css("padding-left","30px")
													.after(
															'<img class="datepickericon" src="<c:url value="/resources/images/icons/calendar.png"/>" alt="calendar" />');
										});
					</script>
					</span> <br />
					<form:input path="dateDepart" style="width:90px;"
						class="dg" />
					<br /> <span> <form:label path="heureDepart">
							<spring:message code="label.heureDepart" />
						</form:label>
					</span> <br />
					<form:input path="heureDepart" style="width:115px;" />
				</div>
				<div>
					<input type="submit" style="margin-top: 75px;"
						value='<spring:message code="label.recheche"/>' />
				</div>
				<div style="clear: both;"></div>
			</fieldset>

		</form:form>
	</div>

</div>

