<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 form 영역</title>
<link href="css/bootstrap.min.css" rel="stylesheet">

<style>
	@keyframes fadein {
	    from {
	        opacity: 0;
	    }
	    to {
	        opacity: 1;
	    }
	}
	.trans1 {
		animation: fadein 1s;
	}
</style>

</head>
<body class="bg-dark">
	<div class="container">

        <!-- Outer Row -->
        <div class="mt-4 row justify-content-center bg-secondary rounded">

            <div class="col-xl-10 col-lg-12 col-md-9">

                <div class="card bg-light o-hidden border-0 shadow-lg my-5">
                    <div class="card-body p-0">
                        <!-- Nested Row within Card Body -->
                        <div class="row">
                            <div class="col-lg-6 d-none d-lg-block">
                            	<img src="img/collage.jpg" class="image-thumnail rounded-start">
                            </div>
                            <div class="col-lg-6 trans1">
                                <div class="p-5">
                                    <div class="text-center">
                                        <h1 class="h4 text-gray-900 mb-4">Renault Samsung</h1>
                                    </div>
                                    <form class="user" id="frm" action="login.do" method="post">
                                        <div class="form-group mb-2">
                                            <input type="text" class="form-control form-control-user"
                                                id="id" name="id" aria-describedby="emailHelp"
                                                placeholder="Enter Id..." required="required">
                                        </div>
                                        <div class="form-group mb-2">
                                            <input type="password" class="form-control form-control-user"
                                            id="password" name="password" placeholder="Password" required="required">
                                        </div>
                        				<div class="form-group mb-2">
                        					<div class="d-flex justify-content-center">
		                                        <input type="submit" class="btn btn-primary btn-user btn-block" value="Login">                        				
                        					</div>
                        				</div>
                                        
                                    </form>
                                    <hr>
                                    
                                    <div class="text-center">
                                        <a class="small" href="signUpForm.do">Create an Account!</a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

            </div>

        </div>
		<div class="p-3 text-light d-flex justify-content-center">
			<p>
				Copyright 2021. Han Jae Ho, Lee Geon Hui All pictures cannot be copied without permission. 
			</p>
		</div>
    </div>


<script src="js/bootstrap.bundle.min.js"></script>
			
</body>
</html>