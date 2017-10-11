<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@include file="../main/index.jsp" %>
<div id="page-wrapper">
    <div class="row">
        <div class="col-lg-12">
            <h1 class="page-header">Your Files In Cloud System</h1>
        </div>
    </div>

    <div class="panel panel-default">
        <div class="panel-body">
            <form class="form-inline" enctype="multipart/form-data" action="${pageContext.request.contextPath }/fileHandleAction/upload.action" method="post">
                <div class="form-group">
                    <label for="uploadFile">上传文件</label>
                    <input type="file" class="fileupload" id="uploadFile" name="uploadFile"><br/>
                </div>
                <input type="submit" class="btn btn-primary"/>
            </form>
        </div>
    </div>

    <%--<button class="btn btn-default" onclick="addFileJs()">添加文件</button>--%>
    <%--<%@include file="fileAdd.jsp" %>--%>
    <%--<%@include file="fileEdit.jsp" %>--%>

    <div class="row" id="fileList">
        <div class="col-lg-12">
            <div class="panel panel-default">
                <div class="panel-heading">文件信息列表</div>
                <table class="table table-bordered table-striped">
                    <thead>
                    <tr>
                        <th>序号</th>
                        <th>文件名</th>
                        <th>文件大小(KB)</th>
                        <th>上传日期</th>
                        <th>下载文件</th>
                        <th>是否共享</th>
                        <th>操作</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${pagination.dataList}" var="fileBean" varStatus="stat">
                        <tr>
                            <td>${(pagination.currentPage-1)*pagination.pageSize+stat.count}</td>
                            <td>${fileBean.fileName}</td>
                            <td>${fileBean.fileSize}</td>
                            <td>${fileBean.createTime}</td>
                            <td>
                                <a href="${pageContext.request.contextPath}/fileHandleAction/download.action?downloadFileName=${fileBean.fileName }" class="btn btn-success btn-xs">点击下载</a>
                            </td>
                            <td>
                                <form>
                                    <select  id="${fileBean.id}" onchange="goChange(${fileBean.id},${fileBean.canShare})" style="width:80px;height:30px">
                                        <c:if test="${fileBean.canShare==false }">
                                            <option value="true">私有</option>
                                            <option value="false" >共享</option>
                                        </c:if>
                                        <c:if test="${fileBean.canShare==true }">
                                            <option value="false">共享</option>
                                            <option value="true" >私有</option>
                                        </c:if>
                                    </select>
                                </form>
                            </td>
                            <td>
                                <a href="javascript:void(0);" onclick="deleteFile(${fileBean.id})" class="btn btn-danger btn-xs">删除</a>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
                <div class="col-md-12 text-right">
                    <!-- 分页标签 -->
                    <ul class="pagination ul-group from-horizontal">
                        <li>
                            <a id="page_first" href="">首页</a>
                        </li>
                        <li>
                            <a id="page_previous" href="">上一页</a>
                        </li>
                        <li>
                            <span>${ pagination.currentPage } / ${pagination.totalPages}</span>
                        </li>
                        <li>
                            <a id="page_next" href="">下一页</a>
                        </li>
                        <li>
                            <a id="page_last" href="">尾页</a>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
    </div>
</div>

<%--分页的url拼凑--%>
<script type="text/javascript">
    $(function () {
        var baseUrl =  "${pageContext.request.contextPath}/fileAction/list.action?";
        var term = "queryRequest.serialNumber=${queryRequest.serialNumber}&queryRequest.name=${queryRequest.name}&queryRequest.phone=${queryRequest.phone}&"
        var first = "queryRequest.currentPage=${pagination.first}";
        var previous = "queryRequest.currentPage=${pagination.previous}";
        var next = "queryRequest.currentPage=${pagination.next}";
        var last = "queryRequest.currentPage=${pagination.last}";

        $("#page_first").attr("href", baseUrl + term + first) ;
        $("#page_previous").attr("href", baseUrl + term + previous);
        $("#page_next").attr("href", baseUrl + term + next);
        $("#page_last").attr("href", baseUrl + term + last);
    });

</script>

<script type="text/javascript">

    function goChange(fileId,canShare){
        var result = "";
        if(canShare==false){
            result = confirm("如果设置共享，您的文件将可以被其他用户搜索到");
            canShare=true;
        }else{
            result = confirm("如果设置私有，您的文件将不可以被其他用户搜索到");
            canShare=false;
        }
        if (result==true){
            window.location.href = "${pageContext.request.contextPath}/fileHandleAction/changeShare.action?fileShareRequest.fileId="+fileId+"&fileShareRequest.canShare="+canShare;
        }else{
            location.reload();
        }
    }

    function addFileJs() {
        $("#addfile").show();
        $("#fileList").hide();
    }

    function backSubmitJs() {
        $("#fileList").show();
        $("#addfile").hide();
    }

    function addSubmit() {
        $.ajax({
            type: "post",
            url: "<%=basePath%>fileAction/add.action",
            data: $("#addfileForm").serialize(),
            success: function (data) {
                alert("文件添加成功");
                window.location.href = "<%=basePath%>fileAction/list.action";
            }
        });
    }

    function checkPatent(opportunity, id) {
        if (opportunity != "签订文件") {
            alert("此文件没有签订文件！");
        } else {
            window.location.href = "<%=basePath%>patentAction/check.action?fileId=" + id;
        }
    }

    function editfile(id) {
        $.ajax({
            type: "post",
            url: "<%=basePath%>fileAction/detail.action",
            data: {"fileId": id},
            success: function (data) {
                var obj = JSON.parse(data);
                $("#edit_file_id").val(obj["file_id"]);
                $("#edit_file_serialNumber").val(obj["file_serialNumber"]);
                $("#edit_file_name").val(obj["file_name"]);
                $("#edit_file_phone").val(obj["file_phone"])
                $("#edit_file_zipcode").val(obj["file_zipcode"])
                $("#edit_file_address").val(obj["file_address"])
                $("#edit_file_source").val(obj["file_source"]);
                $("#edit_file_industry").val(obj["file_industry"]);
                $("#edit_file_Level").val(obj["file_level"]);
                $("#edit_file_annualTurnover").val(obj["file_annualTurnover"]);
                $("#edit_file_nature").val(obj["file_nature"]);
                $("#edit_file_opportunity").val(obj["file_opportunity"]);
            }
        });
    }

    function updatefile() {
        $.post(
            "<%=basePath%>fileAction/update.action",
            $("#edit_file_form").serialize(),
            function (data) {
                if (data == "update_success") {
                    alert("文件信息更新成功！");
                    window.location.href = "<%=basePath%>fileAction/list.action";
                }
            });
    }

    function deletefile(id) {
        if (confirm('确实要删除该文件吗?')) {
            $.post(
                "<%=basePath%>fileAction/delete.action",
                {"fileId": id},
                function (data) {
                    if (data == "delete_success") {
                        alert("文件删除更新成功！");
                        window.location.href = "<%=basePath%>fileAction/list.action";
                    }
                });
        }
    }
</script>