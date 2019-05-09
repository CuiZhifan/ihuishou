package com.qianfeng.order.service;

import com.qianfeng.order.DTO.OrderIdList;
import com.qianfeng.order.PO.TbChit;
import com.qianfeng.order.PO.TbOrder;

import java.util.List;

public interface IOrderService {
    void addBaodan(TbChit tbChit);

    List<OrderIdList> checkOrderIdList(int userId);

    void updateOrder(TbOrder tbOrder);

    TbOrder queryOrder(String OrderId);

    void updateFrozenMoney(int money,int userId);

    void insertHistoryMoney(String OrderId);
}
