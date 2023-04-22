<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="./layout/ublogheader.jsp"%>

<div class="container mt-3">
	<h2>Post 등록페이지, 환영합니다</h2>
	<form>
		<div class="mb-3 mt-3">
			<label for="title">Title</label> 
			<input type="text"
				class="form-control" id="title" placeholder="Enter title"
				name="content">
		</div>
		<div class="mb-3 mt-3">
			<label for="content">Content:</label> 
			<input type="text"
				class="form-control" id="content" placeholder="Enter content"
				name="content">
		</div>


		
	</form>
	<button id="btn-insert" class="btn btn-primary" >포스트등록</button>
</div>

<script src="/js/post.js"></script>
<%@ include file="./layout/ublogfooter.jsp"%>
