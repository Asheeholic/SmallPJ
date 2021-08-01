<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>자유게시판 수정</h1>
	<form id="frm" name="frm" action="snsUpdate.do" method="post">
		<table>
			<tr>
				<th>작성자</th>
				<td><input type="text" id="writer" name="writer" value="${snsDetail[0].sWriter}" placeholder="작성자를 입력하세요" required="required"></td>
			</tr>
			<tr>
				<th>제목</th>
				<td><input type="text" id="title" name="title" value="${snsDetail[0].sTitle}" placeholder="제목을 입력하세요" required="required"></td>
			</tr>
			<tr>
				<th>내용</th>
				<td><input type="text" id="contents" name="contents" value="${snsDetail[0].sContents}" placeholder="내용을 입력하세요" required="required"></td>
			</tr>
		</table>
		<br>
		<input type="hidden" id="sno" name="sno" value="${snsDetail[0].sNo}">
		<input type="submit" value="수정">
	</form>
</body>
</html>