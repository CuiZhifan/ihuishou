package com.qianfeng.index.mapper;

import com.qianfeng.index.VO.IndexBrand;
import com.qianfeng.index.VO.IndexFQuery;
import com.qianfeng.index.VO.IndexType;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface IQueryMapper {
    List<IndexFQuery> indexQueryByPhone(@Param("infoId") int infoId);
    List<IndexBrand> indexQueryAllType(@Param("brandId") int brandId);
    List<IndexBrand> indexQueryBrand();
    List<IndexType> indexQueryType(@Param("brandId") int brandId);
    List<IndexType> queryTypesByName(@Param("word") String word);
}
