package ru.cultserv.adv.yandex.direct.v5.models;

/**
 * User: Iggi
 * Date: 17/08/2017
 * Time: 16:54
 */

public class Unit {
    private String login;
    private int cost;
    private int balance;
    private int dailyLimit;

    public Unit() {
    }

    public Unit(final String login, final int cost, final int balance, final int dailyLimit) {
        this.login = login;
        this.cost = cost;
        this.balance = balance;
        this.dailyLimit = dailyLimit;
    }

    public int getCost() {
        return cost;
    }

    public int getBalance() {
        return balance;
    }

    public int getDailyLimit() {
        return dailyLimit;
    }

    public Unit setCost(final int cost) {
        this.cost = cost;
        return this;
    }

    public Unit setBalance(final int balance) {
        this.balance = balance;
        return this;
    }

    public Unit setDailyLimit(final int dailyLimit) {
        this.dailyLimit = dailyLimit;
        return this;
    }

    public String getLogin() {
        return login;
    }

    public Unit setLogin(final String login) {
        this.login = login;
        return this;
    }

    @Override
    public String toString() {
        return "Unit{" +
                "login=" + login +
                ", cost=" + cost +
                ", balance=" + balance +
                ", dailyLimit=" + dailyLimit +
                '}';
    }
}
