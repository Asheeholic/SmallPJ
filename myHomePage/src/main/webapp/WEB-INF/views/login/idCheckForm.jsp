<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이디 중복체크</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
	<div class="container">
		<div class="row justify-content-center bg-secondary rounded">
			
			<div class="card bg-light o-hidden border-0 shadow-lg my-4">
				<div class=card-header><h1>아이디 중복 체크</h1></div>
				<div class="card-body p-5">	
					<div class="form-group">
						<div class="row">
								<span class="fs-5 text-secondary">아이디 중복 체크는 필수입니다.</span>
						</div>
					</div>
					<div class="text-center">
						<div class="form-group">
							<form id ="frm" action ="idCheck.do" method="post">
								<input type="text" class="form-control form-control-user" id="checkId" name="checkId" value="${checkId }">
								<input type="submit"  class="btn btn-primary btn-sm my-2" value="중복체크" >
							</form>
								
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>