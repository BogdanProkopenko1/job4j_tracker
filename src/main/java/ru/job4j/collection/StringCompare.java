package ru.job4j.collection;

import java.util.Comparator;

public class StringCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        for (int i = 0; i < Math.min(left.length(), right.length()); i++) {
            char chLeft = left.charAt(i);
            char chRight = right.charAt(i);
            if (chLeft != chRight) {
                return chLeft - chRight;
            }
        }
        return left.length() - right.length();
    }
}