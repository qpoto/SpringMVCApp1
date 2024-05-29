package ru.stas.springcourse.dao;

import org.springframework.stereotype.Component;
import ru.stas.springcourse.models.Person;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAO {
    private List<Person> people;
    private static int PEOPLE_COUNT;

    {
        people = new ArrayList<>();

        people.add(new Person(++PEOPLE_COUNT, "Stas"));
        people.add(new Person(++PEOPLE_COUNT, "Max"));
        people.add(new Person(++PEOPLE_COUNT, "Den"));
        people.add(new Person(++PEOPLE_COUNT, "Ira"));
    }

    public List<Person> index() {
        return people;
    }

    public Person show(int id) {
        return people.stream().filter(person -> person.getId() == id).findAny().orElse(null);
    }
}
