package com.qianfeng.order.PO;


import com.qianfeng.order.DTO.ReceiveOrder;

import java.sql.Timestamp;

public class TbOrder {

  private String orderId;
  private Long userId;
  private Long orderPrice;
  private String orderUserName;
  private String orderUserTel;
  private String orderAd;
  private String orderAdInfo;
  private String orderModel;
  private String orderInfo;
  private String takeTime1;
  private String takeTime2;
  private String orderEstimates;
  private String postCompany;
  private String postCode;
  private Long orderStatus;
  private java.sql.Timestamp orderCreateTime;
  private Long orderPhoneType;
  private String orderInfo1;
  private String orderInfo2;
  private String orderInfo3;

  public TbOrder() {
  }

  public TbOrder(String orderId, Long userId, Long orderPrice, String orderUserName, String orderUserTel, String orderAd, String orderAdInfo, String orderModel, String orderInfo, String takeTime1, String takeTime2, String orderEstimates, String postCompany, String postCode, Long orderStatus, Timestamp orderCreateTime, Long orderPhoneType, String orderInfo1, String orderInfo2, String orderInfo3) {
    this.orderId = orderId;
    this.userId = userId;
    this.orderPrice = orderPrice;
    this.orderUserName = orderUserName;
    this.orderUserTel = orderUserTel;
    this.orderAd = orderAd;
    this.orderAdInfo = orderAdInfo;
    this.orderModel = orderModel;
    this.orderInfo = orderInfo;
    this.takeTime1 = takeTime1;
    this.takeTime2 = takeTime2;
    this.orderEstimates = orderEstimates;
    this.postCompany = postCompany;
    this.postCode = postCode;
    this.orderStatus = orderStatus;
    this.orderCreateTime = orderCreateTime;
    this.orderPhoneType = orderPhoneType;
    this.orderInfo1 = orderInfo1;
    this.orderInfo2 = orderInfo2;
    this.orderInfo3 = orderInfo3;
  }

  public TbOrder(ReceiveOrder order) {
    this.orderId = orderId;
    this.userId = userId;
    this.orderPrice = orderPrice;
    this.orderUserName = order.getLink_name();
    this.orderUserTel = order.getMobile();
    this.orderAd = order.getProvince()+"-"+order.getCity()+"-"+order.getDistrict();
    this.orderAdInfo = order.getAddress();
    this.orderModel = order.getIfalipay();
    String sb;
    if ("n".equals(order.getIfalipay())){
      sb = order.getBankname()+"-"+order.getRealname()+"-"+order.getCard_sn();
    }else if ("y".equals(order.getIfalipay())){
      sb = order.getAlipay_realname()+"-"+order.getAlipay_username();
    }else {
      sb = String.valueOf(order.getMianjiao_method());
    }
    this.orderInfo = sb;
    this.takeTime1 = order.getStime();
    this.takeTime2 = order.getEtime();
    this.orderEstimates = orderEstimates;
    this.postCompany = postCompany;
    this.postCode = postCode;
    this.orderStatus = 1L;
    this.orderCreateTime = orderCreateTime;
    this.orderPhoneType = orderPhoneType;
    this.orderInfo1 = orderInfo1;
    this.orderInfo2 = orderInfo2;
    this.orderInfo3 = orderInfo3;
  }

  @Override
  public String toString() {
    return "TbOrder{" +
            "orderId='" + orderId + '\'' +
            ", userId=" + userId +
            ", orderPrice=" + orderPrice +
            ", orderUserName='" + orderUserName + '\'' +
            ", orderUserTel='" + orderUserTel + '\'' +
            ", orderAd='" + orderAd + '\'' +
            ", orderAdInfo='" + orderAdInfo + '\'' +
            ", orderModel='" + orderModel + '\'' +
            ", orderInfo='" + orderInfo + '\'' +
            ", takeTime1='" + takeTime1 + '\'' +
            ", takeTime2='" + takeTime2 + '\'' +
            ", orderEstimates='" + orderEstimates + '\'' +
            ", postCompany='" + postCompany + '\'' +
            ", postCode='" + postCode + '\'' +
            ", orderStatus=" + orderStatus +
            ", orderCreateTime=" + orderCreateTime +
            ", orderPhoneType=" + orderPhoneType +
            ", orderInfo1='" + orderInfo1 + '\'' +
            ", orderInfo2='" + orderInfo2 + '\'' +
            ", orderInfo3='" + orderInfo3 + '\'' +
            '}';
  }

