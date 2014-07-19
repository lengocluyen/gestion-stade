<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<script>
	$(document).ready(function() {
		var iframe = $("#iframschedule");
		iframe.contentWindow.focus();
	});
</script>
<div class="panel-box">
	<div class="titles" style="margin-bottom: 0px;">
		<h4>Emploi du temps</h4>
	</div>
	<div class="row" style="height: 900px; margin-top: 0px">
		<iframe id="iframschedule" width='100%' height='100%' frameborder='0'
			scrolling='no' src="/Gestade/emploidutempsview"> </iframe>
	</div>
</div>