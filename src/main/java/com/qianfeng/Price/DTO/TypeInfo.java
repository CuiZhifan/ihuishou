package com.qianfeng.Price.DTO;

public class TypeInfo {
    private String name;
    private String pic;

    @Override
    public String toString() {
        return "TypeInfo{" +
                "name='" + name + '\'' +
                ", pic='" + pic + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }
}
