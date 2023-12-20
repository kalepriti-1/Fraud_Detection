import org.Bank.BankSystem.BankSystem;
import org.Bank.BankSystem.BankAccount;
import org.Bank.Transaction.Varify;
import org.Bank.Transaction.Withdrawal;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {

    public static void main(String[] args) throws ParseException {
        Main main = new Main();
        main.executeBankOperations();
    }

    private void executeBankOperations() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

        BankSystem bank = createBankWithAccounts();
        Varify varify1 = new Varify(13532124, "Priti@123");

        addWithdrawalTransactions(bank, varify1, sdf);

        System.out.print("Transaction History:-");
        bank.getSortTransactionByAmount();
    }

    private BankSystem createBankWithAccounts() {
        BankSystem bank = new BankSystem();
        BankAccount account1 = new BankAccount(13532124, "Priti kale", "Priti@123", 100000);
        BankAccount account2 = new BankAccount(13535224, "Priya Kale", "Priya@123", 2000000);
        BankAccount account3 = new BankAccount(13235123, "Pratiksha kale", "Pratiksha@123", 3000000);
        bank.addAccount(account1);
        bank.addAccount(account2);
        bank.addAccount(account3);
        return bank;
    }

    private void addWithdrawalTransactions(BankSystem bank, Varify varify, SimpleDateFormat sdf)
            throws ParseException {
        bank.addTransactionToAccount(new Withdrawal(varify.getId(), varify.getPassword(), sdf.parse("17-10-2023"), 1000));
        bank.addTransactionToAccount(new Withdrawal(varify.getId(), varify.getPassword(), sdf.parse("20-10-2024"), 900));
        bank.addTransactionToAccount(new Withdrawal(varify.getId(), varify.getPassword(), sdf.parse("20-10-2024"), 30000));
        bank.addTransactionToAccount(new Withdrawal(varify.getId(), varify.getPassword(), sdf.parse("20-10-2024"), 2000));
    }
}
