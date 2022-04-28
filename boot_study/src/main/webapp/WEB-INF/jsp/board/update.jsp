<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/post/edit/${boardDto.ID}" method="post">
	    <input type="hidden" name="_method" value="put"/>
	    <input type="hidden" name="ID" value="${boardDto.ID}"/>
	
	    제목 : <input type="text" name="TITLE" value="${boardDto.TITLE}"> <br>
	    작성자 : <input type="text" name="REG_ID" value="${boardDto.REG_ID}"> <br>
	    <textarea name="CONTENT">${boardDto.CONTENT}</textarea><br>
	
	    <input type="submit" value="수정">
	</form>
</body>
</html>