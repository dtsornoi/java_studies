package main;

import model.Person;
import persistance.Repository;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Repository repository = new Repository();

        List<Person> personList = repository.trainersFromBucharest();
        for(Person person : personList){
            System.out.println(person);
        }
    }
}
