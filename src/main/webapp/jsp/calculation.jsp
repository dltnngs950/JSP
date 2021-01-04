<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<form action="<%=request.getContextPath() %>/Sumcalculation" method="post">
		<input type="text" name="start" placeholder="시작 값"> <br>
		<input type="text" name="end" placeholder="끝 값"> <br>
		<input type="submit" value="전송">	
	</form>
	
</body>
</html>