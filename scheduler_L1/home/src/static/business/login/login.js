/**
 * 登入业务
 */
$(document).ready(function(){
	login();
});

function login(){
	var name = $("#username").val();
	var password = $("#password").val();
	var data = {"name":name,"password",password};
	xw_tools.sendAjax("#",data);
}