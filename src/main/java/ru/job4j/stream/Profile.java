package ru.job4j.stream;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Profile {

    public Address address;

    public static Map<String, Student> studentMap(List<Student> in) {
        return in.stream().collect(Collectors.toMap(Student::getSurname,
                y -> y));
    }
}