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
	${memberLists[0].id }
	<div>
		<h1>학과 명단</h1>
		<table border="1">
			<tr>
				<th width="150">학사아이디</th>
				<th width="150">이 름</th>
		
				<th width="150">학과명</th>
			</tr>
			<c:forEach var="member" items="${memberList }">
				<tr>
					<td align="center">${member.id }</td>
					<td align="center">${member.name }</td>
					
					<td align="center">${member.department }</td>
					
				</tr>
			</c:forEach>
		</table>
	</div><br/>
	<div>
		<button type="button" onclick="location.href='home.do'">홈으로</button>&nbsp;&nbsp;&nbsp;
		<button type="button" onclick="location.href='memberInsert.do'">회원추가</button>
	</div>
</body>
</html>