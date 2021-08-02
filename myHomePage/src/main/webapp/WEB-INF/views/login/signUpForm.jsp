<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	 function alertDialogBox() {
		 alert("회원가입이 완료 되었습니다.");
	 }
	 function check_pw(){
  
         if(document.getElementById('password').value !='' && document.getElementById('passcheck').value!=''){
             if(document.getElementById('password').value==document.getElementById('passcheck').value){
                 document.getElementById('check').innerHTML='비밀번호가 일치합니다.'
                 document.getElementById('check').style.color='blue';
             }
             else{
                 document.getElementById('check').innerHTML='비밀번호가 일치하지 않습니다.';
                 document.getElementById('check').style.color='red';
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
<body>
	<div align="center">
		<div>
			<h1>회 원 가 입</h1>
			<div>
				<form id="frm" name="frm" action="memberInsert.do" method="post" onsubmit="alertDialogBox();">
					<div>
						<table border="1">
							<tr>
								<th width="150">아이디</th>
								<td width="350">
									<input type="text" id="id" name="id" placeholder="아이디 입력" required="required">
									<input type="button" value="중복확인" onclick="idCheck()">
									
								</td>
							</tr>
							<tr>
								<th width= "150">비밀번호</th>
								<td width= "350">
									<input type="password" id="password" name="password" placeholder="비밀번호 입력" required="required" onchange="check_pw()">
								</td>
							</tr>
							<tr>
								<th width= "150">비밀번호 확인</th>
								<td width= "350">
									<input type="password" id="passcheck" name="passcheck" placeholder="비밀번호 확인" onchange="check_pw()" required="required" ><span id="check"></span>
								</td>
							</tr>
							<tr>
								<th width= "150">이 름</th>
								<td width= "350">
									<input type="text" id="name" name="name" required="required">
								</td>
							</tr>
							<tr>
								<th width= "150">나 이</th>
								<td width= "350">
									<input type="text" id="age" name="age" required="required">
								</td>	
							</tr>
							<tr>
								<th width= "150">학과명</th>
								<td width= "350">
									<select name ="department" id="department" required="required">
										<option selected="selected">선택</option>
										<option value="성악과">성악과</option>
										<option value="작곡가">작곡가</option>
									</select>
								</td>
							</tr>
							<tr>
								<th width= "150">직책</th>
								<td width= "350">
									<select name ="author" id="author"name="author" required="required">
										<option selected="selected">선택</option>
										<option value="STUDENT">STUDENT</option>
										<option value="PROFESSOR">PROFESSOR</option> 
									</select>
								</td>
							</tr>	
						</table>
					</div><br/>
					<div>
						<input type="submit" value="회원가입" >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					</div>
				</form>
						<button onClick="location.href='loginform.do'">홈으로</button>
			</div>
		</div>
	</div>
	

</body>
</html>