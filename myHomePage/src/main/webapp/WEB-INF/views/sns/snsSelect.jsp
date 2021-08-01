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
	${snsDetail[0].sTitle }
	<br>
	<c:forEach var="sns" items="${snsDetail }">
		${sns.cName } : ${sns.cSubject }
		<br>
	</c:forEach>
	<br>
	<hr>
	댓글쓰기
	<br>
	<form id="frm" name="frm" action="commentsInsert.do" method="post">
		<table>
			<input type="hidden" id="sno" name="sno" value="${snsDetail[0].sNo}">
			<tr>
				<th>작성자</th>
				<td><input type="text" id="writer" name="writer" placeholder="작성자를 입력하세요" required="required"></td>
			</tr>
			<tr>
				<th>내용</th>
				<td><input type="text" id="contents" name="contents" placeholder="내용을 입력하세요" required="required"></td>
			</tr>
		</table>
		<input type="submit" value="완료">
		<button type="button" onclick="location.href='snsList.do'">목록으로</button>
	</form>
</body>
</html>