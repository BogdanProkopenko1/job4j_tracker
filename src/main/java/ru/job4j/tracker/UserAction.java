package ru.job4j.tracker;

import java.sql.SQLException;

public interface UserAction {

    String name();

    boolean execute(Store store, Input input) throws SQLException;
}