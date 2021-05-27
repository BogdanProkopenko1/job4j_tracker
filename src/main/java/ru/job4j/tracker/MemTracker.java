package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;

public final class MemTracker {

    private static MemTracker instance = null;
    private int ids = 1;
    private List<Item> items = new ArrayList<Item>();

    private MemTracker() {
    }

    public static MemTracker getInstance() {
        if (instance == null) {
            instance = new MemTracker();
        }
        return instance;
    }

    public Item add(Item item) {
        item.setId(ids);
        items.add(item);
        ids++;
        return item;
    }

    public Item findById(int id) {
        int index = indexOf(id);
        return index != -1 ? items.get(index) : null;
    }

    public List<Item> findAll() {
        return items;
    }

    public List<Item> findByName(String key) {
        List<Item> rsl = new ArrayList<Item>();
        for (Item check : items) {
            if (check.getName().equals(key)) {
                rsl.add(check);
            }
        }
        return rsl;
    }

    private int indexOf(int id) {
        int rsl = -1;
        int index = 0;
        for (Item check : items) {
            if (check.getId() == id) {
                rsl = index;
                break;
            }
            index++;
        }
        return rsl;
    }

    public boolean replace(int id, Item item) {
        boolean result = false;
        int index = indexOf(id);
        if (index != -1) {
            item.setId(items.get(index).getId());
            items.set(index, item);
            result = true;
        }
        return result;
    }

    public boolean delete(int id) {
        int index = indexOf(id);
        if (index != -1) {
            items.remove(index);
            return true;
        } else {
            return false;
        }
    }
}