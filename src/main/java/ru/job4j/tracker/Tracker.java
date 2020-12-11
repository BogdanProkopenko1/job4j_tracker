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
        int index = indexOf(id);
        return index != -1 ? items[index] : null;
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
            if (key != null) {
                for (int i = 0; i < items.length; i++) {
                    if (items[i].equals(key)) {
                        result[counter] = items[i];
                        counter++;
                    }
                }
                result = Arrays.copyOf(result, counter);
            } else {
                System.out.println("Incorrect question!");
            }
            return result;
    }

    private int indexOf(int id) {
        int rsl = -1;
        for (int index = 0; index < size; index++) {
            if (items[index].getId() == id) {
                rsl = index;
                break;
            }
        }
        return rsl;
    }

    public boolean replace(int id, Item item) {
        boolean rsl = false;
        for (int i = 0; i < items.length; i++) {
            if (items[i].getId() == id) {
                item.setId(id);
                items[i] = item;
                rsl = true;
                break;
            }
        }
        return rsl;
    }

    public boolean delete(int id) {
        boolean rsl = false;
        int index = indexOf(id);
        for (int i = 0; i < items.length; i++) {
            if (index != -1) {
                items[index] = null;
                System.arraycopy(items, index + 1, items, index, items.length - index - 1);
                rsl = true;
                items[size - 1] = null;
                break;
            }
        }
        size--;
        return rsl;
    }
}