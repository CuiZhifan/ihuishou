package com.qianfeng;

import com.qianfeng.User.DTO.LoginResult;
import com.qianfeng.User.Mapper.IUserMapper;
import com.qianfeng.User.PO.TbUser;
import com.qianfeng.User.Service.IUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring.xml")
public class TestUser {
    @Autowired
    private IUserMapper mapper;

    @Autowired
    private IUserService service;

    @Test
    public void TestCase(){
        int i = service.checkUser(1);
        System.out.println(i);
    }

    @Test
    public void TestCase1(){
        LoginResult login = service.login("243975576@qq.com","111111");
        System.out.println(login);
    }

    @Test
    public void TestCase2(){
        TbUser user = mapper.queryUser(1);
        System.out.println(user);
    }

    @Test
    public void TestCase3(){
        mapper.CashOut(1);
    }
}
