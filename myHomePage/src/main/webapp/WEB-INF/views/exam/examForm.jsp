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
    <form method="post" action="examUpload.do" enctype="multipart/form-data">
        파일선택: <input type="file" name="uploadFile" multiple="multiple"/>
        전송자: <input type="text" name="sender">
        <input type="submit" value="Upload"/>
    </form>
</body>
</html>