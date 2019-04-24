function GetQueryString(name)
{
    var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");
    var r = window.location.search.substr(1).match(reg);
    if(r!=null)return  unescape(r[2]); return null;
}
var id = GetQueryString("typeId");
var url = "http://localhost:8080/ihuishou/info/property/"+id;
var page1;
var page2;
var page3;
var historymoney;
var phone;

$.ajax({
    url:url,
    success:function (data) {
        page1 = data[0];
        page2 = data[1];
        page3 = data[2];
        historymoney = data[3];
        phone = data[4];
        $("#top-a").attr("href","http://localhost:8080/ihuishou/index/"+phone.brandId);
        $("#top-a").text(phone.brandName);
        $("#top-span").text(phone.typeName);
        $("#gid").val(phone.typeId);
        $(".heat_img").find("img").attr("src","http://localhost:80/ihuishou/"+phone.typePic);
        $(".heat_img").find("img").attr("alt",phone.typeName+"回收价格评估");
        $(".heat_name").first().text(phone.typeName);
        $(".heat_ts").find("em").text(phone.typeMoney/100);
        $(".heat_bao").first().attr("alt",phone.typeName+"回收免费享受第三方理赔服务");
        // 第一步
        var page1l = page1.length;
        var page1html = "";
        for(var i=0;i<page1l;i++){
            page1html += "" +
                "<dd>\n" +
                "   <input type=\"hidden\" name=\"property[]\" id=\"property_"+i+"\" value=\"0\"/>\n" +
                "   <div class=\"property_title\"><h3>"+page1[i].estimateName+"</h3></div>\n" +
                "<ul>";
            var info = page1[i].infolist;
            var infol = info.length;
            for (var j=0;j<infol;j++){
                page1html += "" +
                    "<li autocomplete=\"off\" class=\"\" onClick=\"property_click(this,"+i+","+info[j].infoId+")\" name=\"sx_child_"+i+"\">\n" +
                    "   <div class=\"pro_div\"><span class=\"property_value\"><i>"+info[j].infoName+"</i><ins>"+info[j].infoText+"</ins></span><span\n" +
                    "       class=\"gou\"></span></div>\n" +
                    "</li>\n"
            }
            page1html +="<div class=\"clear\"></div>";
            page1html += "</ul>\n" +
                "                </dd>";
        }
        page1html += "<div id=\"step1_nav\" class=\"property_nav\">\n" +
            "                    <div id=\"btn_step1_next\" class=\"btn_next\">下一步</div>\n" +
            "                </div>";
        $("#PAGE1").html(page1html);
        // 第一步完
        // 第二部
        var page2l = page2.length;
        var page2html = "";
        for(var i=0;i<page2l;i++){
            page2html +=
                "<dd>\n" +
                "   <div class=\"property_title\">\n" +
                "       <h3>"+page2[i].estimateName+"</h3>\n" +
                "   </div>\n" +
                "   <ul>\n" +
                "       <input type=\"hidden\" name=\"desc_pid[]\" value=\"0\"/>\n";
            var info = page2[i].infolist;
            var infol = info.length;
            for (var j=0;j<infol;j++){
                page2html +=
                    "<input type=\"hidden\" name=\"desc_id[]\" id=\"desc_id_"+info[j].infoId+"\" value=\"0\"/>" +
                    "<li onClick=\"item_click(this,"+info[j].infoId+")\" name=\"mx_child_"+j+"\">\n" +
                    "   <div class=\"pro_div\"><span class=\"property_value\"><i>"+info[j].infoName+"</i><ins>"+info[j].infoText+"</ins></span>\n" +
                    "   <span class=\"gou\"></span></div>\n" +
                    "</li>";
            }
            page2html +=
                "       <div class=\"clear\"></div>\n" +
                "   </ul>\n" +
                "</dd>";
        }
        $("#PAGE2").html(page2html);
        // 第二步完
        // 第三步
        var page3l = page3.length;
        var page3html = "";
            // 单选部分
        for(var i=0;i<page3l-1;i++){
            page3html += "" +
                "<dd>\n" +
                "   <input type=\"hidden\" name=\"property[]\" id=\"property_a"+i+"\" value=\"0\"/>\n" +
                "   <div class=\"property_title\"><h3>"+page3[i].estimateName+"</h3></div>\n" +
                "<ul>";
            var info = page3[i].infolist;
            var infol = info.length;
            for (var j=0;j<infol;j++){
                page3html += "" +
                    "<li autocomplete=\"off\" class=\"\" onClick=\"property_click(this,'a"+i+"',"+info[j].infoId+")\" name=\"sx_child_a"+i+"\">\n" +
                    "   <div class=\"pro_div\"><span class=\"property_value\"><i>"+info[j].infoName+"</i><ins>"+info[j].infoText+"</ins></span><span\n" +
                    "       class=\"gou\"></span></div>\n" +
                    "</li>\n"
            }
            page3html +="<div class=\"clear\"></div>";
            page3html += "</ul>\n" +
                "                </dd>";
        }
        // 多选部分
        page3html +=
            "<dd>\n" +
            "   <div class=\"property_title\">\n" +
            "       <h3>"+page3[page3l-1].estimateName+"</h3>\n" +
            "   </div>\n" +
            "   <ul>" +
            "<input type=\"hidden\" id='pj_pid' name=\"pj_pid[]\" value=\"0\"/>";
        var info = page3[page3l-1].infolist;
        var infol = info.length;
        for (var j=0;j<infol;j++){
            page3html +=
                "<input type=\"hidden\" name=\"pj_id[]\" id=\"pj_id_"+info[j].infoId+"\" value=\"0\"/>" +
                "<li onClick=\"pj_click(this,"+info[j].infoId+")\" name=\"mx_child_"+"b"+j+"\">\n" +
                "   <div class=\"pro_div\"><span class=\"property_value\"><i>"+info[j].infoName+"</i><ins>"+info[j].infoText+"</ins></span>\n" +
                "   <span class=\"gou\"></span></div>\n" +
                "</li>";
        }
        page3html +=
            "<div class=\"clear\"></div>\n" +
            "   </ul>\n" +
            "</dd>";
        $("#PAGE3").html(page3html);
        // 第三步完
    }
});

