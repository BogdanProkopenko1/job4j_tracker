package ru.job4j.stream;

import java.util.List;
import java.util.stream.Collectors;

public class Profile {

    private Address address;

    public static List<Address> collect(List<Profile> profiles) {
        return profiles.stream()
                .map((s) -> new Address(
                        s.address.getCity(),
                        s.address.getStreet(),
                        s.address.getHome(),
                        s.address.getApartment()))
                .collect(Collectors.toList());
    }
}