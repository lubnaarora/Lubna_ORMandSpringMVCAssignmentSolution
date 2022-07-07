<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Customer details</title>
<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css"
	integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS"
	crossorigin="anonymous">

<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.12.1/css/all.css"
	crossorigin="anonymous">



</head>
<body>


	<nav class="navbar navbar-dark nav1">
		<h1 class="text1">Customer Relationship Management</h1>
	</nav>



	<div class="container">
		<a class="btn btn-primary" href="addcustomer">Add Customer</a>
		<hr>

		<table class="table table-bordered table-striped">
			<thead class="table-warning">
				<tr>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Email id</th>
					<th>Actions</th>
				</tr>
			</thead>

			<tbody>
				<c:forEach items="${customers}" var="tempCustomer">
					<tr>
						<td>${tempCustomer.firstName}</td>
						<td>${tempCustomer.lastName}</td>
						<td>${tempCustomer.email}</td>
						<td><a class="delete" id="del"
							href="deletecustomer?id=${tempCustomer.id}"
							onclick="if (!(confirm('Are you sure you want to delete this Customer?'))) return false">
								<i class="fa fa-trash" style="color: red; margin-left: 2rem"
								aria-hidden="true"></i>
						</a> <a href="editcustomer?id=${tempCustomer.id}"><i
								class="fas fa-edit" style="margin-left: 2rem"></i></a></td>




					</tr>
				</c:forEach>

			</tbody>
		</table>




	</div>


</body>
</html>