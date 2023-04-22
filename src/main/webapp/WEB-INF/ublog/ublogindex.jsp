<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="./layout/ublogheader.jsp"%>

<div class="container mt-3">

	<div class="card">

		<c:forEach var="apost" items="${postList }">
			<div class="card-body">
				<h4 class="card-title">${apost.title}</h4>
				<a href="#" class="btn btn-secondary">상세보기</a>

			</div>
		</c:forEach>

	</div>

</div>

<%@ include file="./layout/ublogfooter.jsp"%>


