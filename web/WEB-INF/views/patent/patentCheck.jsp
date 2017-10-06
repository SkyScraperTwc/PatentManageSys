<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@include file="../main/index.jsp"%>
<div id="page-wrapper">
	<div class="row">
		<div class="col-lg-12">
			<h1 class="page-header">专利管理</h1>
		</div>
	</div>

	<%@include file="patentAdd.jsp"%>
	<%@include file="patentEdit.jsp"%>

	<div class="row" id="contractList">
		<div class="col-lg-12">
			<div class="panel panel-default">
				<div class="panel-heading">专利信息列表</div>
					<table class="table table-bordered table-striped">
						<thead>
							<tr>
								<th>序号</th>
								<th>专利编号</th>
								<th>专利名称</th>
								<th>专利类型</th>
								<th>专利状态</th>
								<th>专利金额</th>
								<th>作者名称</th>
								<th>修改时间</th>
								<th>操作</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${pagination.dataList}" var="contract" varStatus="stat">
								<tr>
									<td>${(pagination.currentPage-1)*pagination.pageSize+stat.count}</td>
									<td>${contract.serialNumber}</td>
									<td>${contract.name}</td>
									<td>${contract.type}</td>
									<td>${contract.state}</td>
									<td>${contract.money}</td>
									<td>${contract.customer.name}</td>
									<td>${contract.editTime}</td>
									<td>
										<a href="javascript:void(0);"  onclick="editContract(${contract.id})" class="btn btn-primary btn-xs" data-toggle="modal" data-target="#ContractEditDialog">修改</a>
										<a href="javascript:void(0);" onclick="deleteContract(${contract.id})"  class="btn btn-danger btn-xs">删除</a>
									</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				<div class="col-md-12 text-right">
					<!-- 分页标签 -->
					<ul class="pagination ul-group from-horizontal">
						<li><a href="${pageContext.request.contextPath}/contractAction/check.action?currentPage=${pagination.first}&customerId=${customerId}">首页</a></li>
						<li><a href="${pageContext.request.contextPath}/contractAction/check.action?currentPage=${pagination.previous}&customerId=${customerId}">上一页</a></li>
						<li><span>${ pagination.currentPage } / ${pagination.totalPages}</span></li>
						<li><a href="${pageContext.request.contextPath}/contractAction/check.action?currentPage=${pagination.next}&customerId=${customerId}">下一页</a></li>
						<li><a href="${pageContext.request.contextPath}/contractAction/check.action?currentPage=${pagination.last}&customerId=${customerId}">尾页</a></li>
					</ul>
				</div>
				</div>
			</div>
		</div>
	</div>
</div>

<script type="text/javascript">

    function editContract(id) {
        $.ajax({
            type:"post",
            url:"<%=basePath%>contractAction/detail.action",
            data:{"ContractId":id},
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

    function updateContract() {
        $.post(
            "<%=basePath%>contractAction/update.action",
            $("#edit_Contract_form").serialize(),
            function(data){
                if(data=="update_success"){
                    alert("作者信息更新成功！");
                    window.location.href="<%=basePath%>contractAction/list.action";
                }
            });
    }

    function deleteContract(id) {
        if(confirm('确实要删除该作者吗?')) {
            $.post(
                "<%=basePath%>contractAction/delete.action",
                {"ContractId":id},
                function(data){
                    if(data=="delete_success"){
                        alert("作者删除更新成功！");
                        window.location.href="<%=basePath%>contractAction/list.action";
                    }
			});
        }
    }

</script>