<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<style>
.errors {
	color: red;
	font-style: italic;
}
</style>
<meta charset="utf-8">


<title>Admin - Dashboard</title>

<!-- Custom fonts for this template-->
<link href="template/admin/vendor/fontawesome-free/css/all.min.css"
	rel="stylesheet" type="text/css">

<!-- Page level plugin CSS-->
<link href="template/admin/vendor/datatables/dataTables.bootstrap4.css"
	rel="stylesheet">

<!-- Custom styles for this template-->
<link href="template/admin/css/sb-admin.css" rel="stylesheet">

</head>

<body id="page-top">

	<!-- //header here -->
	<jsp:include page="/common/admin/header.jsp" />

	<div id="wrapper">

		<!-- Sidebar -->
		<!-- //menu here -->
		<jsp:include page="/common/admin/menu.jsp" />
		<div id="content-wrapper">

			<div class="container-fluid">

				<!-- Breadcrumbs-->
				<ol class="breadcrumb">
					<li class="breadcrumb-item"><a href="#">Dashboard</a></li>
					<li class="breadcrumb-item active">Overview</li>
				</ol>

				<div class="card mb-3">
					<div class="card-header">
						<i class="fas fa-table"></i> Add User
					</div>
					<div class="card-body">
						<font color="red">${message}</font>
						<form:form action="save" method="post" modelAttribute="user">
							<div class="form-group">
								<label>Username</label>
								<form:input type="text" path="username" placeholder="username"
									class="form-control" />
									<form:errors path="username" cssClass="errors"  />
							</div>
							<div class="form-group">
								<label>Password</label>
								<form:input type="password" path="password"
									placeholder="password" class="form-control" />
									<form:errors path="password" cssClass="errors"  />
							</div>
							<div class="form-group">
								<label>ConfirmPassword</label>
								<form:input type="password" path="confirmPassword"
									placeholder="confirmPassword" class="form-control" />
							</div>
							<div class="form-group">
								<label>Role</label>
								<form:select path="idRole" items="${roles}"
									itemLabel="role_name" itemValue="id" class="form-control" />
							</div>


							<button type="submit" class="btn btn-primary btn-block">Add</button>
			        
						</form:form>
					</div>
				</div>


			</div>
			<!-- /.container-fluid -->

			<!-- Sticky Footer -->
			<!-- //footer here -->
			<jsp:include page="/common/admin/footer.jsp" />

		</div>
		<!-- /.content-wrapper -->

	</div>
	<!-- /#wrapper -->

	<!-- Scroll to Top Button-->
	<a class="scroll-to-top rounded" href="#page-top"> <i
		class="fas fa-angle-up"></i>
	</a>

	<!-- Logout Modal-->
	<!-- //logout here -->
	<jsp:include page="/common/admin/logout.jsp" />

	<!-- Bootstrap core JavaScript-->
	<script src="template/admin/vendor/jquery/jquery.min.js"></script>
	<script
		src="template/admin/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

	<!-- Core plugin JavaScript-->
	<script src="template/admin/vendor/jquery-easing/jquery.easing.min.js"></script>

	<!-- Page level plugin JavaScript-->
	<script src="template/admin/vendor/chart.js/Chart.min.js"></script>
	<script src="template/admin/vendor/datatables/jquery.dataTables.js"></script>
	<script src="template/admin/vendor/datatables/dataTables.bootstrap4.js"></script>

	<!-- Custom scripts for all pages-->
	<script src="template/admin/js/sb-admin.min.js"></script>

	<!-- Demo scripts for this page-->
	<script src="template/admin/js/demo/datatables-demo.js"></script>
	<script src="template/admin/js/demo/chart-area-demo.js"></script>

</body>

</html>