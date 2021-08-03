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
			<span class="fs-5 text-secondary">게시글</span>
		</div>
		<div class="col-12 p-3">
			<hr>
		</div>
		<div class="col-12 fs-4">
			<span class="text-primary">${snsDetail[0].sTitle }</span>
		</div>
		<div class="col-12 fs-5">
			<span>${snsDetail[0].sWriter} | ${snsDetail[0].id}</span>
		</div>
		
		<div class="col-12 p-3">
			<hr>
		</div>
		
		<div class="col-12">
			<span>${snsDetail[0].sContents }</span>
		</div>
		
		<div class="col-12 d-grid gap-2 d-md-flex justify-content-md-end">
			<c:if test="${session.id == snsDetail[0].id}">
				<button class="btn btn-outline-warning" type="button" onclick="UpdateFormSns('${snsDetail[0].sNo}')">게시글 수정</button>
				<button class="btn btn-outline-danger" type="button" onclick="deleteSns('${snsDetail[0].sNo}')">게시글 삭제</button>	
			</c:if>
		</div>
		
		<div class="col-12 p-3">
			<hr>
		</div>
		
		<!-- 댓글들 -->
		<div class="col-12">
			<c:forEach var="sns" items="${snsDetail}">
				<c:if test="${empty sns.cSubject}">
					<strong class="px-3">댓글이 없습니다. 첫번째 댓글의 주인공이 되세요!</strong>
				</c:if>
				
				<c:if test="${not empty sns.cSubject}">
					<strong class="px-3">${sns.cName}</strong>
					<span>${sns.cSubject}</span> 
					<c:if test="${session.id == sns.id1}">
						<%-- <button type="button" onclick="updateComments('${sns.cNo}')">댓글 수정</button> --%>
						<button class="btn btn-outline-danger btn-sm" type="button" onclick="deleteComments('${sns.cNo}', '${sns.sNo}')">댓글 삭제</button>
					</c:if>
					<br>
				</c:if>
			</c:forEach>
		</div>
		
		<div class="col-12 p-3">
			<hr>
		</div>
		
		<div class="col-12">
			<div class="row">
				<div class="col-12">
					<span class="fs-5">댓글쓰기</span>
				</div>
				<br>
				<form id="frm" name="frm" action="commentsInsert.do" method="post">
					<div class="row">
						<div class="col-12 mb-3">
							<label for="writer" class="form-label">작성자</label>
							<input type="text" class="form-control" id="writer" name="writer" placeholder="작성자를 입력하세요" required="required">
						</div>
						<div class="col-12 mb-3">
							<label for="contents" class="form-label">내용</label>
							<textarea id="contents" name="contents" class="form-control" placeholder="내용을 입력하세요" required="required"></textarea>
						</div>
						<input type="hidden" id="sno" name="sno" value="${snsDetail[0].sNo}">
						<div class="d-grid gap-2 d-md-flex justify-content-md-end">
							<input class="btn btn-outline-primary me-md-2" type="submit" value="완료">
							<button class="btn btn-outline-success me-md-2" type="button" onclick="location.href='snsList.do'">목록으로</button>
						</div>
					</div>
				</form>
			</div>
		</div>
		
	</div>
	
	<!-- 게시글 수정 -->
	<form id="updateSns" name="updateSns" action="snsUpdateForm.do" method="post">
		<input type="hidden" id="uno" name="uno">
	</form>
	<script type="text/javascript">
		function UpdateFormSns(n) {
			updateSns.uno.value = n;
			updateSns.submit();
		}
	</script>
	
	
	<!-- 게시글 삭제 -->
	<form id="delSns" name="delSns" action="snsDelete.do" method="post">
		<input type="hidden" id="dno" name="dno">
	</form>
	<script type="text/javascript">
		function deleteSns(n) {
			delSns.dno.value = n;
			delSns.submit();
		}
	</script>
	
	
	<!-- 댓글 삭제 -->
	<form id="delComment" name="delComment" action="commentDelete.do" method="post">
		<input type="hidden" id="cno" name="cno">
		<input type="hidden" id="csno" name="csno">
	</form>
	<script type="text/javascript">
		function deleteComments(n, m) {
			delComment.cno.value = n;
			delComment.csno.value = m;
			delComment.submit();
		}
	</script>
</body>
</html>