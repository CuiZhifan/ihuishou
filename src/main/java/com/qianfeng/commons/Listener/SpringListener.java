package com.qianfeng.commons.Listener;

import com.qianfeng.commons.constant.URL;
import com.qianfeng.redis.Service.IRedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class SpringListener implements ApplicationListener<ContextRefreshedEvent>{
    @Autowired
    private IRedisService service;


    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        if(event.getApplicationContext().getParent() == null){
            System.out.println("系统初始化...");
            try {
                //初始化首页缓存
                service.initializeIndex();
            } catch (Exception e) {
                System.out.println("初始化异常...");
                e.printStackTrace();
            }
            System.out.println("初始化完成...");
        }
    }
}
