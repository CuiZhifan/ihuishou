package com.qianfeng;

import com.qianfeng.Price.PO.GetId;
import com.qianfeng.User.DTO.LoginResult;
import com.qianfeng.User.Mapper.IUserMapper;
import com.qianfeng.User.PO.TbUser;
import com.qianfeng.User.Service.IUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

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
//        LoginResult login = service.login("243975576@qq.com","111111",0);
//        System.out.println(login);
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

    @Test
    public void TestCase4(){
        GetId getId = new GetId();
        getId.setPassword("111111");
        getId.setUserEmail("123@123");
        getId.setUserPhone("");
        getId.setJoinTime(new Timestamp(new Date().getTime()));
        mapper.addUser(getId);
        System.out.println(getId.getUserId());
    }

    @Test
    public void TestCase5(){
        List<Integer> list = mapper.checkUserName("243975576@qq.com");
        if (list.isEmpty()){
            System.out.println("ok");
        }else {
            System.out.println("No ok");
        }
    }
}
