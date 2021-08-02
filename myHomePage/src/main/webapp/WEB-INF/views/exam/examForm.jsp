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
				<span class="fs-5 text-secondary">파일은 100mb까지 가능합니다. 동영상 위주로 올려주세요.</span>
			</div>
			<div class="col-12">
				<span class="fs-5 text-danger">올린 파일은 교수만이 확인 가능합니다!</span>
			</div>
			<div class="col-12">
				<h3>${message }</h3>
			</div>
			<div class="col-12 p-3">
				<hr>
			</div>
		    <form method="post" action="examUpload.do" enctype="multipart/form-data">
				<div class="input-group d-grid gap-2 d-md-flex justify-content-md-end">
				    <input type="file" class="form-control" name="uploadFile" multiple="multiple"/>
			    </div>   
				<div class="d-grid gap-2 d-md-flex justify-content-md-end">
				    <input class="btn btn-outline-primary" type="submit" value="업로드"/>				
				</div>			       
				<input type="hidden" name="id" value="${sessionId }">
			</form>		
			<!-- <div class="input-group mb-3">
				<input type="file" class="form-control" id="inputGroupFile02">
				<label class="input-group-text" for="inputGroupFile02">Upload</label>
			</div> -->
		</div>
	</div>
</body>
</html>