package org.Bank.ErrorHandlle;

public class AccountBlockException extends RuntimeException{
    public AccountBlockException(String message){
        super(message);
    }
}
