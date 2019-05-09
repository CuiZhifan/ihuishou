package com.qianfeng;

import com.qianfeng.redis.Mapper.RedisMapper;
import com.qianfeng.redis.Service.IRedisService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static com.qianfeng.commons.constant.VALUES.PAGESIZE;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring.xml")
public class RedisTest {

    @Autowired
    private StringRedisTemplate redisTemplate;
    @Autowired
    private RedisMapper mapper;
    @Autowired
    private IRedisService service;

    @Test
    public void testCase1(){
        redisTemplate.boundValueOps("qianfeng").set("java2");
    }

    /**
     * 查询字符串缓存
     */
    @Test
    public void testCase2(){
        String qianfeng = redisTemplate.boundValueOps("qianfeng").get();
        System.out.println(qianfeng);
    }

    /**
     * 存Hash类型
     */
    @Test
    public void testCase3(){
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("name","java");
        hashMap.put("age","24");
        redisTemplate.boundHashOps("qianfeng_hash").putAll(hashMap);
    }

    /**
     * 获取hash类型
     */
    @Test
    public void testCase4(){
        Map<Object, Object> qianfengHash = redisTemplate.boundHashOps("qianfeng_hash").entries();
        Object name = qianfengHash.get("name");
        System.out.println(name);
    }

    /**
     * list集合
     */
    @Test
    public void testCase5(){
        Long aLong = redisTemplate.boundListOps("books").leftPushAll("zhangsan", "lisi");
        System.out.println(aLong);
    }

    /**
     * 获取List
     */
    @Test
    public void testCase6(){
        List<String> list = redisTemplate.boundListOps("books").range(0, -1);
        System.out.println(list);
    }

    /**
     * 获取所有Key对应的数据
     */
    @Test
    public void testCase7(){
        Set<String> keys = redisTemplate.keys("redis-zan-10001-*");
        System.out.println(keys);
    }

    @Test
    public void testCase8(){
        mapper.indexQueryType(0,2,PAGESIZE).forEach((d)-> System.out.println(d));
    }

    @Test
    public void testCase9(){
        mapper.indexQueryBrand().forEach((d)-> System.out.println(d));
    }

    @Test
    public void testCase10(){
        System.out.println(mapper.queryCount(1));
    }

    @Test
    public void testCase11(){
        service.initializeIndex();
    }

    @Test
    public void testCase12(){
        String s = service.QueryRedis("ihuishou-index-0-3");
        System.out.println(s);
    }

    @Test
    public void testCase13(){
        Set<String> keys = redisTemplate.keys("ihuishou-*");
        Long delete = redisTemplate.delete(keys);
    }

    public int sum(int n){
        int a;
        if(n==1)a=1;
        else a=sum(n-1)+n;
        return a;
    }

    @Test
    public void testCase14(){
        System.out.println(sum(1000));
    }
}
