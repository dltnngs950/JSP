<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style >
	table {
		border: 1px solid lightgray;
		width : 100%;
		text-align : center;
	}
</style>
</head>
<body>
<table border="1">
	
	<% 
		for (int i = 1 ; i <= 9; i++ ){
			out.write("<tr>");
		for(int j = 2; j <= 9; j++) {
			out.write("<td>" + j + " * " + i + " = " + (j*i) + "</td>");
		}
		out.write("</tr>");
		}
	%>

</table>

</body>
</html>