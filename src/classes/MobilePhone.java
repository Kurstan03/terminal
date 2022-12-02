package classes;

import enams.Mobile;

public class MobilePhone {
    private String mobileName;
    private String color;
    private String phoneNumber;
    private double balance;

    public MobilePhone(String  mobileName, String color, String phoneNumber, double balance) {
        try {
            this.mobileName = mobileName;
            this.color = color;
            if (phoneNumber.matches("[0-9]+")) {
                if (phoneNumber.length() == 10) {
                    this.phoneNumber = phoneNumber;
                }else {
                    throw new Exception("phone number must be at least 10 digits!");
                }
            }else {
                throw new Exception("phone number can only be with numbers!");
            }
            this.balance = balance;
        }catch (Exception e){
            System.err.println(e.getMessage());
        }
    }

    public String getMobileName() {
        return mobileName;
    }

    public void setMobileName(String mobileName) {
        this.mobileName = mobileName;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "\n  MobilePhone{" +
                "mobileName='" + mobileName + '\'' +
                ", color='" + color + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", balance=" + balance +
                '}';
    }
}
