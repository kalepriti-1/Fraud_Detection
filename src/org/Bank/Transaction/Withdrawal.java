package org.Bank.Transaction;

import org.Bank.BankSystem.BankAccount;
import org.Bank.BankSystem.BankSystem;
import org.Bank.ErrorHandlle.AccountDetailsNotMatch;

import java.util.Date;

public class Withdrawal {
    private int id;
    private String password;
    private Date date;
    private double amount;

    public Withdrawal(int id, String password, Date date, double amount) {
        this.id = id;
        this.password = password;
        this.date = date;
        this.amount = amount;
    }

    public Date getDate() {
        return date;
    }

    public double getAmount() {
        return amount;
    }

    public int getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "Withdrawal{" +
                "id=" + id +
                ", password='" + password + '\'' +
                ", date=" + date +
                ", amount=" + amount +
                '}';
    }
}

