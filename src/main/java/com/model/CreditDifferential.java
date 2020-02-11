package com.model;

public class CreditDifferential extends Credit {
    public CreditDifferential(int id, int personId, double sum, double percent, int month) {
        super(id, personId, sum, percent, month);
        setKind(false);
    }

    public CreditDifferential(int id, int personId, double sum, double percent, int month, int countMonth, double resultSum) {
        super(id, personId, sum, percent, month, countMonth, resultSum);
        setKind(false);
    }

    public double creditBody(){
        return sum / month;
    }

    public double creditInMonth(){
        double pr = percent / 100 / 12;
        //System.out.println(pr * sum);
        return pr * sum + creditBody();
    }
}
