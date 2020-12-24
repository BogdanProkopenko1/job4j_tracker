package ru.job4j.tracker;

public interface UserAction {

    String name();
    boolean execute(Tracker tracker, Input input);
}