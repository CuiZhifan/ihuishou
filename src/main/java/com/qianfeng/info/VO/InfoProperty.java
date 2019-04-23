package com.qianfeng.info.VO;

import java.util.List;

public class InfoProperty {
    private String infoName;
    private String infoText;
    private int discountValue;

    @Override
    public String toString() {
        return "InfoProperty{" +
                "infoName='" + infoName + '\'' +
                ", infoText='" + infoText + '\'' +
                ", discountValue=" + discountValue +
                '}';
    }

    public String getInfoName() {
        return infoName;
    }

    public void setInfoName(String infoName) {
        this.infoName = infoName;
    }

    public String getInfoText() {
        return infoText;
    }

    public void setInfoText(String infoText) {
        this.infoText = infoText;
    }

    public int getDiscountValue() {
        return discountValue;
    }

    public void setDiscountValue(int discountValue) {
        this.discountValue = discountValue;
    }
}
