package com.qianfeng.info.service.InfoServiceImpl;

import com.qianfeng.info.VO.HistoryMoney;
import com.qianfeng.info.VO.TitleProperty;
import com.qianfeng.info.VO.TypeInfo;
import com.qianfeng.info.mapper.IInfoMapper;
import com.qianfeng.info.service.IInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class InfoServiceImpl implements IInfoService {

    @Autowired
    private IInfoMapper mapper;

    @Override
    public List<TitleProperty> queryPropertyByTypeId(int typeId) {
        List<TitleProperty> properties = mapper.queryPropertyByTypeId(typeId);
        List<TitleProperty> page1 = new ArrayList<>();
        List<TitleProperty> page2 = new ArrayList<>();
        List<TitleProperty> page3 = new ArrayList<>();
        properties.forEach((d)->{
            if (d.getEstimatePage()==1){
                page1.add(d);
            }else if (d.getEstimatePage()==2){
                page2.add(d);
            }else {
                page3.add(d);
            }
        });
        List list = new ArrayList();
        list.add(page1);
        list.add(page2);
        list.add(page3);
        return list;
    }

    @Override
    public List<HistoryMoney> queryHistoryMoneyById(int typeId) {
        List<HistoryMoney> historyMonies = mapper.queryHistoryMoneyById(typeId);
        List<HistoryMoney> list = new ArrayList<>();
        int length = historyMonies.size();
        if (length-->0){
            for(int i=length;i>=0;i--){
                list.add(historyMonies.get(i));
            }
        }
        return list;
    }

    @Override
    public TypeInfo queryTypeInfoById(int typeId) {
        TypeInfo typeInfo = mapper.queryTypeInfoById(typeId);
        return typeInfo;
    }
}
