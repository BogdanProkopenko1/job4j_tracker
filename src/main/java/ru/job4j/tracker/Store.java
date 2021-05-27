package ru.job4j.tracker;

import java.sql.SQLException;
import java.util.List;

public interface Store extends AutoCloseable {

    void init();

    Item add(Item item);

    boolean replace(int id, Item item);

    boolean delete(int id);

    List<Item> findAll() throws SQLException;

    List<Item> findByName(String key) throws SQLException;

    Item findById(int id) throws SQLException;
}