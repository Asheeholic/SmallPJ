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
	<h1>자유게시판 글쓰기</h1>
	<c:if test="${not empty message }">
		<p>${message }</p>	
	</c:if>
	
	<form id="frm" name="frm" action="snsInsert.do" method="post">
		<table>
			<tr>
				<th>작성자</th>
				<td><input type="text" id="writer" name="writer" placeholder="작성자를 입력하세요" required="required"></td>
			</tr>
			<tr>
				<th>제목</th>
				<td><input type="text" id="title" name="title" placeholder="제목을 입력하세요" required="required"></td>
			</tr>
			<tr>
				<th>내용</th>
				<td><input type="text" id="contents" name="contents" placeholder="내용을 입력하세요" required="required"></td>
			</tr>
		</table>
		<br>
		<input type="submit" value="완료">
		<button type="button" onclick="location.href='snsList.do'">게시판으로</button>
	</form>
</body>
</html>