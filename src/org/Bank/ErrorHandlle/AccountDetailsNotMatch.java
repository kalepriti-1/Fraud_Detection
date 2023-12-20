package org.Bank.ErrorHandlle;

public class AccountDetailsNotMatch extends RuntimeException{
    public AccountDetailsNotMatch(String message){
        super(message);
    }
}
