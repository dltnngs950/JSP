<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form action="${pageContextPath.request.getContextPath}/Scope" method="post">
	<input type="text" name="name" value="brown" placeholder="name-scope 입력"/> <br><br>
	<input type="submit" value="전송"/>
	</form>
	
</body>
</html>