package com.lingzhix;

/**
 * @author zqiang
 * @version 1.0
 * @date 2022/3/4 23:19
 */
public class Account {
    private String id;
    private String name;
    private String password;
    private double hadMoney;
    private double onceMoney;

    public Account() {
    }

    public Account(String id, String name, String password, double hadMoney, double onceMoney) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.hadMoney = hadMoney;
        this.onceMoney = onceMoney;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getHadMoney() {
        return hadMoney;
    }

    public void setHadMoney(double hadMoney) {
        this.hadMoney += hadMoney;
    }

    public double getOnceMoney() {
        return onceMoney;
    }

    public void setOnceMoney(double onceMoney) {
        this.onceMoney = onceMoney;
    }
}
