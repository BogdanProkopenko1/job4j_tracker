package ru.job4j.tracker;

public class Item {
    private int id;
    private String name;

    public Item() {
    }

    public Item(int identifier) {
        this.id = identifier;
    }

    public Item(int ident, String nam) {
        this.id = ident;
        this.name = nam;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}