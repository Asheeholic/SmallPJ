<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<script type="text/javascript">
		function getRecord(n){
			frm.id.value = n;
			frm.submit();
		}
	</script>
</head>
<body>
	<div>
		<h1>학과 명단</h1>
		<table class="table table-hover">
			<tr>
				<th>학사아이디</th>
				<th>이 름</th>
				<th>학과명</th>
			</tr>
			<c:forEach var="member" items="${memberList }">
				<tr onclick="getRecord('${member.id}')">
					<td>${member.id }</td>
					<td>${member.name }</td>
					<td>${member.department }</td>
				</tr>
			</c:forEach>
		</table>
	</div><br/>
	<div class="d-grid gap-2 d-md-flex justify-content-md-end">
		<button class="btn btn-outline-primary" type="button" onclick="location.href='home.do'">홈으로</button>
	</div>
	<div>
		<form id="frm" name="frm" action="memberSelect.do" method="post">
			<input type="hidden" id="id" name="id">
		</form>
	</div>
	
</body>
</html>