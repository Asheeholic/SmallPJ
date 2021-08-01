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
	<table class="table table-light table-hover">
		<thead>
			<tr>
				<th>게시판 번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>날짜</th>
				<th>댓글수</th>
			</tr>			
		</thead>
		<tbody>
			<c:forEach var="sns" items="${snsList }">
				<tr onclick="getSns('${snsList }')">
					<td>${sns.sNo}</td>
					<td>${sns.sTitle}</td>
					<td>${sns.sWriter}</td>
					<td>${sns.sDate}</td>
					<td>${sns.sAno}</td>
				</tr>			
			</c:forEach>
		</tbody>
	</table>
	<form id="frm" name="frm" method="post">
		<input type="hidden" id="sno" name="sno">
	</form>
	<script type="text/javascript">
		function getSns(n) {
			frm.sno.value = n;
			frm.submit();
		}
	</script>
</body>
</html>