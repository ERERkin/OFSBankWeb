package com.model;

import com.DB.DB;

public class StateTreasuryBill {
    //Это класс Гос. Каз. Вексель
    private int id;
    private int personId;
    private int month;
    private double firstSum;
    //Имеет коллчиество месяцев до окончания и сумма за которую ее продал банк

    public StateTreasuryBill(int id, int personId, int month, double firstSum) {
        this.id = id;
        this.personId = personId;
        this.month = month;
        this.firstSum = firstSum;
    }

    //Конструктор, ну вы поняли

    public double stateTreasuryBillInNextMonth(){
        month--;
        DB.updateSTB(id, month);
        if(month == 0){
            return 100;
        }
        return 0;
    }
    //Переход на след месяц, если время не настало возвращает ноль, в противном случае 100 сом(ну тут тип стандарт нашего
    //государства

    //Геттеры сеттеры пока не нужны

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public double getFirstSum() {
        return firstSum;
    }

    public void setFirstSum(double firstSum) {
        this.firstSum = firstSum;
    }

    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
