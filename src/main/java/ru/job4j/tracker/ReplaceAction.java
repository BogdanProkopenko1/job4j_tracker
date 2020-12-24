package ru.job4j.tracker;

public class ReplaceAction implements UserAction {
    @Override
    public String name() {
        return "=== Edit item ===";
    }

    @Override
    public boolean execute(Tracker tracker, Input input) {
        int id = input.askInt("Item id: ");
        String newName = input.askStr("New item name: ");
        Item item = new Item(id, newName);
        if (tracker.replace(id, item)) {
            System.out.println("Item was successful edited.");
        } else {
            System.out.println("ERROR. Item not found.");
        }
        System.out.println("=============================" + System.lineSeparator()
                + System.lineSeparator() + System.lineSeparator());
        return true;
    }
}
