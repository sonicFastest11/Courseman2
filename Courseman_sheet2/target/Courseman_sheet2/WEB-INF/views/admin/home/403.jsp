<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="utf-8">


<title>403</title>

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
	<jsp:include page="/common/admin/header2.jsp" />

	<div id="wrapper">

		<!-- Sidebar -->
		<!-- //menu here -->
		<jsp:include page="/common/admin/menu.jsp" />
		<div id="content-wrapper">

			<div class="container-fluid">
				<h1>Khong duoc truy cap trang admin</h1>
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