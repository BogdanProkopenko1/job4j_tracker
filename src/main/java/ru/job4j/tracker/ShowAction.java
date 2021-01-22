package ru.job4j.tracker;

public class ShowAction implements UserAction {

    private final Output output;

    public ShowAction(Output output) {
        this.output = output;
    }

    @Override
    public String name() {
        return "=== All items ===";
    }

    @Override
    public boolean execute(Tracker tracker, Input input) {
        Item[] out = tracker.findAll();
        for (Item item : out) {
            output.println(item);
        }
        System.out.println("All items showed." + System.lineSeparator() + "============================="
                + System.lineSeparator() + System.lineSeparator() + System.lineSeparator());
        return true;
    }
}