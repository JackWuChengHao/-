window.xw_tools = {
    sendAjax:function(url,data){
    	console.log(data);
    	if(data === null || data === undefined){
    		data = "";
    	}
    	console.log(JSON.stringify(data));
		var resultcode = undefined;
		$.ajax({
			url:url,
			type:"post",
			dataType:"json",
			data:JSON.stringify(data),
			contentType:"application/json;charset=utf-8",
			async:false,
			success:function(result_data){
				resultcode =result_data["code"];
			},
			error:function(){
				alert("请求出错", "", "error");
				
			}
		});
		return resultcode;
    },
};

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