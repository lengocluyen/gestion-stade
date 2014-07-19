<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<div class="panel-box" style="padding-bottom:15px;">
	<div class="titles">
		<h4>Infomartion de votre compte</h4>
	</div>
	<div class="row">
		<div class="col-md-2"><p>Nom et prenom:</p></div>
		<div class="col-md-2"><p>${account.fullname}</p></div>
		<div class="col-md-2"><p>Telephone:</p></div>
		<div class="col-md-2"><p>${account.phonenumber}</p></div>
		<div class="col-md-2"><p>Pseudo:</p></div>
		<div class="col-md-2"><p>${account.username}</p></div>
	</div>
	<div class="row">
		<div class="col-md-2"><p>Date de creation:</p></div>
		<div class="col-md-2"><p>${account.dateCreate}</p></div>
		<div class="col-md-2"><p>Le temps final de login:</p></div>
		<div class="col-md-6"><p>${account.lastLogin}</p></div>
		
	</div>
	<div class="row">
	<div class="col-md-12">
			<input type="button" onclick="location.href='http://localhost:8080/Gestade/inscription';"  class="btn btn-primary" value='Modifier' />
		</div>
	</div>
</div>