<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>예담예술대학교 LMS</title>

<link href="css/bootstrap.min.css" rel="stylesheet">

</head>
<body class="bg-dark">
	<div class="container-fluid">
		<div class="d-flex flex-stratch row" >
			<tiles:insertAttribute name="menu" />
			<div class="col-md-10 col-12">
				<div class="row">
					<div class="col-12 sticky-top"><tiles:insertAttribute name="header" /></div>
					<div class="col-12 bg-white m-3"><tiles:insertAttribute name="body" /></div>
					<div class="col-12"><tiles:insertAttribute name="footer" /></div>
				</div>
			</div>
		</div>
	</div>
	<%-- <tiles:insertAttribute name="header" />
	<tiles:insertAttribute name="menu" />
	<tiles:insertAttribute name="body" />
	<tiles:insertAttribute name="footer" /> --%>
	
	
<script src="js/bootstrap.bundle.min.js"></script>
</body>
</html>