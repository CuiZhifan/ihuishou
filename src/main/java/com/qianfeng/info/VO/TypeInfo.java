package com.qianfeng.info.VO;

public class TypeInfo {
    private int typeId;
    private int brandId;
    private String brandName;
    private String typeName;
    private String typePic;
    private int typeMoney;

    public int getBrandId() {
        return brandId;
    }

    public void setBrandId(int brandId) {
        this.brandId = brandId;
    }

    @Override
    public String toString() {
        return "TypeInfo{" +
                "typeId=" + typeId +
                ", brandName='" + brandName + '\'' +
                ", brandId='" + brandId + '\'' +
                ", typeName='" + typeName + '\'' +
                ", typePic='" + typePic + '\'' +
                ", typeMoney=" + typeMoney +
                '}';
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brand_name) {
        this.brandName = brand_name;
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

    public String getTypePic() {
        return typePic;
    }

    public void setTypePic(String typePic) {
        this.typePic = typePic;
    }

    public int getTypeMoney() {
        return typeMoney;
    }

    public void setTypeMoney(int typePrice) {
        this.typeMoney = typePrice;
    }
}
