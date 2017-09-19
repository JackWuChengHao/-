/**
 * 
 */
$("document").ready(function(){
	//水平垂直居中 支持浏览器窗口大小改变，存在垂直滚动条
	xw_tools.centerObj($("#login_form"));
	alert("11");
	$("#submit_logininfo").on("click",login);
	alert("22");
});
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
	// $('#table').bootstrapTable({
	//     url: 'http://localhost:8060/userlist',
	// //     pagination: true,
	// striped: true,             //是否显示行间隔色
	// sortable: true,                     //是否启用排序
	// 	sortName:"id",
	//     sidePagination: "client",
	//     sortOrder: "asc",                   //排序方式
	//     pageNumber:1,                       //初始化加载第一页，默认第一页
	//     pageSize: 10,                       //每页的记录行数（*）
	//     pageList: [1, 2, 3, 4],        //可供选择的每页的行数（*）
	//     showRefresh: true,                  //是否显示刷新按钮
	//     columns: [{
	//         field: 'id',
	//         title: 'id'
	//     }, {
	//         field: 'name',
	//         title: 'username'
	//     }, {
	//         field: 'password',
	//         title: 'password'
	//     }, ]
	// });
function login(){
//	alert("okok");
	loginvalidator();

}
window.spring = {};
function loginvalidator(){
	spring.login_form_validate = $("#login_form").validate({
        errorElement : 'span',
        errorClass : 'help-block',
        rules : {
        	username : "required",
        	password : "required",
        },
        messages : {
        	username : "请输入用户名",
        	password : "请输入密码",
       },
       errorPlacement : function(error, element) {
           element.next().remove();//删除显示图标
           element.after('<span class="glyphicon glyphicon-remove form-control-feedback" aria-hidden="true"></span>');
           element.closest('.form-group').append(error);//显示错误消息提示
       },
       //给未通过验证的元素进行处理
       highlight : function(element) {
           $(element).closest('.form-group').addClass('has-error has-feedback');
       },
       //验证通过的处理
       success : function(label) {
           var el=label.closest('.form-group').find("input");
           el.next().remove();//与errorPlacement相似
           el.after('<span class="glyphicon glyphicon-ok form-control-feedback" aria-hidden="true"></span>');
           label.closest('.form-group').removeClass('has-error').addClass("has-feedback has-success");
           label.remove();
       },
       onsubmit:true,
	});
}