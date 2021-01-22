package ru.job4j.tracker;

public class ShowToIdAction implements UserAction {

    private final Output out;

    public ShowToIdAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "=== Find item by Id ===";
    }

    @Override
    public boolean execute(Tracker tracker, Input input) {
        int id = input.askInt("Enter item id: ");
        Item rsl = tracker.findById(id);
        if (rsl != null) {
            out.println("Result = " + rsl.toString());
        } else {
            out.println("Item not found.");
        }
        out.println("=============================" + System.lineSeparator()
                + System.lineSeparator() + System.lineSeparator());
        return true;
    }
}