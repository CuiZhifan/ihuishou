package com.qianfeng.order.DTO;

public class ReceiveOrder {
    private String ifalipay;//支付方式 n/y/s
    private String ifbaoxian;//是否保险
    private Integer userId;//用户ID
    private String baoxian_name;//真实姓名（保险）
    private String baoxian_card_id;//身份证
    private String link_name;//联系人
    private String mobile;//电话
    private String province;//省
    private String city;//市
    private String district;//县
    private String address;//详细地址
    private String stime;//开始时间
    private String etime;//结束时间
    private String bankname;//银行名称
    private String realname;//真实姓名（银行）
    private String card_sn;//银行卡号
    private String lock;//上锁情况 y/n
    private String pwd;//解锁密码
    private String alipay_realname;//支付宝真实姓名
    private String alipay_username;//支付宝账号
    private Integer mianjiao_method;//面交模式

    @Override
    public String toString() {
        return "ReceiveOrder{" +
                "ifalipay='" + ifalipay + '\'' +
                ", ifbaoxian='" + ifbaoxian + '\'' +
                ", userId=" + userId +
                ", baoxian_name='" + baoxian_name + '\'' +
                ", baoxian_card_id='" + baoxian_card_id + '\'' +
                ", link_name='" + link_name + '\'' +
                ", mobile='" + mobile + '\'' +
                ", province='" + province + '\'' +
                ", city='" + city + '\'' +
                ", district='" + district + '\'' +
                ", address='" + address + '\'' +
                ", stime='" + stime + '\'' +
                ", etime='" + etime + '\'' +
                ", bankname='" + bankname + '\'' +
                ", realname='" + realname + '\'' +
                ", card_sn='" + card_sn + '\'' +
                ", lock='" + lock + '\'' +
                ", pwd='" + pwd + '\'' +
                ", alipay_realname='" + alipay_realname + '\'' +
                ", alipay_username='" + alipay_username + '\'' +
                ", mianjiao_method=" + mianjiao_method +
                '}';
    }

    public String getIfalipay() {
        return ifalipay;
    }

    public void setIfalipay(String ifalipay) {
        this.ifalipay = ifalipay;
    }

    public String getIfbaoxian() {
        return ifbaoxian;
    }

    public void setIfbaoxian(String ifbaoxian) {
        this.ifbaoxian = ifbaoxian;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getBaoxian_name() {
        return baoxian_name;
    }

    public void setBaoxian_name(String baoxian_name) {
        this.baoxian_name = baoxian_name;
    }

    public String getBaoxian_card_id() {
        return baoxian_card_id;
    }

    public void setBaoxian_card_id(String baoxian_card_id) {
        this.baoxian_card_id = baoxian_card_id;
    }

    public String getLink_name() {
        return link_name;
    }

    public void setLink_name(String link_name) {
        this.link_name = link_name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getStime() {
        return stime;
    }

    public void setStime(String stime) {
        this.stime = stime;
    }

    public String getEtime() {
        return etime;
    }

    public void setEtime(String etime) {
        this.etime = etime;
    }

    public String getBankname() {
        return bankname;
    }

    public void setBankname(String bankname) {
        this.bankname = bankname;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public String getCard_sn() {
        return card_sn;
    }

    public void setCard_sn(String card_sn) {
        this.card_sn = card_sn;
    }

    public String getLock() {
        return lock;
    }

    public void setLock(String lock) {
        this.lock = lock;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getAlipay_realname() {
        return alipay_realname;
    }

    public void setAlipay_realname(String alipay_realname) {
        this.alipay_realname = alipay_realname;
    }

    public String getAlipay_username() {
        return alipay_username;
    }

    public void setAlipay_username(String alipay_username) {
        this.alipay_username = alipay_username;
    }

    public Integer getMianjiao_method() {
        return mianjiao_method;
    }

    public void setMianjiao_method(Integer mianjiao_method) {
        this.mianjiao_method = mianjiao_method;
    }
}
