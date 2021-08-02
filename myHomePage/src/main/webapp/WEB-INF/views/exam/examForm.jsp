<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-12">
				<h1>시험의 동영상 파일들을 올려주세요!</h1>
			</div>
			<div class="col-12">
				<h3>${message }</h3>
			</div>
			<div class="col-12 d-grid gap-2 d-md-flex justify-content-md-end">
			    <form method="post" action="examUpload.do" enctype="multipart/form-data">
			        <input type="file" name="uploadFile" multiple="multiple"/>
			        <input type="hidden" name="id" value="${sessionId }">
			        <input class="btn btn-outline-primary" type="submit" value="업로드"/>
			    </form>		
			</div>
		</div>
	</div>
</body>
</html>