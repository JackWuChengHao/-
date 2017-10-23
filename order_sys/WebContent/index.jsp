<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css"
	href=<%=request.getContextPath() + "/static/bootstrap/css/bootstrap.css"%>>
<link rel="stylesheet" type="text/css"
	href=<%=request.getContextPath() + "/static/sweetalert/sweetalert.css"%>>
<link rel="stylesheet" type="text/css"
	href=<%=request.getContextPath() + "/static/css/main.css"%>>
<link rel="stylesheet" type="text/css"
	href=<%=request.getContextPath() + "/static/bootstraptable/bootstrap-table.css"%>>
<link rel="stylesheet" type="text/css"
	href=<%=request.getContextPath() + "/static/fileinput/css/fileinput.css"%>>
<link rel="stylesheet" type="text/css"
	href=<%=request.getContextPath() + "/static/tip12/css/css.css"%>>
<script
	src=<%=request.getContextPath() + "/static/jquery/jquery-3.2.1.js"%>></script>
<script
	src=<%=request.getContextPath() + "/static/bootstrap/js/bootstrap.js"%>></script>
<script
	src=<%=request.getContextPath() + "/static/sweetalert/sweetalert.js"%>></script>
<script
	src=<%=request.getContextPath() + "/static/fileinput/js/fileinput.js"%>></script>
<script
	src=<%=request.getContextPath() + "/static/bootstraptable/bootstrap-table.js"%>></script>
<script
	src=<%=request.getContextPath() + "/static/bootstraptable/locale/bootstrap-table-zh-CN.js"%>></script>
<script
	src=<%=request.getContextPath() + "/static/valid/jquery.validate.js"%>></script>
<script
	src=<%=request.getContextPath() + "/static/valid/messages_zh.js"%>></script>
<script
	src=<%=request.getContextPath() + "/static/valid/additional-methods.js"%>></script>
<script
	src=<%=request.getContextPath() + "/static/tip12/js/msgTips.js"%>></script>
<script
	src=<%=request.getContextPath() + "/static/business/tool/js/tool.js"%>></script>
<script src=<%=request.getContextPath() + "/static/clipboard.min.js"%>></script>
<script src=<%=request.getContextPath() + "/static/css/main.js"%>></script>
<title>订单生成</title>
</head>
<body>
	<div class="container">
	<!-- Button trigger modal -->
		<!-- 	模态框起始 -->
	<!-- Modal -->
<div class="modal fade in " id="order-info-modal" tabindex="-1" role="dialog">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h4 class="modal-title" id="order-infoLabel">订单信息</h4>
      </div>
      <div class="modal-body" id="order-info" >
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
        <button type="button" class="btn btn-info"  id="copy_order_info"  
        data-clipboard-action="copy" data-clipboard-target="#order-info">复制订单信息</button>
      </div>
    </div>
  </div>
</div>
		<!-- 	模态框结束 -->
		<div id="msgshowbox" style="dispaly: none"></div>
		<form class="form-horizontal col-md-4" role="form" id="order_info_form"
			style="position: absolute;" method="post"
			action="##">
			<div class="form-group">
				<label for="shopping-cart" class="col-sm-4  control-label">
					<span class="glyphicon glyphicon-shopping-cart">商品：</span>
				</label>
				<div class="col-sm-8">
					<textarea class="form-control input-sm" name="shopping-cart"
						id="shopping-cart" placeholder="请输入商品"></textarea>
				</div>
			</div>
			<div class="form-group">
				<label for="receiver" class="col-sm-4 control-label"><span
					class="glyphicon glyphicon-user"></span>收件人：</label>
				<div class="col-sm-8">
					<input type="text" class="form-control input-sm" name="receiver"
						id="receiver" placeholder="请输入收件人">
				</div>
			</div>
			<div class="form-group">
				<label for="telephone" class="col-sm-4 control-label"><span
					class="glyphicon glyphicon-bell"></span>联系方式：</label>
				<div class="col-sm-8">
					<input type="text" class="form-control input-sm" name="telephone"
						id="telephone" placeholder="请输入联系方式">
				</div>
			</div>
			<div class="form-group">
				<label for="address" class="col-sm-4 control-label"><span
					class="glyphicon glyphicon-map-marker"></span>收件地址：</label>
				<div class="col-sm-8">
					<textarea class="form-control input-sm" name="address" id="address"
						placeholder="请输入收件地址"></textarea>
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-10 col-sm-push-2 ">
					<div class="col-sm-6">
						<input type="button" class="btn btn-sm btn-block btn-info"
							id="generate_order_info" value="生成订单" />
					</div>
					<div class="col-sm-6">
						<button class="btn  btn-sm  btn-block btn-warning" type="reset">重置</button>
					</div>
				</div>
			</div>
		</form>
	</div>
	<footer class="footer navbar-fixed-bottom "><div class="copy-right">CopyRight@xiaowu20171024</div></footer>
</body>
</html>