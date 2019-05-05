package com.qianfeng.order.mapper;

import com.qianfeng.order.DTO.OrderIdList;
import com.qianfeng.order.PO.TbChit;
import com.qianfeng.order.PO.TbOrder;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface IOrderMapper {

    void addBaodan(TbChit tbChit);

    List<OrderIdList> checkOrderIdList(@Param("userId") int userId);

    void updateOrder(TbOrder tbOrder);

    TbOrder queryOrder(@Param("orderId") String OrderId);

    void updateFrozen(@Param("money") int money,@Param("userId") int userId);
}
