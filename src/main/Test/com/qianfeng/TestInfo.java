package com.qianfeng;

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
}
