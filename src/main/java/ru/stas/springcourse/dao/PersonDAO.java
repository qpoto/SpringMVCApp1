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

        people.add(new Person(++PEOPLE_COUNT, "Stas", 24, "Stas@mail.ru"));
        people.add(new Person(++PEOPLE_COUNT, "Max", 34, "Max@mail.ru"));
        people.add(new Person(++PEOPLE_COUNT, "Den", 44, "Den@mail.ru"));
        people.add(new Person(++PEOPLE_COUNT, "Ira", 54, "Ira@mail.ru"));
    }

    public List<Person> index() {
        return people;
    }

    public Person show(int id) {
        return people.stream().filter(person -> person.getId() == id).findAny().orElse(null);
    }

    public void save(Person person) {
        person.setId(++PEOPLE_COUNT);
        people.add(person);
    }

    public void update(int id, Person person) {
        Person personToUpdate = show(id);
        personToUpdate.setName(person.getName());
        personToUpdate.setAge(person.getAge());
        personToUpdate.setEmail(person.getEmail());
    }

    public void delete(int id) {
        people.removeIf(person -> person.getId() == id);
    }
}
