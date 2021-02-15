
<!DOCTYPE html>
<html>
<head>
<style>
ul {
  list-style-type: none;
  margin: 0;
  padding: 0;
  overflow: hidden;
  background-color: #333;
}

li {
  float: left;
}

li a {
  display: block;
  color: white;
  text-align: center;
  padding: 14px 16px;
  text-decoration: none;
  margin-right:10px;
}

li a:hover:not(.active) {
  background-color: #111;
}

.active {
  background-color: #4CAF50;
}
</style>
</head>
<body>

<ul>
  <li><a href="https://github.com/PoKeM0oN2">Github</a></li>
  <li><a href="<%= request.getContextPath() %>/addstudent" class="nav-link">Add Student</a></li>
  <li><a href="<%= request.getContextPath() %>/viewstudent" class="nav-link">View Students</a></li>
  <li><a href="<%= request.getContextPath() %>/duefee" class="nav-link">Due Fee</a></li>

  <li>
 	<form action="searchstudent" method="get">
	<table>
	<tr><td><input type="number"  placeholder="Search by rollno" name="rollno" required/></td><td colspan="1" align="center">
	<input type="submit" value="Search"/></td></tr>
	
	</table>
	</form>
  </li>
  
  <li><a href="<%= request.getContextPath() %>/accountantlogout" class="nav-link">Logout</a></li>
</ul>

</body>
</html>