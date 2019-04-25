package com.qianfeng.Price.DTO;

public class QueryChart {
    private Integer cart_total_items;
    private Integer cart_total;

    @Override
    public String toString() {
        return "queryChart{" +
                "count=" + cart_total_items +
                ", sum=" + cart_total +
                '}';
    }

    public Integer getCart_total_items() {
        return cart_total_items;
    }

    public void setCart_total_items(Integer count) {
        this.cart_total_items = count;
    }

    public Integer getCart_total() {
        return cart_total;
    }

    public void setCart_total(Integer sum) {
        this.cart_total = sum;
    }
}
