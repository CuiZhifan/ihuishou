package com.qianfeng.Price.VO;

import com.qianfeng.commons.constant.URL;

public class PriceTypeInfo {
    private String typePic;
    private int typeId;
    private String typeName;
    private int discount;
    private String infos;
    private String key;

    @Override
    public String toString() {
        return "PriceTypeInfo{" +
                "typePic='" + typePic + '\'' +
                ", typeId=" + typeId +
                ", typeName='" + typeName + '\'' +
                ", discount=" + discount +
                ", infos='" + infos + '\'' +
                ", key='" + key + '\'' +
                '}';
    }

    public String getTypePic() {
        return typePic;
    }

    public void setTypePic(String typePic) {
        this.typePic = URL.picURL+typePic;
    }

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public String getInfos() {
        return infos;
    }

    public void setInfos(String infos) {
        this.infos = infos;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }


}
