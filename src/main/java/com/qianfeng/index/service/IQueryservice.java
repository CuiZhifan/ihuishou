package com.qianfeng.index.service;

import com.qianfeng.index.VO.IndexBrand;
import com.qianfeng.index.VO.IndexFQuery;
import com.qianfeng.index.VO.IndexType;

import java.util.List;

public interface IQueryservice {
    List<IndexFQuery> indexQueryByPhone(int infoId);
    List<IndexBrand> indexQueryAllType(int brandId);
    List<IndexBrand> indexQueryBrand();
    List<IndexType> indexQueryType(int brandId);
    List<IndexType> queryTypesByName(String word,String page);
}
