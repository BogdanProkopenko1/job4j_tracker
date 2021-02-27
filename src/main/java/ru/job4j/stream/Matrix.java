package ru.job4j.stream;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Matrix {

    public static void main(String... args) {
        int[][] rsl = {{0, 1, 2, 3, 4}, {5, 6, 7, 8, 9}};
        List<Integer> result = new ArrayList<>();
        for (int[] ints : rsl) {
            for (int o : ints) {
                result.add(o);
            }
        }
        System.out.println(result);
    }
}