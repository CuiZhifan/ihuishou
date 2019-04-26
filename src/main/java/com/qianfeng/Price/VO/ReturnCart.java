package com.qianfeng.Price.VO;

import com.qianfeng.commons.constant.URL;

public class ReturnCart {
    private String rowid;
    private String remove_url;
    private String img;
    private String name;
    private String base_url;
    private int price;

    @Override
    public String toString() {
        return "ReturnCart{" +
                "rowid='" + rowid + '\'' +
                ", remove_url='" + remove_url + '\'' +
                ", img='" + img + '\'' +
                ", name='" + name + '\'' +
                ", price='" + price + '\'' +
                ", base_url='" + base_url + '\'' +
                '}';
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getRowid() {
        return rowid;
    }

    public void setRowid(String rowid) {
        this.rowid = rowid;
        this.remove_url = URL.removeOrderURL+rowid;
        this.base_url = URL.baseURL;
    }

    public String getRemove_url() {
        return remove_url;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = URL.picURL+img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBase_url() {
        return base_url;
    }

//    public void setBase_url(String base_url) {
//    }
//    public void setRemove_url(String remove_url) {
//    }
}
