package org.Bank.Transaction;

import org.Bank.BankSystem.BankAccount;
import org.Bank.BankSystem.BankSystem;
import org.Bank.ErrorHandlle.AccountDetailsNotMatch;

public class Varify {
    private int id;
    private String password;



    public Varify(int id, String password) {
        try {
            BankSystem.isAccountDetailMatch(id, password);
            this.id = id;
            this.password = password;
        } catch (AccountDetailsNotMatch e) {
            System.out.println(e.getMessage());
        }
    }

    public int getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }
}
