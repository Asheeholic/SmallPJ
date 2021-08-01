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
	</div>
	<div>
		<button type="button" onclick="location.href='memberList.do'">뒤로</button> &nbsp;&nbsp;&nbsp;
		<button type="button" onclick="update()">회원수정</button> &nbsp;&nbsp;&nbsp; <!-- 관리자 전용 -->
		<button type="button" onclick="location.href='memberDelete.do'">회원삭제</button>
	</div>
	<!-- 수정 -->
	<div>
		<form id="updatefrm" name="updatefrm" action="memberUpdateForm.do" method="post">
			<input type="hidden" id ="id" name ="id" value='${member.id }'>
			<input type ="hidden" id ="password" name="password" value='${member.password }'>
			<input type ="hidden" id = "name"  name="name" value='${member.name }' >
			<input type="hidden" id ="age" name ="age" value='${member.age }'>
			<input type="hidden" id ="department" name ="department" value='${member.department }'>
			<input type="hidden" id ="author" name ="author" value='${member.author }'>
			
		</form>
		<script type="text/javascript">
			function update(){
				updatefrm.submit();
			}
		</script>
	</div>
</body>
</html>