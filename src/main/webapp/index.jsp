<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<% // 스크립틀릿
		
		
	%>
	webapp/index.jsp -> localhost/index.jsp <br>
	
	webapp/image/brown.png <br>
	
	<img src="<%= request.getContextPath() %>/image/sally.png"/>

</body>
</html>