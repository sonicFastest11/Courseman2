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
				<h2 style="color: Blue" align="center">Login</h2>
			</div>
			<div class="card-body">
				<p class="italic">${message}</p>
				<form:form action="doLogin" method="post" modelAttribute="user">
					<div class="form-group">
						<label>Username</label>
						<form:input type="text" path="username" placeholder="username"
							class="form-control" />
					</div>
					<div class="form-group">
						<label>Password</label>
						<form:input type="password" path="password" placeholder="password"
							class="form-control" />
					</div>
					<div class="checkbox">
						<label> <input type="checkbox" value="remember-me">
							Remember Password
						</label>
					</div>
					<button type="submit" class="btn btn-primary btn-block">Login</button>
			        <div class="text-center">
						<a class="d-block small mt-3" href="register">Register an Account</a> 
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