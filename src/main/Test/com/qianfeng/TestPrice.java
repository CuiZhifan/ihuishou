package com.qianfeng;

import com.qianfeng.Price.DTO.CartInfo;
import com.qianfeng.Price.DTO.QueryChart;
import com.qianfeng.Price.PO.GetId;
import com.qianfeng.Price.VO.PriceTypeInfo;
import com.qianfeng.Price.VO.ReturnCart;
import com.qianfeng.Price.mapper.IPriceMapper;
import com.qianfeng.Price.service.IPriceService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring.xml")
public class TestPrice {
    @Autowired
    private IPriceMapper mapper;
    @Autowired
    private IPriceService service;

    @Test
    public void testCase(){
        PriceTypeInfo info = mapper.queryTypeInfo(18);
        System.out.println(info);
    }

    @Test
    public void testCase1(){
        QueryChart chart = service.queryCartNum(24);
        System.out.println(chart);
    }

    @Test
    public void testCase2(){
        mapper.removeCart("test2");
    }

    @Test
    public void testCase3(){
        List<ReturnCart> carts = service.queryCartInfo(0);
        carts.forEach((d)-> System.out.println(d));
    }

    @Test
    public void testCase4(){
        CartInfo cartInfo = new CartInfo();
        cartInfo.setOrderId(UUID.randomUUID().toString().replace("-", "").substring(0,20));
        cartInfo.setUserId(1);
        cartInfo.setOrderPrice(2000);
        cartInfo.setOrderEstimates("QAQ");
        cartInfo.setOrderStatus(0);
        cartInfo.setOrderCreateTime(new Timestamp(new Date().getTime()));
        cartInfo.setOrderPhoneType(1);
        mapper.addCart(cartInfo);
    }
}
