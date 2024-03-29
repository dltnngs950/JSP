<%@page import="kr.or.ddit.user.model.UserVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

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

<!-- <script src="/js/jquery/jquery-1.12.4.js"></script> -->
<link href="${cp}/css/bootstrap.css" rel="stylesheet">
<!-- Bootstrap core CSS -->
<script src="${cp}/css/bootstrap.js"></script>
<!-- Custom styles for this template -->
<link href="${cp}/css/dashboard.css" rel="stylesheet">
<link href="${cp}/css/blog.css" rel="stylesheet">

<script>
// 	사용자 수정 : method -> get action -> /userModify
// 	사용자 삭제 : method -> post action -> /deleteUser
// 	파라미터 : userid ( 공용 )  
// 문서 로딩이 완료 되었을때

	$(function(){
		
	$("#modifyBtn").on('click', function(){
		
		$("#frm").attr("method", "GET")
		$("#frm").attr("action", "${cp}/userModify")
		$("#frm").submit();
		
	})
	
	$("#deleteBtn").on('click', function(){
			if(confirm("정말 삭제 하시겠습니까?")==true){
			$("#frm").attr("method", "post")
			$("#frm").attr("action", "${cp}/deleteUser")
			alert("삭제 되었습니다")
			$("#frm").submit();
			} else {
				return;
			}
		})

	})
</script>

</head>

<body>

	<%@ include file="/common/header.jsp" %>
	
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
</nav>

	<div class="container-fluid">
		<div class="row">

			<div class="col-sm-3 col-md-2 sidebar">

					<%@include file="/common/left.jsp" %> 

			</div>
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
					
					<%
						UserVo userVo = (UserVo)request.getAttribute("user");
					%>
				

				<form class="form-horizontal" id="frm" role="form">
					<input type="hidden" name="userid" value="<%= userVo.getUserid()%>">
					
					<div class="form-group">
						<label for="userNm" class="col-sm-2 control-label">사용자 사진</label>
						<div class="col-sm-10">
						<img src="${cp}/profile/<%=userVo.getUserid() %>.png"/>
						</div>
					</div>
					
					<div class="form-group">
						<label for="userNm" class="col-sm-2 control-label">사용자 아이디</label>
						<div class="col-sm-10">
							<span><%=userVo.getUserid() %></span>
						</div>
					</div>

					<div class="form-group">
						<label for="userNm" class="col-sm-2 control-label">사용자 이름</label>
						<div class="col-sm-10">
							<span><%=userVo.getUsernm() %></span>
						</div>
					</div>
					
					<div class="form-group">
						<label for="userNm" class="col-sm-2 control-label">별명</label>
						<div class="col-sm-10">
							<span><%=userVo.getAlias() %></span>
						</div>
					</div>
					
					<div class="form-group">
						<label for="pass" class="col-sm-2 control-label">Password</label>
						<div class="col-sm-10">
							<span>***************</span>
						</div>
					</div>
					
					<div class="form-group">
						<label for="pass" class="col-sm-2 control-label">가입일자</label>
						<div class="col-sm-10">
							<span><fmt:formatDate value="<%=userVo.getReg_dt() %>" pattern="yyyy.MM.dd"/></span>
						</div>
					</div>
					
					<div class="form-group">
						<label for="pass" class="col-sm-2 control-label">도로주소</label>
						<div class="col-sm-10">
							<span><%=userVo.getAddr1() %></span>
						</div>
					</div>
					
					<div class="form-group">
						<label for="pass" class="col-sm-2 control-label">상세주소</label>
						<div class="col-sm-10">
							<span><%=userVo.getAddr2() %></span>
						</div>
					</div>
					
					<div class="form-group">
						<label for="pass" class="col-sm-2 control-label">우편번호</label>
						<div class="col-sm-10">
							<span><%=userVo.getZipcode()%></span>
						</div>
					</div>
					

					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
							
							<button type="button" id="modifyBtn" class="btn btn-default">사용자 수정</button>
							<button type="button" id="deleteBtn" class="btn btn-default">사용자 삭제</button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>
