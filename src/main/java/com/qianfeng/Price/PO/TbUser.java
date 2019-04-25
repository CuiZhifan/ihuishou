package com.qianfeng.Price.PO;


public class TbUser {

  private int userId;
  private String userName;
  private String userPwd;
  private long userBalance;
  private long userFrozen;
  private long userFrozenOtn;
  private String userEmail;
  private java.sql.Timestamp joinTime;
  private long userLevel;
  private long userIncome;
  private String userPhone;
  private String userInfo1;
  private String userInfo2;
  private String userInfo3;

  @Override
  public String toString() {
    return "TbUser{" +
            "userId=" + userId +
            ", userName='" + userName + '\'' +
            ", userPwd='" + userPwd + '\'' +
            ", userBalance=" + userBalance +
            ", userFrozen=" + userFrozen +
            ", userFrozenOtn=" + userFrozenOtn +
            ", userEmail='" + userEmail + '\'' +
            ", joinTime=" + joinTime +
            ", userLevel=" + userLevel +
            ", userIncome=" + userIncome +
            ", userPhone='" + userPhone + '\'' +
            ", userInfo1='" + userInfo1 + '\'' +
            ", userInfo2='" + userInfo2 + '\'' +
            ", userInfo3='" + userInfo3 + '\'' +
            '}';
  }

  public long getUserId() {
    return userId;
  }

  public void setUserId(int userId) {
    this.userId = userId;
  }


  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }


  public String getUserPwd() {
    return userPwd;
  }

  public void setUserPwd(String userPwd) {
    this.userPwd = userPwd;
  }


  public long getUserBalance() {
    return userBalance;
  }

  public void setUserBalance(long userBalance) {
    this.userBalance = userBalance;
  }


  public long getUserFrozen() {
    return userFrozen;
  }

  public void setUserFrozen(long userFrozen) {
    this.userFrozen = userFrozen;
  }


  public long getUserFrozenOtn() {
    return userFrozenOtn;
  }

  public void setUserFrozenOtn(long userFrozenOtn) {
    this.userFrozenOtn = userFrozenOtn;
  }


  public String getUserEmail() {
    return userEmail;
  }

  public void setUserEmail(String userEmail) {
    this.userEmail = userEmail;
  }


  public java.sql.Timestamp getJoinTime() {
    return joinTime;
  }

  public void setJoinTime(java.sql.Timestamp joinTime) {
    this.joinTime = joinTime;
  }


  public long getUserLevel() {
    return userLevel;
  }

  public void setUserLevel(long userLevel) {
    this.userLevel = userLevel;
  }


  public long getUserIncome() {
    return userIncome;
  }

  public void setUserIncome(long userIncome) {
    this.userIncome = userIncome;
  }


  public String getUserPhone() {
    return userPhone;
  }

  public void setUserPhone(String userPhone) {
    this.userPhone = userPhone;
  }


  public String getUserInfo1() {
    return userInfo1;
  }

  public void setUserInfo1(String userInfo1) {
    this.userInfo1 = userInfo1;
  }


  public String getUserInfo2() {
    return userInfo2;
  }

  public void setUserInfo2(String userInfo2) {
    this.userInfo2 = userInfo2;
  }


  public String getUserInfo3() {
    return userInfo3;
  }

  public void setUserInfo3(String userInfo3) {
    this.userInfo3 = userInfo3;
  }

}
