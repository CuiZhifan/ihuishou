package com.qianfeng.index.VO;

public class GetDate {
    private int gid;
    private int package_id;
    private String property_ids;
    private String desc_ids;
    private String pj_ids;

    @Override
    public String toString() {
        return "GetDate{" +
                "gid=" + gid +
                ", package_id=" + package_id +
                ", property_ids='" + property_ids + '\'' +
                ", desc_ids='" + desc_ids + '\'' +
                ", pj_ids='" + pj_ids + '\'' +
                '}';
    }

    public int getGid() {
        return gid;
    }

    public void setGid(int gid) {
        this.gid = gid;
    }

    public int getPackage_id() {
        return package_id;
    }

    public void setPackage_id(int package_id) {
        this.package_id = package_id;
    }

    public String getProperty_ids() {
        return property_ids;
    }

    public void setProperty_ids(String property_ids) {
        this.property_ids = property_ids;
    }

    public String getDesc_ids() {
        return desc_ids;
    }

    public void setDesc_ids(String desc_ids) {
        this.desc_ids = desc_ids;
    }

    public String getPj_ids() {
        return pj_ids;
    }

    public void setPj_ids(String pj_ids) {
        this.pj_ids = pj_ids;
    }
}
