<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>sidebar</title>
</head>
<body>
	<div class="d-flex flex-column flex-shrink-0 p-3 sidebar text-white col-md-2 col-12 border-end border-secondary">
	    <a href="/" class="d-flex align-items-center mb-3 mb-md-0 me-md-auto text-white text-decoration-none">
	      <svg class="bi me-2" width="40" height="32"><use xlink:href="#bootstrap"/></svg>
	      <span class="fs-4">예담예술대학교</span>
	    </a>
	    <hr>
	    <ul class="nav nav-pills flex-column mb-auto">
	      <li class="nav-item">
	        <a href="#" class="nav-link active" aria-current="page">
	          <svg class="bi me-2" width="16" height="16"><use xlink:href="#home"/></svg>
	          Home
	        </a>
	      </li>
	      <li>
	        <a href="#" class="nav-link text-white">
	          <svg class="bi me-2" width="16" height="16"><use xlink:href="#speedometer2"/></svg>
	          Community
	        </a>
	      </li>
	      <li>
	        <a href="examForm.do" class="nav-link text-white">
	          <svg class="bi me-2" width="16" height="16"><use xlink:href="#table"/></svg>
	          Exam Submit (stu only)
	        </a>
	      </li>
	      <li>
	        <a href="examList.do" class="nav-link text-white">
	          <svg class="bi me-2" width="16" height="16"><use xlink:href="#grid"/></svg>
	          ExamList (prof only)
	        </a>
	      </li>
	      <c:if test="${session.author == 'ADMIN'}">
		      <li>
		        <a href="memberList.do" class="nav-link text-white">
		          <svg class="bi me-2" width="16" height="16"><use xlink:href="#people-circle"/></svg>
		          MemberList (admin only)
		        </a>
		      </li>
	      </c:if>
	    </ul>
	    <hr>
	    <div class="dropdown">
	      <a href="#" class="d-flex align-items-center text-white text-decoration-none dropdown-toggle" id="dropdownUser1" data-bs-toggle="dropdown" aria-expanded="false">
	        <img src="https://github.com/mdo.png" alt="" width="32" height="32" class="rounded-circle me-2">
	        <strong>${sessionName }님 (${sessionId })</strong>
	      </a>
	      <ul class="dropdown-menu dropdown-menu-dark text-small shadow" aria-labelledby="dropdownUser1">
	        <li><a class="dropdown-item" href="#">New project...</a></li>
	        <li><a class="dropdown-item" href="#">Settings</a></li>
	        <li><a class="dropdown-item" href="#">Profile</a></li>
	        <li><hr class="dropdown-divider"></li>
	        <li><a class="dropdown-item" href="logout.do">Sign out</a></li>
	      </ul>
	    </div>
  	</div>
</body>
</html>