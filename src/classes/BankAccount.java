package classes;

import enams.Bank;

import java.util.InputMismatchException;

public class BankAccount {
    private Bank bankName;
    private double balance;
    private String cardNumber;
    private String password;

    public BankAccount(Bank bankName, double balance, String cardNumber, String password) {
        try {
            this.bankName = bankName;
            this.balance = balance;
            if (cardNumber.matches("[0-9]+")) {
                if (cardNumber.length() == 4){
                    this.cardNumber = cardNumber;
                }else {
                    throw new Exception("card number must be at least 4 digits!");
                }
            }else {
                throw new Exception("card number can only be with numbers!");
            }
            this.password = password;

        }catch (InputMismatchException e){
            System.out.println("balance is written only in numbers!");
        }catch (Exception e){
            System.err.println(e.getMessage());
        }
    }

    public Bank getBankName() {
        return bankName;
    }

    public void setBankName(Bank bankName) {
        this.bankName = bankName;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "\n  BankAccount{" +
                "bankName=" + bankName +
                ", balance=" + balance +
                ", cardNumber='" + cardNumber + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
