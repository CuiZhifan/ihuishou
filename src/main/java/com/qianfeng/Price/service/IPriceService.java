package com.qianfeng.Price.service;

import com.qianfeng.Price.VO.PriceTypeInfo;

public interface IPriceService {

    PriceTypeInfo queryTypeInfo(int typeId);
}
