package com.qianfeng.info.controller;

import com.qianfeng.info.VO.HistoryMoney;
import com.qianfeng.info.VO.TypeInfo;
import com.qianfeng.info.service.IInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/info")
public class infoController {
    @Autowired
    private IInfoService service;

    @ResponseBody
    @RequestMapping("/property/{typeId}")
    public List queryProperty(@PathVariable("typeId") int typeId){
        List list = service.queryPropertyByTypeId(typeId);
        List<HistoryMoney> historyMonies = service.queryHistoryMoneyById(typeId);
        TypeInfo info = service.queryTypeInfoById(typeId);
        list.add(historyMonies);
        list.add(info);
        System.out.println("传输完成");
        return list;
    }
}
