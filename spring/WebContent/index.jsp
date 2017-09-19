<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css"
	href="/spring/static/bootstrap/css/bootstrap.css" />
<link rel="stylesheet" type="text/css"
	href="/spring/static/css/main.css" />
<link rel="stylesheet" type="text/css"
	href="/spring/static/bootstraptable/bootstrap-table.css" />
<link rel="stylesheet" type="text/css"
	href="/spring/static/fileinput/css/fileinput.css" />
<script src="/spring/static/jquery/jquery-3.2.1.js"></script>
<script src="/spring/static/bootstrap/js/bootstrap.js"></script>
<script src="/spring/static/sweetalert/sweetalert.js"></script>
<script src="/spring/static/fileinput/js/fileinput.js"></script>
<script src="/spring/static/bootstraptable/bootstrap-table.js"></script>
<script
	src="/spring/static/bootstraptable/locale/bootstrap-table-zh-CN.js"></script>
<script src="/spring/static/valid/jquery.validate.js"></script>
<script src="/spring/static/valid/messages_zh.js"></script>
<script src="/spring/static/valid/additional-methods.js"></script>
<script src="/spring/static/business/tool/js/tool.js"></script>
<script src="/spring/static/css/main.js"></script>
<title>登入页面</title>
</head>
<body>
	<div class="container">
		<form class="form-horizontal col-md-4" role="form" id="login_form"
			style="position: absolute;">
			<div class="form-group">
				<label for="username" class="col-sm-2  control-label"> <span class="glyphicon glyphicon-user"></span>用户名</label>
				<div class="col-sm-5">
					<input type="text" name="username" class=" form-control input-sm"
						id="username" placeholder="请输入名字" >
				</div>
			</div>
			<div class="form-group">
				<label for="password" class="col-sm-2 control-label"><span class="glyphicon glyphicon-eye-close"></span>密码</label>
				<div class="col-sm-5">
					<input type="text" class="form-control input-sm" name="password"
						id="password" placeholder="请输入密码">
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-5 col-sm-push-2 ">
					<div class="col-sm-6">
						<button class="btn btn-sm btn-block btn-info" type="button" id="submit_logininfo">登入</button>
					</div>
					<div class="col-sm-6">
						<button class="btn  btn-sm  btn-block btn-warning"  type="reset">重置</button>
					</div>
				</div>
			</div>
		</form>
	</div>
</body>
</html>