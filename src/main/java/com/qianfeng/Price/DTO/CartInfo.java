package com.qianfeng.Price.DTO;

import java.sql.Date;
import java.sql.Timestamp;

public class CartInfo {
    private String orderId;
    private int userId;
    private int orderPrice;
    private String orderEstimates;
    private int orderStatus;
    private Timestamp orderCreateTime;
    private int orderPhoneType;

    @Override
    public String toString() {
        return "CartInfo{" +
                "orderId='" + orderId + '\'' +
                ", userId=" + userId +
                ", orderPrice=" + orderPrice +
                ", orderEstimates='" + orderEstimates + '\'' +
                ", orderStatus=" + orderStatus +
                ", orderCreateTime=" + orderCreateTime +
                ", orderPhoneType=" + orderPhoneType +
                '}';
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(int orderPrice) {
        this.orderPrice = orderPrice;
    }

    public String getOrderEstimates() {
        return orderEstimates;
    }

    public void setOrderEstimates(String orderEstimates) {
        this.orderEstimates = orderEstimates;
    }

    public int getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(int orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Timestamp getOrderCreateTime() {
        return orderCreateTime;
    }

    public void setOrderCreateTime(Timestamp orderCreateTime) {
        this.orderCreateTime = orderCreateTime;
    }

    public int getOrderPhoneType() {
        return orderPhoneType;
    }

    public void setOrderPhoneType(int orderPhoneType) {
        this.orderPhoneType = orderPhoneType;
    }
}
