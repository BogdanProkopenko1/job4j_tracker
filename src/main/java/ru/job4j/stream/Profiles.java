package ru.job4j.stream;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Profiles {

    public static List<Address> collect(List<Profile> profiles) {
        return (profiles.stream()
                .map((s) -> new Address(
                        s.address.getCity(),
                        s.address.getStreet(),
                        s.address.getHome(),
                        s.address.getApartment()))
                .collect(Collectors.toList())).stream()
                .sorted(Comparator.comparing(Address::getCity))
                .distinct().collect(Collectors.toList());
    }
}
