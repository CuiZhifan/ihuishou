package com.qianfeng.info.VO;

import java.util.List;

public class InfoProperty {
    private int infoId;
    private String infoName;
    private String infoText;
    private String discountValue;

    @Override
    public String toString() {
        return "InfoProperty{" +
                "infoId='" + infoId + '\'' +
                "infoName='" + infoName + '\'' +
                ", infoText='" + infoText + '\'' +
                ", discountValue=" + discountValue +
                '}';
    }

    public int getInfoId() {
        return infoId;
    }

    public void setInfoId(int infoId) {
        this.infoId = infoId;
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

    public String getDiscountValue() {
        return discountValue;
    }

    public void setDiscountValue(String discountValue) {
        this.discountValue = discountValue;
    }
}
