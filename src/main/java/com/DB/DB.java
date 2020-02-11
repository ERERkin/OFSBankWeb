package com.DB;

import com.model.*;

import java.sql.*;
import java.util.ArrayList;

public class DB {
    private static final String url = "jdbc:postgresql://localhost:5432/";
    private static final String user = "postgres";
    private static final String password = "postgres";
    public static Connection connect() throws ClassNotFoundException {
        Class.forName("org.postgresql.Driver");
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to the PostgresSQL server successfully");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }
    public static boolean addBank(Bank bank){
        String SQL = "insert into bank(budget) values (?)";
        try(Connection connection = connect();
            PreparedStatement statement = connection.prepareStatement(SQL);) {
            statement.setDouble(1, bank.getBudget());
            statement.executeUpdate();
            return true;
        } catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
        return false;
    }
    public static boolean addClient(Person person){
        String SQL = "insert into people_bank(id, bank_id, name, address, age, gender) values (?,?,?,?,?,?)";
        try(Connection connection = connect();
            PreparedStatement statement = connection.prepareStatement(SQL);) {
            statement.setInt(1, person.getId());
            statement.setInt(2, person.getBankId());
            statement.setString(3, person.getName());
            statement.setString(4, person.getAddress());
            statement.setInt(5, person.getAge());
            statement.setString(6, person.getGender());
            statement.executeUpdate();
            return true;
        } catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
        return false;
    }
    public static boolean addCredit(Credit credit){
        String SQL = "insert into Credits(person_id, sum, percent, month, kind) values \n" +
                "(?,?,?,?,?);";;
        try(Connection connection = connect();
            PreparedStatement statement = connection.prepareStatement(SQL);) {
            statement.setInt(1, credit.getPersonId());
            statement.setDouble(2, credit.getSum());
            statement.setDouble(3, credit.getPercent());
            statement.setInt(4, credit.getMonth());
            statement.setBoolean(5, credit.isKind());
            statement.executeUpdate();
            return true;
        } catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
        return false;
    }
    public static boolean addPayment(Payment payment){
        String SQL = "insert into Payments(credit_id, month, payment) VALUES (?,?,?);";
        try(Connection connection = connect();
            PreparedStatement statement = connection.prepareStatement(SQL);) {
            statement.setInt(1, payment.getCreditId());
            statement.setInt(2, payment.getMonth());
            statement.setDouble(3, payment.getPayment());
            statement.executeUpdate();
            return true;
        } catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
        return false;
    }
    public static boolean addStateTreasuryBill(StateTreasuryBill stateTreasuryBill){
        String SQL = "insert into State_treasury_bills(people_id, month, firstSum) VALUES (?,?,?);";
        try(Connection connection = connect();
            PreparedStatement statement = connection.prepareStatement(SQL);) {
            statement.setInt(1, stateTreasuryBill.getPersonId());
            statement.setInt(2, stateTreasuryBill.getMonth());
            statement.setDouble(3, stateTreasuryBill.getFirstSum());
            statement.executeUpdate();
            return true;
        } catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
        return false;
    }
    public static Person findClient(int id){
        String SQL = "select * from People_bank where id = ?;";
        Person person = null;
        try(Connection connection = connect();
            PreparedStatement statement = connection.prepareStatement(SQL);) {
            statement.setInt(1, id);
            try(ResultSet rs = statement.executeQuery()) {
                rs.next();
                person = new Person(rs.getInt(1), rs.getInt(2),
                        rs.getString(3), rs.getString(4),
                        rs.getInt(5), rs.getString(6));
            }
        } catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
        return person;
    }
    public static ArrayList<Credit> creditList(int clientId, boolean creditKind){
        String SQL;
        if(creditKind) SQL = "select * from credits where month <> 0 and person_id = ?;";
        else SQL = "select * from credits where month = 0 and person_id = ?;";
        Person person = null;
        ArrayList<Credit> credits = new ArrayList<>();
        try(Connection connection = connect();
            PreparedStatement statement = connection.prepareStatement(SQL);) {
            statement.setInt(1, clientId);
            try(ResultSet rs = statement.executeQuery()) {
                while(rs.next()) {
                    if (rs.getBoolean("kind")) {
                        credits.add(new CreditAnnuity(rs.getInt(1), rs.getInt(2),
                                Math.round(rs.getDouble(3)), Math.round(rs.getDouble(4)),
                                rs.getInt(5), rs.getInt(6),
                                rs.getDouble(7)));
                    } else {
                        credits.add(new CreditDifferential(rs.getInt(1), rs.getInt(2),
                                Math.round(rs.getDouble(3)), Math.round(rs.getDouble(4)),
                                rs.getInt(5), rs.getInt(6),
                                rs.getDouble(7)));
                    }
                }
            }
        } catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
        return credits;
    }
    public static ArrayList<Payment> getPaymentsGraphicsByCreditId(int creditId){
        ArrayList<Payment> payments = new ArrayList<>();
        String SQL = "select * from payments where credit_id = ?;";
        try(Connection connection = connect();
            PreparedStatement statement = connection.prepareStatement(SQL);) {
            statement.setInt(1, creditId);
            System.out.println("TUT");
            try(ResultSet rs = statement.executeQuery()) {
                while(rs.next()) {
                    payments.add(new Payment(rs.getInt(1), rs.getInt(2),
                            rs.getInt(3), rs.getDouble(4)));
                }
            }
        } catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
        return payments;
    }
    public static ArrayList<StateTreasuryBill> getStateTreasuryBillClientId(int clientId){
        ArrayList<StateTreasuryBill> stateTreasuryBills = new ArrayList<>();
        String SQL = "select * from state_treasury_bills where people_id = ?;";
        try(Connection connection = connect();
            PreparedStatement statement = connection.prepareStatement(SQL);) {
            statement.setInt(1, clientId);
            try(ResultSet rs = statement.executeQuery()) {
                while(rs.next()) {
                    stateTreasuryBills.add(new StateTreasuryBill(rs.getInt(1),rs.getInt(2),
                            rs.getInt(3), rs.getDouble(4)));
                }
            }
        } catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
        return stateTreasuryBills;
    }
    /*public static double sumCredits(){
        String SQL = "select * from state_treasury_bills where people_id = ?;";
        try(Connection connection = connect();
            PreparedStatement statement = connection.prepareStatement(SQL);) {
            statement.setInt(1, clientId);
            try(ResultSet rs = statement.executeQuery()) {
                while(rs.next()) {
                    stateTreasuryBills.add(new StateTreasuryBill(rs.getInt(1),rs.getInt(2),
                            rs.getInt(3), rs.getDouble(4)));
                }
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
    }*/
    public static void updateCredit(int creditId, double sum, int month, int countMonth, double resultSum){
        String SQL = "update Credits set sum = ?, month = ?, result_sum = ?, countMonth = ? where id = ?;";
        try(Connection connection = connect();
            PreparedStatement statement = connection.prepareStatement(SQL);) {
            statement.setDouble(1, sum);
            statement.setInt(2, month);
            statement.setDouble(3, Math.round(resultSum));
            statement.setDouble(4, countMonth);
            statement.setInt(5, creditId);
            statement.executeUpdate();
        } catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }
    public static void deleteSTB(int idSTB){
        String SQL = "delete from state_treasury_bills where id = ?;";
        try(Connection connection = connect();
            PreparedStatement statement = connection.prepareStatement(SQL);) {
            statement.setInt(1, idSTB);
            statement.executeUpdate();
        } catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }
    public static void updateSTB(int idSTB, int month){
        String SQL = "update state_treasury_bills set month = ? where id = ?;";
        try(Connection connection = connect();
            PreparedStatement statement = connection.prepareStatement(SQL);) {
            statement.setInt(1, month);
            statement.setInt(2, idSTB);
            statement.executeUpdate();
        } catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }
    public static void updateBank(int idBank, double budget){
        String SQL = "update banks set budget = ? where id = ?;";
        try(Connection connection = connect();
            PreparedStatement statement = connection.prepareStatement(SQL);) {
            statement.setDouble(1, budget);
            statement.setInt(2, idBank);
            statement.executeUpdate();
        } catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }
    public static Bank selectBank(int bankId){
        Bank bank = null;
        String SQL = "select * from banks where id = ?; ";
        try(Connection connection = connect();
            PreparedStatement statement = connection.prepareStatement(SQL);) {
            statement.setInt(1, bankId);
            try(ResultSet rs = statement.executeQuery()){
                rs.next();
                bank = new Bank(bankId, rs.getDouble("budget"));
            }
        } catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
        return bank;
    }
    public static ArrayList<Person> clientList(int bankId){
        ArrayList<Person> people = new ArrayList<>();
        String SQL = "select * from People_bank where bank_id = ?;";
        try(Connection connection = connect();
            PreparedStatement statement = connection.prepareStatement(SQL);) {
            statement.setInt(1, bankId);
            try(ResultSet rs = statement.executeQuery()) {
                while(rs.next()) {/*
                    stateTreasuryBills.add(new StateTreasuryBill(rs.getInt(1),rs.getInt(2),
                            rs.getInt(3), rs.getDouble(4)));\*/
                    people.add(new Person(rs.getInt(1), rs.getInt(2),
                            rs.getString(3), rs.getString(4), rs.getInt(5),
                            rs.getString(6)));
                }
            }
        } catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
        return people;
    }
}
