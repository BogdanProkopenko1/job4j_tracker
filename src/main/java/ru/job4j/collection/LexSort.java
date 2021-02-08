package ru.job4j.collection;

import java.util.Comparator;

public class LexSort implements Comparator<String> {

    @Override
    public int compare(String left, String right) {
        int valLeft = Integer.parseInt(left.split("\\.")[0]);
        int valRight = Integer.parseInt(right.split("\\.")[0]);
        return valLeft - valRight;
    }
}