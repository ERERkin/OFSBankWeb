package com.model;

import java.util.ArrayList;

public class Person {
    private int id;
    private int bankId;
    private String name;
    private String address;
    private int age;
    private String gender;
    private ArrayList<Credit> activeCredits = new ArrayList<>();
    private ArrayList<Credit> passiveCredits = new ArrayList<>();
    private ArrayList<StateTreasuryBill> stateTreasuryBills = new ArrayList<>();
    //Ну нахуй все объяснять сами поймете

    public Person(int id, int bankId, String name, String address, int age, String gender) {
        this.id = id;
        this.bankId = bankId;
        this.name = name;
        this.address = address;
        this.age = age;
        this.gender = gender;
    }


    // Тут тоже


    public int getBankId() {
        return bankId;
    }

    public void setBankId(int bankId) {
        this.bankId = bankId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public ArrayList<Credit> getActiveCredits() {
        return activeCredits;
    }

    public ArrayList<Credit> getPassiveCredits() {
        return passiveCredits;
    }

    public void addCredit(int id, int personId, double sum, double percent, int month, double resultSum, boolean kind){
        if(kind){
            activeCredits.add(new CreditAnnuity(id,personId,sum,percent,month));
        }else {
            activeCredits.add(new CreditDifferential(id,personId,sum, percent, month));
        }
    }
    // Добавление кредита в список кредитов

    public void addStateTreasuryBill(int personId,int month, int firstSum){
        stateTreasuryBills.add(new StateTreasuryBill(personId, month, firstSum));
    }
    // Добавление векселя в список векселей

    public double profitMonth(){
        double answer = 0.0;
        for(int i = 0; i < activeCredits.size(); i++){
            answer += Math.round(activeCredits.get(i).creditInMonth());
            activeCredits.get(i).monthMinus();
            if(activeCredits.get(i).month == 0){
                passiveCredits.add(activeCredits.get(i));
                activeCredits.remove(i);
                i--;
            }
        }
        for(int i = 0; i < stateTreasuryBills.size(); i++){
            double k = stateTreasuryBills.get(i).stateTreasuryBillInNextMonth();
            answer -= k;
            if(Math.round(k) == 0){
                stateTreasuryBills.remove(i);
                i--;
            }
        }
        return answer;
    }
    //Пизда тут а если проще алгоритм

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
