package ru.job4j.search;

import java.util.ArrayList;
import java.util.function.Predicate;

public class PhoneDictionary {

    private ArrayList<Person> persons = new ArrayList<Person>();

    public void add(Person person) {
        this.persons.add(person);
    }

    /**
     * Вернуть список всех пользователей, который содержат key в любых полях.
     * @param key Ключ поиска.
     * @return Список подощедщих пользователей.
     */

    public ArrayList<Person> find(String key) {
        ArrayList<Person> result = new ArrayList<>();
        for (int i = 0; i < persons.size(); i++) {
            Person person = persons.get(i);
            Predicate<Person> findByName = (name) -> person.getName().contains(key);
            Predicate<Person> findBySurname = (surname) -> person.getSurname().contains(key);
            Predicate<Person> findByPhone = (phone) -> person.getPhone().contains(key);
            Predicate<Person> findByAddress = (address) -> person.getAddress().contains(key);
            Predicate<Person> findAll = (obj) ->
                            findByAddress.test(obj)
                            || findByName.test(obj)
                            || findBySurname.test(obj)
                            || findByPhone.test(obj);
            if (findAll.test(person)) {
                result.add(persons.get(i));
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Person person0 = new Person("Bogdan", "Prok", "258", "Ufa");
        Person person1 = new Person("Dima", "Zotov", "741", "Uhta");
        PhoneDictionary phoneDictionary = new PhoneDictionary();
        phoneDictionary.add(person0);
        phoneDictionary.add(person1);
        System.out.println(person0.toString());
        System.out.println(person1.toString());
        System.out.println("rsl is " + phoneDictionary.find("rok"));
        System.out.println("rsl is " + phoneDictionary.find("Uh"));
    }
}