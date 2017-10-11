<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=8">
<meta http-equiv="Expires" content="0">
<meta http-equiv="Pragma" content="no-cache">
<meta http-equiv="Cache-control" content="no-cache">
<meta http-equiv="Cache" content="no-cache">
<title>专利信息管理后台</title>

<link href="<%=basePath%>css/bootstrap.min.css" rel="stylesheet">
<link href="<%=basePath%>css/metisMenu.min.css" rel="stylesheet">
<link href="<%=basePath%>css/dataTables.bootstrap.css" rel="stylesheet">
<link href="<%=basePath%>css/sb-admin-2.css" rel="stylesheet">
<link href="<%=basePath%>css/font-awesome.min.css" rel="stylesheet" type="text/css">
<link href="<%=basePath%>css/boot-crm.css" rel="stylesheet" type="text/css">

<script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
<script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
<script src="<%=basePath%>js/jquery.min.js"></script>
<script src="<%=basePath%>js/bootstrap.min.js"></script>
<script src="<%=basePath%>js/metisMenu.min.js"></script>
<script src="<%=basePath%>js/jquery.dataTables.min.js"></script>
<script src="<%=basePath%>js/dataTables.bootstrap.min.js"></script>
<script src="<%=basePath%>js/sb-admin-2.js"></script>
</head>

<body>
<div id="wrapper">
	<nav class="navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0">
	<div class="navbar-header">
		<button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
			<span class="sr-only">Toggle navigation</span> <span
				class="icon-bar"></span> <span class="icon-bar"></span> <span
				class="icon-bar"></span>
		</button>
		<a class="navbar-brand" href="#">BOOT专利信息管理后台 v1.0 &nbsp&nbsp&nbsp欢迎您：${sessionScope.user.username}</a>
		<a class="navbar-brand" href="<%=basePath%>authorityAction/logout.action" >注销</a>
	</div>
	<div class="navbar-default sidebar" role="navigation">
		<div class="sidebar-nav navbar-collapse">
			<ul class="nav" id="side-menu">
				<li class="sidebar-search">
					<div class="input-group custom-search-form">
						<input type="text" class="form-control" placeholder="查询内容...">
						<span class="input-group-btn">
							<button class="btn btn-default" type="button">
								<i class="fa fa-search" style="padding: 3px 0 3px 0;"></i>
							</button>
						</span>
					</div>
				</li>
				<li>
					<a href="<%=basePath%>userAction/list.action" class="active">
						<i class="fa fa-user fa-fw"></i> 管理员管理
					</a>
				</li>
				<li>
					<a href="<%=basePath%>authorAction/list.action" class="active">
						<i class="fa fa-edit fa-fw"></i> 作者管理
					</a>
				</li>
				<li>
					<a href="<%=basePath%>patentAction/list.action" class="active">
						<i class="fa fa-facebook fa-fw"></i> 专利管理
					</a>
				</li>
				<li>
					<a href="<%=basePath%>fileHandleAction/list.action" class="active">
						<i class="fa fa-file fa-fw"></i> 我的云网盘
					</a>
				</li>
				<li>
					<a href="<%=basePath%>fileHandleAction/toSearch.action" class="active">
						<i class="fa fa-search fa-fw"></i> 文件云搜索
					</a>
				</li>
			</ul>
		</div>
	</div>
	</nav>

  </div>
</div>

</body>
</html>
