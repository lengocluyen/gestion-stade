<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!-- mainmenu-->
<nav class="mainmenu">
	<div class="container">
		<!-- Menu-->
		<ul class="sf-menu" id="menu">
			<c:forEach items="${admenu}" var="admenu">
				<li><a href="${admenu.item.url}"
					class="${admenu.item.isCurrent}"> ${admenu.item.name} </a> <c:if
						test="${!empty admenu.enfants}">
						<ul>
							<c:forEach items="${admenu.enfants}" var="admenuenfant">
								<li><a href="${admenuenfant.url}"
									class="${admenuenfant.isCurrent}"> ${admenuenfant.name} </a></li>
							</c:forEach>
						</ul>
					</c:if></li>
			</c:forEach>
		</ul>
		<!-- End Menu-->
	</div>
</nav>
<!-- End mainmenu-->