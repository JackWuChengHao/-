<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css"
	href="/spring/static/bootstrap/css/bootstrap.css" />
<link rel="stylesheet" type="text/css"
	href="/spring/static/bootstrap/css/bootstrap.css" />
<link rel="stylesheet" type="text/css"
	href="/spring/static/fileinput/css/fileinput.css" />
<script src="/spring/static/jquery/jquery-3.2.1.js"></script>
<script src="/spring/static/bootstrap/js/bootstrap.js"></script>
<script src="/spring/static/sweetalert/sweetalert.js"></script>
<script src="/spring/static/business/tool/js/tool.js"></script>
<script src="/spring/static/fileinput/js/fileinput.js"></script>
<title>Insert title here</title>
</head>
<body>
			<button id="button">登入</button>	
			<input type="file" name="txt_file" id="txt_file" multiple class="file-loading" />
</body>
<script type="text/javascript">
	$("#button").on("click",function(){
		var user = {};
		user.name="123";
		user.password="12312312";
		var result = xw_tools.sendAjax("http://localhost:8060/show",user);
		console.log(result);
	});
	
	$('#txt_file').fileinput({
		language: 'zh', 
		ajaxSettings:{type:"POST"},
		uploadUrl: "http://localhost:8060/file",
		allowedFileExtensions: ['jpg', 'gif', 'png'],//接收的文件后缀
        showUpload: true, //是否显示上传按钮
        showCaption: false,//是否显示标题
        browseClass: "btn btn-primary", //按钮样式     
        dropZoneEnabled: true,//是否显示拖拽区域
        enctype: 'multipart/form-data',
//         validateInitialCount:true,
//         previewFileIcon: "<i class='glyphicon glyphicon-king'></i>",
//         msgFilesTooMany: "选择上传的文件数量({n}) 超过允许的最大数值{m}！",
	});
</script>
</html>