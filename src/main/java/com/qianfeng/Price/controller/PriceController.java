package com.qianfeng.Price.controller;

import com.qianfeng.Price.DTO.GetUserId;
import com.qianfeng.Price.DTO.QueryChart;
import com.qianfeng.Price.VO.PriceCart;
import com.qianfeng.Price.VO.PriceTypeInfo;
import com.qianfeng.Price.VO.ReturnCart;
import com.qianfeng.Price.service.IPriceService;
import com.qianfeng.commons.DTO.Messages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/price")
public class PriceController {

    @Autowired
    private IPriceService service;

    @RequestMapping("/{key}")
    public String test(@PathVariable("key") String key){
        String url = "redirect:/html/price.html?key="+key;
        return url;
    }

    @RequestMapping("/getInfo/{key}")
    @ResponseBody
    public PriceTypeInfo toPrice(@PathVariable("key") String key, HttpSession session){
        Messages list = (Messages) session.getAttribute(key);
        int typeId = list.getTypeId();
        int money = list.getMoney();
        String infos = list.getInfos();
        PriceTypeInfo info = service.queryTypeInfo(typeId);
        info.setDiscount(money);
        info.setInfos(infos);
        info.setKey(key);
        return info;
    }

    @RequestMapping("/removeCart/{orderId}")
    @ResponseBody
    public List removeCart(@PathVariable("orderId") String orderId){
        GetUserId userId = service.getUserById(orderId);
        int i = service.removeCart(orderId);
        QueryChart chart = service.queryCartNum(userId.getUserId());
        List list = new ArrayList();
        list.add(i);
        list.add(chart);
        return list;
    }

    @RequestMapping("/addCart")
    @ResponseBody
    public List addCart(PriceCart cart,HttpSession session){
        service.addCart(cart,session);
        //获取session中的信息
        Messages attribute = (Messages) session.getAttribute(cart.getKey());
        //新建返回集合
        List result = new ArrayList();
        result.add("1");
            //查询购物车数量及总价
        Integer userId = attribute.getUserId();
        QueryChart queryChart = service.queryCartNum(userId);
        result.add(queryChart);
        //新建第三个数据
//        ReturnCart returnCart = new ReturnCart();
//            //添加相关信息
//        returnCart.setRowid(UUID.randomUUID().toString().replace("-","").substring(0,20));
//        //获取ID
//        int id = cart.getTypeid();
//            //查询ID对应的信息
//        PriceTypeInfo info = service.queryTypeInfo(id);
//        returnCart.setImg(info.getTypePic());
//        returnCart.setName(info.getTypeName());
//        //获取session中的价格
//        returnCart.setPrice((Integer) attribute.get(1));
//        System.out.println(returnCart);
//        result.add(returnCart);
        //新建第三个数据
        List<ReturnCart> carts = service.queryCartInfo(attribute.getUserId());
        result.add(carts);
        return result;
    }

    @ResponseBody
    @RequestMapping("/returnCarts")
    public List<ReturnCart> returnAllCart(String key,HttpSession session){
        Messages attribute = (Messages) session.getAttribute(key);
        List<ReturnCart> carts = service.queryCartInfo(attribute.getUserId());
        return carts;
    }
}
