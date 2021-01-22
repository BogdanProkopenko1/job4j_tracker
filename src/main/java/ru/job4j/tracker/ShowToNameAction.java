package ru.job4j.tracker;

public class ShowToNameAction implements UserAction {

    private final Output out;

    public ShowToNameAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "=== Find items by name ===";
    }

    @Override
    public boolean execute(Tracker tracker, Input input) {
        String name = input.askStr("Enter name: ");
        Item[] rsl = tracker.findByName(name);
        if (rsl.length != 0) {
            out.println("Result: ");
            for (Item item : rsl) {
                out.println(item);
            }
        } else {
            out.println("Item(s) not found.");
        }
        out.println("=============================" + System.lineSeparator()
                + System.lineSeparator() + System.lineSeparator());
        return true;
    }
}