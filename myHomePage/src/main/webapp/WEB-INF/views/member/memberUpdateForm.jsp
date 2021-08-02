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
				<td align="center">${id }
					<input type="hidden" id="id" name="id" value='${id }'>
				</td>
				
			</tr>
			<tr>	
				<th width="150">비밀번호</th>
				<td align="center">
				<input type="text" id="password"  size="10" name="password" value='${password }'> 
				
				</td>
			</tr>
			<tr>	
				<th width="150">이  름</th>
				<td align="center">
					<input type="text" id="name" size="10" name="name" value='${name }'>
				</td>
			</tr>	
			<tr>	
				<th width="150">나  이</th>
				<td align="center">${age }</td>
			</tr>
			<tr>	
				<th width="150">학 과 명</th>
				<td align="center">${department }</td>
			</tr>
			<tr>
				<th width="150">직 책</th>
				<td align="center">${author }</td>
			</tr>
		</table> 
		<div>
			<input type="submit" value="수정">&nbsp;&nbsp;&nbsp;
			<button type="button" onclick="memberDelete()">회원삭제</button>&nbsp;&nbsp;&nbsp;
			<button type="button" onclick="location.href='memberList.do'">뒤로</button>&nbsp;&nbsp;&nbsp;
			
		</div>	
	</form>
	</div>
	<form id='deletefrm' name='deletefrm' action='memberDelete.do' method='post'>
		<input type="hidden" id="id" name="id" value="${id }" >
	</form>
	<script type="text/javascript">
		function memberDelete(){
			deletefrm.submit();
		}
	</script>	
</body>
</html>