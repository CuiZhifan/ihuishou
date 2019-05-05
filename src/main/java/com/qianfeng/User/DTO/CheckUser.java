package com.qianfeng.User.DTO;

public class CheckUser {
    private int userId;

    @Override
    public String toString() {
        return "CheckUser{" +
                "userId=" + userId +
                '}';
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
