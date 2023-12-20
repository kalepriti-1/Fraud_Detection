package org.Bank.BankSystem;

import org.Bank.ErrorHandlle.AccountBlockException;
import org.Bank.Transaction.Withdrawal;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class BankAccount {
        private int id;
        private String name;
        private String password;
        private double balance;
        private List< Withdrawal > transactions = new ArrayList<>();
        private int retry = 3;
        private boolean blocked;

        public BankAccount(int id, String name, String password, double balance) {
            this.id = id;
            this.name = name;
            this.password = password;
            this.balance = balance;
            this.blocked = false;
        }

        public int getId() {
            return id;
        }

        public String getPassword() {
            return password;
        }

        public double getBalance() {
            return balance;
        }
        public int getRetry(){
            return retry;
        }
        public void updateRetry(){
            if (retry == 0){
                blocked =true;
                throw  new AccountBlockException("Your Account Block go to bank and unblock your account");
            }else{
                retry = retry -1;
                System.out.println("You have " + (retry) + " attempts remaining to log in.");            }
        }

        public void withdraw(Withdrawal withdrawal) {
            if (!blocked){
                this.balance -= withdrawal.getAmount();
                transactions.add(withdrawal);
            }else{
                System.out.println("account is block go to bank an unblock your account");
            }

        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            BankAccount account = (BankAccount) o;
            return id == account.id && Double.compare(account.balance, balance) == 0 && Objects.equals(name, account.name) && Objects.equals(password, account.password) && Objects.equals(transactions, account.transactions);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id, name, password, balance, transactions);
        }


        public List<Withdrawal> getAccountTransactions() {
            return transactions;
        }
        public boolean isBlocked(){
            return blocked;
        }

        @Override
        public String toString() {
            return "Account{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", password='" + password + '\'' +
                    ", balance=" + balance +
                    ", transactions=" + transactions +
                    '}';
        }
    }

