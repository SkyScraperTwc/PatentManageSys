<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@include file="../main/index.jsp" %>
<div id="page-wrapper">
    <div class="row">
        <div class="col-lg-12">
            <h1 class="page-header">作者管理</h1>
        </div>
    </div>
    <div class="panel panel-default">
        <div class="panel-body">
            <form class="form-inline" action="${pageContext.request.contextPath }/authorAction/list.action"
                  method="post">
                <div class="form-group">
                    <label for="authorName">作者名称</label>
                    <input type="text" class="form-control" id="authorName" value="${queryRequest.name}" name="queryRequest.name">
                </div>
                <div class="form-group">
                    <label for="authorSerialNumber">作者编号</label>
                    <input type="text" class="form-control" id="authorSerialNumber" value="${queryRequest.serialNumber}" name="queryRequest.serialNumber">
                </div>
                <div class="form-group">
                    <label for="authorPhone">作者电话</label>
                    <input type="text" class="form-control" id="authorPhone" value="${queryRequest.phone}" name="queryRequest.phone">
                </div>
                <button type="submit" class="btn btn-primary">查询</button>
            </form>
        </div>
    </div>

    <button class="btn btn-default" onclick="addAuthorJs()">添加作者</button>
    <%@include file="authorAdd.jsp" %>
    <%@include file="authorEdit.jsp" %>

    <div class="row" id="authorList">
        <div class="col-lg-12">
            <div class="panel panel-default">
                <div class="panel-heading">作者信息列表</div>
                <table class="table table-bordered table-striped">
                    <thead>
                    <tr>
                        <th>序号</th>
                        <th>编号</th>
                        <th>作者名称</th>
                        <th>联系地址</th>
                        <th>手机</th>
                        <th>修改时间</th>
                        <th>操作</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${pagination.dataList}" var="author" varStatus="stat">
                        <tr>
                            <td>${(pagination.currentPage-1)*pagination.pageSize+stat.count}</td>
                            <td>${author.serialNumber}</td>
                            <td>${author.name}</td>
                            <td>${author.address}</td>
                            <td>${author.phone}</td>
                            <td>${author.editTime}</td>
                            <td>
                                <a href="javascript:void(0);" onclick="editAuthor(${author.id})" class="btn btn-primary btn-xs" data-toggle="modal" data-target="#authorEditDialog">修改</a>
                                <a href="javascript:void(0);" onclick="deleteAuthor(${author.id})" class="btn btn-danger btn-xs">删除</a>
                                <a href="javascript:void(0);" onclick="checkPatent(${author.id})" class="btn btn-success btn-xs">查看专利</a>
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
        var baseUrl =  "${pageContext.request.contextPath}/authorAction/list.action?";
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

    function addAuthorJs() {
        $("#addAuthor").show();
        $("#authorList").hide();
    }

    function backSubmitJs() {
        $("#authorList").show();
        $("#addAuthor").hide();
    }

    function addSubmit() {
        $.ajax({
            type: "post",
            url: "<%=basePath%>authorAction/add.action",
            data: $("#addAuthorForm").serialize(),
            success: function (data) {
                alert("作者添加成功");
                window.location.href = "<%=basePath%>authorAction/list.action";
            }
        });
    }

    function checkPatent(opportunity, id) {
        if (opportunity != "签订专利") {
            alert("此作者没有签订专利！");
        } else {
            window.location.href = "<%=basePath%>patentAction/check.action?authorId=" + id;
        }
    }

    function editAuthor(id) {
        $.ajax({
            type: "post",
            url: "<%=basePath%>authorAction/detail.action",
            data: {"authorId": id},
            success: function (data) {
                var obj = JSON.parse(data);
                $("#edit_author_id").val(obj["author_id"]);
                $("#edit_author_serialNumber").val(obj["author_serialNumber"]);
                $("#edit_author_name").val(obj["author_name"]);
                $("#edit_author_phone").val(obj["author_phone"])
                $("#edit_author_zipcode").val(obj["author_zipcode"])
                $("#edit_author_address").val(obj["author_address"])
                $("#edit_author_source").val(obj["author_source"]);
                $("#edit_author_industry").val(obj["author_industry"]);
                $("#edit_author_Level").val(obj["author_level"]);
                $("#edit_author_annualTurnover").val(obj["author_annualTurnover"]);
                $("#edit_author_nature").val(obj["author_nature"]);
                $("#edit_author_opportunity").val(obj["author_opportunity"]);
            }
        });
    }

    function updateAuthor() {
        $.post(
            "<%=basePath%>authorAction/update.action",
            $("#edit_author_form").serialize(),
            function (data) {
                if (data == "update_success") {
                    alert("作者信息更新成功！");
                    window.location.href = "<%=basePath%>authorAction/list.action";
                }
            });
    }

    function deleteAuthor(id) {
        if (confirm('确实要删除该作者吗?')) {
            $.post(
                "<%=basePath%>authorAction/delete.action",
                {"authorId": id},
                function (data) {
                    if (data == "delete_success") {
                        alert("作者删除更新成功！");
                        window.location.href = "<%=basePath%>authorAction/list.action";
                    }
                });
        }
    }
</script>