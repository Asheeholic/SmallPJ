<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이디 중복체크</title>
</head>
<body>
	<div align="center">
		<h1>아이디 중복 체크</h1>
	
		<form id ="frm" action ="idCheck.do" method="post">
			<input type="text" id="checkId" name="checkId" value="${checkId }">
			<input type="submit" value="중복체크">
		
	
		</form>
	</div>
</body>
</html>