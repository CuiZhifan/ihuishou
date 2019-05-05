package com.qianfeng.User.DTO;

public class LoginResult {
    private int userId;
    private String userName;
    private String msg;

    @Override
    public String toString() {
        return "LoginResult{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", msg=" + msg +
                '}';
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getUserId() {
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
}
