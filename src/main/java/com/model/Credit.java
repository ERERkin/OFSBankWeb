package com.model;

import java.util.ArrayList;

public abstract class Credit {
    protected int id;
    protected int personId;
    protected double sum;
    protected double percent;
    protected int month;
    protected int countMonth = 0;
    protected double resultSum;
    private boolean kind;
    protected ArrayList<Payment> payments = new ArrayList<>();
    //Помните у нас был заемщик так вот он превратиолся в кредит а еще тут появился график платежей

    public Credit(int id, int personId, double sum, double percent, int month) {
        this.id = id;
        this.personId = personId;
        this.sum = sum;
        this.percent = percent;
        this.month = month;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCountMonth() {
        return countMonth;
    }

    public void setCountMonth(int countMonth) {
        this.countMonth = countMonth;
    }

    public boolean isKind() {
        return kind;
    }

    public void setKind(boolean kind) {
        this.kind = kind;
    }

    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }

    //Ну тут ничего не изменилось

    public double getResultSum() {
        return resultSum;
    }

    public void setResultSum(double resultSum) {
        this.resultSum = resultSum;
    }

    public double getSum() {
        return sum;
    }

    public void setSum(double sum) {
        this.sum = sum;
    }

    public double getPercent() {
        return percent;
    }

    public void setPercent(double percent) {
        this.percent = percent;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public double notAn(){
        return 0;
    }

    public void monthMinus(){
        payments.add(new Payment(id, ++countMonth, creditInMonth()));
        resultSum += creditInMonth();
        sum = sum - creditBody();
        month--;
    }
    //Тут еще происходит добавление в график платежей

    public abstract double creditBody();

    public abstract double creditInMonth();

    @Override
    public String toString() {
        return "Credit{" +
                "sum=" + sum +
                ", percent=" + percent +
                '}';
    }
}
