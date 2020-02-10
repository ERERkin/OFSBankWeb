package com.model;

public class CreditAnnuity extends Credit {
    public CreditAnnuity(int id, int personId, double sum, double percent, int month) {
        super(id, personId, sum, percent, month);
        setKind(true);
    }

    public double creditBody(){
        return creditInMonth() - sum * percent / 100 / 12;
    }

    public double creditInMonth(){
        double ans;
        double pr = percent / 100 / 12;
        ans = pr + pr/( Math.pow((1 + pr),month) - 1);
        return ans * sum;
    }
}
