package com.copeika.monex.models;

public class Budget {
    private Integer money;

    public Budget() {

    }

    public Budget(Integer money){
        this.money = money;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }
}
