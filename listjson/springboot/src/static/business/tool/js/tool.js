/**
 * js工具库
 */

/**
 * 封装小吴自己的js工具库
 */

window.xw_tools = {
    sendAjax:function(url,data){
    	alert("okok");
		var result = {};
		$.ajax({
			url:url,
			dataType:"json",
			data:JSON.stringify(data),
			contentType:"application/x-www-form-urlencoded",
			async:false,
			success:function(result){
				result = JSON.parse(result);
				return result;
			},
			error:function(){
				result = undefined;
				sweetAlert("请求出错", "", "error");
				return result;
			}
		})
    },
};