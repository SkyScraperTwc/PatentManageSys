<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme() + "://"
		+ request.getServerName() + ":" + request.getServerPort()
		+ path + "/";
%>
  	<!-- BEGIN JAVASCRIPTS(Load javascripts at bottom, this will reduce page load time) -->
	<!-- BEGIN CORE PLUGINS -->
	<script src="<%=basePath%>media/js/jquery-1.10.1.min.js" type="text/javascript"></script>
	<script src="<%=basePath%>media/js/jquery-migrate-1.2.1.min.js" type="text/javascript"></script>
	<!-- IMPORTANT! Load jquery-ui-1.10.1.custom.min.js before bootstrap.min.js to fix bootstrap tooltip conflict with jquery ui tooltip -->
	<script src="<%=basePath%>media/js/jquery-ui-1.10.1.custom.min.js" type="text/javascript"></script>      
	<script src="<%=basePath%>media/js/bootstrap.min.js" type="text/javascript"></script>
	<script src="<%=basePath%>media/js/jquery.slimscroll.min.js" type="text/javascript"></script>
	<script src="<%=basePath%>media/js/jquery.blockui.min.js" type="text/javascript"></script>  
	<script src="<%=basePath%>media/js/jquery.cookie.min.js" type="text/javascript"></script>
	<script src="<%=basePath%>media/js/jquery.uniform.min.js" type="text/javascript" ></script>
	<!-- END CORE PLUGINS -->