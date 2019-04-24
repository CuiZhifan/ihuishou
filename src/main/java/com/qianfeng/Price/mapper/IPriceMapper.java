package com.qianfeng.Price.mapper;

import com.qianfeng.Price.VO.PriceTypeInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface IPriceMapper {
    PriceTypeInfo queryTypeInfo(@Param("typeId") int typeId);
}
