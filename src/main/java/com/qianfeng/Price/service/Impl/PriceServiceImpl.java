package com.qianfeng.Price.service.Impl;

import com.qianfeng.Price.VO.PriceTypeInfo;
import com.qianfeng.Price.mapper.IPriceMapper;
import com.qianfeng.Price.service.IPriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PriceServiceImpl implements IPriceService {

    @Autowired
    private IPriceMapper mapper;

    @Override
    public PriceTypeInfo queryTypeInfo(int typeId) {
        return mapper.queryTypeInfo(typeId);
    }
}
