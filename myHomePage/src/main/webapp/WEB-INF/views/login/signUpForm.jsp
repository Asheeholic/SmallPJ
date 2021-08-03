<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link href="css/bootstrap.min.css" rel="stylesheet">
<style>
	.jb-xx-small {font-size: xx-small; }
	  .jb-red { color: red; }
</style>

<script type="text/javascript">
	
	 function check_pw(){
  
         if((document.getElementById('password').value != '') && (document.getElementById('passcheck').value != '')){
             
        	 if(document.getElementById('password').value == document.getElementById('passcheck').value){
        		// 비밀번호 일치
        		 document.getElementById('check').innerHTML = '비밀번호가 일치합니다.'
                 document.getElementById('check').style.color ='blue';
        		 
             } else {
                 // 비밀번호 불일치
            	 document.getElementById('check').innerHTML = '비밀번호가 일치하지 않습니다.';
                 document.getElementById('check').style.color = 'red';
                 
             }
         }
     }
	function idCheck(){
		let id = document.getElementById("id").value;
		
		openWin = window.open("idCheckForm.do?id="+id,
					"childForm", "width=570, height=350, resizable = no, scrollbars= no ");
	}
  </script>

</head>
<body class="bg-dark">
	<div class="container">
	
		<div class="mt-4 row justify-content-center bg-secondary rounded">
			
			<div class="col-xl-10 col-lg-12 col-md-9">
			
				<div class="card bg-light o-hidden border-0 shadow-lg my-5">
					 <div class="card-body p-0">
						
						<div class="row">
							<div class="col-lg-6 d-none d-lg-block">
                            	<img src="img/collage2.jpg" class="image-thumnail rounded-start">
                            </div>
                            <div class="col-lg-6">
                            	<div class="p-5">
	                            	<div class="text-center">
	                            		<h3 class="h4 text-gray-900 mb-4 jb-red">${message }</h3>
	                                	<h1 class="h4 text-gray-900 mb-4">Create an Account!</h1>
	                            	</div>
	                            
									<form class="user" id="frm" name="frm" action="memberInsert.do" method="post"
											onsubmit="alertDialogBox();">
										<!--first-form end 아이디입력 중복제거 시작-->	
										<div class="form-group row">
											<div class="col-sm-8 mb-3 mb-sm-0">
												<div class="row">
													<div class="col-12">
														<span>아이디</span>
													</div>
													<div class="col-10">
														<input type="text" class="form-control form-control-user" 
																id="id" name="id" aria-describedby="emailHelp"
																placeholder="아이디 입력" required="required" >
													</div>
													<div class="col-2">
														<input type="button"  class="btn btn-primary btn-sm" value="중복확인" onclick="idCheck()">														
													</div>			
												</div>
											</div>
										</div>
										<!--first-form end 아이디입력 중복제거 종료 -->	
										
										<!-- 비밀번호, 비밀번호 확인 시작 -->
										<div class="form-group row">
											<div class="col-sm-6 mb-3 mb-sm-0">
												<div class="row">
													<div class="col-12">
														<span>비밀번호</span>
													</div>
													<div class="col-12">
														<input type="password" class="form-control form-control-user"
															id="password" name="password" placeholder="비밀번호 입력"
															required="required" onchange="check_pw()">
													</div>
												</div>			
											</div>
											<div class="col-sm-6 mb-3 mb-sm-0">
												<div class="row">
													<div class="col-12">
														<span>비밀번호 확인</span>
													</div>
													<div class="col-12">
														<input type="password" id="passcheck" class="form-control form-control-user"
																name="passcheck" placeholder="비밀번호 확인" onchange="check_pw()"
																required="required"><span id="check" class="jb-xx-small"></span>
													</div>
												</div>
											</div>
										</div>
										<!-- 비밀번호, 비밀번호 확인 종료 -->
										
										<!-- 이름 시작 -->
										<div class="form-group" >
											<div class="row">
												<div class="col-12">
													<span>이름</span>
												</div>
												<div class="col-12">
													<input type="text" class="form-control form-control-user"
																id="name" name="name" placeholder="이 름" required="required" >
												</div>
											</div>
										</div>
										<!-- 이름 종료 -->
										
										<!-- 나이 시작 -->
										<div class="form-group">
											<div class="row">
												<div class="col-12">
													<span>나이</span>
												</div>
												<div class="col-12">
													<input type="text"  class="form-control form-control-user"
														id="age" name="age" placeholder="나 이" required="required">
												</div>
											</div>
										</div>			
										<!-- 나이 종료 -->
										
										<!-- 학과명, 직책 설정 시작 -->	
										<div class="form-group row my-2">
											<div class="col-sm-6 mb-3 mb-sm-0">
												<div class="row">
													<div class="col-12">
														<span>학과명</span>
													</div>
													<div class="col-12">
														<select name="department" id="department" class="form-control form-control-user"
																required="required">
															<option selected="selected">선택</option>
															<option value="성악과">성악과</option>
															<option value="작곡가">작곡가</option>
														</select>
													</div>
												</div>
											</div>
											<div class="col-sm-6 mb-3 mb-sm-0">
												<div class="row">
													<div class="col-12">
														<span>직책</span>
													</div>
													<div>
														<select name="author" id="author" class="form-control form-control-user"
																name="author" required="required">
															<option selected="selected">선택</option>
															<option value="STUDENT">STUDENT</option>
															<option value="PROFESSOR">PROFESSOR</option>
														</select>
													</div>
												</div>
											</div>
										</div>
										<!-- 학과명, 직책 설정 종료 -->	
										<div class="form-group row">
											<input type="submit" value="회원가입" class="btn btn-primary btn-sm">
						
										</div>	
									</form>
								</div> 
								<!-- <div class="p-5"> 50번 종료 부분-->
								<br/>
								
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>	
	</div>
</body>
</html>