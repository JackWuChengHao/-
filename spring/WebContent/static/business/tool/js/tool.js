window.xw_tools = {
		showerrmsg:function(msg){
			$("#msgshowbox").manhua_msgTips({
				Event : "click",			//响应的事件
				timeOut : 1000,				//提示层显示的时间
				msg : msg,			//显示的消息
				speed : 10,				//滑动速度
				type : "error"			//提示类型（1、success 2、error 3、warning）

			});
//			$("#msgshowbox").on('click',function(){TINY.box.show({html:msg,animate:false,close:false,boxid:'error',top:5})});
			$("#msgshowbox").trigger("click");
		},
		sendAjax:function(options){
			var url = options["url"];
			var send_data = options["data"];
			var successFn = options["successFn"];
			url,send_data,successFn
			if(send_data === null || send_data === undefined){
				send_data = "";
			}
			var resultcode = undefined; 
			$.ajax({
				url:url,
				type:"post",
				dataType:"json",
				data:JSON.stringify(send_data),
				contentType:"application/json;charset=utf-8",
				async:true,
				success:function(data){
					if(successFn === undefined){
						resultcode =data["code"];
						if(resultcode  === "0" ){
							swal("","Operate Success", "success");
						}else{
							$("#msgshowbox").text(result_data["message"]).show(500).hide(300);
						}
					}else{
						successFn(data);
					}
				},
				error:function(jqXHR, textStatus, errorThrown){
						switch (jqXHR.status){  
						case(500): 
							swal("","服务器系统内部错误", "error");
						break;  
						case(401):  
							swal("","未登录", "error");
						break;  
						case(403):  
							swal("","无权限执行此操作", "error");
						break;  
						case(408):  
							swal("","请求超时", "error");
						break;  
						default:  
							swal("","服务端可能歇菜了", "error");
						}  
					},   
			});
			return resultcode;
		},    

		centerObj:function(obj){
			var screenWidth = $(window).width(), screenHeight = $(window).height();  //当前浏览器窗口的宽高
			var scrolltop = $(document).scrollTop();//获取当前窗口距离页面顶部高度
			var objLeft = (screenWidth - obj.width()) / 2;
			var objTop = (screenHeight - obj.height()) / 2 + scrolltop;
			obj.css({left: objLeft +"px", top: objTop +"px"});
			//浏览器窗口大小改变时
			$(window).resize(function () {
				screenWidth = $(window).width();
				screenHeight = $(window).height();
				scrolltop = $(document).scrollTop();
				objLeft = (screenWidth - obj.width()) / 2;
				objTop = (screenHeight - obj.height()) / 2 + scrolltop;
				obj.css({left: objLeft +"px", top: objTop +"px"});
			});
			//浏览器有滚动条时
			$(window).scroll(function () {
				screenWidth = $(window).width();
				screenHeight = $(window).height();
				scrolltop = $(document).scrollTop();
				objLeft = (screenWidth - obj.width()) / 2;
				objTop = (screenHeight - obj.height()) / 2 + scrolltop;
				obj.css({left: objLeft +"px", top: objTop +"px"});
			});
		},
};

//$("document").ready(
//function(){
//$(":reset").on("click",function(){
//alert("okokok");
//$("form").validate().resetForm();
//alert("okokokhehe");
//});
//}
//);

(function ($) {
	//1.得到$.ajax的对象
	var _ajax = $.ajax;
	$.ajax = function (options) {
		//2.每次调用发送ajax请求的时候定义默认的error处理方法
		var fn = {
				error: function (XMLHttpRequest, textStatus, errorThrown) {
					toastr.error(XMLHttpRequest.responseText, '错误消息', { closeButton: true, timeOut: 0, positionClass: 'toast-top-full-width' });
				},
				success: function (data, textStatus) { },
				beforeSend: function (XHR) { },
				complete: function (XHR, TS) { }
		}
		//3.如果在调用的时候写了error的处理方法，就不用默认的
		if (options.error) {
			fn.error = options.error;
		}
		if (options.success) {
			fn.success = options.success;
		}
		if (options.beforeSend) {
			fn.beforeSend = options.beforeSend;
		}
		if (options.complete) {
			fn.complete = options.complete;
		}
		//4.扩展原生的$.ajax方法，返回最新的参数
		var _options = $.extend(options, {
			error: function (XMLHttpRequest, textStatus, errorThrown) {
				fn.error(XMLHttpRequest, textStatus, errorThrown);
			},
			success: function (data, textStatus) {
				fn.success(data, textStatus);
			},
			beforeSend: function (XHR) {
				fn.beforeSend(XHR);
			},
			complete: function (XHR, TS) {
				fn.complete(XHR, TS);
			}
		});
		//5.将最新的参数传回ajax对象
		_ajax(_options);
	};
})(jQuery);


//combobox
(function ($) {
	$.fn.combobox = function (options, param) {
		if (typeof options == 'string') {
			return $.fn.combobox.methods[options](this, param);
		}
		options = $.extend({}, $.fn.combobox.defaults, options || {});
		var target = $(this);
		target.attr('valuefield', options.valueField);
		target.attr('textfield', options.textField);
		target.empty();
		var option = $('<option></option>');
		option.attr('value', '');
		option.text(options.placeholder);
		target.append(option);
		if (options.data) {
			init(target, options.data);
		}
		else {
			//var param = {};
			options.onBeforeLoad.call(target, option.param);
			if (!options.url) return;
			$.getJSON(options.url, option.param, function (data) {
				init(target, data);
			});
		}
		function init(target, data) {
			$.each(data, function (i, item) {
				var option = $('<option></option>');
				option.attr('value', item[options.valueField]);
				option.text(item[options.textField]);
				target.append(option);
			});
			options.onLoadSuccess.call(target);
		}
		target.unbind("change");
		target.on("change", function (e) {
			if (options.onChange)
				return options.onChange(target.val());
		});
	}
	$.fn.combobox.methods = {
			getValue: function (jq) {
				return jq.val();
			},
			setValue: function (jq, param) {
				jq.val(param);
			},
			load: function (jq, url) {
				$.getJSON(url, function (data) {
					jq.empty();
					var option = $('<option></option>');
					option.attr('value', '');
					option.text('请选择');
					jq.append(option);
					$.each(data, function (i, item) {
						var option = $('<option></option>');
						option.attr('value', item[jq.attr('valuefield')]);
						option.text(item[jq.attr('textfield')]);
						jq.append(option);
					});
				});
			}
	};
	$.fn.combobox.defaults = {
			url: null,
			param: null,
			data: null,
			valueField: 'value',
			textField: 'text',
			placeholder: '请选择',
			onBeforeLoad: function (param) { },
			onLoadSuccess: function () { },
			onChange: function (value) { }
	};
})(jQuery);