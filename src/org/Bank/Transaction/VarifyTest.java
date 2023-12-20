package org.Bank.Transaction;

import org.Bank.BankSystem.BankAccount;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VarifyTest {

    @Test
    void getId() {
        BankAccount account1 = new BankAccount(13532124,"Priti kale","Priti@123",100000);
        Varify varify = new Varify(13532124,"Priti@123");
        assertEquals(0,varify.getId());
    }

    @Test
    void getPassword() {
        BankAccount account1 = new BankAccount(13532124,"Priti kale","Priti@123",100000);
        Varify varify = new Varify(13532124,"Priti@123");
        assertEquals(null,varify.getPassword());
    }

}