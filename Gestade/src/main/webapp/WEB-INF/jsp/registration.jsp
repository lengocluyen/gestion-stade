<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<div class="panel-box">
	<div class="titles">
		<h4>Ajout d'une Inscription de Stade</h4>
	</div>
	<form:form class="form-theme" method="post" action="${action}"
		commandName="schedule">
		<div class="row">
			<c:if test="${!empty message}">

				<div class="alert alert-success">${message}</div>

			</c:if>
			<div class="form-group">
				<div class="col-md-6">

					<form:label path="stadeID">
						<spring:message code="label.stadeID" />
					</form:label>
					<form:select path="stadeID"  class="form-control">
							<form:options items="${stadelist}" itemLabel="name"
								itemValue="stadeID" />
						</form:select>
<!-- 					<form:input path="stadeID" maxlength="100" class="form-control" /> -->
				</div>
				<div class="col-md-6">
					<form:label path="dateOrder">
						<spring:message code="label.dateOrder" />
					</form:label>
					<form:select path="dateOrder"  class="form-control">
							<form:options items="${datelist}"/>
						</form:select>
										</div>
				
			</div>
		</div>
		<div class="row">
			<div class="form-group">
								<div class="col-md-6">

					<form:label path="fromHour">
						<spring:message code="label.fromHour" />
					</form:label>
					<form:select path="fromHour"  class="form-control">
							<form:options items="${hourlist}"/>
						</form:select>
				</div>
				<div class="col-md-6">

					<form:label path="toHour">
						<spring:message code="label.toHour" />
					</form:label>
					
					<form:select path="toHour"  class="form-control">
							<form:options items="${hourlist}"/>
						</form:select>
				</div>
			</div>
		</div>
		<div class="form-group">
			<div class="col-md-6">
				<form:label path="price">
					<spring:message code="label.price" />
				</form:label>
				<form:input path="price" maxlength="100" readonly="true" class="form-control" />
			</div>
		</div>
		<div class="row">
			<div class="col-md-12">
				<input type="submit" value="Submit" class="btn btn-lg btn-primary">
			</div>
		</div>
	</form:form>
</div>
<link rel="stylesheet"
	href='<c:url value="/resources/js/include/ui-1.10.0/ui-lightness/jquery-ui-1.10.0.custom.min.css"/>'
	type="text/css" />
<link rel="stylesheet"
	href='<c:url value="/resources/css/jquery.ui.timepicker.css?v=0.3.3"/>'
	type="text/css" />

<script type="text/javascript"
	src='<c:url value="/resources/js/include/jquery-1.9.0.min.js"/>'></script>
<script type="text/javascript"
	src='<c:url value="/resources/js/include/ui-1.10.0/jquery.ui.core.min.js"/>'></script>
<script type="text/javascript"
	src='<c:url value="/resources/js/include/ui-1.10.0/jquery.ui.widget.min.js"/>'></script>
<script type="text/javascript"
	src='<c:url value="/resources/js/include/ui-1.10.0/jquery.ui.tabs.min.js"/>'></script>
<script type="text/javascript"
	src='<c:url value="/resources/js/include/ui-1.10.0/jquery.ui.position.min.js"/>'></script>

<script type="text/javascript"
	src='<c:url value="/resources/js/jquery.ui.timepicker.js?v=0.3.3"/>'></script>

<script type="text/javascript"
	src="https://apis.google.com/js/plusone.js"></script>
<script>
jQuery(document).ready(function() {
		 var _gaq = _gaq || [];
	        _gaq.push(['_setAccount', 'UA-24327002-1']);
	        _gaq.push(['_trackPageview']);

	        (function() {
	            var ga = document.createElement('script'); ga.type = 'text/javascript'; ga.async = true;
	            ga.src = ('https:' == document.location.protocol ? 'https://ssl' : 'http://www') + '.google-analytics.com/ga.js';
	            var s = document.getElementsByTagName('script')[0]; s.parentNode.insertBefore(ga, s);
	        })();
		$('#fromHour').timepicker({
			showLeadingZero : false,
			onSelect : tpStartSelect,
			maxTime : {
				hour : 16,
				minute : 30
			}
		});
		alert("a2");

		$('#toHour').timepicker({
			showLeadingZero : false,
			onSelect : tpEndSelect,
			minTime : {
				hour : 9,
				minute : 15
			}
		});
		$('.datepicker').datepicker({
			dateFormat : 'mm-dd-yy'
		});
	});

	// when start time change, update minimum for end timepicker
	function tpStartSelect(time, endTimePickerInst) {
		$('#fromHour').timepicker('option', {
			minTime : {
				hour : endTimePickerInst.hours,
				minute : endTimePickerInst.minutes
			}
		});
	}

	// when end time change, update maximum for start timepicker
	function tpEndSelect(time, startTimePickerInst) {
		$('#toHour').timepicker('option', {
			maxTime : {
				hour : startTimePickerInst.hours,
				minute : startTimePickerInst.minutes
			}
		});
	}
</script>