<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@include file="../main/index.jsp"%>
<div id="page-wrapper">
	<div class="row">
		<div class="col-lg-12">
			<h1 class="page-header">管理员管理</h1>
		</div>
	</div>

	<button class="btn btn-default" onclick="addCustomer()">添加管理员</button>

<div class="row" id="userList">
	<div class="col-lg-12">
		<div class="panel panel-default">
			<div class="panel-heading">管理员信息列表</div>
				<table class="table table-bordered table-striped">
					<thead>
						<tr>
							<th>序号</th>
							<th>编号</th>
							<th>管理员名称</th>
							<th>性别</th>
							<th>手机</th>
							<th>作者数量</th>
							<th>修改时间</th>
							<th>操作</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${pagination.dataList}" var="user" varStatus="stat">
							<tr>
								<td>${(pagination.currentPage-1)*pagination.pageSize+stat.count}</td>
								<td>${user.serialNumber}</td>
								<td>${user.username}</td>
								<td>${user.sex}</td>
								<td>${user.phone}</td>
								<td>${fn:length(user.authorSet)}</td>
								<td>${user.editTime}</td>
								<td>
									<a href="javascript:void(0);"  onclick="editUser(${user.id})" class="btn btn-primary btn-xs" data-toggle="modal" data-target="#userEditDialog">修改</a>
									<a href="javascript:void(0);" onclick="deleteUser(${user.id})"  class="btn btn-danger btn-xs">删除</a>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<div class="col-md-12 text-right">
					<!-- 分页标签 -->
					<ul class="pagination ul-group from-horizontal">
						<li><a href="${pageContext.request.contextPath}/userAction/list.action?currentPage=${pagination.first}">首页</a></li>
						<li><a href="${pageContext.request.contextPath}/userAction/list.action?currentPage=${pagination.previous}">上一页</a></li>
						<li><span>${ pagination.currentPage } / ${pagination.totalPages}</span></li>
						<li><a href="${pageContext.request.contextPath}/userAction/list.action?currentPage=${pagination.next}">下一页</a></li>
						<li><a href="${pageContext.request.contextPath}/userAction/list.action?currentPage=${pagination.last}">尾页</a></li>
					</ul>
				</div>
			</div>
		</div>
	</div>
</div>

<%@include file="userAdd.jsp"%>
<%@include file="userEdit.jsp"%>

<script type="text/javascript">

    function addCustomer(){
        $("#userList").hide();
        $("#addUser").show();
    }

    function backSubmit(){
        $("#userList").show();
        $("#addUser").hide();
    }

    function addSubmit(){
        $.ajax({
            type:"post",
            url:"<%=basePath%>userAction/add.action",
            data:$("#addUserForm").serialize(),
            success:function(data) {
                alert("管理员添加成功");
                window.location.href="<%=basePath%>userAction/list.action";
            }
        });
    }

    function editUser(id) {
        $.ajax({
            type:"post",
            url:"<%=basePath%>customerAction/detail.action",
            data:{"customerId":id},
            success:function(data) {
                var obj = JSON.parse(data);
                $("#edit_cust_id").val(obj["cust_id"]);
                $("#edit_cust_name").val(obj["cust_name"]);
                $("#edit_cust_phone").val(obj["cust_phone"])
                $("#edit_cust_zipcode").val(obj["cust_zipcode"])
                $("#edit_cust_address").val(obj["cust_address"])
                $("#edit_cust_source").val(obj["cust_source"]);
                $("#edit_cust_industry").val(obj["cust_industry"]);
                $("#edit_cust_Level").val(obj["cust_level"]);
                $("#edit_cust_annualTurnover").val(obj["cust_annualTurnover"]);
                $("#edit_cust_nature").val(obj["cust_nature"]);
                $("#edit_cust_opportunity").val(obj["cust_opportunity"]);
            }
        });
    }

    function updateCustomer() {
        $.post(
            "<%=basePath%>customerAction/update.action",
            $("#edit_customer_form").serialize(),
            function(data){
                alert("管理员信息更新成功！");
                window.location.href="<%=basePath%>customerAction/list.action";
            });
    }

    function deleteCustomer(id) {
        if(confirm('确实要删除该管理员吗?')) {
            $.post(
                "<%=basePath%>customerAction/delete.action",
                {"customerId":id},
                function(data){
                    if(data=="delete_success"){
                        alert("管理员删除更新成功！");
                        window.location.href="<%=basePath%>customerAction/list.action";
                    }
                });
        }
    }

</script>