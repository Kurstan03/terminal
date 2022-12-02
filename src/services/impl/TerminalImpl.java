package services.impl;

import classes.Person;
import classes.MobilePhone;
import enams.Mobile;
import services.TerminalInterface;

import java.time.LocalDate;
import java.util.InputMismatchException;

public class TerminalImpl implements TerminalInterface {
    private MobilePhone[] mobilePhones;

    public MobilePhone[] getMobilePhones() {
        return mobilePhones;
    }

    public void setMobilePhones(MobilePhone[] mobilePhones) {
        this.mobilePhones = mobilePhones;
    }

    @Override
    public String createMobilePhone(MobilePhone... terminal) {
        MobilePhone[] mobilePhonesArr;
        if (getMobilePhones() == null){
            this.mobilePhones = terminal;
        }else {
            mobilePhonesArr = new MobilePhone[getMobilePhones().length + terminal.length];
            int index = 0;
            for (int i = 0; i < getMobilePhones().length; i++) {
                mobilePhonesArr[index++] = getMobilePhones()[i];
            }
            for (MobilePhone mobilePhone : terminal) {
                mobilePhonesArr[index++] = mobilePhone;
            }
            setMobilePhones(mobilePhonesArr);
        }
        return "Mobil phone successfully saved!";
    }

    @Override
    public MobilePhone[] getAllMobilePhone() {
        return  getMobilePhones();
    }

    @Override
    public String transferToCard(Person fromPerson, Person[] toPeople, String cardNumber, double summa) {
        double usluga = 0;
        String result = "";
        try {
            if (cardNumber.matches("[0-9]+")) {
                if (cardNumber.length() == 4) {
                    for (Person person : toPeople) {
                        if (person.getBankAccount().getCardNumber().trim().equals(cardNumber.trim())) {
                            fromPerson.getBankAccount().setBalance(fromPerson.getBankAccount().getBalance() - summa);
                            if (person.getBankAccount().getBankName().equals(fromPerson.getBankAccount().getBankName())) {
                                person.getBankAccount().setBalance(person.getBankAccount().getBalance() + summa);
                            } else {
                                usluga = summa * 5 / 100;
                                person.getBankAccount().setBalance(person.getBankAccount().getBalance() + (summa - usluga));
                            }
                            result = "translation successfully completed!" +
                                    "\ndate: " + LocalDate.now() +
                                    "\nfrom: " + fromPerson.getFirstName() +
                                    "\nto: " + person.getFirstName() +
                                    "\nsumma: " + summa +
                                    " som\nusluga: " + usluga +
                                    " som\nfor enrollment: " + (summa - usluga) + " som";

                        }
                    }
                    if (result.equals("")){
                        result = "subscriber not found!";
                    }
                } else {
                    throw new Exception("card number must be at least 4 digits!");
                }
            } else {
                throw new Exception("card number can only be with numbers!");
            }

        } catch (InputMismatchException e) {
            System.out.println("summa is written only in numbers!");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return result;
    }

    @Override
    public String transferToPhoneNumber(Person fromPerson, Person[] toPeople, Mobile terminal, String phoneNumber, double summa) {
        double usluga = 0;
        String result = "";
        try {
            if (phoneNumber.matches("[0-9]+")) {
                if (phoneNumber.length() == 10) {
                    for (Person person : toPeople) {
                        if (phoneNumber.trim().equals(person.getMobilePhone().getPhoneNumber().trim())) {
                            fromPerson.getMobilePhone().setBalance(fromPerson.getMobilePhone().getBalance() - summa);
                            if (terminal == Mobile.BEELINE) {
                                if (phoneNumber.trim().substring(1, 3).equals("22") || phoneNumber.trim().substring(1, 3).equals("77")) {
                                    person.getMobilePhone().setBalance(person.getMobilePhone().getBalance() + summa);
                                } else {
                                    usluga = summa / 100;
                                    person.getMobilePhone().setBalance(person.getMobilePhone().getBalance() + (summa - usluga));
                                }
                            } else if (terminal == Mobile.MEGACOM) {
                                if (phoneNumber.trim().substring(1, 3).equals("55") || phoneNumber.trim().substring(1, 3).equals("99")) {
                                    person.getMobilePhone().setBalance(person.getMobilePhone().getBalance() + summa);
                                } else {
                                    usluga = summa / 100;
                                    person.getMobilePhone().setBalance(person.getMobilePhone().getBalance() + (summa - usluga));
                                }
                            } else {
                                if (phoneNumber.trim().substring(1, 3).equals("50") || phoneNumber.trim().substring(1, 3).equals("70")) {
                                    person.getMobilePhone().setBalance(person.getMobilePhone().getBalance() + summa);
                                } else {
                                    usluga = summa / 100;
                                    person.getMobilePhone().setBalance(person.getMobilePhone().getBalance() + (summa - usluga));
                                }
                            }
                            result = "translation successfully completed!" +
                                    "\ndate: " + LocalDate.now() +
                                    "\nfrom: " + fromPerson.getFirstName() +
                                    "\nto: " + person.getFirstName() +
                                    "\nsumma: " + summa +
                                    " som\nusluga: " + usluga +
                                    " som\nfor enrollment: " + (summa - usluga) + " som";
                        }
                    }
                    if (result.equals("")){
                        result = "subscriber not found!";
                    }
                } else {
                    throw new Exception("phone number must be at least 10 digits!");
                }
            } else {
                throw new Exception("phone number can only be with numbers!");
            }

        } catch (InputMismatchException e) {
            System.out.println("summa is written only in numbers!" + e);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return result;
    }
}
