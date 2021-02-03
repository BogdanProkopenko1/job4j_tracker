package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;

public final class Tracker {

    private static Tracker instance = null;
    private List<Item> items = new ArrayList<Item>();

    private Tracker() {
    }

    public static Tracker getInstance() {
        if (instance == null) {
            instance = new Tracker();
        }
        return instance;
    }

    public Item add(Item item) {
        items.add(item);
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
            }
            index++;
        }
            return rsl;
    }
        public boolean replace (int id, Item item){
            boolean result = false;
            int index = indexOf(id);
            if (index != -1) {
                item.setId(items.get(index).getId());
                items.set(index, item);
                result = true;
            }
            return result;
        }

        public boolean delete (int id){
            if (indexOf(id) != -1) {
                items.remove(indexOf(id));
                return true;
            } else {
                return false;
            }
    }
}