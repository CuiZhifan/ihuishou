var userID = window.localStorage.USERID;
if(userID!=null){
    $.ajax({
        url: "/ihuishou/Order/OrderInfo/" + userID,
        success: function (data) {
            var arr = data[0];
            $(".cart_total_items").html(arr['cart_total_items']);
            $("#cart_total").html('￥' + arr['cart_total']);

            var infos = data[1];
            var length = infos.length;

            $(".NEWCART").remove();
            for (var i = 0; i < length; i++) {
                //添加商品信息
                var item_info = infos[i];
                var item_class = arr['cart_total_items'] % 2 == 0 ? '' : 'class="on"';
                var item_id = 'cart_items_' + item_info['rowid'];

                var html = '';

                html += '<tr id="' + item_id + '" class="NEWCART">';
                html += '<td class="table-padding">';
                html += '<div class="mui-pic">';
                html += '<a href="javascript:remove_cart(\'' + item_info['remove_url'] + '\',\'' + item_info['rowid'] + '\')" class="close_btn"><img src="' + item_info['base_url'] + 'images/close.png" /></a>';
                html += '<a href="javascript:void(0)"><img src="' + item_info['img'] + '"  width="74" height="56"/></a></div></td>';
                html += '<td><p><a href="javascript:void(0)">' + item_info['name'] + '</a></p></td>';
                html += '<td><em>￥ ' + item_info['price'] + '</em></td>';
                html += ' </tr>';
                //alert(html);
                $("#cart_tr_title").after(html);
            }
        }
    })
}else {
    var html = "<li><a id=\"loginoff\" href=\"../login.html\" rel=\"nofollow\">登录</a></li>\n" +
        "       <li><a href=\"members/register.html\" rel=\"nofollow\">注册</a></li>";
    $("#login_show").html(html);
}
var KEY = window.localStorage.KEY;
//注销
function loginOff() {
    window. localStorage.removeItem('USERID');
    window. localStorage.removeItem('KEY');
    // window.location.reload();
}