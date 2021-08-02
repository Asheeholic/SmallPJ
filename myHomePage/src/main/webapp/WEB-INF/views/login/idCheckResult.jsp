<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
<script type="text/javascript">
	function formClose(){
		self.close();
	}
</script>
</head>
<body>
<body>
	<div class="container">
		<div class="row justify-content-center bg-secondary rounded">
			
			<div class="card bg-light o-hidden border-0 shadow-lg my-4">
				<div class=card-header><h1>아이디 중복 확인 결과</h1></div>
				<div class="card-body p-5">	
				
					<div class="text-center">
						<div class="form-group">
							<h3>${message }</h3>
							<button type="button" class="btn btn-primary btn-sm" onclick="formClose()">확인</button>
								
						</div>
					</div>
			
		
					</div>
				</div>
			</div>
		</div>	
		
			
</body>
</html>