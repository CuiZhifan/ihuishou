package com.qianfeng.order.PO;

public class TbChit {
    private int userId;
    private String baoxian_name;
    private String baoxian_card_id;

    @Override
    public String toString() {
        return "TbChit{" +
                "userId=" + userId +
                ", baoxian_name='" + baoxian_name + '\'' +
                ", baoxian_card_id='" + baoxian_card_id + '\'' +
                '}';
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getBaoxian_name() {
        return baoxian_name;
    }

    public void setBaoxian_name(String baoxian_name) {
        this.baoxian_name = baoxian_name;
    }

    public String getBaoxian_card_id() {
        return baoxian_card_id;
    }

    public void setBaoxian_card_id(String baoxian_card_id) {
        this.baoxian_card_id = baoxian_card_id;
    }
}
