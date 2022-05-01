<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>${boardDto.TITLE}</h2>
	<p>작성일 : ${board.REG_DATE}</p>
	
	<p>${boardDto.CONTENT}</p>
	
	<!-- 수정/삭제 -->
	<div>
	    <a href="/post/edit/${boardDto.ID}">
	        <button>수정</button>
	    </a>
	
	    <form id="delete-form" action="/post/${boardDto.ID}" method="post">
	        <input type="hidden" name="_method" value="delete"/>
	        <button id="delete-btn">삭제</button>
	    </form>
	</div>
</body>
</html>