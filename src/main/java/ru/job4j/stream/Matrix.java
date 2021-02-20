package ru.job4j.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Matrix {

    public static void main(String... args) {
        List<List<Integer>> rsl = Arrays.asList(
                Arrays.asList(1, 2, 3, 4, 5, 6),
                Arrays.asList(7, 8, 9, 10, 11, 12, 13, 14)
        );
        List<Integer> result = rsl.stream().flatMap(List::stream).collect(Collectors.toList());
        System.out.println(result);
    }
}