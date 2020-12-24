package ru.job4j.tracker;

public class CreateAction implements UserAction {

    @Override
    public String name() {
        return "=== Create a new item ===";
    }

    @Override
    public boolean execute(Tracker tracker, Input input) {
        String name = input.askStr("Enter name: ");
        Item item = new Item(name);
        tracker.add(item);
        System.out.println("Item successful created." + System.lineSeparator() + "============================="
                + System.lineSeparator() + System.lineSeparator() + System.lineSeparator());
        return true;
    }
}
