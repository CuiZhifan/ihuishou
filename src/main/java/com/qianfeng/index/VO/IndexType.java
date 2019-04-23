package com.qianfeng.index.VO;

public class IndexType {
    private int typeId;
    private String typeName;
    private String typePic;

    @Override
    public String toString() {
        return "IndexType{" +
                "typeId=" + typeId +
                ", typeName='" + typeName + '\'' +
                ", typePic='" + typePic + '\'' +
                '}';
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
}
