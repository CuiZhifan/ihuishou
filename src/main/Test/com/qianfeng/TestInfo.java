package com.qianfeng;

import com.qianfeng.index.VO.GetDate;
import com.qianfeng.info.VO.HistoryMoney;
import com.qianfeng.info.VO.TitleProperty;
import com.qianfeng.info.VO.TypeInfo;
import com.qianfeng.info.mapper.IInfoMapper;
import com.qianfeng.info.service.IInfoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring.xml")
public class TestInfo {

    @Autowired
    private IInfoMapper mapper;
    @Autowired
    private IInfoService service;

    @Test
    public void testCase1(){
        List<TitleProperty> list = mapper.queryPropertyByTypeId(1);
        list.forEach((d)->{
            System.out.println(d.getEstimateName()+"-"+d.getEstimatePage());
            d.getInfolist().forEach((c)-> System.out.println(c));
        });
    }

    @Test
    public void testCase2(){
        List<HistoryMoney> moneyList = service.queryHistoryMoneyById(1);
        moneyList.forEach((d)-> System.out.println(d));
    }

    @Test
    public void testCase3(){
        TypeInfo typeInfo = mapper.queryTypeInfoById(5);
        System.out.println(typeInfo);
    }

    @Test
    public void testCase4(){
        GetDate date = new GetDate();
        date.setGid(1);
        date.setPackage_id(0);
        date.setProperty_ids("3,6,7,12,14,19,33,36,39,42");
        date.setDesc_ids("20,21,22,23,25");
        date.setPj_ids("0,47,48,49,50");
        service.returnMoney(date);
    }
}
