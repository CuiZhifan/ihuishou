package com.qianfeng.Price.VO;

public class PriceCart {
    private int gid;
    private int typeid;
    private String act;
    private String key;

    @Override
    public String toString() {
        return "PriceCart{" +
                "gid=" + gid +
                ", typeid=" + typeid +
                ", act='" + act + '\'' +
                ", key='" + key + '\'' +
                '}';
    }

    public int getGid() {
        return gid;
    }

    public void setGid(int gid) {
        this.gid = gid;
    }

    public int getTypeid() {
        return typeid;
    }

    public void setTypeid(int typeid) {
        this.typeid = typeid;
    }

    public String getAct() {
        return act;
    }

    public void setAct(String act) {
        this.act = act;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
