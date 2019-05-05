package com.qianfeng.commons.DTO;

import com.qianfeng.order.DTO.OrderIdList;

import java.util.List;

public class Messages {
    private int typeId;
    private int money;
    private int userId;
    private String infos;
    private List<OrderIdList> orderList;


    @Override
    public String toString() {
        return "Messages{" +
                "typeId=" + typeId +
                ", money=" + money +
                ", userId=" + userId +
                ", infos='" + infos + '\'' +
                '}';
    }

    public List<OrderIdList> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<OrderIdList> orderList) {
        this.orderList = orderList;
    }

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getInfos() {
        return infos;
    }

    public void setInfos(String infos) {
        this.infos = infos;
    }
}
