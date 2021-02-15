<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Add accountant</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css">
<script>
function check()
{ 
     var firstname = document.form.firstname.value; 
     var lastname = document.form.lastname.value;
     var password = document.form.password.value;
     var email = document.form.email.value;
     var address = document.form.address.value;
     var contact = document.form.contact.value;
      
   
     if (firstname==null || firstname=="")
     { 
     alert("Firstname field can't be blank."); 
     return false; 
     }
     else if(lastname==null || lastname=="")
     {
     alert("Lastname field can't be blank.");
 	 return false
     }
     else if(password==null || password=="")
     { 
     alert("Password field can't be blank."); 
     return false; 
     } 
     else if(email==null || email=="")
     {
     alert("Email field can't be blank.")
     return false;
     }
     else if(address==null || address=="")
     {
     alert("address field can't be blank")
     return false;
     }
     else if(contact==null || contact=="")
     {
     alert("Contact field can't be blank.")
     return false;
     }
 } 
 </script>
</head>
<body>
 <%@include file="../resources/headeraccountant.jsp" %>
 
	<br>
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">

				<form name="form" action="<%=request.getContextPath()%>/filter" method="get" onsubmit="return check()">
				<fieldset class="form-group">
					<label>Name</label> <input type="text"
						value="<c:out value='${StudentBean.name}' />" class="form-control"
						name="name" required="required">
				</fieldset>

				<fieldset class="form-group">
					<label>Email</label> <input type="text"
						value="<c:out value='${StudentBean.email}' />" class="form-control"
						name="email">
				</fieldset>
						
				<fieldset class="form-group">
					<label>Sex</label>
					<p>
						<input type="radio" id="male" name="sex" value="Male" required>
						<label for="male">Male</label><br>
					
						<input type="radio" id="female" name="sex" value="Female" required>
						<label for="female">Female</label><br>
					</p>
				</fieldset>
					
				<fieldset class="form-group">
					<label>Course</label> <input type="text"
						value="<c:out value='${StudentBean.course}' />" class="form-control"
						name="course">
				</fieldset>
				
				<fieldset class="form-group">
					<label>Fee</label> <input type="text"
						value="<c:out value='${StudentBean.fee}' />" class="form-control"
						name="fee">
				</fieldset>
				
				<fieldset class="form-group">
					<label>Paid</label> <input type="text"
						value="<c:out value='${StudentBean.paid}' />" class="form-control"
						name="paid">
				</fieldset>		
				
				<fieldset class="form-group">
					<label>Address</label> <input type="text"
						value="<c:out value='${StudentBean.address}' />" class="form-control"
						name="address">
				</fieldset>
				
				<fieldset class="form-group">
					<label>Contact</label> <input type="text"
						value="<c:out value='${StudentBean.contact}' />" class="form-control"
						name="contact">
				</fieldset>

				<button type="submit" class="btn btn-success">Add student</button>
				</form>
			</div>
		</div>
	</div>
	
	 <%@include file="../resources/footer.jsp" %>
</body>
</html>