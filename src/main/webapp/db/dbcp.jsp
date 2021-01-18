<%@page import="java.sql.Connection"%>
<%@page import="org.apache.commons.dbcp2.BasicDataSource"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		BasicDataSource bs = (BasicDataSource)application.getAttribute("bs");
	
		// 시작
		long startT = System.currentTimeMillis();
		// 커넥션 데이터 소스부터 얻고 반환하는 반복작업
		for(int i = 0; i < 30; i++){
		Connection conn = bs.getConnection();
		conn.close();
		}
		// 종료( 작업 시간 확인 )
		long endT = System.currentTimeMillis();
		out.print("duration : " + (endT - startT));
		
	%>
	
</body>
</html>