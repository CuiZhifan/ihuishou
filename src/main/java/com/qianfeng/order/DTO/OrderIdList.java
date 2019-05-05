package com.qianfeng.order.DTO;

public class OrderIdList {
    private String OrderId;

    @Override
    public String toString() {
        return "OrderIdList{" +
                "OrderId='" + OrderId + '\'' +
                '}';
    }

    public String getOrderId() {
        return OrderId;
    }

    public void setOrderId(String orderId) {
        OrderId = orderId;
    }
}
