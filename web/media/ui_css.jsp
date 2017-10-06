<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme() + "://"
		+ request.getServerName() + ":" + request.getServerPort()
		+ path + "/";
%>
	<!-- BEGIN GLOBAL MANDATORY STYLES -->
	<link href="<%=basePath%>media/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
	<link href="<%=basePath%>media/css/bootstrap-responsive.min.css" rel="stylesheet" type="text/css"/>
	<link href="<%=basePath%>media/css/font-awesome.min.css" rel="stylesheet" type="text/css"/>
	<link href="<%=basePath%>media/css/style-metro.css" rel="stylesheet" type="text/css"/>
	<link href="<%=basePath%>media/css/style.css" rel="stylesheet" type="text/css"/>
	<link href="<%=basePath%>media/css/style-responsive.css" rel="stylesheet" type="text/css"/>
	<link href="<%=basePath%>media/css/${session.emp.theme}.css" rel="stylesheet" type="text/css" id="style_color"/>
	<link href="<%=basePath%>media/css/uniform.default.css" rel="stylesheet" type="text/css"/>
	<!-- END GLOBAL MANDATORY STYLES -->
	<link rel="shortcut icon" href="<%=basePath%>media/image/favicon.ico" />