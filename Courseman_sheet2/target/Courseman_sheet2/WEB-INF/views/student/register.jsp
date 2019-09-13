<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<style>
p.italic {
	color: red;
	font-style: italic;
	}
.errors {
	color: red;
	font-style: italic;
}

</style>
<meta charset="utf-8">
<title>Login</title>
<!-- Custom fonts for this template-->
<link href="template/admin/vendor/fontawesome-free/css/all.min.css"
	rel="stylesheet" type="text/css">

<!-- Custom styles for this template-->
<link href="template/admin/css/sb-admin.css" rel="stylesheet">

</head>
<body>
	<div class="container">
		<div class="card card-login mx-auto mt-5">
			<div class="card-header">
				<h2 style="color: Blue" align="center">Register</h2>
			</div>
			<div class="card-body">
				<p class="italic">${message}</p>
				<form:form action="saveStudent" method="post" modelAttribute="user">
					<div class="form-group">
						<label>Username</label>
						<form:input type="text" path="username" placeholder="username"
							class="form-control" />
							<form:errors path="username" cssClass="errors"  />
					</div>
					<div class="form-group">
						<label>Password</label>
						<form:input type="password" path="password" placeholder="password"
							class="form-control" />
							<form:errors path="password" cssClass="errors"  />
					</div>
					<div class="form-group">
						<label>ConfirmPassword</label>
						<form:input type="password" path="confirmPassword"
							placeholder="confirmPassword" class="form-control" />
					</div>


					<button type="submit" class="btn btn-primary btn-block">Register</button>
			        <div class="text-center">
						<a class="d-block small mt-3" href="login">Login</a>
					</div>
				</form:form>

			</div>
		</div>
	</div>
	<!-- Bootstrap core JavaScript-->
	<script src="template/admin/vendor/jquery/jquery.min.js"></script>
	<script
		src="template/admin/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

	<!-- Core plugin JavaScript-->
	<script src="template/admin/vendor/jquery-easing/jquery.easing.min.js"></script>
</body>
</html>