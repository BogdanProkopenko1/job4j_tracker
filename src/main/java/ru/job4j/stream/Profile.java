package ru.job4j.stream;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Profile {

    private Address address;

    public Address getAddress() {
        return address;
    }

    public static Map<String, List<Student>> studentMap(List<Student> in) {
        return in.stream()
                .collect(Collectors.groupingBy(Student::getSurname, Collectors.toList()));
    }

    public static void main(String[] args) {
        List<Student> operand = List.of(
                new Student(50, "Igor"),
                new Student(70, "Bogdan"),
                new Student(90, "Dima"),
                new Student(30, "Dasha"),
                new Student(60, "Valeria"),
                new Student(60, "Sergey")
        );
        System.out.println(studentMap(operand));
    }
}