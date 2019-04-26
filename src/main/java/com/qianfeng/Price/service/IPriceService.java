package com.qianfeng.Price.service;

import com.qianfeng.Price.DTO.CartInfo;
import com.qianfeng.Price.DTO.GetUserId;
import com.qianfeng.Price.DTO.QueryChart;
import com.qianfeng.Price.PO.GetId;
import com.qianfeng.Price.VO.PriceCart;
import com.qianfeng.Price.VO.PriceTypeInfo;
import com.qianfeng.Price.VO.ReturnCart;

import javax.servlet.http.HttpSession;
import java.util.List;

public interface IPriceService {

    PriceTypeInfo queryTypeInfo(int typeId);

    QueryChart queryCartNum(int userId);

    int removeCart(String orderId);

    List<ReturnCart> queryCartInfo(int userId);

    GetUserId getUserById(String orderId);

    void addCart(PriceCart cart,HttpSession session);
}
