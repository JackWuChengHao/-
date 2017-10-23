/**
 * 
 */
$("document").ready(function(){
	//水平垂直居中 支持浏览器窗口大小改变，存在垂直滚动条
	xw_tools.centerObj($("#order_info_form"));
	//订单生成按钮的单击事件绑定
	$("#generate_order_info").on("click",show_order);
//	剪切板的处理开始
    var clipboard = new Clipboard('#copy_order_info');
    clipboard.on('success', function(e) {
        alert("复制订单信息成功");
    });
    clipboard.on('error', function(e) {
    	 alert("复制订单信息失败");
    });
//	剪切板的处理结束
});


function show_order(){
	try{
	var shop_cart_arr = $("#shopping-cart").val().split("、");
	var shop_cart = "";
	for(var i=0 ;i< shop_cart_arr.length;i++){
		shop_cart =shop_cart + shop_cart_arr[i] +"</br>";
	}
	var province = $("#address").val().indexOf("省");
	var city = $("#address").val().indexOf("市");
	var province_name = $("#address").val().substring(0,(province+1));
	var city_name = $("#address").val().substring((province+1),(city+1));
	var town = $("#address").val().substring((city+1));
	var content = shop_cart+$("#receiver").val()+","+$("#telephone").val()+","+province_name+" "+city_name+" "+town+","+"200000"+"</br>"+"发件人: 日安小站，13013686692"
//	填入模态框中
	$("#order-info").html("");
	$("#order-info-modal").modal("show");
	$("#order-info").html(content);
	}catch(e){
		alert("error info: "+e);
	}
}
