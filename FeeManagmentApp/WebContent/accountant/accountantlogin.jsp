<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet">
<script>
function check()
{ 
     var email = document.form.email.value; 
     var password = document.form.password.value;

      
   
     if (email==null || email=="")
     { 
     alert("Email field can't be blank."); 
     return false; 
     }
     else if(password==null || password=="")
     { 
     alert("Password field can't be blank."); 
     return false; 
     } 
 } 
</script> 
</head>
<body>
 <%@include file="../resources/header.jsp" %>
 
 <div align="center">
  <h1>Accountant Login</h1>
  
  <form name="form" action="<%=request.getContextPath()%>/accountantlogin" method="post" onsubmit="return check()">
   <table style="with: 100%">
    <tr>
     <td>Email</td>
     <td><input type="text" name="email" /></td>
    </tr>
    <tr>
     <td>Password</td>
     <td><input type="password" name="password" /></td>
    </tr>
    
    	 <tr>
         <td></td>
         <td><input type="submit" value="Login"></input><input
         type="reset" value="Reset"></input></td>
         </tr>

   </table>
  </form>
  </div>
  
  <%@include file="../resources/footer.jsp" %>
</body>
</html>