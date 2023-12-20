package org.Bank.Transaction;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.util.Date;


public class WithdrawalTest {

        @Test
        public void testWithdrawal() {
            Date currentDate = new Date();
            Withdrawal withdrawal = new Withdrawal(1, "password123", currentDate, 500.0);

            assertEquals(1, withdrawal.getId());
            assertEquals("password123", withdrawal.getPassword());
            assertEquals(currentDate, withdrawal.getDate());
            assertEquals(500.0, withdrawal.getAmount(), 0.01);
        }


}