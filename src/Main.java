import classes.BankAccount;
import classes.MobilePhone;
import classes.Person;
import enams.Bank;
import enams.Mobile;
import services.impl.BankAccountImpl;
import services.impl.PersonImpl;
import services.impl.TerminalImpl;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        BankAccount aiyl = new BankAccount(Bank.AIYL_BANK,3000,"4444","nurs");
        BankAccount optima = new BankAccount(Bank.OPTIMA_BANK,2000,"1234","kurs");
        BankAccount bakai = new BankAccount(Bank.BAKAI_BANK,5000,"9999","baiysh");

        MobilePhone phone = new MobilePhone("Samsung","white","0999775533",300.0);
        MobilePhone phone1 = new MobilePhone("Redimi","green","0220113355",500);
        MobilePhone phone2 = new MobilePhone("iPhone","grey","0700668800",200);
        Person[] people = new Person[]{
                new Person("kurstan","Erkinbaev","kurstan@gmail.com", phone,"123", optima),
                new Person("Nurseiit", "Sadirov","nur@gmail.com", phone1, "234", aiyl),
                new Person("Baiysh","Orozaliev","baiysh@gmail.com", phone2,"777", bakai)
        };


        PersonImpl personImpl = new PersonImpl();
        System.out.println(personImpl.createPerson(people[0],people[1]));
        System.out.println(personImpl.createPerson(people[2]));
        System.out.println(personImpl.createPerson(
                new Person("Yryskeldi", "Alymbekov", "yrys@gmail.com",
                        new MobilePhone("Redmi", "black", "0777009933", 700), "555",
                        new BankAccount(Bank.OPTIMA_BANK, 7000, "1111", "yrys"))
        ));
        System.out.println(Arrays.toString(personImpl.getAllPerson()));
        System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
        BankAccountImpl bankAccountImpl = new BankAccountImpl();
        System.out.println(bankAccountImpl.createBankAccount(aiyl));
        System.out.println(bankAccountImpl.createBankAccount(optima,bakai));
        System.out.println(Arrays.toString(bankAccountImpl.getAllBankAccount()));
        System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");

        System.out.println(bankAccountImpl.credit(people[0], Bank.OPTIMA_BANK, 600, 4000));
        System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
        System.out.println(bankAccountImpl.credit(people[2], Bank.RSK_BANK, 3000, 25000));

        System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");


        TerminalImpl terminalImpl = new TerminalImpl();
        System.out.println(terminalImpl.createMobilePhone(phone));
        System.out.println(terminalImpl.createMobilePhone(phone1));
        System.out.println(Arrays.toString(terminalImpl.getAllMobilePhone()));
        System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");

        System.out.println(terminalImpl.transferToCard(people[0], personImpl.getAllPerson(), "1111", 400));
        System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
        System.out.println(terminalImpl.transferToPhoneNumber(people[0], personImpl.getAllPerson(), Mobile.BEELINE, "0700668800", 200));
        System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
        System.out.println(Arrays.toString(personImpl.getAllPerson()));
    }
}