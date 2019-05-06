package com.qianfeng.index.controller;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.qianfeng.index.VO.IndexBrand;
import com.qianfeng.index.VO.IndexType;
import com.qianfeng.index.mapper.IQueryMapper;
import com.qianfeng.index.service.IQueryservice;
import com.qianfeng.index.service.Impll.IndexServiceImpl;
import com.qianfeng.redis.Service.IRedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Controller
@RequestMapping("/index")
@CrossOrigin
public class IndexController {

    @Autowired
    private IQueryservice service;
    @Autowired
    private IRedisService redisService;

    private Gson gson = new Gson();

    @RequestMapping("/type/setSession/{word}")
    @CrossOrigin
    @ResponseBody
    public String setSession(HttpSession session,@PathVariable("word")String word){
        String name = UUID.randomUUID().toString().replace("-","").substring(0,10);
        session.setAttribute(name,word);
        return name;
    }

    @RequestMapping("/type/{brandId}")
    @ResponseBody
    @CrossOrigin
    public List<IndexBrand> queryAll(@PathVariable("brandId") String brandId,HttpSession session){
        String[] strings = brandId.split("-");
        int id = Integer.parseInt(strings[0]);
        String name = null;
        String pageStr = "1";
        if(strings.length>1){
            if("null".equals(strings[1])){
                strings[1] = null;
            }
            if(strings[1]!=null){
                name = strings[1];
            }
            if(strings.length>2) {
                if ("null".equals(strings[2])) {
                    strings[2] = null;
                }
                if (strings[2] != null) {
                    pageStr = strings[2];
                }
            }
        }
        List list = new ArrayList();
        List<IndexBrand> brands = service.indexQueryBrand();
        list.add(brands);
        if (name!=null){
            String word = (String) session.getAttribute(name);
            session.setAttribute("word",null);
            List<IndexType> types = service.queryTypesByName(word);
            list.add(types);
        }else {
            List<IndexType> types;
            if (pageStr!=null){
                String key = "ihuishou-index-"+id+"-"+pageStr;
                String str = redisService.QueryRedis(key);
                types = gson.fromJson(str,new TypeToken<List<IndexType>>(){}.getType());
            }else {
                types = service.indexQueryType(id);
            }
            list.add(types);
        }
        return list;
    }
}
