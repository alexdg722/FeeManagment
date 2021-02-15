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
<%@include file="../resources/headeraccountant.jsp" %>
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">
				
				<form action="updatestudent" method="post">
			
					<h2>
            			Edit student
					</h2>
				

				<c:if test="${beanStudent != null}">
					<input type="hidden" name="rollno" value="<c:out value='${beanStudent.rollno}' />" />
				</c:if>

				<fieldset class="form-group">
					<label>Name</label> <input type="text"
						value="<c:out value='${beanStudent.name}' />" class="form-control"
						name="name" required="required">
				</fieldset>
				
				<fieldset class="form-group">
					<label>Email</label> <input type="text"
						value="<c:out value='${beanStudent.email}' />" class="form-control"
						name="email" required="required">
				</fieldset>
						
				<fieldset class="form-group">
					<label>Sex</label>
					<p>
						Male <input type="radio" name="sex" 
               			value="Male" <c:if test="${beanStudent.sex=='Male'}">checked</c:if>>
                
						Female <input type="radio" name="sex" 
                		value="Female" <c:if test="${beanStudent.sex=='Female'}">checked</c:if>>
                	<p>
				</fieldset>
							
				<fieldset class="form-group">
					<label>Course</label> <input type="text"
						value="<c:out value='${beanStudent.course}' />" class="form-control"
						name="course" required="required">
				</fieldset>
				
				<fieldset class="form-group">
					<label>Fee</label> <input type="text"
						value="<c:out value='${beanStudent.fee}' />" class="form-control"
						name="fee" required="required">
				</fieldset>
				
				<fieldset class="form-group">
					<label>Paid</label> <input type="text"
						value="<c:out value='${beanStudent.paid}' />" class="form-control"
						name="paid" required="required">
				</fieldset>
				
				<fieldset class="form-group">
					<label>Address</label> <input type="text"
						value="<c:out value='${beanStudent.address}' />" class="form-control"
						name="address" required="required">
				</fieldset>
				
				<fieldset class="form-group">
					<label>Contact</label> <input type="text"
						value="<c:out value='${beanStudent.contact}' />" class="form-control"
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
