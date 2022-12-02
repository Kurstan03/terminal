package services.impl;

import classes.BankAccount;
import classes.Person;
import enams.Bank;
import services.BankAccountInterface;

public class BankAccountImpl implements BankAccountInterface {
    private BankAccount[] bankAccounts;


    public BankAccount[] getBankAccounts() {
        return bankAccounts;
    }

    public void setBankAccounts(BankAccount[] bankAccounts) {
        this.bankAccounts = bankAccounts;
    }

    @Override
    public String createBankAccount(BankAccount ... bankAccounts) {
        BankAccount[] bankAccountsArr;
        if(getBankAccounts() == null){
            this.bankAccounts = bankAccounts;
        }else {
            bankAccountsArr = new BankAccount[bankAccounts.length + getBankAccounts().length];
            int index = 0;
            int index1 = 0;
            for (int i = 0; i < bankAccountsArr.length; i++) {
                if (i < getBankAccounts().length){
                    bankAccountsArr[i] = getBankAccounts()[index];
                    index ++;
                }else {
                    bankAccountsArr[i] = bankAccounts[index1];
                    index1++;
                }
            }
            setBankAccounts(bankAccountsArr);
        }
        return "Bank accounts successfully saved!";
    }

    @Override
    public BankAccount[] getAllBankAccount() {
        return getBankAccounts();
    }

    @Override
    public String credit(Person person, Bank bank, int deposit, double summa) {
        if (bank == Bank.AIYL_BANK){
            person.getBankAccount().setBalance(person.getBankAccount().getBalance() + summa);
            return bank + "\n" + person.getFirstName() + " вы успешно получили кредит!\nсумма кредита: " + summa +
                    "\nпроцент банка: 5%" +
                    "\nваш долг составляет: " + ((summa * 5 / 100) + summa);
        } else if (bank == Bank.OPTIMA_BANK){
            person.getBankAccount().setBalance(person.getBankAccount().getBalance() + summa);
            return bank + "\n" + person.getFirstName() + " вы успешно получили кредит!\nсумма кредита: " + summa +
                    "\nпроцент банка: 6%" +
                    "\nваш долг составляет: " + ((summa * 6 / 100) + summa);
        } else if (bank == Bank.BAKAI_BANK) {
            person.getBankAccount().setBalance(person.getBankAccount().getBalance() + summa);
            return bank + "\n" + person.getFirstName() + " вы успешно получили кредит!\nсумма кредита: " + summa +
                    "\nпроцент банка: 7%" +
                    "\nваш долг составляет: " + ((summa * 7 / 100) + summa);
        }else if (bank == Bank.KYRGYZSTAN_BANK){
            person.getBankAccount().setBalance(person.getBankAccount().getBalance() + summa);
            return bank + "\n" + person.getFirstName() + " вы успешно получили кредит!\nсумма кредита: " + summa +
                    "\nпроцент банка: 8%" +
                    "\nваш долг составляет: " + ((summa * 8 / 100) + summa);
        }else {
            person.getBankAccount().setBalance(person.getBankAccount().getBalance() + summa);
            return bank + "\n" + person.getFirstName() + " вы успешно получили кредит!\nсумма кредита: " + summa +
                    "\nпроцент банка: 9" +
                    "\nваш долг составляет: " + ((summa * 9 / 100) + summa);
        }
    }
}
