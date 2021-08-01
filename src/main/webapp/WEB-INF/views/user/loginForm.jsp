<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

<%@ include file="../layout/header.jsp"%>
  
<div class="container">
	
	<form action="/action_page.php" method="post">
	  <div class="form-group">
	    <label for="username">Username:</label>
	    <input type="text" name="username" class="form-control" placeholder="Enter username" id="username">
	  </div>
	  
	  <div class="form-group">
	    <label for="password">Password:</label>
	    <input type="password" name="password" class="form-control" placeholder="Enter password" id="password">
	  </div>
	  
	  <div class="form-group form-check">
	    <label class="form-check-label">
	      <input type="checkbox" name="remember" class="form-check-input"> Remember me
	    </label>
	  </div>
	  <button id="btn-login" class="btn btn-primary">로그인</button>
	</form>
  
    
		
</div>

<!-- 전통 로그인 방식  -->
<!-- script src="/js/user.js"></script-->
<%@ include file="../layout/footer.jsp"%>