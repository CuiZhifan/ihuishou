package com.qianfeng.info.mapper;

import com.qianfeng.Price.PO.GetId;
import com.qianfeng.info.DTO.GetMoney;
import com.qianfeng.info.VO.HistoryMoney;
import com.qianfeng.info.VO.TitleProperty;
import com.qianfeng.info.VO.TypeInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface IInfoMapper {
    List<TitleProperty> queryPropertyByTypeId(@Param("typeId") int typeId);

    List<HistoryMoney> queryHistoryMoneyById(@Param("typeId") int typeId);

    TypeInfo queryTypeInfoById(@Param("typeId") int typeId);

    List<GetMoney> getMoney(@Param("typeId") int typeId,@Param("ids") String[] ids);

    void addTemporaryWorker(GetId getId);
}
