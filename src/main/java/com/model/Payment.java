package com.model;

public class Payment {
    private int id;
    private int creditId;
    private int month;
    private double payment;
    // Класс тут тип один платеж надо название класса поменять, но мне лень потом


    public Payment(int id, int creditId, int month, double payment) {
        this.id = id;
        this.creditId = creditId;
        this.month = month;
        this.payment = payment;
    }

    public int getCreditId() {
        return creditId;
    }

    public void setCreditId(int creditId) {
        this.creditId = creditId;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public void setPayment(double payment) {
        this.payment = payment;
    }

    public int getMonth() {
        return month;
    }

    public double getPayment() {
        return payment;
    }
    //Ну тут понятно

    @Override
    public String toString() {
        return "PaymentSchedule{" +
                "month=" + month +
                ", payment=" + payment +
                '}';
    }
}
