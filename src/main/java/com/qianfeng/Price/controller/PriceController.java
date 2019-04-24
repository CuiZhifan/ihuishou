package com.qianfeng.Price.controller;

import com.qianfeng.Price.VO.PriceTypeInfo;
import com.qianfeng.Price.service.IPriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
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
        List list = (List) session.getAttribute(key);
        int typeId = (int) list.get(0);
        int money = (int) list.get(1);
        String infos = (String) list.get(2);
        PriceTypeInfo info = service.queryTypeInfo(typeId);
        info.setDiscount(money);
        info.setInfos(infos);
        info.setKey(key);
        System.out.println(info);
        return info;
    }
}
