<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	request.getContextType() : <%= request.getContentType() %> <br>
	request.getMethod() : <%= request.getMethod() %> <br>
	requset.getRequestURI() : <%= request.getRequestURI() %> <br>
	${cp}() : ${cp} <br>
	requset.getServerPort() :  <%= request.getServerPort() %><br><br><br>
	
	<img src="${cp}/image/sally.png"/>
	
</body>
</html>