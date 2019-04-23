package com.qianfeng.index.VO;

public class IndexCQuery {
    private String cname;
    private String cinfo;
    private String discount;

    @Override
    public String toString() {
        return "IndexCQuery{" +
                "cname='" + cname + '\'' +
                ", cinfo='" + cinfo + '\'' +
                ", discount='" + discount + '\'' +
                '}';
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getCinfo() {
        return cinfo;
    }

    public void setCinfo(String cinfo) {
        this.cinfo = cinfo;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }
}
