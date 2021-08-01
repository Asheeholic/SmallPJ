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

<h1 align="center">회원 상세보기(수정) </h1>
	<div align="center">
	<form id="frm" name="frm" action="memberUpdate.do" method="post">
		<table border="1">
			<tr>
				<th width="70">아이디</th>
				<td align="center">${member.id }</td>
			</tr>
			<tr>	
				<th width="150">비밀번호</th>
				<td align="center">${member.password }</td>
			</tr>
			<tr>	
				<th width="150">이  름</th>
				<td align="center">${member.name }</td>
			</tr>	
			<tr>	
				<th width="150">나  이</th>
				<td align="center">${member.age }</td>
			</tr>
			<tr>	
				<th width="150">학 과 명</th>
				<td align="center">${member.department }</td>
			</tr>
			<tr>
				<th width="150">직 책</th>
				<td align="center">${member.author }</td>
			</tr>
		</table> 
		<div>
			<button type="button" onclick="location.href='memberList.do'">뒤로</button>&nbsp;&nbsp;&nbsp;
			<input type="submit" value="수정">
		</div>	
	</form>
	</div>
		
</body>
</html>