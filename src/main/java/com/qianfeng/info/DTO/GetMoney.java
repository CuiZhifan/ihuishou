package com.qianfeng.info.DTO;

public class GetMoney {
    private String discount;
    private String infoName;

    @Override
    public String toString() {
        return infoName+"-"+discount;
    }

    public String getInfoName() {
        return infoName;
    }

    public void setInfoName(String infoName) {
        this.infoName = infoName;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }
}
