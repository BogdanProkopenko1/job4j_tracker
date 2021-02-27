package ru.job4j.collection;

import java.util.Arrays;
import java.util.HashSet;

public class Article {

    public static boolean generateBy(String origin, String line) {
        String[] originalArray = origin.split(" ");
        String[] copiedArray = line.split(" ");
        HashSet<String> originalSet = new HashSet<String>();
        HashSet<String> copiedSet = new HashSet<String>();
        originalSet.addAll(Arrays.asList(originalArray));
        copiedSet.addAll(Arrays.asList(copiedArray));
        return !originalSet.addAll(copiedSet);
    }
}