  public String getOrderId() {
    return orderId;
  }

  public void setOrderId(String orderId) {
    this.orderId = orderId;
  }


  public Long getUserId() {
    return userId;
  }

  public void setUserId(Long userId) {
    this.userId = userId;
  }


  public Long getOrderPrice() {
    return orderPrice;
  }

  public void setOrderPrice(Long orderPrice) {
    this.orderPrice = orderPrice;
  }


  public String getOrderUserName() {
    return orderUserName;
  }

  public void setOrderUserName(String orderUserName) {
    this.orderUserName = orderUserName;
  }


  public String getOrderUserTel() {
    return orderUserTel;
  }

  public void setOrderUserTel(String orderUserTel) {
    this.orderUserTel = orderUserTel;
  }


  public String getOrderAd() {
    return orderAd;
  }

  public void setOrderAd(String orderAd) {
    this.orderAd = orderAd;
  }


  public String getOrderAdInfo() {
    return orderAdInfo;
  }

  public void setOrderAdInfo(String orderAdInfo) {
    this.orderAdInfo = orderAdInfo;
  }


  public String getOrderModel() {
    return orderModel;
  }

  public void setOrderModel(String orderModel) {
    this.orderModel = orderModel;
  }


  public String getOrderInfo() {
    return orderInfo;
  }

  public void setOrderInfo(String orderInfo) {
    this.orderInfo = orderInfo;
  }


  public String getTakeTime1() {
    return takeTime1;
  }

  public void setTakeTime1(String takeTime1) {
    this.takeTime1 = takeTime1;
  }


  public String getTakeTime2() {
    return takeTime2;
  }

  public void setTakeTime2(String takeTime2) {
    this.takeTime2 = takeTime2;
  }


  public String getOrderEstimates() {
    return orderEstimates;
  }

  public void setOrderEstimates(String orderEstimates) {
    this.orderEstimates = orderEstimates;
  }


  public String getPostCompany() {
    return postCompany;
  }

  public void setPostCompany(String postCompany) {
    this.postCompany = postCompany;
  }


  public String getPostCode() {
    return postCode;
  }

  public void setPostCode(String postCode) {
    this.postCode = postCode;
  }


  public Long getOrderStatus() {
    return orderStatus;
  }

  public void setOrderStatus(Long orderStatus) {
    this.orderStatus = orderStatus;
  }


  public java.sql.Timestamp getOrderCreateTime() {
    return orderCreateTime;
  }

  public void setOrderCreateTime(java.sql.Timestamp orderCreateTime) {
    this.orderCreateTime = orderCreateTime;
  }


  public Long getOrderPhoneType() {
    return orderPhoneType;
  }

  public void setOrderPhoneType(Long orderPhoneType) {
    this.orderPhoneType = orderPhoneType;
  }


  public String getOrderInfo1() {
    return orderInfo1;
  }

  public void setOrderInfo1(String orderInfo1) {
    this.orderInfo1 = orderInfo1;
  }


  public String getOrderInfo2() {
    return orderInfo2;
  }

  public void setOrderInfo2(String orderInfo2) {
    this.orderInfo2 = orderInfo2;
  }


  public String getOrderInfo3() {
    return orderInfo3;
  }

  public void setOrderInfo3(String orderInfo3) {
    this.orderInfo3 = orderInfo3;
  }

}
