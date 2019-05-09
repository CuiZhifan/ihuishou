package com.qianfeng.index.service.Impll;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.qianfeng.commons.constant.VALUES;
import com.qianfeng.index.VO.IndexBrand;
import com.qianfeng.index.VO.IndexFQuery;
import com.qianfeng.index.VO.IndexType;
import com.qianfeng.index.mapper.IQueryMapper;
import com.qianfeng.index.service.IQueryservice;
import com.qianfeng.redis.Mapper.RedisMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class IndexServiceImpl implements IQueryservice {

    @Autowired
    private IQueryMapper mapper;
    @Autowired
    private StringRedisTemplate redisTemplate;

    @Override
    public List<IndexFQuery> indexQueryByPhone(int infoId) {
        return null;
    }

    @Override
    public List<IndexBrand> indexQueryAllType(int brandId) {
        return null;
    }

    @Override
    public List<IndexBrand> indexQueryBrand() {
        return mapper.indexQueryBrand();
    }

    @Override
    public List<IndexType> indexQueryType(int brandId) {
        return mapper.indexQueryType(brandId);
    }

    @Override
    public List<IndexType> queryTypesByName(String word,String page) {
        word = "%"+word+"%";
        String key = "ihuishou-index-"+word+"-"+page;
        List<IndexType> list;
        Gson gson = new Gson();
        String result = redisTemplate.boundValueOps(key).get();
        if (result==null){
            list = mapper.queryTypesByName(word);
            //存入缓存
            synchronized (this){
                result = redisTemplate.boundValueOps(key).get();
                if (result==null){
                    int length = list.size();
                    int pages = length/ VALUES.PAGESIZE;
                    if (length%VALUES.PAGESIZE!=0){
                        pages++;
                    }
                    for (int i=0;i<pages;i++){
                        ArrayList<IndexType> types = new ArrayList<>();
                        for (int j=0;j<VALUES.PAGESIZE;j++){
                            types.add(list.get(i*VALUES.PAGESIZE+j));
                        }
                        String json = gson.toJson(types);
                        String KEY = "ihuishou-index-"+word+"-"+(i+1);
                        redisTemplate.boundValueOps(KEY).set(json);
                    }
                    result = redisTemplate.boundValueOps(key).get();
                }
                list = gson.fromJson(result,new TypeToken<List<IndexType>>(){}.getType());
            }
        }else {
            list = gson.fromJson(result,new TypeToken<List<IndexType>>(){}.getType());
        }
        return list;
    }
}
