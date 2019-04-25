package com.qianfeng.info.service.InfoServiceImpl;

import com.qianfeng.Price.PO.GetId;
import com.qianfeng.index.VO.GetDate;
import com.qianfeng.info.DTO.GetMoney;
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

    @Override
    public List returnMoney(GetDate date) {
//        读取参数
        int typeId = date.getGid();
        String infos = (date.getProperty_ids()+","+date.getDesc_ids()+","+date.getPj_ids()).replace(",,",",");
        infos = infos.replace(",0,",",");
        //        获取总折扣
        String[] ids = infos.split(",");
        List<GetMoney> monies = mapper.getMoney(typeId, ids);
        double pct = 1;int count = 0;String infoName = "";String AAA = "";
        for (GetMoney m:monies){
            String discount = m.getDiscount();
            infoName += AAA;
            infoName += m.getInfoName();
            AAA = ",";
            if(discount.startsWith("%")){
                pct = pct * Double.parseDouble(discount.replace("%",""));
            }else {
                count += Integer.parseInt(discount);
            }
        }
//        获取原价
        int money = mapper.queryTypeInfoById(typeId).getTypeMoney();
//        计算价格
        money = (int) ((money-count)*pct);
        if(money<5000){
            money = 5000;
        }
        money = money/100;
        List list = new ArrayList();
        list.add(money);
        list.add(infoName);
        return list;
    }

    @Override
    public int addTemporaryWorker() {
        GetId getId1 = new GetId();
        mapper.addTemporaryWorker(getId1);
        return getId1.getUserId();
    }


}
