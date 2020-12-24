package ru.job4j.tracker;

public class ShowToIdAction implements UserAction {
    @Override
    public String name() {
        return "=== Find item by Id ===";
    }

    @Override
    public boolean execute(Tracker tracker, Input input) {
        int id = input.askInt("Enter item id: ");
        Item rsl = tracker.findById(id);
        if (rsl != null) {
            System.out.println("Result = " + rsl.toString());
        } else {
            System.out.println("Item not found.");
        }
        System.out.println("=============================" + System.lineSeparator()
                + System.lineSeparator() + System.lineSeparator());
        return true;
    }
}
