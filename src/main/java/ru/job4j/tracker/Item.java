package ru.job4j.tracker;

import java.time.LocalDateTime;
public class Item {
    private int id;
    private String name;
    private LocalDateTime created = LocalDateTime.now();

    public Item() { }
    public Item(int identifier) {
        this.id = identifier;
    }
    public Item(int identifier, String nam) {
        this.id = identifier;
        this.name = nam;
    }

    public LocalDateTime getCreated() {
        return created;
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

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", created=" + created +
                '}';
    }
}