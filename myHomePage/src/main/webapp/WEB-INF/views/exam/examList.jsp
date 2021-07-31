<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:forEach var="exam" items="${examList }">
		${exam.name }
		<br>
		${exam.fDate }
		<br>
	    <a href="examDownload.do?fileName=${exam.filePath }">${exam.filePath }</a>
	    <hr>
	</c:forEach>
</body>
</html>