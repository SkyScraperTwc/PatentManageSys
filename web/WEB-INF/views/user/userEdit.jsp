<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<div class="modal fade" id="customerEditDialog" tabindex="-1"
	role="dialog" aria-labelledby="myModalLabel">
	<div class="modal-dialog" role="document">
		<div class="modal-content">

			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<h4 class="modal-title" id="myModalLabel">修改客户信息</h4>
			</div>

			<div class="modal-body">
				<form class="form-horizontal" id="edit_customer_form">
					<input type="hidden" id="edit_cust_id" name="updateRequest.cust_id" value=""/>
					<div class="form-group">
						<label for="edit_cust_name" class="col-sm-2 control-label">客户名称</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="edit_cust_name" placeholder="客户名称" name="updateRequest.cust_name">
						</div>
					</div>

					<div class="form-group">
						<label for="edit_cust_phone" class="col-sm-2 control-label">移动电话</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="edit_cust_phone" placeholder="移动电话" name="updateRequest.cust_phone">
						</div>
					</div>

					<div class="form-group">
						<label for="edit_cust_zipcode" class="col-sm-2 control-label">邮政编码</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="edit_cust_zipcode" placeholder="邮政编码" name="updateRequest.cust_zipcode">
						</div>
					</div>

					<div class="form-group">
						<label for="edit_cust_address" class="col-sm-2 control-label">联系地址</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="edit_cust_address" placeholder="联系地址" name="updateRequest.cust_address">
						</div>
					</div>

					<div class="form-group">
						<label for="edit_cust_source" style="float:left;padding:7px 15px 0 27px;">客户来源</label>
						<div class="col-sm-10">
							<select class="form-control" id="edit_cust_source" placeholder="客户来源" name="updateRequest.cust_source">
								<option value="0">--请选择--</option>
								<option value="1">电话营销</option>
								<option value="2">网络营销</option>
								<option value="3">媒体推广</option>
							</select>
						</div>
					</div>

					<div class="form-group">
						<label for="edit_cust_industry" style="float:left;padding:7px 15px 0 27px;">所属行业</label>
						<div class="col-sm-10">
							<select class="form-control" id="edit_cust_industry" name="updateRequest.cust_industry">
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
						<label for="edit_cust_Level" style="float:left;padding:7px 15px 0 27px;">客户级别</label>
						<div class="col-sm-10">
							<select class="form-control" id="edit_cust_Level" name="updateRequest.cust_level">
								<option value="">--请选择--</option>
								<option value="1">普通客户</option>
								<option value="2">VIP客户</option>
							</select>
						</div>
					</div>

					<div class="form-group">
						<label for="edit_cust_annualTurnover" style="float:left;padding:7px 15px 0 27px;">年营业额</label>
						<div class="col-sm-10">
							<select class="form-control" id="edit_cust_annualTurnover" name="updateRequest.cust_annualTurnover">
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
						<label for="edit_cust_nature" style="float:left;padding:7px 15px 0 27px;">公司性质</label>
						<div class="col-sm-10">
							<select class="form-control" id="edit_cust_nature" name="updateRequest.cust_nature">
								<option value="0">--请选择--</option>
								<option value="1">民企</option>
								<option value="2">合资</option>
								<option value="3">国企</option>
							</select>
						</div>
					</div>

					<div class="form-group">
						<label for="edit_cust_opportunity" style="float:left;padding:7px 15px 0 27px;">商机状态</label>
						<div class="col-sm-10">
							<select class="form-control" id="edit_cust_opportunity" name="updateRequest.cust_opportunity">
								<option value="0">--请选择--</option>
								<option value="1">意向客户</option>
								<option value="2">初步沟通</option>
								<option value="3">深度沟通</option>
								<option value="4">签订合同</option>
							</select>
						</div>
					</div>
				</form>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
				<button type="button" class="btn btn-primary" onclick="updateCustomer()">保存修改</button>
			</div>
		</div>
	</div>
</div>