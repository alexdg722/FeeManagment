
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
  <li><a href="https://github.com/alexdg722">Github</a></li>
  <li><a href="<%= request.getContextPath() %>/addaccountant" class="nav-link">Add Accountant</a></li>
  <li><a href="<%= request.getContextPath() %>/viewaccountant" class="nav-link">View Accountant</a></li>
  <li><a href="<%= request.getContextPath() %>/adminlogout" class="nav-link">Logout</a></li>
</ul>

</body>
</html>
