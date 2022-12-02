package services.impl;

import classes.Person;
import services.PersonInterface;

public class PersonImpl implements PersonInterface {
    private Person[] people;

    public Person[] getPeople() {
        return people;
    }

    public void setPeople(Person[] people) {
        this.people = people;
    }

    @Override
    public String createPerson(Person ... people) {
        Person[] peopleArr;

        if (getPeople() == null){
            this.people = people;
        }else {
            peopleArr = new Person[getPeople().length + people.length];
            int index = 0;
            for (int i = 0; i < getPeople().length; i++) {
                peopleArr[index++] = getPeople()[i];
            }
            for (int i = 0; i < people.length; i++) {
                peopleArr[index++] = people[i];
            }
            setPeople(peopleArr);
        }
        return "Person successfully saved";
    }

    @Override
    public Person[] getAllPerson() {
        return getPeople();
    }
}
