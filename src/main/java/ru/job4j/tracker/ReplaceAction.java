package ru.job4j.tracker;

public class ReplaceAction implements UserAction {

    private final Output out;

    public ReplaceAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "=== Edit item ===";
    }

    @Override
    public boolean execute(Store store, Input input) {
        int id = input.askInt("Item id: ");
        String newName = input.askStr("New item name: ");
        Item item = new Item(id, newName);
        if (store.replace(id, item)) {
            out.println("Item was successful edited.");
        } else {
            out.println("ERROR. Item not found.");
        }
        out.println("=============================" + System.lineSeparator()
                + System.lineSeparator() + System.lineSeparator());
        return true;
    }
}