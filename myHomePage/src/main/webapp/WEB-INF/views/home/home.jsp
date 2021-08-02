<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
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
<body>
	<div>
		<h1 class="trans1">${sessionName }님 환영합니다.</h1>
	</div>
	
	<div id="carouselExampleControls" class="carousel slide" data-bs-ride="carousel">
	  <div class="carousel-inner">
	    <div class="carousel-item active">
	      <img src="img/piano.jpg" class="d-block w-100 img-thumbnail" alt="...">
	    </div>
	    <div class="carousel-item">
	      <img src="img/prague.jpg" class="d-block w-100 img-thumbnail" alt="...">
	    </div>
	    <div class="carousel-item">
	      <img src="img/classical-music.jpg" class="d-block w-100 img-thumbnail" alt="...">
	    </div>
	  </div>
	  <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleControls" data-bs-slide="prev">
	    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
	    <span class="visually-hidden">Previous</span>
	  </button>
	  <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleControls" data-bs-slide="next">
	    <span class="carousel-control-next-icon" aria-hidden="true"></span>
	    <span class="visually-hidden">Next</span>
	  </button>
	</div>
</body>
</html>