package ru.job4j.stream;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Profile {

    private Address address;

    public static List<Address> collect(List<Profile> profiles) {
        List<Address> rsl = profiles.stream()
                .map((s) -> new Address(
                        s.address.getCity(),
                        s.address.getStreet(),
                        s.address.getHome(),
                        s.address.getApartment()))
                .collect(Collectors.toList());
        return rsl.stream().sorted(Comparator.comparing(Address::getCity)).distinct().collect(Collectors.toList());
    }

    public static Map<String, Student> studentMap(List<Student> in) {
        return in.stream().collect(Collectors.toMap(Student::getSurname,
                y -> y));
    }
}