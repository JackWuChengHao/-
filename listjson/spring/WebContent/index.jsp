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
	href="/spring/static/bootstraptable/bootstrap-table.css" />
<link rel="stylesheet" type="text/css"
	href="/spring/static/fileinput/css/fileinput.css" />
<script src="/spring/static/jquery/jquery-3.2.1.js"></script>
<script src="/spring/static/bootstrap/js/bootstrap.js"></script>
<script src="/spring/static/sweetalert/sweetalert.js"></script>
<script src="/spring/static/business/tool/js/tool.js"></script>
<script src="/spring/static/fileinput/js/fileinput.js"></script>
<script src="/spring/static/bootstraptable/bootstrap-table.js"></script>
<script src="/spring/static/bootstraptable/locale/bootstrap-table-zh-CN.js"></script>
<title>Insert title here</title>
</head>
<body>
<table id="table"></table>
<!-- 			<button id="button">登入</button>	 -->
<!-- 			<input type="file" name="txt_file" id="txt_file"   class="file-loading" /> -->
</body>
<script type="text/javascript">
// <!-- 	$("#button").on("click",function(){ -->
// <!-- 		var user =  new Array(); -->
// <!-- 	    for(i = 0;i<2;i++){ -->
// <!-- 	    	user[i] = {}; -->
// <!-- 	    	user[i].name="123"; -->
// <!-- 			user[i].password="12312312"; -->
// <!-- 	    } -->
// <!-- 		var result = xw_tools.sendAjax("http://localhost:8060/show",user); -->
// <!-- 		console.log(result); -->
// <!-- 	}); -->
	
// <!-- 	$('#txt_file').fileinput({ -->
// <!-- 		language: 'zh',  -->
// <!-- 		ajaxSettings:{type:"POST"}, -->
// <!-- 		uploadUrl: "http://localhost:8060/file", -->
// <!-- 		allowedFileExtensions: ['jpg', 'gif', 'png'],//接收的文件后缀 -->
// <!--         showUpload: true, //是否显示上传按钮 -->
// <!--         showCaption: false,//是否显示标题 -->
// <!--         browseClass: "btn btn-primary", //按钮样式      -->
// <!--         dropZoneEnabled: true,//是否显示拖拽区域 -->
// <!--         enctype: 'multipart/form-data', -->
// <!-- 	}); -->
$('#table').bootstrapTable({
    url: 'http://localhost:8060/userlist',
//     pagination: true,
striped: true,             //是否显示行间隔色
sortable: true,                     //是否启用排序
	sortName:"id",
    sidePagination: "client",
    sortOrder: "asc",                   //排序方式
    pageNumber:1,                       //初始化加载第一页，默认第一页
    pageSize: 10,                       //每页的记录行数（*）
    pageList: [1, 2, 3, 4],        //可供选择的每页的行数（*）
    showRefresh: true,                  //是否显示刷新按钮
    columns: [{
        field: 'id',
        title: 'id'
    }, {
        field: 'name',
        title: 'username'
    }, {
        field: 'password',
        title: 'password'
    }, ]
});
</script>

</html>