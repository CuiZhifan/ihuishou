package com.qianfeng;

import com.qianfeng.Price.VO.PriceTypeInfo;
import com.qianfeng.Price.mapper.IPriceMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring.xml")
public class TestPrice {
    @Autowired
    private IPriceMapper mapper;

    @Test
    public void testCase(){
        PriceTypeInfo info = mapper.queryTypeInfo(1);
        System.out.println(info);
    }
}
