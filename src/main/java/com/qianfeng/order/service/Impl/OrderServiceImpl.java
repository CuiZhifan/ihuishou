package com.qianfeng.order.service.Impl;

import com.qianfeng.User.Mapper.IUserMapper;
import com.qianfeng.User.PO.TbUser;
import com.qianfeng.order.DTO.HistoryMoney;
import com.qianfeng.order.DTO.OrderIdList;
import com.qianfeng.order.PO.TbChit;
import com.qianfeng.order.PO.TbOrder;
import com.qianfeng.order.mapper.IOrderMapper;
import com.qianfeng.order.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements IOrderService {

    @Autowired
    private IOrderMapper mapper;
    @Autowired
    private IUserMapper userMapper;

    @Override
    public void addBaodan(TbChit tbChit) {
        if (tbChit.getBaoxian_name()!=null && tbChit.getBaoxian_card_id()!=null){
            mapper.addBaodan(tbChit);
        }
    }

    @Override
    public List<OrderIdList> checkOrderIdList(int userId) {
        return mapper.checkOrderIdList(userId);
    }

    @Override
    public void updateOrder(TbOrder tbOrder) {
        if (tbOrder.getOrderId()!=null){
            mapper.updateOrder(tbOrder);
        }
    }

    @Override
    public TbOrder queryOrder(String OrderId) {
        return mapper.queryOrder(OrderId);
    }

    @Override
    public void updateFrozenMoney(int money, int userId) {
        mapper.updateFrozen(money*100,userId);
    }

    @Override
    public void insertHistoryMoney(String OrderId) {
        HistoryMoney historyMoney = mapper.queryHistoryMoneyInfo(OrderId);
        mapper.addHistoryMoney(historyMoney);
    }
}
