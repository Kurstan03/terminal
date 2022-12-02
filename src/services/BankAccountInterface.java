package services;

import classes.BankAccount;
import classes.Person;
import enams.Bank;

public interface BankAccountInterface {
    String createBankAccount(BankAccount ... bankAccounts);
    BankAccount[] getAllBankAccount();
    String credit(Person person, Bank bank, int deposit, double summa);
}
