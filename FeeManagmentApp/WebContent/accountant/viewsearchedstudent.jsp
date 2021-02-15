<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View Students</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
</head>
<body>
<%@include file="../resources/headeraccountant.jsp" %>

<div class="row">
		<!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

		<div class="container">
			<h4 class="text-center">Student with Rollno= <c:out value="${searchedStudent.rollno}" /> </h4>
			<hr>
			<div class="container text-left">

			
			</div>
			<br>
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>Roll ID</th>
						<th>Name</th>
						<th>Email</th>
						<th>Sex</th>
						<th>Course</th>
						<th>fee</th>
						<th>paid</th>
						<th>due</th>
						<th>address</th>
						<th>contact</th>
						<th>Actions</th>

					</tr>
				</thead>
				<tbody>
				

						<tr>
							<td><c:out value="${searchedStudent.rollno}" /></td>
							<td><c:out value="${searchedStudent.name}" /></td>
							<td><c:out value="${searchedStudent.email}" /></td>
							<td><c:out value="${searchedStudent.sex}" /></td>
							<td><c:out value="${searchedStudent.course}" /></td>
							<td><c:out value="${searchedStudent.fee}" /></td>
							<td><c:out value="${searchedStudent.paid}" /></td>
							<td><c:out value="${searchedStudent.due}" /></td>
							<td><c:out value="${searchedStudent.address}" /></td>
							<td><c:out value="${searchedStudent.contact}" /></td>
							
							<td><a href="editstudent?rollno=<c:out value='${searchedStudent.rollno}' />">Edit</a>
								&nbsp;&nbsp;&nbsp;&nbsp; <a
								href="deletestudent?rollno=<c:out value='${searchedStudent.rollno}' />">Delete</a></td>
							
					
						</tr>
					<!-- } -->

			</table>
		</div>
	</div>

<%@include file="../resources/footer.jsp" %>
</body>
</html>