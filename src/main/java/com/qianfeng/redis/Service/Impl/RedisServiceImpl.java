package com.qianfeng.redis.Service.Impl;

import com.google.gson.Gson;
import com.qianfeng.index.VO.IndexBrand;
import com.qianfeng.index.VO.IndexType;
import com.qianfeng.redis.Mapper.RedisMapper;
import com.qianfeng.redis.Service.IRedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

import static com.qianfeng.commons.constant.VALUES.PAGESIZE;

@Service
public class RedisServiceImpl implements IRedisService {
    @Autowired
    private RedisMapper mapper;
    @Autowired
    private StringRedisTemplate redisTemplate;

    private Gson gson = new Gson();

    @Override
    public void initializeIndex() {
        //清除当前项目的缓存
        clearRedis();
        //添加品牌缓存
        saveTypes(0);
        List<IndexBrand> brands = mapper.indexQueryBrand();
        //添加型号分页缓存
        for (IndexBrand b:brands){
            saveTypes(b.getBrandId());
        }
        String json = gson.toJson(brands);
        redisTemplate.boundValueOps("ihuishou-index-brands").set(json);
    }

    /**
     * 查询缓存
     * @param key 缓存名
     * @return 缓存内容
     */
    @Override
    public String QueryRedis(String key) {
        return redisTemplate.boundValueOps(key).get();
    }

    /**
     * 保存型号分页缓存
     * @param brandId 品牌ID
     */
    private void saveTypes(Integer brandId){
        //计算分页信息
        Integer count = mapper.queryCount(brandId);
        int page = count/PAGESIZE;
        int more = count%PAGESIZE;
        if (more!=0){
            page++;
        }
        if (page<1){
            page = 1;
        }
        //添加缓存
        for (int i=1;i<=page;i++){
            int start = (i-1)*PAGESIZE;
//            System.out.println(i+"-"+start);
            //分页查询
            List<IndexType> types = mapper.indexQueryType(brandId, start, PAGESIZE);
//            types.forEach((d)-> System.out.println(d));
            //生成缓存键值对
            String json = gson.toJson(types);
            String key = "ihuishou-index-"+brandId+"-"+i;
            redisTemplate.boundValueOps(key).set(json);
        }
    }

    private void clearRedis(){
        //查询当前项目的所有缓存
        Set<String> keys = redisTemplate.keys("ihuishou-*");
        //清空缓存
        Long delete = redisTemplate.delete(keys);
    }
}
