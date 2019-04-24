package com.qianfeng.index.service.Impll;

import com.qianfeng.index.VO.IndexBrand;
import com.qianfeng.index.VO.IndexFQuery;
import com.qianfeng.index.VO.IndexType;
import com.qianfeng.index.mapper.IQueryMapper;
import com.qianfeng.index.service.IQueryservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class IndexServiceImpl implements IQueryservice {

    @Autowired
    private IQueryMapper mapper;

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
    public List<IndexType> queryTypesByName(String word) {
        word = "%"+word+"%";
        return mapper.queryTypesByName(word);
    }
}
