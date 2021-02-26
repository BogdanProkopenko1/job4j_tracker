package ru.job4j.collection;

public class Article {

    public static boolean generateBy(String origin, String line) {
        String[] text = line.split(" ");
        boolean rsl = true;
        for (int i = 0; i < text.length; i++) {
            if (!origin.contains(text[i])) {
                rsl = false;
            }
        }
        return rsl;
    }
}