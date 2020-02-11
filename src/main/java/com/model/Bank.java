package com.model;

import com.DB.DB;

import java.util.ArrayList;

public class Bank {
    private int id;
    private ArrayList<Person> people = new ArrayList<>();
    //private ArrayList<StateTreasuryBill> stateTreasuryBills = new ArrayList<>();
    private double budget = 0;
    // Класс банк есть бюджет и список клиентов

    public Bank(double budget) {
        this.budget = budget;
    }

    public Bank(int id, double budget) {
        this.id = id;
        this.budget = budget;
    }

    public double getBudget() {
        return budget;
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }

    public void nextMonth(){
        ArrayList<Person> people = DB.clientList(id);
        for(int i = 0; i < people.size(); i++){
            budget += people.get(i).profitMonth();
        }
        DB.updateBank(id, budget);
    }
    //Ну тип он запускает profitMonth() у каждого клиента и смотрит на сколько банк развел этих лохов гыыы

    public ArrayList<Person> getPeople() {
        return people;
    }
    // Возвращает клиентов банка

    public void addBorrower(int id, int bankId, String name, String address, int age, String gender){
        people.add(new Person(id, bankId, name, address, age, gender));
        DB.addClient(new Person(id, bankId, name, address, age, gender));
    }
    // Добавляет нового клиента в список

    public void addCredit(int id, int personId, double sum, double percent, int month, double resultSum, boolean kind){
        Person.addCredit(id, personId, sum, percent, month, resultSum, kind);/*
        for(int i = 0; i < people.size(); i++){
            if(personId == people.get(i).getId()){
                people.get(i).addCredit(id, personId, sum, percent, month, resultSum, kind);
                break;
            }
        }*/
    }
    // Добавляет кредит к человеку по id

    public void addStateTreasuryBill(int month, double firstSum, int id){
        budget += firstSum;
        Person.addStateTreasuryBill(id, month, firstSum);
        DB.updateBank(id, budget);
    }
    // Добавляет облигацию к человеку по id

    /*public int creditorsCount(){
        return credits.size();
    }*/
}
