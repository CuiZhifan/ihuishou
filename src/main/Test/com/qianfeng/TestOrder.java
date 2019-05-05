package com.qianfeng;

import com.qianfeng.order.DTO.OrderIdList;
import com.qianfeng.order.PO.TbChit;
import com.qianfeng.order.PO.TbOrder;
import com.qianfeng.order.mapper.IOrderMapper;
import com.qianfeng.order.service.IOrderService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring.xml")
public class TestOrder {

    @Autowired
    private IOrderMapper mapper;
    @Autowired
    private IOrderService service;

    @Test
    public void testCase(){
        TbChit tbChit = new TbChit();
        tbChit.setUserId(1);
        tbChit.setBaoxian_name("崔加瓦");
        tbChit.setBaoxian_card_id("1234223432344234");
        mapper.addBaodan(tbChit);
    }

    @Test
    public void testCase1(){
        List<OrderIdList> list = service.checkOrderIdList(1);
        list.forEach((d)-> System.out.println(d));
    }

    @Test
    public void testCase2(){
        TbOrder order = service.queryOrder("test1");
        System.out.println(order);
    }
}
