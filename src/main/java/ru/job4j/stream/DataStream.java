package ru.job4j.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DataStream {

    public static void main(String[] args) {
        ArrayList<Integer> nums = new ArrayList<Integer>();
        for (int i = -10; i <= 10; i++) {
            nums.add(i);
        }
        List<Integer> rsl = nums.stream().filter(num -> num > 0).collect(Collectors.toList());
        System.out.println(rsl);
    }
}