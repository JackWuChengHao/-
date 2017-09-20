window.xw_tools = {
    sendAjax:function(url,data){
    	console.log(data);
    	if(data === null || data === undefined){
    		data = "";
    	}
    	console.log(JSON.stringify(data));
		var result = undefined;
		$.ajax({
			url:url,
			type:"post",
			dataType:"json",
			data:JSON.stringify(data),
			contentType:"application/json;charset=utf-8",
			async:false,
			success:function(result_data){
				result = JSON.parse(result_data);
			},
			error:function(){
				alert("请求出错", "", "error");
			}
		});
		return result;
    },
};