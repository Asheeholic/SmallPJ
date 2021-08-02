<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>제출 폼</h1>
	<h3>아파치 자카르타의 프로젝트의 fileupload 모듈을 이용한 파일 업로드</h3>
	<h5>${message}</h5>
    <form method="post" action="examUpload.do" enctype="multipart/form-data">
        파일선택: <input type="file" name="uploadFile" multiple="multiple"/>
        <input type="hidden" name="id" value="${sessionId }">
        <input type="submit" value="Upload"/>
    </form>
</body>
</html>