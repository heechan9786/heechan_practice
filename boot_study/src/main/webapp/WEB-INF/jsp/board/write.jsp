<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form  action="/post" method="post">
		제목 : <input type="text" name="TITLE"> <br>
        작성자 : <input type="text" name="REG_ID"> <br>
        <textarea name="CONTENT"></textarea><br>

        <input type="submit" value="등록">
	</form>
</body>
</html>