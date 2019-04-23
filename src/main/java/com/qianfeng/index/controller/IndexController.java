package com.qianfeng.index.controller;

import com.qianfeng.index.VO.IndexBrand;
import com.qianfeng.index.VO.IndexType;
import com.qianfeng.index.mapper.IQueryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/index")
@CrossOrigin
public class IndexController {

    @Autowired
    private IQueryMapper mapper;

    @RequestMapping("/brand")
    @ResponseBody
    @CrossOrigin
    public List<IndexBrand> queryBrand(){
        List<IndexBrand> brandList = mapper.indexQueryBrand();
        return brandList;
    }

//    @RequestMapping("/type/{brandId}")
//    @ResponseBody
//    @CrossOrigin
//    public List<IndexType> qierytype(@PathVariable("brandId") int brandId){
//        if(brandId<=0){
//            brandId = 0;
//        }
//        List<IndexType> types = mapper.indexQueryType(brandId);
//        return types;
//    }

    @RequestMapping("/type/{brandId}")
    @ResponseBody
    @CrossOrigin
    public List<IndexBrand> queryAll(@PathVariable("brandId") int brandId){
        List<IndexBrand> brands = mapper.indexQueryBrand();
        List<IndexType> types = mapper.indexQueryType(brandId);
        List list = new ArrayList();
        list.add(brands);
        list.add(types);
        return list;
    }
}
