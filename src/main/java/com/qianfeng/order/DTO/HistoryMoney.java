package com.qianfeng.order.DTO;

import java.sql.Timestamp;

public class HistoryMoney {
    private long typeId;
    private long historyMoney;
    private java.sql.Timestamp historyTime;

    public long getTypeId() {
        return typeId;
    }

    public void setTypeId(long typeId) {
        this.typeId = typeId;
    }

    public long getHistoryMoney() {
        return historyMoney;
    }

    public void setHistoryMoney(long historyMoney) {
        this.historyMoney = historyMoney;
    }

    public Timestamp getHistoryTime() {
        return historyTime;
    }

    public void setHistoryTime(Timestamp historyTime) {
        this.historyTime = historyTime;
    }
}
