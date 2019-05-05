package com.qianfeng.redis.Mapper;

import com.qianfeng.index.VO.IndexBrand;
import com.qianfeng.index.VO.IndexType;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RedisMapper {
    List<IndexType> indexQueryType(@Param("brandId") int brandId,@Param("start") int start,@Param("size") int size);
    List<IndexBrand> indexQueryBrand();
    Integer queryCount(@Param("brandId") int brandId);
}
