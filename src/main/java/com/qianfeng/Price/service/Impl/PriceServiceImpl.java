package com.qianfeng.Price.service.Impl;

import com.qianfeng.Price.DTO.GetUserId;
import com.qianfeng.Price.DTO.QueryChart;
import com.qianfeng.Price.PO.GetId;
import com.qianfeng.Price.VO.PriceTypeInfo;
import com.qianfeng.Price.VO.ReturnCart;
import com.qianfeng.Price.mapper.IPriceMapper;
import com.qianfeng.Price.service.IPriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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


}
