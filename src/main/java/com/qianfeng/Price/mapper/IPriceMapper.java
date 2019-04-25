package com.qianfeng.Price.mapper;

import com.qianfeng.Price.DTO.GetUserId;
import com.qianfeng.Price.DTO.QueryChart;
import com.qianfeng.Price.DTO.TypeInfo;
import com.qianfeng.Price.PO.GetId;
import com.qianfeng.Price.PO.TbUser;
import com.qianfeng.Price.VO.PriceTypeInfo;
import com.qianfeng.Price.VO.ReturnCart;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface IPriceMapper {
    PriceTypeInfo queryTypeInfo(@Param("typeId") int typeId);

    QueryChart queryCartNum(@Param("userId") int userId);

    void removeCart(@Param("orderId") String orderId);

    List<ReturnCart> queryCartInfo(@Param("userID") int userID);

    GetUserId getUserById(@Param("orderId") String orderId);
}
