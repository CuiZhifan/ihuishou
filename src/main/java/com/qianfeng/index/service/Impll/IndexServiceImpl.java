package com.qianfeng.index.service.Impll;

import com.qianfeng.index.VO.IndexBrand;
import com.qianfeng.index.VO.IndexFQuery;
import com.qianfeng.index.VO.IndexType;
import com.qianfeng.index.service.IQueryservice;

import java.util.List;

public class IndexServiceImpl implements IQueryservice {

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
        return null;
    }

    @Override
    public List<IndexType> indexQueryType(int brandId) {
        return null;
    }

    @Override
    public List<IndexType> queryTypesByName(String word) {
        return null;
    }
}
