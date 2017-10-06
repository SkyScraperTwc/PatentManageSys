<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


<div class="row" id="addCustomer" style="display: none">
	<div class="col-lg-12">
		<form id="addCustomerForm" class="form-horizontal" style="width: 600px; margin: 0 auto;" method="post">
			<div class="form-group">
				<label class="col-sm-2 control-label">客户名称</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" placeholder="客户名称" name="saveRequest.cust_name">
				</div>
			</div>
			<div class="form-group">
				<label  class="col-sm-2 control-label">移动电话</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" placeholder="移动电话" name="saveRequest.cust_phone">
				</div>
			</div>
			<div class="form-group">
				<label  class="col-sm-2 control-label">邮政编码</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" placeholder="邮政编码" name="saveRequest.cust_zipcode">
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">联系地址</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" placeholder="联系地址" name="saveRequest.cust_address">
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">客户来源</label>
				<div class="col-sm-10">
					<select class="form-control" placeholder="客户来源" name="saveRequest.cust_source">
						<option value="0">--请选择--</option>
						<option value="1">电话营销</option>
						<option value="2">网络营销</option>
						<option value="3">媒体推广</option>
					</select>
				</div>
			</div>
			<div class="form-group">
				<label  class="col-sm-2 control-label">所属行业</label>
				<div class="col-sm-10">
					<select class="form-control" name="saveRequest.cust_industry">
						<option value="0">--请选择--</option>
						<option value="1">教育培训</option>
						<option value="2">电子商务</option>
						<option value="3">对外贸易</option>
						<option value="4">酒店旅游</option>
						<option value="5">互联网</option>
					</select>
				</div>
			</div>
			<div class="form-group">
				<label  class="col-sm-2 control-label">客户级别</label>
				<div class="col-sm-10">
					<select class="form-control" name="saveRequest.cust_level">
						<option value="0">--请选择--</option>
						<option value="1">普通客户</option>
						<option value="2">VIP客户</option>
					</select>
				</div>
			</div>
			<div class="form-group">
				<label  class="col-sm-2 control-label">年营业额</label>
				<div class="col-sm-10">
					<select class="form-control" name="saveRequest.cust_annualTurnover">
						<option value="0">--请选择--</option>
						<option value="1">1-50万</option>
						<option value="2">50-200万</option>
						<option value="3">200-500万</option>
						<option value="4">500-1000万</option>
						<option value="5">1000万以上</option>
					</select>
				</div>
			</div>
			<div class="form-group">
				<label  class="col-sm-2 control-label">公司性质</label>
				<div class="col-sm-10">
					<select class="form-control" name="saveRequest.cust_nature">
						<option value="0">--请选择--</option>
						<option value="1">民企</option>
						<option value="2">合资</option>
						<option value="3">国企</option>
					</select>
				</div>
			</div>
			<div class="form-group">
				<label  class="col-sm-2 control-label">商机状态</label>
				<div class="col-sm-10">
					<select class="form-control" name="saveRequest.cust_opportunity">
						<option value="0">--请选择--</option>
						<option value="1">意向客户</option>
						<option value="2">初步沟通</option>
						<option value="3">深度沟通</option>
						<option value="4">签订合同</option>
					</select>
				</div>
			</div>
			<div class="form-group">
				<button class="btn btn-default" onclick="addSubmit()">添加</button>
				<button class="btn btn-default" onclick="backSubmit()">返回</button>
			</div>
		</form>
	</div>
</div>
