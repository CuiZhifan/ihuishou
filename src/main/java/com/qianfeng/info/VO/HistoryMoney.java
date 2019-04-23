package com.qianfeng.info.VO;

import java.sql.Date;

public class HistoryMoney {
    private int money;
    private java.sql.Date date;

    @Override
    public String toString() {
        return "HistoryMoney{" +
                "money=" + money +
                ", date=" + date +
                '}';
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
