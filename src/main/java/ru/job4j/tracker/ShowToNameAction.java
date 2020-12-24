package ru.job4j.tracker;

public class ShowToNameAction implements UserAction {

    @Override
    public String name() {
        return "=== Find items by name ===";
    }

    @Override
    public boolean execute(Tracker tracker, Input input) {
        String name = input.askStr("Enter name: ");
        Item[] rsl = tracker.findByName(name);
        if (rsl.length != 0) {
            System.out.println("Result: ");
            for (Item item : rsl) {
                System.out.println(item);
            }
        } else {
            System.out.println("Item(s) not found.");
        }
        System.out.println("=============================" + System.lineSeparator()
                + System.lineSeparator() + System.lineSeparator());
        return true;
    }
}