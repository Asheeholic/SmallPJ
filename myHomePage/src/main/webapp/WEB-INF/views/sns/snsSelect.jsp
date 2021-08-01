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
	(${snsDetail[0].id})
	(${sessionId})
	<button type="button" onclick="deleteSns('${snsDetail[0].sno}')">삭제</button>
	<br>
	<c:forEach var="sns" items="${snsDetail }">
		${sns.cName } : ${sns.cSubject } : <button type="button" onclick="deleteComments('${sns.cNo}')">삭제</button>
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
	
	
	<!-- 게시글 삭제 -->
	<form id="delSns" name="delSns" action="snsdelete.do" method="post">
		<input type="hidden" id="sno" name="sno">
	</form>
	<script type="text/javascript">
		function deleteSns(n) {
			delSns.sno.value = n;
			delSns.submit();
		}
	</script>
	
	
	<!-- 댓글 삭제 -->
	<form id="delComment" name="frm" action="commentdelete.do" method="post">
		<input type="hidden" id="cno" name="cno">
	</form>
	<script type="text/javascript">
		function deleteComments(n) {
			delComment.cno.value = n;
			delComment.submit();
		}
	</script>
</body>
</html>