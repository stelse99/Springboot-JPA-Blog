<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

<!-- 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 -->


<%@ include file="../layout/header.jsp"%> 
<div class="container">
	<form action="/auth/loginProc" method="post">
	  <div class="form-group">
	    <label for="title">Title</label>
	    <input type="text" name="title" class="form-control" placeholder="Enter Title" id="title">
	  </div>
	  
	  <div class="form-group">
  		<label for="comment">Content:</label>
  		<textarea name="content" class="form-control summernote" rows="5" id="content"></textarea>
	  </div>
	</form>
  
    <button id="btn-save" class="btn btn-primary">글쓰기</button>

</div>

<script>
	$('.summernote').summernote({
		//placeholder: 'Hello Bootstrap 4',
		tabsize: 2,
		height: 300
	});
</script>

<script src="/js/board.js"></script>
<%@ include file="../layout/footer.jsp"%>

