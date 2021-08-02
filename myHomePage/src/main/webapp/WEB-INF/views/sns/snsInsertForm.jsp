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
	<div class="row">
		<div class="col-12">
			<h1>자유게시판 글쓰기</h1>
		</div>
		<div class="col-12">
			<c:if test="${not empty message }">
				<h3>${message }</h3>
			</c:if>
		</div>
		<div class="col-12">
			<form id="frm" name="frm" action="snsInsert.do" method="post">
				<div class="row">
					<div class="col-12 mb-3">
						<label for="writer" class="form-label">작성자</label>
						<input type="text" class="form-control" id="writer" name="writer" value="${snsDetail[0].sWriter}" placeholder="작성자를 입력하세요" required="required">
					</div>
					<div class="col-12 mb-3">
						<label for="title" class="form-label">제목</label>
						<input type="text" class="form-control" id="title" name="title" value="${snsDetail[0].sTitle}" placeholder="제목을 입력하세요" required="required">
					</div>
					<div class="col-12 mb-3">
						<label for="contents" class="form-label">내용</label>
						<textarea id="contents" name="contents" class="form-control" placeholder="내용을 입력하세요" required="required">${snsDetail[0].sContents}</textarea>
					</div>
					<div class="col-12 d-grid gap-2 d-md-flex justify-content-md-end">
						<input class="btn btn-outline-primary me-md-2" type="submit" value="완료">
						<button class="btn btn-outline-success me-md-2" type="button" onclick="location.href='snsList.do'">목록으로</button>					
					</div>
				</div>
			</form>
		</div>
	</div>
</body>
</html>