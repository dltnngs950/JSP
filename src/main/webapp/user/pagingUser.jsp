<%@page import="kr.or.ddit.common.model.PageVo"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="kr.or.ddit.user.model.UserVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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

<link href="bootstrap.css" rel="stylesheet"><!-- Bootstrap core CSS -->
<script src="${cp }/js/bootstrap.js"></script><!-- Custom styles for this template -->

	<!-- Custom styles for this template -->
<link href="${cp }/css/dashboard.css" rel="stylesheet">

<link href="${cp }/css/blog.css" rel="stylesheet">
<script>
	$(function(){
		$(".user").on("click", function(){
			// this : 클릭 이벤트가 발생한 element
			// data-속성명 data-userid, 속성명은 대소문자 무시하고 소문자로 인식
			// data-userId ==> data-userid
			var userid = $(this).data("userid");
			$("#userid").val(userid);
			$("#frm").submit();
		})
	})
</script>
</head>

<body>
<%@ include file="/common/header.jsp" %>

<form id="frm" action="${cp }/user">
	<input type="hidden" id="userid" name="userid" value="">
</form>

	
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
</div><div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
				

<div class="row">
	<div class="col-sm-8 blog-main">
		<h2 class="sub-header">사용자 페이징 리스트</h2>
		<div class="table-responsive">
			<table class="table table-striped">
			
			<tr>
					<th>사용자 아이디</th>
					<th>사용자 이름</th>
					<th>사용자 별명</th>
					<th>등록일시</th>
				</tr>
			
			<%
				List<UserVo> list = (List<UserVo>)request.getAttribute("userlist");
			%>
			<c:forEach items="${userlist }" var="user">
				<tr class="user" data-userid="${user.userid }">
					<td>${user.userid }</td>
					<td>${user.usernm }</td>
					<td>${user.alias }</td>
					<td><fmt:formatDate value="${user.reg_dt}" pattern="yyyy.MM.dd"/></td>
				</tr>
			</c:forEach>
			
				</table>
		</div>

		<a class="btn btn-default pull-right">사용자 등록</a>

		<div class="text-center">
		requset.getAttribute("pageVO") : <%=((PageVo)request.getAttribute("pageVo")).getPage() %>
		
		<%-- pagination 값이 4이므로 1부터 까지 4번반복된다
			전체 사용자수 : 16명
			페이지 사이즈 : 5
			전체 페이지 수 : 4페이지
		 --%>
		 pagination : <%=request.getAttribute("pagination") %>
				<ul class="pagination">
				<li class="prev"><a href="${cp }/pagingUser?page=1&pageSize=${pageVo.pageSize}">,,,</a></li>
				<c:forEach begin="1" end="${pagination }" var="i">
					<c:choose>
						<c:when test="${pageVo.page == i }">
		 					<li class="active"><span>${i }</span></li>
						</c:when>
						<c:otherwise>
							<li><a href="${cp }/pagingUser?page=${i }
							&pageSize=${pageVo.pageSize}">${i }</a></li>
						</c:otherwise>
					</c:choose>
				</c:forEach>				
		<li class="next"><a href="${cp }/pagingUser?page=${pagination }
		&pageSize=${pageVo.pageSize}">,,,</a></li>
		
				</ul>
		</div>
	</div>
</div>
	</div>
		</div>
	</div>
</body>
</html>
