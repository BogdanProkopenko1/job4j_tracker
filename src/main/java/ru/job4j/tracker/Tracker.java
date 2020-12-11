package ru.job4j.tracker;

import java.util.Arrays;

public class Tracker {
    private final Item[] items = new Item[100];
    private int ids = 1;
    private int size = 0;

    public Item add(Item item) {
        item.setId(ids++);
        items[size++] = item;
        return item;
    }

    public Item findById(int id) {
        Item rsl = null;
        for (int index = 0; index < size; index++) {
            Item item = items[index];
            if (item.getId() == id) {
                rsl = item;
                break;
            }
        }
        return rsl;
    }

    public Item[] findAll() {
        int counter = 0;
        Item[] defragmentation = new Item[items.length];
        for (int i = 0; i < items.length; i++) {
            if (items[i] != null) {
                defragmentation[counter] = items[i];
                counter++;
            }
        }
        defragmentation = Arrays.copyOf(defragmentation, counter);
        return defragmentation;
    }

    public Item[] findByName(String key) {
        int counter = 0;
        Item[] result = new Item[items.length];
        for (int i = 0; i < items.length; i++) {
            if (items[i].equals(key)) {
                result[counter] = items[i];
                counter++;
            }
        }
        result = Arrays.copyOf(result, counter);
        return result;
    }
}