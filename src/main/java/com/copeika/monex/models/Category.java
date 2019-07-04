package com.copeika.monex.models;

public class Category {
    private String id;
    private  String name;
    private Integer limit;
    private Integer money_expenditures;

    public Category(String name, Integer limit, Integer money_expenditures){
        this.name = name;
        this.limit = limit;
        this.money_expenditures = money_expenditures;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getMoney_expenditures() {
        return money_expenditures;
    }

    public void setMoney_expenditures(Integer money_expenditures) {
        this.money_expenditures = money_expenditures;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
