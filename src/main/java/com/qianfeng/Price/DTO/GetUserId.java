package com.qianfeng.Price.DTO;

public class GetUserId {
    private int userId;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "GetUserId{" +
                "userId=" + userId +
                '}';
    }
}
