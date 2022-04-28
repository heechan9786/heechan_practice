<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <%@ include file="./common/header.jsp" %>
    
	<a href="/post">글쓰기</a>
	
	<table>
	    <thead>
		    <tr>
		        <th class="one wide">번호</th>
		        <th class="ten wide">글제목</th>
		        <th class="two wide">작성자</th>
		        <th class="three wide">작성일</th>
		    </tr>
	    </thead>
	
	    <tbody>
	    	<c:forEach var="board" items="${ boardList }">
	    		<tr>
	    			<td>${board.ID}</td>
	    			<td>${board.TITLE}</td>
	    			<td>${board.REG_ID}</td>
	    			<fmt:formatDate var="reg_dt" value="${board.REG_DATE}" pattern="yyyy-MM-dd HH:mm"/>
	    			<td>${reg_dt}</td>
	    		</tr>
	    	</c:forEach>
	    </tbody>
	</table>
</body>
</html>