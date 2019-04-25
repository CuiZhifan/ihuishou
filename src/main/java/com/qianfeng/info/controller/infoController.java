package com.qianfeng.info.controller;

import com.qianfeng.index.VO.GetDate;
import com.qianfeng.info.VO.HistoryMoney;
import com.qianfeng.info.VO.TypeInfo;
import com.qianfeng.info.service.IInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

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

    @RequestMapping("/getDate")
    @ResponseBody
    public List resive(GetDate date, HttpSession session){
        List result = service.returnMoney(date);
        int money = (int) result.get(0);
        String infos = (String) result.get(1);
//        System.out.println("评估后价格"+money);
        List list = new ArrayList();
        List info = new ArrayList();
        info.add(date.getGid());
        info.add(money);
        info.add(infos);
        if(date.getPackage_id()<0){
            info.add(service.addTemporaryWorker());
        }else {
            info.add(date.getPackage_id());
        }
        String key = UUID.randomUUID().toString().replace("-","").substring(0,10);
        session.setAttribute(key,info);
        list.add("1");
        list.add(key);
        return list;
    }


}
