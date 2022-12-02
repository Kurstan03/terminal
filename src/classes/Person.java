package classes;

public class Person {
    private String firstName;
    private String lastName;
    private String gmail;
    private MobilePhone mobilePhone;
    private String passport;
    public BankAccount bankAccount;

    public Person(String firstName, String lastName, String gmail, MobilePhone mobilePhone, String passport, BankAccount bankAccount) {
        try {
            if (firstName.matches("[A-Za-zА-Яа-я]*"))
                this.firstName = firstName;
            else {
                throw new Exception("first name can only contain letters!");
            }
            if (lastName.matches("[A-Za-zА-Яа-я]*")) {
                this.lastName = lastName;
            }else {
                throw new Exception("last name can only contain letters!");
            }if (gmail.contains("@gmail")) {
                this.gmail = gmail;
            }else {
                throw new Exception("gmail must contain @gmail");
            }
            this.mobilePhone = mobilePhone;
            if (passport.matches("[0-9]+")) {
                if (passport.length() == 3) {
                    this.passport = passport;
                }else {
                    throw new Exception("passport number must be at least 3 digits!");
                }
            }else {
                throw new Exception("passport number can only be with numbers!");
            }
            this.bankAccount = bankAccount;
        }catch (Exception e){
            System.err.println(e.getMessage());
        }
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGmail() {
        return gmail;
    }

    public void setGmail(String gmail) {
        this.gmail = gmail;
    }

    public MobilePhone getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(MobilePhone mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    public BankAccount getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    @Override
    public String toString() {
        return "\nPerson{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", gmail='" + gmail + '\'' +
                ", mobilePhone=" + mobilePhone +
                ", passport='" + passport + '\'' +
                ", bankAccount=" + bankAccount +
                '}';
    }
}
