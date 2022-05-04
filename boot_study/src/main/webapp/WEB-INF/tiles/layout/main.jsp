<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html>
<html lang="ko">
<head>
	<tiles:insertAttribute name="css"/>
	<tiles:insertAttribute name="script"/>
</head>
<body>
    <tiles:insertAttribute name="header"/>
    <tiles:insertAttribute name="contents"/>
    <tiles:insertAttribute name="footer"/>
</body>
</html>