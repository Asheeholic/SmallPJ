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
	<div>
		<h1>자유게시판</h1>
	</div>
	<div>
		<span class="fs-5 text-secondary">여러분들의 생각을 적어주세요!</span>
	</div>
	<div>
		${message }
	</div>
	<div class="card">
		<div class="card-body">
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
						<tr onclick="getSns('${sns.sNo}')">
							<td>${sns.sNo}</td>
							<td>${sns.sTitle}</td>
							<td>${sns.sWriter}</td>
							<td>${sns.sDate}</td>
							<td>${sns.sAno}</td>
						</tr>			
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
	<br>
	<div class="d-grid gap-2 d-md-flex justify-content-md-end">
		<button class="btn btn-outline-primary me-md-2" type="button" onclick="location.href='snsInsertForm.do'">글쓰기</button>
	</div>
	<form id="frm" name="frm" action="snsSelect.do" method="post">
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