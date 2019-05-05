package com.qianfeng.Price.service.Impl;

import com.qianfeng.Price.DTO.CartInfo;
import com.qianfeng.Price.DTO.GetUserId;
import com.qianfeng.Price.DTO.QueryChart;
import com.qianfeng.Price.PO.GetId;
import com.qianfeng.Price.VO.PriceCart;
import com.qianfeng.Price.VO.PriceTypeInfo;
import com.qianfeng.Price.VO.ReturnCart;
import com.qianfeng.Price.mapper.IPriceMapper;
import com.qianfeng.Price.service.IPriceService;
import com.qianfeng.commons.DTO.Messages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class PriceServiceImpl implements IPriceService {

    @Autowired
    private IPriceMapper mapper;

    @Override
    public PriceTypeInfo queryTypeInfo(int typeId) {
        return mapper.queryTypeInfo(typeId);
    }

    @Override
    public QueryChart queryCartNum(int userId) {
        QueryChart chart = mapper.queryCartNum(userId);
        if (chart.getCart_total()==null){
            chart.setCart_total(0);
        }
        return chart;
    }

    @Override
    public int removeCart(String orderId) {
        try{
            mapper.removeCart(orderId);
            return 1;
        }catch (Exception e){
            return 0;
        }
    }

    @Override
    public List<ReturnCart> queryCartInfo(int userId) {
        List<ReturnCart> cartInfo = mapper.queryCartInfo(userId);
        return cartInfo;
    }

    @Override
    public GetUserId getUserById(String orderId) {
        return mapper.getUserById(orderId);
    }

    @Override
    public void addCart(PriceCart cart, HttpSession session) {
        Messages list = (Messages) session.getAttribute(cart.getKey());
        CartInfo cartInfo = new CartInfo();
        cartInfo.setOrderId(UUID.randomUUID().toString().replace("-", "").substring(0,20));
        cartInfo.setUserId(list.getUserId());
        cartInfo.setOrderPrice(list.getMoney());
        cartInfo.setOrderEstimates(list.getInfos());
        cartInfo.setOrderStatus(0);
        cartInfo.setOrderCreateTime(new Timestamp(new Date().getTime()));
        cartInfo.setOrderPhoneType(list.getTypeId());
        mapper.addCart(cartInfo);
    }


}
