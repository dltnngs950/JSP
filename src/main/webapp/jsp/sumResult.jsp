<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>sumResult</h2>
	
	start와 end의 누적값 : <%= session.getAttribute("sumResult") %> <br><br>
	
	fir와 sec의 곱셈값 : <%= session.getAttribute("sumResult1") %>

</body>
</html>