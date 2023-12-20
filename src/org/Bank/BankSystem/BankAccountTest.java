package org.Bank.BankSystem;

import org.Bank.Transaction.Varify;
import org.Bank.Transaction.Withdrawal;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class BankAccountTest {

    @Test
    void getId() {
        BankAccount account1 = new BankAccount(13532124,"Priti kale","Priti@123",100000);
        assertEquals(13532124 , account1.getId());
    }

    @Test
    void getPassword() {
        BankAccount account1 = new BankAccount(13532124,"Priti kale","Priti@123",100000);
        assertEquals("Priti@123" , account1.getPassword());
    }

    @Test
    void getBalance() {
        BankAccount account1 = new BankAccount(13532124,"Priti kale","Priti@123",100000);
        assertEquals(100000 , account1.getBalance());
    }

    @Test
    void updateRetry() {
        BankAccount account1 = new BankAccount(13532124,"Priti kale","Priti@123",100000);
        assertEquals(3, account1.getRetry());
        account1.updateRetry();
        account1.updateRetry();

        assertTrue(!account1.isBlocked());
        assertEquals(1, account1.getRetry());
        account1.updateRetry();
        assertTrue(!account1.isBlocked());
    }

    @Test
    void withdraw() {
        BankAccount account1 = new BankAccount(13532124,"Priti kale","Priti@123",100000);
        Withdrawal withdrawal = new Withdrawal(13532124,"Priti@123",new Date(),100);
        account1.withdraw(withdrawal);
        assertTrue(account1.getAccountTransactions().contains(withdrawal));
    }

    @Test
    void testEquals() {
        BankAccount account1 = new BankAccount(13532124,"Priti kale","Priti@123",100000);
        assertEquals("Account{id=13532124, name='Priti kale', password='Priti@123', balance=100000.0, transactions=[]}",account1.toString());
    }

    @Test
    void testHashCode() {
        BankAccount account1 = new BankAccount(13532124,"Priti kale","Priti@123",100000);
        BankAccount account2 = new BankAccount(13532124,"Priti kale","Priti@123",100000);
        assertTrue(account2.hashCode() == account1.hashCode());

    }

}