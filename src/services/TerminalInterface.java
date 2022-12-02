package services;

import classes.Person;
import classes.MobilePhone;
import enams.Mobile;

public interface TerminalInterface {
    String createMobilePhone(MobilePhone... terminal);
    MobilePhone[] getAllMobilePhone();
    String transferToCard(Person fromPerson, Person[] toPeople, String cardNumber, double summa);
    String transferToPhoneNumber(Person fromPerson, Person[] toPeople, Mobile terminal, String phoneNumber, double summa);
}
