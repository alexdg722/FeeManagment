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
 <%@include file="../resources/headeradmin.jsp" %>
	<br>
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">

				<form name="form" action="<%=request.getContextPath()%>/addaccountant" method="post" onsubmit="return check()">
				<fieldset class="form-group">
					<label>Firstname</label> <input type="text"
						value="<c:out value='${AccountantBean.firstname}' />" class="form-control"
						name="firstname" required="required">
				</fieldset>

				<fieldset class="form-group">
					<label>Lastname</label> <input type="text"
						value="<c:out value='${AccountantBean.lastname}' />" class="form-control"
						name="lastname">
				</fieldset>

				<fieldset class="form-group">
					<label>Password</label> <input type="password"
						value="<c:out value='${AccountantBean.password}' />" class="form-control"
						name="password">
				</fieldset>
				
				<fieldset class="form-group">
					<label>Email</label> <input type="text"
						value="<c:out value='${AccountantBean.email}' />" class="form-control"
						name="email">
				</fieldset>
				
				<fieldset class="form-group">
					<label>Address</label> <input type="text"
						value="<c:out value='${AccountantBean.address}' />" class="form-control"
						name="address">
				</fieldset>
				
				<fieldset class="form-group">
					<label>Contact</label> <input type="text"
						value="<c:out value='${AccountantBean.contact}' />" class="form-control"
						name="contact">
				</fieldset>

				<button type="submit" class="btn btn-success">Add accountant</button>
				</form>
			</div>
		</div>
	</div>
	 <%@include file="../resources/footer.jsp" %>
</body>
</html>