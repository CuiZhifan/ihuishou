package com.qianfeng.info.service;

import com.qianfeng.info.VO.HistoryMoney;
import com.qianfeng.info.VO.TypeInfo;

import java.util.List;

public interface IInfoService {
    List queryPropertyByTypeId(int typeId);

    List<HistoryMoney> queryHistoryMoneyById(int typeId);

    TypeInfo queryTypeInfoById(int typeId);
}
