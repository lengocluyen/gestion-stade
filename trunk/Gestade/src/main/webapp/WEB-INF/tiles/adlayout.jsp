<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<!-- Make IE8 behave like IE7, necessary for charts -->
<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7">
<!-- CSS -->
<link rel="stylesheet" type="text/css" media="screen"
	href='<c:url value="/resources/css/reset.css" />'>
<link rel="stylesheet" type="text/css" media="screen"
	href='<c:url value="/resources/css/main.css"/>'>
<link rel="stylesheet" type="text/css" media="screen"
	href='<c:url value="/resources/css/custom-theme/jquery-ui-1.8.1.custom.css"/>'>

<!-- IE specific CSS stylesheet -->
<!--[if IE]>
			<link rel="stylesheet" type="text/css" media="screen" href='<c:url value="/resources/css/ie.css"/>' />
		<![endif]-->

<!-- This stylesheet contains advanced CSS3 features that do not validate yet -->
<link rel="stylesheet" type="text/css" media="screen"
	href='<c:url value="/resources/css/css3.css"/>'>

<!-- JavaScript -->
<script type="text/javascript" src='<c:url value="/resources/js/jquery-1.4.2.min.js"/>'></script>
<script type="text/javascript" src='<c:url value="/resources/js/jquery-ui.min.js"/>'></script>
<script type="text/javascript" src='<c:url value="/resources/js/jquery.wysiwyg.js"/>'></script>
<script type="text/javascript" src='<c:url value="/resources/js/jquery.rounded.js"/>'></script>
<script type="text/javascript" src='<c:url value="/resources/js/excanvas.js"/>'></script>
<script type="text/javascript" src='<c:url value="/resources/js/jquery.visualize.js"/>'></script>
<script type="text/javascript" src='<c:url value="/resources/js/script.js"/>'></script>
<title><tiles:insertAttribute name="title" ignore="true" /></title>
</head>
<body>
	<div id="bokeh">
		<div id="container">
			<div id="header">
				<tiles:insertAttribute name="header" />
				<tiles:insertAttribute name="menu" />
				<h2>
					<img height="32" src='<c:url value="/resources/images/icon.jpg"/>'
						alt="Manage Users">
					<label>&nbsp;&nbsp;&nbsp;Bienvenue à la gestion du sysème de covoiturage</label>
				</h2>
			</div>
			<div id="content">
				<tiles:insertAttribute name="body" />
				<div class="clear"></div>
			</div>

		</div>
	</div>
	<tiles:insertAttribute name="footer" />
</body>
</html>