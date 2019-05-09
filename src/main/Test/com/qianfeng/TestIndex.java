package com.qianfeng;

import com.qianfeng.index.VO.IndexBrand;
import com.qianfeng.index.VO.IndexFQuery;
import com.qianfeng.index.VO.IndexType;
import com.qianfeng.index.mapper.IQueryMapper;
import com.qianfeng.index.service.IQueryservice;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring.xml")
public class TestIndex {
    @Autowired
    private IQueryMapper mapper;
    @Autowired
    private IQueryservice serice;

    @Test
    public void testCase1(){
        List<IndexFQuery> list = mapper.indexQueryByPhone(1);
        list.forEach((d)->{
            System.out.println(d.getFname());
            d.getClist().forEach((c)-> System.out.println(c.getCname()+"-"+c.getCinfo()+"-"+c.getDiscount()));
        });
    }

    @Test
    public void testCase2(){
        List<IndexBrand> list = mapper.indexQueryAllType(0);
        list.forEach((d)->{
            System.out.println(d.getBrandId()+"-"+d.getBrandName());
            d.getTypeList().forEach((c)-> System.out.println(c.getTypeId()+"-"+c.getTypeName()+"-"+c.getTypePic()));
        });
    }

    @Test
    public void testCase3(){
        List<IndexType> typeList = mapper.indexQueryType(0);
        typeList.forEach((d)-> System.out.println(d));
    }

    @Test
    public void testCase4(){
        List<IndexBrand> brands = mapper.indexQueryBrand();
        brands.forEach((d)-> System.out.println(d));
    }

    @Test
    public void testCase5(){
        List<IndexType> types = mapper.queryTypesByName("%%");
        types.forEach((d)-> System.out.println(d));
    }

    @Test
    public void testCase6(){
        List<IndexType> types = serice.queryTypesByName("i", "2");
        types.forEach((d)-> System.out.println(d));
    }
}
