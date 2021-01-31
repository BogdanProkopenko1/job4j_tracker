package ru.job4j.collection;

import java.util.HashSet;

public class UniqueText {

    public static boolean isEquals(String originText, String duplicateText) {
        boolean rsl = true;
        String[] origin = originText.split(" ");
        String[] text = duplicateText.split(" ");
        HashSet<String> check = new HashSet<String>();
        for (String org : origin) {
            check.add(org);
        }
        for (String r : text) {
            if (!check.contains(r)) {
                rsl = false;
                break;
            }
        }
        return rsl;
    }
}