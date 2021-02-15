<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Edit accountant</title>

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">

</head>

</head>
<body>
<%@include file="../resources/headeradmin.jsp" %>
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">
				
				<form action="updateaccountant" method="post">
			
					<h2>
            			Edit accountant
					</h2>
				

				<c:if test="${bean != null}">
					<input type="hidden" name="id" value="<c:out value='${bean.id}' />" />
				</c:if>

				<fieldset class="form-group">
					<label>Firstname</label> <input type="text"
						value="<c:out value='${bean.firstname}' />" class="form-control"
						name="firstname" required="required">
				</fieldset>
				
				<fieldset class="form-group">
					<label>Firstname</label> <input type="text"
						value="<c:out value='${bean.lastname}' />" class="form-control"
						name="lastname" required="required">
				</fieldset>
				
				<fieldset class="form-group">
					<label>Email</label> <input type="text"
						value="<c:out value='${bean.email}' />" class="form-control"
						name="email" required="required">
				</fieldset>
				
				<fieldset class="form-group">
					<label>Password</label> <input type="text"
						value="<c:out value='${bean.password}' />" class="form-control"
						name="password" required="required">
				</fieldset>
				
				<fieldset class="form-group">
					<label>Address</label> <input type="text"
						value="<c:out value='${bean.address}' />" class="form-control"
						name="address" required="required">
				</fieldset>
				
				<fieldset class="form-group">
					<label>Contact</label> <input type="text"
						value="<c:out value='${bean.contact}' />" class="form-control"
						name="contact" required="required">
				</fieldset>


				<button type="submit" class="btn btn-success">Save</button>
				</form>
			</div>
		</div>
	</div>

	<%@include file="../resources/footer.jsp" %>
</body>
</html>
