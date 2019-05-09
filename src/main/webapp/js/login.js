$(document).ready(function() {
    var userID = window.localStorage.USERID;
    if (userID != null) {
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
    } else {
        var html = "<li><a id=\"loginoff\" href=\"../login.html\" rel=\"nofollow\">登录</a></li>\n" +
            "       <li><a href=\"/ihuishou/register.html\" rel=\"nofollow\">注册</a></li>";
        $("#login_show").html(html);
    }
    var KEY = window.localStorage.KEY;

//注销
    function loginOff() {
        window.localStorage.removeItem('USERID');
        window.localStorage.removeItem('KEY');
        // window.location.reload();
    }

//
    $(".mui-button").attr("onclick", "new_addcart('/ihuishou/Order/HelloOrder','sub','" + KEY + "')");
    $(".loginOff").attr("onclick","loginOff()");



        function new_addcart(url, act, key) {
        var gid = $("#gid").val();
        if ($("#if_show_price") == 0) return false;
        if ($("#issubmit").val() == 0 && act == "add") {
            alert("请不要重复添加购物车");
            return false;
        }
        $("#if_show_price").val(0);		//加锁
        var typeid = 1;
        if ($("#typeid").length == 1) typeid = $("#typeid").val();
        $.post(url, {'gid': gid, 'key': key, 'act': act, 'typeid': typeid}, function (data) {
            $("#if_show_price").val(1);	//解锁
            //alert(data);
            var obj = eval(data);
            //提交回购单操作
            if (act == 'sub') {
                if (obj[0] == 1) {
                    gourl = url.replace("/ihuishou/Order/HelloOrder", "/ihuishou/html/cart.html");
                    //location.href	=	gourl;
                    var check_url = url.replace("/ihuishou/Order/HelloOrder", "/ihuishou/user/checkUser");
                    $.post(check_url, {'key': key}, function (data) {
                        var obj = eval(data);
                        if (obj[0] == 0) {
                            alert("您还没有登录，或已失效，请重新登录！！");
                            location.href = url.replace("/ihuishou/Order/HelloOrder", "/ihuishou/login.html");
                            return;
                        } else {
                            gourl = url.replace("/ihuishou/Order/HelloOrder", "/ihuishou/html/cart.html");
                            ;
                            location.href = gourl;
                            return;
                        }
                    })
                } else {
                    div_id = arguments[3] ? arguments[3] : 'btn_sub_cart';
                    $("#" + div_id).attr('disabled', false);
                    alert("数据传输有误");
                }
                //return;
            } else {
                if (obj[0] == 1) {
                    var arr = obj[1];
                    $(".cart_total_items").html(arr['cart_total_items']);
                    $("#cart_total").html('￥' + arr['cart_total']);

                    var infos = obj[2];
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
                    $("#issubmit").val(0);
                    alert("已加入回购车");
                } else if (obj[0] == 2) {
                    alert("数据传输有误");
                } else if (obj[0] == 0) {
                    alert("操作失败");
                }
            }
        })

        if (act == 'addcart') {	//加入回购车

        } else if (act == 'sub') {

        }
    }
})
