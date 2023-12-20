package org.Bank.BankSystem;

import org.Bank.ErrorHandlle.AccountDetailsNotMatch;
import org.Bank.Transaction.Withdrawal;

import java.util.*;

public class BankSystem {
    static List< BankAccount > accounts = new ArrayList<>();
    Map< Date, List< Withdrawal > > accounttransactions = new TreeMap<>();


    public static void isAccountDetailMatch(int id, String password) {
        int flag = 0;
        for (BankAccount account : accounts) {
            if (id == account.getId() && password.equals(account.getPassword())) {
                flag = 2;
            } else if (id == account.getId() && !password.equals(account.getPassword())) {
                account.updateRetry();
                flag = 1;
            }
        }
        switch (flag){
            case 1:
                System.out.println("password wrong");
                break;
            case 2:
                System.out.println("varify");
                break;
            default:
                throw new AccountDetailsNotMatch("Account detils not match");
        }
    }

    public List< BankAccount > getAccounts() {
        return accounts;
    }

    public void addAccount(BankAccount account) {
        accounts.add(account);
    }

    public void addTransactionToAccount(Withdrawal withdrawal) {

        for (BankAccount account : accounts) {
            if (withdrawal.getId() == account.getId() && withdrawal.getPassword().equals(account.getPassword())) {
                account.withdraw(withdrawal);
            } else if (withdrawal.getId() == account.getId() && !withdrawal.getPassword().equals(account.getPassword())) {
                account.updateRetry();
            }
        }
    }

    public Map< Date, List< Withdrawal > > getAccountTransactionByDate() {;
        Map< Date, List< Withdrawal > > accounttransactionscopy = new TreeMap<>();
        for (BankAccount account : accounts) {
            for (Withdrawal withdrawal : account.getAccountTransactions()) {
                if (accounttransactionscopy.containsKey(withdrawal.getDate())){
                    accounttransactionscopy.get(withdrawal.getDate()).add(withdrawal);
                }else{
                    List<Withdrawal> withdrawals = new ArrayList<>();
                    withdrawals.add(withdrawal);
                    accounttransactionscopy.put(withdrawal.getDate(),withdrawals);
                }
            }
        }
        return accounttransactionscopy;

    }
    public void getSortTransactionByAmount() {
        Map<Date, List<Withdrawal>> transactionMapCopy = getAccountTransactionByDate();
        Map<Date , List<Withdrawal>> transactionMapCopysort = new TreeMap<>();
        for (Date date : transactionMapCopy.keySet()) {
            System.out.println("Transaction date:-"+date);
            List<Withdrawal> withdrawalList = transactionMapCopy.get(date);
            System.out.println("Before sorting: " + withdrawalList);
            withdrawalList.sort((o1, o2) -> Double.compare(o2.getAmount(), o1.getAmount()));
            System.out.println("After sorting: " + withdrawalList);
            for (Withdrawal withdrawal : withdrawalList){
                System.out.println(withdrawal);
            }
        }
    }


}
