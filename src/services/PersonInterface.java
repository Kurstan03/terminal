package services;

import classes.Person;
public interface PersonInterface {
    String createPerson(Person ... people);
    Person[] getAllPerson();
}
