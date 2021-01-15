<%@page import="java.sql.Connection"%>
<%@page import="org.apache.tomcat.jdbc.pool.DataSource"%>
<%@page import="javax.naming.InitialContext"%>
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
		// 서버에 등록된 자원을 요청할 때 사용하는 객체
		InitialContext context = new InitialContext();
	
		// 서버에 등록된 커넥션 풀 자원 요청
		DataSource ds = (DataSource) context.lookup("java:comp/env/jdbc/oracleDB"); // java:comp/env/ ( 자원요청할때 앞에쓰는 접두어 )
		
		// 시작
		long startT = System.currentTimeMillis();
		// 커넥션 데이터 소스부터 얻고 반환하는 반복작업
		for(int i = 0; i < 30; i++){
		Connection conn = ds.getConnection();
		conn.close();
		}
		// 종료( 작업 시간 확인 )
		long endT = System.currentTimeMillis();
		out.print("duration : " + (endT - startT));
	%>
	
	
</body>
</html>