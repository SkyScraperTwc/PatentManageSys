<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<div class="modal fade" id="authorEditDialog" tabindex="-1"
	role="dialog" aria-labelledby="myModalLabel">
	<div class="modal-dialog" role="document">
		<div class="modal-content">

			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<h4 class="modal-title" id="myModalLabel">修改作者信息</h4>
			</div>

			<div class="modal-body">
				<form class="form-horizontal" id="edit_author_form">

					<input type="hidden" id="edit_author_id" name="updateRequest.id" />
					<input type="hidden" id="edit_author_serialNumber" name="updateRequest.serialNumber" />

					<div class="form-group">
						<label for="edit_author_name" class="col-sm-2 control-label">作者名称</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="edit_author_name" placeholder="作者名称" name="updateRequest.name">
						</div>
					</div>

					<div class="form-group">
						<label for="edit_author_phone" class="col-sm-2 control-label">移动电话</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="edit_author_phone" placeholder="移动电话" name="updateRequest.phone">
						</div>
					</div>

					<div class="form-group">
						<label for="edit_author_address" class="col-sm-2 control-label">联系地址</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="edit_author_address" placeholder="联系地址" name="updateRequest.address">
						</div>
					</div>

				</form>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
				<button type="button" class="btn btn-primary" onclick="updateAuthor()">保存修改</button>
			</div>
		</div>
	</div>
</div>