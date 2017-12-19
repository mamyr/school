<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Success</title>
<link href="assets/css/bootstrap-united.css" rel="stylesheet" />

</head>
<body>
	<script src="jquery-1.8.3.js">
		
	</script>

	<script src="bootstrap/js/bootstrap.js">
		
	</script>

	<div class="navbar navbar-default">

		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target=".navbar-responsive-collapse">
				<span class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
		</div>

		<div class="navbar-collapse collapse navbar-responsive-collapse">
			<form class="navbar-form navbar-right">
				<input type="text" class="form-control" placeholder="Search">
			</form>
			<ul class="nav navbar-nav navbar-right">
				<li><a href="/school">Home</a></li>
				<li><a href="student.html">Student Add</a></li>
				<li class="active"><a href="success.html">List</a></li>
			</ul>
		</div>
		<!-- /.nav-collapse -->
	</div>

	<!-- 
	<legend>Electronic School Login Success</legend>
	 -->
	<div class="panel panel-success">
		<div class="panel-heading">
			<h3 class="panel-title">Electronic School</h3>
		</div>
		<div class="panel-body">
			<div class="alert alert-dismissable alert-success">
				<button type="button" class="close" data-dismiss="alert">×</button>
				<strong>Well done!</strong> You successfully logged-into the system.
				Now you can explore the complete features!
			</div>
		</div>
	</div>
<!-- List all Students -->
	<div class="container">

		<c:if test="${not empty msg}">
		    <div class="alert alert-${css} alert-dismissible" role="alert">
			<button type="button" class="close" data-dismiss="alert" aria-label="Close">
				<span aria-hidden="true">×</span>
			</button>
			<strong>${msg}</strong>
		    </div>
		</c:if>

		<h1>All Students</h1>

		<table class="table table-striped">
			<thead>
				<tr>
					<th>#ID</th>
					<th>UserName</th>
					<th>Email</th>
					<th>Full Name</th>
					<th>Action</th>
				</tr>
			</thead>

			<c:forEach var="student" items="${students}">
			    <tr>
				<td>
					${student.id}
				</td>
				<td>${student.userName}</td>
				<td>${student.emailAddress}</td>
				<td>${student.firstName}&nbsp;${student.lastName}</td>
				<td>
				  <spring:url value="/students/${student.id}/delete.html" var="deleteUrl" />

				  <button class="btn btn-danger" onclick="this.disabled=true;location.href='${deleteUrl}'">Delete</button>
                </td>
			    </tr>
			</c:forEach>
			<tr>
			<td colspan="5">
				<button class="btn btn-info" onclick="location.href='/school/student.html'">Add New Student</button>
			</td>
			</tr>
		</table>

	</div>

	<div></div>
	<div></div>
	<a class="btn btn-primary" href="<spring:url value="login.html"/>">Login
		as different user/Exit?</a>
</body>
</html>