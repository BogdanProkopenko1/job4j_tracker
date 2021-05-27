package ru.job4j.tracker;

public class DeleteAction implements UserAction {

    private final Output out;

    public DeleteAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "=== Delete item ===";
    }

    @Override
    public boolean execute(Store store, Input input) {
        int id = input.askInt("Item id: ");
        if (store.delete(id)) {
            out.println("Item was deleted!");
        } else {
            out.println("ERROR. Item not found.");
        }
        out.println("=============================" + System.lineSeparator()
                + System.lineSeparator() + System.lineSeparator());
        return true;
    }
}