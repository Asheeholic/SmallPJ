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
	<div class="row">
		<div class="col-12">
			<span class="fs-1">시험리스트</span>
		</div>
		<div class="col-12">
			<span class="fs-5 text-secondary">학생들이 올린 시험 파일들입니다.</span>
		</div>
		<div class="col-12">
			<table class="table table-hover">
				<tr>
					<th>아이디</th>
					<th>이름</th>
					<th>파일</th>
					<th>등록 날짜</th>
				</tr>
				<c:forEach var="exam" items="${examList }">
					<tr>
						<td>${exam.id }</td>
						<td>${exam.name }</td>
						<td><a href="examDownload.do?fileName=${exam.filePath }">${exam.filePath }</a></td>
						<td>${exam.fDate }</td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
</body>
</html>