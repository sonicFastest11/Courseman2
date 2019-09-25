<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
						<i class="fas fa-table"></i> List of Courses
					</div>
					<div class="card-body">
					<p class="italic">${message}</p>
						<div class="table-responsive">
							<table class="table table-bordered" id="dataTable" width="100%"
								cellspacing="0">
								<thead>
									<tr>
										<th>ID</th>
										<th>Course_Code</th>
										<th>Course_Name</th>
										<th>Course_Teacher</th>
										<th>Course_Time</th>
										<th>Course_Fee</th>
										<th>Course_Type</th>
										<th>Start Date</th>
										<th>End Date</th>
										<th>Enrol Course</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach var="course" items="${list}">
                						<tr>
											<td>${course.id}</td>
											<td>${course.code}</td>
											<td>${course.name}</td>
											<td>${course.userid.profile.name}</td>
											<td>${course.time}</td>
											<td>${course.fee}</td>
											<td>${course.type}</td>
											<td>${course.startDate}</td>
											<td>${course.endDate}</td>
											<td><a href="enrolCourseStudent?courseid=${course.id}">Enrol</a></td>
										</tr>
									</c:forEach>
								</tbody>

							</table>
						</div>
					</div>
					<div class="card-footer small text-muted">Updated yesterday
						at 11:59 PM</div>
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