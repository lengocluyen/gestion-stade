<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!-- end #nav -->
<nav class="mainmenu">
	<div class="container">
		<!-- Menu-->
		<ul class="sf-menu" id="menu">
		<c:forEach items="${menu}" var="menu">
			<li><a href="${menu.url}" class="${menu.isCurrent}">
				${menu.name} </a></li>
			</c:forEach>
		</ul>
		<!-- End Menu-->
	</div>
</nav>
