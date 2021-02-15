<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View accountants</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
</head>

</head>
<body>
<%@include file="../resources/headeradmin.jsp" %>

<div class="row">
		<!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

		<div class="container">
			<h3 class="text-center">List of Accountants</h3>
			<hr>
			<div class="container text-left">

			
			</div>
			<br>
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>Id</th>
						<th>Firstname</th>
						<th>Lastname</th>
						<th>Email</th>
						<th>Password</th>
						<th>Address</th>
						<th>Contact</th>
						<th>Actions</th>

					</tr>
				</thead>
				<tbody>
				
					<c:forEach var="accountant" items="${accountantList}">

						<tr>
							<td><c:out value="${accountant.id}" /></td>
							<td><c:out value="${accountant.firstname}" /></td>
							<td><c:out value="${accountant.lastname}" /></td>
							<td><c:out value="${accountant.email}" /></td>
							<td><c:out value="${accountant.password}" /></td>
							<td><c:out value="${accountant.address}" /></td>
							<td><c:out value="${accountant.contact}" /></td>

							<td><a href="editaccountant?id=<c:out value='${accountant.id}' />">Edit</a>
								&nbsp;&nbsp;&nbsp;&nbsp; <a
								href="deleteaccountant?id=<c:out value='${accountant.id}' />">Delete</a></td>
						</tr>
					</c:forEach>
					<!-- } -->
				</tbody>

			</table>
		</div>
	</div>

<%@include file="../resources/footer.jsp" %>
</body>
</html>