package com.qianfeng.User.DTO;

public class FrozenMoney {
    private int frozenMoney;
    private int frozenMoneyOTN;

    @Override
    public String toString() {
        return "FrozenMoney{" +
                "frozenMoney=" + frozenMoney +
                ", frozenMoneyOTN=" + frozenMoneyOTN +
                '}';
    }

    public int getFrozenMoney() {
        return frozenMoney;
    }

    public void setFrozenMoney(int frozenMoney) {
        this.frozenMoney = frozenMoney;
    }

    public int getFrozenMoneyOTN() {
        return frozenMoneyOTN;
    }

    public void setFrozenMoneyOTN(int frozenMoneyOTN) {
        this.frozenMoneyOTN = frozenMoneyOTN;
    }
}
