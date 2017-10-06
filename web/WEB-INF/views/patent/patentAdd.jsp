<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<div class="row" id="addPatent" style="display: none">
	<div class="col-lg-12">
		<form id="addPatentForm" class="form-horizontal" style="width: 600px; margin: 0 auto;" method="post">
			<div class="form-group">
				<label class="col-sm-2 control-label">专利名字</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" placeholder="专利名字" name="saveRequest.name">
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">作者编号</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" placeholder="作者编号" name="saveRequest.author_serialNumber">
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">专利类型</label>
				<div class="col-sm-10">
					<select class="form-control" placeholder="专利类型" name="saveRequest.type">
						<option value="0">--请选择--</option>
						<option value="1">发明专利</option>
						<option value="2">实用新型专利</option>
						<option value="3">外观设计专利</option>
					</select>
				</div>
			</div>
			<div class="form-group">
				<label  class="col-sm-2 control-label">专利状态</label>
				<div class="col-sm-10">
					<select class="form-control" name="saveRequest.state">
						<option value="0">--请选择--</option>
						<option value="1">专利申请尚未授权</option>
						<option value="2">专利申请撤回</option>
						<option value="3">专利权有效</option>
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
