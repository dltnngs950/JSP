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
		<h3>시작값 끝값 사이 누적합</h3>
		<input type="text" name="start" placeholder="시작 값"> <br>
		<input type="text" name="end" placeholder="끝 값"> <br>
		<input type="submit" value="전송">	
	</form>
	
	<form action="<%=request.getContextPath() %>/mulcalculation" method="post">
		<h3>곱하기</h3>
		<input type="text" name="fir" placeholder="첫 숫자"> <br>
		<input type="text" name="sec" placeholder="곱할 숫자"> <br>
		<input type="submit" value="전송">	
	</form>
	
	
	
</body>
</html>