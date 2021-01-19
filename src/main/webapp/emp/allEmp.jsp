<%@page import="kr.or.ddit.staff.model.EmpVo"%>
<%@page import="kr.or.ddit.user.model.UserVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">

<title>Jsp</title>

<%@include file="/common/common_lib.jsp" %>

<script src="/js/jquery/jquery-1.12.4.js"></script><link href="bootstrap.css" rel="stylesheet"><!-- Bootstrap core CSS -->
<script src="${cp}/js/bootstrap.js"></script><!-- Custom styles for this template -->

	<!-- Custom styles for this template -->
<link href="${cp}/css/dashboard.css" rel="stylesheet">

<link href="${cp}/css/blog.css" rel="stylesheet">
</head>

<body>

	
<nav class="navbar navbar-inverse navbar-fixed-top">
	<div class="container-fluid">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false"
				aria-controls="navbar">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="#">JSP/SPRING</a>
		</div>
		<div id="navbar" class="navbar-collapse collapse">
			<ul class="nav navbar-nav navbar-right">
				<li><a href="#">Dashboard</a></li>
				<li><a href="#">Settings</a></li>
				<li><a href="#">Profile</a></li>
				<li><a href="#">Help</a></li>
			</ul>
			<form class="navbar-form navbar-right">
				<input type="text" class="form-control" placeholder="Search...">
			</form>
		</div>
	</div>
</nav><div class="container-fluid">
		<div class="row">
			
<div class="col-sm-3 col-md-2 sidebar">
	<%@include file="/common/left.jsp" %>
</div><div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
				

<div class="row">
	<div class="col-sm-8 blog-main">
		<h2 class="sub-header">직원</h2>
		<div class="table-responsive">
			<table class="table table-striped">
			
			<tr>
					<th>직원 번호</th>
					<th>직원 이름</th>
					<th>담당 업무</th>
					<th>입사 일시</th>
				</tr>
			
			<%
				List<EmpVo> list = (List<EmpVo>)request.getAttribute("emplist");
		
				for(int i =0; i < list.size(); i++){
					
					EmpVo vo = list.get(i);
					
					if(list != null){
				
			%>
				<tr>
					<td><%=vo.getEmpno() %></td>
					<td><%=vo.getEname() %></td>
					<td><%=vo.getJob() %></td>
					<td><%=vo.getHiredate_sdf() %></td>
				</tr>
			<%
					}
				}
			%>
			
				</table>
		</div>

		<a class="btn btn-default pull-right">직원 등록</a>

		<div class="text-center">
			<ul class="pagination">
				<li><a href="#">1</a></li>
				<li><a href="#">2</a></li>
				<li><a href="#">3</a></li>
				<li><a href="#">4</a></li>
				<li><a href="#">5</a></li>
			</ul>
		</div>
	</div>
</div>
	</div>
		</div>
	</div>
</body>
</html>
