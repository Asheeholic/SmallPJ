<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1 align="center">회원 상세보기 </h1>
	<div align="center">
		<table border="1">
			<tr>
				<th width="70">아이디</th>
				<th width="150">비밀번호</th>
				<th width="150">이  름</th>
				<th width="150">나  이</th>
				<th width="150">학 과 명</th>
				<th width="150">직 책</th>
			</tr>
			
			<tr>
				<td align="center">${member.id }</td>
				<td align="center">${member.password }</td>
				<td align="center">${member.name }</td>
				<td align="center">${member.age }</td>
				<td align="center">${member.department }</td>
				<td align="center">${member.author }</td>
			</tr>
			
		</table> 
	</div>
</body>
</html>