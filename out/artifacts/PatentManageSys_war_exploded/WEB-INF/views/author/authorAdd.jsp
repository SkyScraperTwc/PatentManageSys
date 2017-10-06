<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<div class="row" id="addAuthor" style="display: none">
	<div class="col-lg-12">
		<form id="addAuthorForm" class="form-horizontal" style="width: 600px; margin: 0 auto;" method="post">
			<div class="form-group">
				<label class="col-sm-2 control-label">作者名称</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" placeholder="作者名称" name="saveRequest.name">
				</div>
			</div>
			<div class="form-group">
				<label  class="col-sm-2 control-label">移动电话</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" placeholder="移动电话" name="saveRequest.phone">
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">联系地址</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" placeholder="联系地址" name="saveRequest.address">
				</div>
			</div>
			<div class="form-group">
				<button class="btn btn-default" onclick="addSubmit()">添加</button>
				<button class="btn btn-default" onclick="backSubmitJs()">返回</button>
			</div>
		</form>
	</div>
</div>
