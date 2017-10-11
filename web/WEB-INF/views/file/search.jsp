<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@include file="../main/index.jsp" %>
<div style="padding-left:300px;" id="page-wrapper">
    <div style="font-size: 25px ; padding-right: 80px ;padding-top: 200px">Input Your Files Names!</div>

    <form action="${pageContext.request.contextPath}/fileHandleAction/search.action" method="post"  style="margin: 10px">
        <input type="text" name="searchContent" maxlength="50" size="40" style="font-size: 20px;padding-left:3px; padding-top: 5px; padding-bottom: 3px; text-shadow: blue;" >
        <input type="submit" style=" font-size: 24px;cursor: pointer" value="Search">
    </form>
</div>