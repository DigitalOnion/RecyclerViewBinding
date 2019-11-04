package com.outerspace.recyclerviewbinding;

import java.util.ArrayList;

import android.os.Handler;
import android.support.v4.util.Consumer;

public class PersonRepo {
    private static PersonRepo instance = new PersonRepo();

    private PersonRepo() { }

    public static PersonRepo getInstance() { return instance; }

    private Consumer<Person> personConsumer;

    public void setPersonConsumer(Consumer<Person> personConsumer) {
        this.personConsumer = personConsumer;
    }

    public void addPerson(Person person) {
        personConsumer.accept(person);
    }

    public void addPerson(String fullName, String title, String nickname) {
        Person person = new Person(fullName, title, nickname);
        addPerson(person);
    }

    public void start() {
        Person[] people = new Person[]{
                new Person("Luis Virueña", "papá", "smooth"),
                new Person("Elvi Chávez", "mamá", "smooth teacher"),
                new Person("Sofía Virueña", "hijita", "smootheer"),
                new Person("Aldo Virueña", "hijo", "futttt"),
        };

        for(int i = 0; i < people.length; i++) {
            addPerson(people[i]);
        }
    }
}
