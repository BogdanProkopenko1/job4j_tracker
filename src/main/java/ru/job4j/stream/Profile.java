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
        Comparator<Address> comparator = new Comparator<Address>() {
            @Override
            public int compare(Address o1, Address o2) {
                return o1.getCity().compareTo(o2.getCity());
            }
        };
        return rsl.stream().sorted(comparator).distinct().collect(Collectors.toList());
    }

    public static Map<String, Student> studentMap(List<Student> in) {
        return in.stream().collect(Collectors.toMap(Student::getSurname,
                y -> y));
    }
}